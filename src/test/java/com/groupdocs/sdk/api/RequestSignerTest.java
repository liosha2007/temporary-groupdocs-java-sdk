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
package com.groupdocs.sdk.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.groupdocs.sdk.common.ApiInvoker;
import com.groupdocs.sdk.common.GroupDocsRequestSigner;
import com.groupdocs.sdk.common.RequestSigner;

/**
 * Test cases to ensure correctness of request signature generation 
 * 
 * @author zhaidarbek
 *
 */
public class RequestSignerTest extends AbstractUnitTest {
	
	String basePath = "https://api.groupdocs.com/v2.0/storage/2721ad21bcf0d71e/folders/test.docx?description=";
	String clientKey = "2721ad21bcf0d71e";
	String privateKey = "8d8a7d642a807a31c2741c101a60cef2";
	RequestSigner signer = new GroupDocsRequestSigner(privateKey);

	@Test
	public void testSimplePath() {
		String requestUrl = basePath + "uploaded";
		String expected = requestUrl + "&signature=OT6eFQYsZulqFDTsv4XSNlmc3FY";
		assertEquals(expected, sign(requestUrl));
	}

	@Test
	public void testPathEndingWithSpace() {
		String requestUrl = basePath + "test DOC file ";
		String expected = basePath + "test%20DOC%20file%20&signature=rdw%2F%2FiP0mwN7Bme2sJ99AZmOpq4";
		assertEquals(expected, sign(requestUrl));
	}
	
	@Test
	public void testPathWithAtSymbol() {
		String requestUrl = basePath + "with @ symbol";
		String expected = basePath + "with%20@%20symbol&signature=ar7cFk0RSaVukMIUbvJB%2FYp5oHs";
		assertEquals(expected, sign(requestUrl));
	}
	
	@Test
	public void testPathWithStarSymbol() {
		String requestUrl = basePath + "with * symbol";
		String expected = basePath + "with%20*%20symbol&signature=iwzySzo6jbCXhf4lMB3r%2FtcV8Kc";
		assertEquals(expected, sign(requestUrl));
	}
	
	@Test
	public void testPathWithBrackets() {
		String requestUrl = basePath + "with ( and )";
		String expected = basePath + "with%20(%20and%20)&signature=rDzSggRSTkBFOi%2F0P%2Bta6j%2BvYzY";
		assertEquals(expected, sign(requestUrl));
	}
	
	@Test
	public void testPathWithSquareBrackets() {
		String requestUrl = basePath + "with [ and ]";
		String expected = basePath + "with%20%5B%20and%20%5D&signature=hfLg0YTTGdXpvdqV%2B7y2YJkJZqo";
		assertEquals(expected, sign(requestUrl));
	}
	
	@Test
	public void testPathWithEncodeURIComponent() {
		// https://developer.mozilla.org/en-US/docs/JavaScript/Reference/Global_Objects/encodeURIComponent
		String requestUrl = basePath + "alpha123 - _ . ! ~ * ' ( )";
		String expected = basePath + "alpha123%20-%20_%20.%20!%20~%20*%20'%20(%20)&signature=6ZTSvVrJ3Wvp9aZ93wtp5oH2hJ4";
		assertEquals(expected, sign(requestUrl));
	}
	
	@Test
	public void testPathWithEncodeURI() {
		// https://developer.mozilla.org/en-US/docs/JavaScript/Reference/Global_Objects/encodeURI
		String requestUrl = basePath + "alpha123 ; , / ? : @ & = + $"; // omitted # 
		String expected = basePath + "alpha123%20;%20,%20/%20?%20:%20@%20&%20=%20%2B%20$&signature=zqj1XJtWE0%2F%2FMon%2FiSJN%2FC6Yyco";
		assertEquals(expected, sign(requestUrl));
	}
	
	public String sign(String url) {
		return ApiInvoker.encodeURI(signer.signUrl(url));
	}

}
