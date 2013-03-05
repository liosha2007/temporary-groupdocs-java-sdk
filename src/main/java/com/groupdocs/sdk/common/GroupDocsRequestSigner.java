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

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.core.util.Base64;

public class GroupDocsRequestSigner implements RequestSigner {

	private static final String ENC = "UTF-8";
	private static final String SIGN_ALG = "HmacSHA1";
	private String privateKey;

	public GroupDocsRequestSigner(String privateKey) {
		this.privateKey = privateKey;
	}
	
	@Override
	public String signUrl(String url) {
		StringBuilder temp = new StringBuilder(url);
		try {
			URL resourceURL = new URL(url);
			String pathAndQuery = resourceURL.getFile();
			if(url.lastIndexOf(" ") == url.length() - 1){
				pathAndQuery = pathAndQuery + " ";
			}
			String signature = sign(ApiInvoker.encodeURI(pathAndQuery));
			temp.append((resourceURL.getQuery() == null ? "?" : "&")).append("signature=").append(ApiInvoker.encodeURIComponent(signature));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return temp.toString();
	}

	@Override
	public String signContent(String requestBody, Builder builder) {
    	return requestBody;
    }

    private String sign(String toSign){
		try {
			Mac mac = Mac.getInstance(SIGN_ALG);
			mac.init(new SecretKeySpec(privateKey.getBytes(ENC), SIGN_ALG));
			String signature = new String(Base64.encode(mac.doFinal(toSign.getBytes(ENC))), ENC);
			if(signature.endsWith("=")){
				signature = signature.substring(0, signature.length() - 1);
			}
			return signature;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}

