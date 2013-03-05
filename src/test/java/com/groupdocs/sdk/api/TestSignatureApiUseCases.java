package com.groupdocs.sdk.api;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.groupdocs.sdk.common.ApiInvoker;
import com.groupdocs.sdk.common.FileStream;
import com.groupdocs.sdk.common.GroupDocsRequestSigner;
import com.groupdocs.sdk.model.SignatureEnvelopeDocumentResponse;
import com.groupdocs.sdk.model.SignatureEnvelopeFieldSettings;
import com.groupdocs.sdk.model.SignatureEnvelopeResponse;
import com.groupdocs.sdk.model.SignatureEnvelopeSettings;
import com.groupdocs.sdk.model.SignatureFieldInfo;
import com.groupdocs.sdk.model.SignatureRoleInfo;
import com.groupdocs.sdk.model.SignatureStatusResponse;

@Category(IntegrationTest.class)
public class TestSignatureApiUseCases extends AbstractIntegrationTest {
	
	SignatureApi api = new SignatureApi();
	String server = "dev-"; // use "" for production
	
	{
		api.setBasePath("https://" + server + "api.groupdocs.com/v2.0");
		ApiInvoker.getInstance().setRequestSigner(new GroupDocsRequestSigner("e205c73b479f0e5a66501fac3e89d86b"));
		userId = "16698cae909805f2";
	}
	
	@Test
	public void testSendEnvelopeForSigning() throws Exception {
		//upload document
		File file = new File(".", "src/test/resources/interactiveform_enabled.pdf");
		InputStream is = new FileInputStream(file);
		StorageApi storageApi = new StorageApi();
		storageApi.setBasePath("https://" + server + "api.groupdocs.com/v2.0");
		String documentId = storageApi.Upload(userId, "samples/signature/" + file.getName(), null, new FileStream(is)).getResult().getGuid();
		IOUtils.closeQuietly(is);
		assertThat(documentId, not(nullValue()));
		
		//create envelope
		SignatureEnvelopeSettings env = new SignatureEnvelopeSettings();
		env.setEmailSubject("Sing this!");
		SignatureEnvelopeResponse envelopeResponse = api.CreateSignatureEnvelope(userId, "SampleEnvelope_" + UUID.randomUUID(), env, null, null);
		assertThat(envelopeResponse, not(nullValue()));
		
		//add document to envelope
		final String envelopeId = envelopeResponse.getResult().getEnvelope().getId();
		assertThat(envelopeId, not(nullValue()));
		SignatureEnvelopeDocumentResponse envelopeDocument = api.AddSignatureEnvelopeDocument(userId, envelopeId, documentId, null);
		assertThat(envelopeDocument, not(nullValue()));
		
		//update document object after it's created
		documentId = envelopeDocument.getResult().getDocument().getDocumentId();
		assertThat(documentId, not(nullValue()));
		
		//add new recipient to envelope
		String roleId = null;
		List<SignatureRoleInfo> roles = api.GetRolesList(userId, null).getResult().getRoles();
		for(SignatureRoleInfo role : roles){
			if(role.getName().equalsIgnoreCase("Signer")){
				roleId = role.getId();
			}
		}
		assertThat(roleId, not(nullValue()));
		String recipientId = api.AddSignatureEnvelopeRecipient(userId, envelopeId, "john@smith.com", "John", "Smith", null, roleId).getResult().getRecipient().getId();
		assertThat(recipientId, not(nullValue()));
		
		//add city field to envelope
		String fieldId = null;
		List<SignatureFieldInfo> fields = api.GetFieldsList(userId, null).getResult().getFields();
		for(SignatureFieldInfo field : fields){
			if(field.getFieldType() == 2){ // single line, see http://scotland.groupdocs.com/wiki/display/SDS/field.type
				fieldId = field.getId();
			}
		}
		assertThat(fieldId, not(nullValue()));
		SignatureEnvelopeFieldSettings envField = new SignatureEnvelopeFieldSettings();
		envField.setName("City");
		envField.setLocationX(0.3);
		envField.setLocationY(0.2);
		envField.setPage(1);
		api.AddSignatureEnvelopeField(userId, envelopeId, documentId, recipientId, fieldId, envField);
		
		//add signature field to envelope
		fieldId = null;
		envField = new SignatureEnvelopeFieldSettings();
		for(SignatureFieldInfo field : fields){
			if(field.getFieldType() == 1){ // signature, see http://scotland.groupdocs.com/wiki/display/SDS/field.type
				fieldId = field.getId();
			}
		}
		assertThat(fieldId, not(nullValue()));
		envField.setName("Signature");
		envField.setLocationX(0.3);
		envField.setLocationY(0.3);
		envField.setPage(1);
		api.AddSignatureEnvelopeField(userId, envelopeId, documentId, recipientId, fieldId, envField);
		
		//send envelope
		FileStream fs = new FileStream(IOUtils.toInputStream("http://jake.dyndns.biz:8080/dummyCallbackHandler"));
		SignatureStatusResponse envelopeSend = api.SignatureEnvelopeSend(userId, envelopeId, fs);
		assertThat(envelopeSend, not(nullValue()));
		assertThat(envelopeSend.getStatus(), equalTo("Ok"));
		
		String embedUrl = "https://" + server + "apps.groupdocs.com/signature/signembed/" + envelopeId + "/" + recipientId;
		System.out.println("Use following URL to sign the envelope: " + embedUrl);
	}

}
