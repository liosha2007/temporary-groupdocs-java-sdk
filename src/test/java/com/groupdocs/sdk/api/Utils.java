package com.groupdocs.sdk.api;

import com.groupdocs.sdk.model.SignatureContactInfo;
import com.groupdocs.sdk.model.SignatureContactSettings;
import com.groupdocs.sdk.model.SignatureEnvelopeInfo;
import com.groupdocs.sdk.model.SignatureEnvelopeSettings;

public class Utils {

	public static void copy(SignatureContactInfo src,
			SignatureContactSettings dest) {
		dest.setEmail(src.getEmail());
		dest.setFirstName(src.getFirstName());
		dest.setLastName(src.getLastName());
	}

	public static void copy(SignatureEnvelopeInfo src,
			SignatureEnvelopeSettings dest) {
//		dest.set
	}

}
