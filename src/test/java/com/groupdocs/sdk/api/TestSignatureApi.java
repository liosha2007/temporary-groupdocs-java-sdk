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

import com.groupdocs.sdk.common.*;
import com.groupdocs.sdk.model.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@Category(IntegrationTest.class)
public class TestSignatureApi extends AbstractIntegrationTest {
  
	@Test
	public void testDeleteSignatureTemplateDocument() throws ApiException {
	
  		String userId = "";
		String templateId = "";
		String documentId = "";
		SignatureStatusResponse response = new SignatureApi().DeleteSignatureTemplateDocument(userId, templateId, documentId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testAddSignatureTemplateField() throws ApiException {
	
  		SignatureTemplateFieldSettings body = new SignatureTemplateFieldSettings();
  		body.setName("Signature");
  		body.setDefaultValue("Big Boss Signature");
  		body.setFontUnderline(true);
  		body.setMandatory(true);
  		body.setPage(1); // required
  		body.setLocationX(90d); // required
  		body.setLocationY(85d); // required
		String templateId = "b2b9c26d9d87228781874d7e047c4448";
		String documentId = "0b2a90765c30d5bec23ebee4f646a139";
		String recipientId = "f0d986b034c23a8b964460ab8afc6a56";
		String fieldId = "b5b2304a968c58479a6c9f8f48f4eda1";
		//TODO keeps saying: Unknown field
		SignatureTemplateFieldResponse response = new SignatureApi().AddSignatureTemplateField(userId, templateId, documentId, recipientId, fieldId, body);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testModifySignatureTemplateField() throws ApiException {
	
  		SignatureTemplateFieldSettings body = null;
		String userId = "";
		String templateId = "";
		String documentId = "";
		String fieldId = "";
		SignatureTemplateFieldResponse response = new SignatureApi().ModifySignatureTemplateField(userId, templateId, documentId, fieldId, body);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testDeleteSignatureTemplateFieldLocation() throws ApiException {
	
  		String userId = "";
		String templateId = "";
		String fieldId = "";
		String locationId = "";
		SignatureStatusResponse response = new SignatureApi().DeleteSignatureTemplateFieldLocation(userId, templateId, fieldId, locationId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testModifySignatureTemplateFieldLocation() throws ApiException {
	
  		SignatureTemplateFieldLocationSettings body = null;
		String userId = "";
		String templateId = "";
		String documentId = "";
		String recipientId = "";
		String fieldId = "";
		String locationId = "";
		SignatureTemplateFieldResponse response = new SignatureApi().ModifySignatureTemplateFieldLocation(userId, templateId, documentId, recipientId, fieldId, locationId, body);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testGetSignatureTemplateFields() throws ApiException {
	
		String templateId = "b2b9c26d9d87228781874d7e047c4448";
		String documentId = "";
		String recipientId = "";
		SignatureTemplateFieldsResponse response = new SignatureApi().GetSignatureTemplateFields(userId, templateId, documentId, recipientId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testDeleteSignatureTemplateField() throws ApiException {
	
  		String userId = "";
		String templateId = "";
		String fieldId = "";
		SignatureTemplateResponse response = new SignatureApi().DeleteSignatureTemplateField(userId, templateId, fieldId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testGetSignatures() throws ApiException {
	
		Integer page = null;
		String name = null;
		Integer records = null;
		SignatureSignaturesResponse response = new SignatureApi().GetSignatures(userId, page, name, records);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testDeleteSignature() throws ApiException {
	
  		String userId = "";
		String signatureId = "";
		SignatureStatusResponse response = new SignatureApi().DeleteSignature(userId, signatureId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testCreateSignature() throws ApiException {
	
  		SignatureSignatureSettings body = null;
		String userId = "";
		String name = "";
		SignatureSignatureResponse response = new SignatureApi().CreateSignature(userId, name, body);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testFillEnvelopeField() throws ApiException {
	
  		String userId = "";
		String envelopeId = "";
		String documentId = "";
		String recipientId = "";
		String fieldId = "";
		String signatureId = "";
		FileStream body = null;
		SignatureEnvelopeFieldResponse response = new SignatureApi().FillEnvelopeField(userId, envelopeId, documentId, recipientId, fieldId, signatureId, body);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testSignEnvelope() throws ApiException {
	
  		String userId = "";
		String envelopeId = "";
		String recipientId = "";
		SignatureStatusResponse response = new SignatureApi().SignEnvelope(userId, envelopeId, recipientId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testDeclineEnvelope() throws ApiException {
	
  		String userId = "";
		String envelopeId = "";
		String recipientId = "";
		SignatureStatusResponse response = new SignatureApi().DeclineEnvelope(userId, envelopeId, recipientId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testDelegateEnvelopeRecipient() throws ApiException {
	
  		String userId = "";
		String envelopeId = "";
		String recipientId = "";
		String email = "";
		String firstname = "";
		String lastname = "";
		SignatureStatusResponse response = new SignatureApi().DelegateEnvelopeRecipient(userId, envelopeId, recipientId, email, firstname, lastname);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testAddContact() throws ApiException {
	
  		SignatureContactSettings body = new SignatureContactSettings();
  		body.setEmail("zhaidarbek.ayazbayev@gmail.com");
  		body.setFirstName("Jaydarbek");
  		body.setLastName("Ayazbayev");
		SignatureContactResponse response = new SignatureApi().AddContact(userId, body);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testModifyContact() throws ApiException {
	
		SignatureContactsResponse contactsResponse = new SignatureApi().GetContacts(userId, null, null, null, null, null);
		SignatureContactsResult contactsResult = contactsResponse.getResult();
		List<SignatureContactInfo> contacts = contactsResult.getContacts();
		SignatureContactInfo contact = contacts.get(0);
		SignatureContactSettings body = new SignatureContactSettings();
		Utils.copy(contact, body);
  		body.setFirstName(body.getFirstName() + "_updated");
		String contactId = contact.getId();
		SignatureContactResponse response = new SignatureApi().ModifyContact(userId, contactId, body);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testGetContacts() throws ApiException {
	
		String page = null;
		String firstName = null;
		String lastName = null;
		String email = null;
		String records = null;
		SignatureContactsResponse response = new SignatureApi().GetContacts(userId, page, firstName, lastName, email, records);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testDeleteContact() throws ApiException {
	
  		String userId = "";
		String contactId = "";
		SignatureContactResponse response = new SignatureApi().DeleteContact(userId, contactId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testImportContacts() throws ApiException {
	
		List<SignatureContactSettings> body = new ArrayList<SignatureContactSettings>();
		SignatureContactsImportResponse response = new SignatureApi().ImportContacts(userId, body);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testGetSignatureEnvelopeResources() throws ApiException {
	
		String statusIds = "-1";
		SignatureEnvelopeResourcesResponse response = new SignatureApi().GetSignatureEnvelopeResources(userId, statusIds);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testAddContactIntegration() throws ApiException {
	
		String body = "whatisit";
		SignatureStatusResponse response = new SignatureApi().AddContactIntegration(userId, body);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testGetSignaturePredefinedLists() throws ApiException {
	
  		String userId = "";
		SignaturePredefinedListsResponse response = new SignatureApi().GetSignaturePredefinedLists(userId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testAddPredefinedList() throws ApiException {
	
  		SignaturePredefinedListSettings body = new SignaturePredefinedListSettings();
  		body.setName("somekey");
  		body.setDefaultValue("defaultValue");
  		body.setValues("somevalue1, somevalue2, etc...");
		SignaturePredefinedListResponse response = new SignatureApi().AddPredefinedList(userId, body);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testDeletePredefinedList() throws ApiException {
	
  		String userId = "";
		String listId = "";
		SignaturePredefinedListResponse response = new SignatureApi().DeletePredefinedList(userId, listId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testGetEnvelopeAuditLogs() throws ApiException {
	
		String envelopeId = "bfe1903323678698d01e56cd2614f4ac";
		SignatureEnvelopeAuditLogsResponse response = new SignatureApi().GetEnvelopeAuditLogs(userId, envelopeId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testCreateSignatureForm() throws ApiException {
	
  		SignatureFormSettings body = new SignatureFormSettings();
  		body.setCanParticipantDownloadForm(true);
  		body.setFieldsInFinalFileName("myfieldname");
//  		body.setEmailBody("emailBody");
//  		body.setEmailSubject("emailSubject");
//  		body.setIsDemo(true);
//  		body.setOwnerShouldSign(1);
  		String name = "Services Agreement";
  		body.setName(name);
		Integer assemblyId = null;
		String templateId = null;
		SignatureFormResponse response = new SignatureApi().CreateSignatureForm(userId, name, templateId, assemblyId, body);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testGetSignatureFormDocuments() throws ApiException {
	
  		String formId = "b6cc28e565fc10b16ee9cf615fba4245";
		SignatureFormDocumentsResponse response = new SignatureApi().GetSignatureFormDocuments(userId, formId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testGetSignatureFormFields() throws ApiException {
	
		String formId = "b6cc28e565fc10b16ee9cf615fba4245";
		String documentId = "53d631dd443d65b9dc4e537a2c2d702c";
//		String participantId = ""; //TODO can be empty string same as recipientId
		SignatureFormFieldsResponse response = new SignatureApi().GetSignatureFormFields(userId, formId, documentId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testDeleteSignatureForm() throws ApiException {
	
  		String userId = "";
		String formId = "";
		SignatureStatusResponse response = new SignatureApi().DeleteSignatureForm(userId, formId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testGetSignatureForm() throws ApiException {
	
		String formId = "b6cc28e565fc10b16ee9cf615fba4245";
		SignatureFormResponse response = new SignatureApi().GetSignatureForm(userId, formId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testGetSignatureForms() throws ApiException {
	
		String statusId = null;
		Integer page = null;
		String date = null;
		String name = null;
		Integer records = null;
		String documentId = null;
		SignatureFormsResponse response = new SignatureApi().GetSignatureForms(userId, statusId, page, date, name, records, documentId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testRenameSignatureForm() throws ApiException {
	
  		String userId = "";
		String formId = "";
		String name = "";
		SignatureFormResponse response = new SignatureApi().RenameSignatureForm(userId, formId, name);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testPublishSignatureForm() throws ApiException {
	
  		String userId = "";
		String formId = "";
		SignatureStatusResponse response = new SignatureApi().PublishSignatureForm(userId, formId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testCompleteSignatureForm() throws ApiException {
	
  		String userId = "";
		String formId = "";
		SignatureStatusResponse response = new SignatureApi().CompleteSignatureForm(userId, formId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testModifySignatureForm() throws ApiException {
	
  		SignatureFormSettings body = null;
		String userId = "";
		String formId = "";
		SignatureFormResponse response = new SignatureApi().ModifySignatureForm(userId, formId, body);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testArchiveSignatureForm() throws ApiException {
	
  		String userId = "";
		String formId = "";
		SignatureStatusResponse response = new SignatureApi().ArchiveSignatureForm(userId, formId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testGetSignatureFormResources() throws ApiException {
	
		String statusIds = "-1";
		SignatureFormResourcesResponse response = new SignatureApi().GetSignatureFormResources(userId, statusIds);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testGetSignatureTemplateResources() throws ApiException {
	
		SignatureTemplateResourcesResponse response = new SignatureApi().GetSignatureTemplateResources(userId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testSignDocument() throws Exception {
	
		File file = new File("/home/zhaidarbek/workspace/groupdocs/java/groupdocs-java-samples/interactiveform_enabled.pdf");
		File signature = new File(getClass().getClassLoader().getResource("signature.png").toURI());
		String base64file = MimeUtils.readAsDataURL(file);
		String base64signature = MimeUtils.readAsDataURL(signature);
  		
  		SignatureSignDocumentDocumentSettings document = new SignatureSignDocumentDocumentSettings();
  		document.setName("test.doc");
  		document.setData(base64file);
		
		SignatureSignDocumentSignerSettings signerr = new SignatureSignDocumentSignerSettings();
		signerr.setPlaceSignatureOn("");
		signerr.setName("My Name");
		signerr.setData(base64signature);
		signerr.setHeight(40d);
		signerr.setWidth(100d);
		signerr.setTop(0.03319);
		signerr.setLeft(0.52171);
		
		SignatureSignDocumentSettings body = new SignatureSignDocumentSettings();
		List<SignatureSignDocumentSignerSettings> signers = new ArrayList<SignatureSignDocumentSignerSettings>();
		signers.add(signerr);
		body.setSigners(signers);
  		List<SignatureSignDocumentDocumentSettings> documents = new ArrayList<SignatureSignDocumentDocumentSettings>();
		documents.add(document);
		body.setDocuments(documents);
		
		SignatureSignDocumentsResponse response = new SignatureApi().SignDocument(userId, body);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testGetSignatureEnvelopes() throws ApiException {
	
		String statusId = null;
		Integer page = null;
		String recipient = null;
		String date = null;
		String name = null;
		Integer records = null;
		String document = null;
		SignatureEnvelopesResponse response = new SignatureApi().GetSignatureEnvelopes(userId, statusId, page, date, name, records, document, recipient);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testGetRecipientSignatureEnvelopes() throws ApiException {
	
		String statusId = null;
		Integer page = null;
		Integer records = null;
		SignatureEnvelopesResponse response = new SignatureApi().GetRecipientSignatureEnvelopes(userId, statusId, page, records);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testGetSignatureEnvelope() throws ApiException {
	
		String envelopeId = "bfe1903323678698d01e56cd2614f4ac";
		SignatureEnvelopeResponse response = new SignatureApi().GetSignatureEnvelope(userId, envelopeId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testCreateSignatureEnvelope() throws ApiException {
	
  		SignatureEnvelopeSettings body = new SignatureEnvelopeSettings();
  		body.setEmailBody("emailBody");
  		body.setEmailSubject("emailSubject");
  		body.setIsDemo(true);
  		body.setOwnerShouldSign(1);
		String name = "test envelope";
		Integer envelopeGuid = null;
		String templateGuid = null;
		SignatureEnvelopeResponse response = new SignatureApi().CreateSignatureEnvelope(userId, name, body, templateGuid, envelopeGuid);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testModifySignatureEnvelope() throws ApiException {
	
		SignatureEnvelopesResponse envelopesResponse = new SignatureApi().GetSignatureEnvelopes(userId, null, null, null, null, null, null, null);
		SignatureEnvelopesResult envelopesResult = envelopesResponse.getResult();
		List<SignatureEnvelopeInfo> envelopes = envelopesResult.getEnvelopes();
		SignatureEnvelopeInfo envelope = envelopes.get(0);
		SignatureEnvelopeSettings body = new SignatureEnvelopeSettings();
		Utils.copy(envelope, body);
		String envelopeId = "";
		SignatureEnvelopeResponse response = new SignatureApi().ModifySignatureEnvelope(userId, envelopeId, body);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testRenameSignatureEnvelope() throws ApiException {
	
  		String userId = "";
		String envelopeId = "";
		String name = "";
		SignatureEnvelopeResponse response = new SignatureApi().RenameSignatureEnvelope(userId, envelopeId, name);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testDeleteSignatureEnvelope() throws ApiException {
	
  		String userId = "";
		String envelopeId = "";
		SignatureStatusResponse response = new SignatureApi().DeleteSignatureEnvelope(userId, envelopeId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testGetRolesList() throws ApiException {
	
		String id = null;
		SignatureRolesResponse response = new SignatureApi().GetRolesList(userId, id);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testGetFieldsList() throws ApiException {
	
		String id = null;
		SignatureFieldsResponse response = new SignatureApi().GetFieldsList(userId, id);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testCreateSignatureField() throws ApiException {
	
  		SignatureFieldSettings body = new SignatureFieldSettings();
  		body.setName("address");
  		body.setGraphSizeH(15);
  		body.setGraphSizeW(10);
  		SignatureFieldResponse response = new SignatureApi().CreateSignatureField(userId, body);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testModifySignatureField() throws ApiException {
	
  		SignatureFieldSettings body = null;
		String userId = "";
		String fieldId = "";
		SignatureFieldResponse response = new SignatureApi().ModifySignatureField(userId, fieldId, body);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testDeleteSignatureField() throws ApiException {
	
  		String userId = "";
		String fieldId = "";
		SignatureStatusResponse response = new SignatureApi().DeleteSignatureField(userId, fieldId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testAddSignatureEnvelopeRecipient() throws ApiException {
	
		Integer order = null;
		String recipientLastName = "TestLastname";
		String recipientEmail = "somenone@existingemail.com";
		String envelopeId = "1a623fdf8bdfd1f527b3b9b5de947667";
		String recipientFirstName = "TestFirstaname";
		String role = "693e6cee8a4a21285f86930491b455ec"; // Signer
		SignatureEnvelopeRecipientResponse response = new SignatureApi().AddSignatureEnvelopeRecipient(userId, envelopeId, recipientEmail, recipientFirstName, recipientLastName, order, role);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testGetSignatureEnvelopeRecipients() throws ApiException {
	
		String envelopeId = "bfe1903323678698d01e56cd2614f4ac";
		SignatureEnvelopeRecipientsResponse response = new SignatureApi().GetSignatureEnvelopeRecipients(userId, envelopeId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testDeleteSignatureEnvelopeRecipient() throws ApiException {
	
  		String userId = "";
		String envelopeId = "";
		String recipientId = "";
		SignatureStatusResponse response = new SignatureApi().DeleteSignatureEnvelopeRecipient(userId, envelopeId, recipientId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testModifySignatureEnvelopeRecipient() throws ApiException {
	
  		String userId = "";
		Integer order = 0;
		String envelopeId = "";
		String recipientEmail = "";
		String recipientFirstName = "";
		String recipientLastName = "";
		String role = "";
		String recipientId = "";
		SignatureEnvelopeRecipientResponse response = new SignatureApi().ModifySignatureEnvelopeRecipient(userId, envelopeId, recipientId, recipientEmail, recipientFirstName, recipientLastName, order, role);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testAddSignatureEnvelopeDocument() throws ApiException {
	
		String envelopeId = "1a623fdf8bdfd1f527b3b9b5de947667";
		String documentId = "a8e39117127960d4eb4bb4294a5ca773e44f5e03c5328facda5051fcd85a31e0";
		Integer order = null;
		SignatureEnvelopeDocumentResponse response = new SignatureApi().AddSignatureEnvelopeDocument(userId, envelopeId, documentId, order);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testGetSignatureEnvelopeDocuments() throws ApiException {
	
		String envelopeId = "bfe1903323678698d01e56cd2614f4ac";
		SignatureEnvelopeDocumentsResponse response = new SignatureApi().GetSignatureEnvelopeDocuments(userId, envelopeId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testGetSignedEnvelopeDocument() throws ApiException, IOException {
	
		String envelopeId = "bfe1903323678698d01e56cd2614f4ac";
		String documentId = "couldn't figure out";
		FileStream stream = new SignatureApi().GetSignedEnvelopeDocument(userId, envelopeId, documentId);
		String response = IOUtils.toString(stream.getInputStream());
		System.out.println("asdf " + response.substring(0, 100));
		assertThat(stream.getFileName(), equalTo("CMSList_2.zip"));
		
	}
	
	@Test
	public void testGetSignedEnvelopeDocuments() throws ApiException, IOException {
	
		String envelopeId = "bfe1903323678698d01e56cd2614f4ac";
		FileStream stream = new SignatureApi().GetSignedEnvelopeDocuments(userId, envelopeId);
		IOUtils.copy(stream.getInputStream(), new FileOutputStream(stream.getFileName()));
		assertThat(stream.getFileName(), equalTo("CMSList_2.zip"));
		
	}
	
	@Test
	public void testDeleteSignatureEnvelopeDocument() throws ApiException {
	
  		String userId = "";
		String envelopeId = "";
		String documentId = "";
		SignatureStatusResponse response = new SignatureApi().DeleteSignatureEnvelopeDocument(userId, envelopeId, documentId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testAddSignatureEnvelopeField() throws ApiException {
	
  		SignatureEnvelopeFieldSettings body = null;
		String envelopeId = "1a623fdf8bdfd1f527b3b9b5de947667";
		String documentId = "9f28eb77937ef26c817402dcb50dc6b4";
		String recipientId = "";
		String fieldId = "3589bb5a2f30eb57ff55cb85c218ea2b";
		SignatureEnvelopeFieldsResponse response = new SignatureApi().AddSignatureEnvelopeField(userId, envelopeId, documentId, recipientId, fieldId, body);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testGetSignatureEnvelopeFields() throws ApiException {
	
		String envelopeId = "bfe1903323678698d01e56cd2614f4ac";
		String documentId = "8ce8478e795f36f236eeefc42ccf475b";
		String recipientId = ""; // TODO if bbcafe39385d9fa99c8108d3ba355791 same result
		SignatureEnvelopeFieldsResponse response = new SignatureApi().GetSignatureEnvelopeFields(userId, envelopeId, documentId, recipientId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testDeleteSignatureEnvelopeField() throws ApiException {
	
  		String userId = "";
		String envelopeId = "";
		String fieldId = "";
		SignatureStatusResponse response = new SignatureApi().DeleteSignatureEnvelopeField(userId, envelopeId, fieldId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testModifySignatureEnvelopeField() throws ApiException {
	
  		SignatureEnvelopeFieldSettings body = null;
		String userId = "";
		String envelopeId = "";
		String documentId = "";
		String fieldId = "";
		SignatureEnvelopeFieldResponse response = new SignatureApi().ModifySignatureEnvelopeField(userId, envelopeId, documentId, fieldId, body);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testArchiveSignatureEnvelope() throws ApiException {
	
  		String userId = "";
		String envelopeId = "";
		SignatureStatusResponse response = new SignatureApi().ArchiveSignatureEnvelope(userId, envelopeId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testRestartExpiredSignatureEnvelope() throws ApiException {
	
  		String userId = "";
		String envelopeId = "";
		SignatureStatusResponse response = new SignatureApi().RestartExpiredSignatureEnvelope(userId, envelopeId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testSignatureEnvelopeSend() throws ApiException {
	
  		String userId = "";
		String envelopeId = "";
		SignatureStatusResponse response = new SignatureApi().SignatureEnvelopeSend(userId, envelopeId, null);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testDeleteSignatureEnvelopeFieldLocation() throws ApiException {
	
  		String userId = "";
		String envelopeId = "";
		String fieldId = "";
		String locationId = "";
		SignatureStatusResponse response = new SignatureApi().DeleteSignatureEnvelopeFieldLocation(userId, envelopeId, fieldId, locationId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testModifySignatureEnvelopeFieldLocation() throws ApiException {
	
  		SignatureEnvelopeFieldLocationSettings body = null;
		String userId = "";
		String envelopeId = "";
		String documentId = "";
		String recipientId = "";
		String fieldId = "";
		String locationId = "";
		SignatureEnvelopeFieldResponse response = new SignatureApi().ModifySignatureEnvelopeFieldLocation(userId, envelopeId, documentId, recipientId, fieldId, locationId, body);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testGetSignatureTemplates() throws ApiException {
	
		String page = null;
		String documentGuid = null;
		String recipientName = null;
		String name = null;
		String records = null;
		SignatureTemplatesResponse response = new SignatureApi().GetSignatureTemplates(userId, page, documentGuid, recipientName, name, records);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testGetSignatureTemplate() throws ApiException {
	
		String templateId = "b2b9c26d9d87228781874d7e047c4448";
		SignatureTemplateResponse response = new SignatureApi().GetSignatureTemplate(userId, templateId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testCreateSignatureTemplate() throws ApiException {
	
  		SignatureTemplateSettings body = new SignatureTemplateSettings();
  		body.setEmailBody("emailBody");
  		body.setEmailSubject("emailSubject");
  		body.setOwnerShouldSign(1);
		String name = "Test Template";
		String templateId = null;
		String envelopetId = "";
		SignatureTemplateResponse response = new SignatureApi().CreateSignatureTemplate(userId, name, templateId, body, envelopetId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testModifySignatureTemplate() throws ApiException {
	
  		SignatureTemplateSettings body = null;
		String userId = "";
		String templateId = "";
		SignatureTemplateResponse response = new SignatureApi().ModifySignatureTemplate(userId, templateId, body);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testRenameSignatureTemplate() throws ApiException {
	
  		String userId = "";
		String templateId = "";
		String name = "";
		SignatureTemplateResponse response = new SignatureApi().RenameSignatureTemplate(userId, templateId, name);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testDeleteSignatureTemplate() throws ApiException {
	
  		String userId = "";
		String templateId = "";
		SignatureStatusResponse response = new SignatureApi().DeleteSignatureTemplate(userId, templateId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testAddSignatureTemplateRecipient() throws ApiException {
	
  		String templateId = "b2b9c26d9d87228781874d7e047c4448";
		String nickname = "TestRecipient";
		String order = null;
		String role = "693e6cee8a4a21285f86930491b455ec";
		SignatureTemplateResponse response = new SignatureApi().AddSignatureTemplateRecipient(userId, templateId, nickname, order, role);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testGetSignatureTemplateRecipients() throws ApiException {
	
		String templateId = "b2b9c26d9d87228781874d7e047c4448";
		SignatureApi api = new SignatureApi();
		SignatureTemplateRecipientsResponse response = api.GetSignatureTemplateRecipients(userId, templateId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testDeleteSignatureTemplateRecipient() throws ApiException {
	
  		String userId = "";
		String templateId = "";
		String recipientId = "";
		SignatureStatusResponse response = new SignatureApi().DeleteSignatureTemplateRecipient(userId, templateId, recipientId);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testModifySignatureTemplateRecipient() throws ApiException {
	
  		String userId = "";
		String templateId = "";
		String nickname = "";
		String order = "";
		String roleId = "";
		String recipientId = "";
		SignatureTemplateResponse response = new SignatureApi().ModifySignatureTemplateRecipient(userId, templateId, recipientId , nickname, roleId, order);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testAddSignatureTemplateDocument() throws ApiException {
	
		String templateId = "b2b9c26d9d87228781874d7e047c4448";
		String documentId = "be9160671f7ddb4165da2a3ad3eb7126668bcc67d2a74e232ce098d64536461d";
		String order = null;
		SignatureTemplateDocumentResponse response = new SignatureApi().AddSignatureTemplateDocument(userId, templateId, documentId, order);
		assertThat(response, not(nullValue()));
		
	}
	
	@Test
	public void testGetSignatureTemplateDocuments() throws ApiException {
	
		String templateId = "b2b9c26d9d87228781874d7e047c4448";
		SignatureTemplateDocumentsResponse response = new SignatureApi().GetSignatureTemplateDocuments(userId, templateId);
		assertThat(response, not(nullValue()));
		
	}
	
	
}
