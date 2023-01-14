package com.tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.basepage.BasePage;
import com.functions.SignInFunc;
import com.utilities.ExcelUtils;

public class SignInTest extends BasePage {

	SignInFunc sifunc = new SignInFunc();

	@Test(description = "Validating signIn with valid user name and pwd", priority = 1, enabled = false)
	public void signInVerification() throws IOException {
		SignInFunc sif = new SignInFunc();
		sif.validSignIn();

	}

	@Test(description = "Verify by clicking on cancel button in SI and Create an Account Page", priority = 2, enabled = false)
	public void verifyCancelBtn() {

		sifunc.validateCancelBtnSIReg();

	}

	@Test(description = "Verify by Signinig from Google Account", priority = 3, enabled = false)
	public void verifySignInGoogleId() {

		sifunc.googleSignIn();

	}

	@Test(description = "Verify by Signinig from FaceBook Account", priority = 4, enabled = false)
	public void verifySignInFaceBookId() {

		sifunc.facebookSignIn();

	}

	@Test(description = "Verify by Signinig from Apple Account", priority = 5, enabled = false)
	public void verifySignInAppleId() {

		sifunc.appleSignIn();

	}

	@Test(description = "Verify by Signinig from Twitter Account", priority = 6, enabled = false)
	public void verifySignInTwitterId() {

		sifunc.twitterSignIn();

	}

	@Test(description = "Verify by Signinig Out after Login", priority = 7, enabled = true)
	public void verifySignOut() throws IOException {
		signInVerification();
		sifunc.signOutFunction();

	}
}