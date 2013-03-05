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

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.io.IOUtils;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.header.ContentDisposition;

public class FileStream {

	private InputStream inputStream;
	private String contentType;
	private String fileName;
	private long size = -1;
	
	
	public FileStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public FileStream(String requestUri, ClientResponse response) {
		this.inputStream = response.getEntityInputStream();
		if(response.getType() != null){
			this.contentType = response.getType().toString();
		}
		
		MultivaluedMap<String, String> headers = response.getHeaders();
		try {
			// http://www.ietf.org/rfc/rfc2183.txt
			ContentDisposition cd = new ContentDisposition(headers.getFirst("Content-Disposition"));
			fileName = cd.getFileName() == null ? getFileNameFromUrl(requestUri) : cd.getFileName();
			size = cd.getSize() == 0 ? response.getLength() : cd.getSize();
		} catch (ParseException e) {
		}
	}

	private String getFileNameFromUrl(String requestUri) {
		try {
			URL url = new URL(requestUri);
			String path = url.getPath();
			return path.substring(path.lastIndexOf('/') + 1);
		} catch (MalformedURLException e) {
			return null;
		}
	}

	public InputStream getInputStream() {
		return inputStream;
	}
	
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public byte[] toByteArray() {
		try {
			return IOUtils.toByteArray(inputStream);
		} catch (IOException e) {
			return null;
		}
	}

}
