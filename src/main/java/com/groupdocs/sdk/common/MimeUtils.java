/**
 *  Copyright 2012 GroupDocs.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.groupdocs.sdk.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64InputStream;
import org.apache.commons.io.IOUtils;

import com.sun.jersey.multipart.file.DefaultMediaTypePredictor;

public class MimeUtils {
	private static final Map<String, String> mimeTab = new HashMap<String, String>();
	private static final Map<String, String> extensionMap = new HashMap<String, String>();

	static {
		try {
			registerMimeTypes(ApiInvoker.class
					.getResourceAsStream("/META-INF/mime.types"));
		} catch (IOException e) {
			System.err.println("Failed to read mime.types file");
		}
	}

	public static String getMimeTypeFor(String filenameOrExtension) {
		if (filenameOrExtension == null) {
			return null;
		}

		String ext;
		if (filenameOrExtension.contains(".")) {
			ext = filenameOrExtension.substring(filenameOrExtension
					.lastIndexOf('.') + 1);
		} else {
			ext = filenameOrExtension;
		}
		return mimeTab.get(ext.toLowerCase());
	}

	public static String getExtensionFor(String mimeType) {
		if (mimeType == null) {
			return null;
		}

		return extensionMap.get(mimeType.toLowerCase());
	}

	public static void registerMimeType(String mimeType, String... extensions) {
		if (mimeType == null || mimeType.length() == 0 || extensions == null
				|| extensions.length == 0) {
			return;
		}

		mimeType = mimeType.toLowerCase();

		String defaultExtension = extensionMap.get(mimeType);

		for (String extension : extensions) {
			if (extension != null && extension.length() > 0) {
				extension = extension.toLowerCase();
				mimeTab.put(extension, mimeType);
				if (defaultExtension == null) {
					defaultExtension = extension;
				}
			}
		}

		if (defaultExtension != null) {
			extensionMap.put(mimeType, defaultExtension);
		}
	}

	public static void registerMimeTypes(InputStream is) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is,
				"ISO-8859-1"));

		String line;
		while ((line = br.readLine()) != null) {
			if (line.startsWith("#")) {
				continue;
			}
			String[] parts = line.split("\\s+");
			if (parts.length > 1) {
				String[] extensions = new String[parts.length - 1];
				System.arraycopy(parts, 1, extensions, 0, extensions.length);
				registerMimeType(parts[0], extensions);
			}
		}
	}

	/**
	 * Read file contents into String according to
	 * http://en.wikipedia.org/wiki/Data_URI_scheme#Format
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws Exception
	 */
	public static String readAsDataURL(File file) throws IOException {
		String mimeType = getMimeTypeFor(file.getName());
		if (mimeType == null) {
			mimeType = new DefaultMediaTypePredictor().getMediaTypeFromFile(
					file).toString();
		}
		return readAsDataURL(file, mimeType);
	}

	public static String readAsDataURL(File file, String contentType)
			throws IOException {
		return readAsDataURL(new FileInputStream(file), contentType);
	}

	public static String readAsDataURL(InputStream is, String contentType)
			throws IOException {
		String base64file = IOUtils.toString(new Base64InputStream(is, true, 0,
				null));
		return "data:" + contentType + ";base64," + base64file;
	}

}