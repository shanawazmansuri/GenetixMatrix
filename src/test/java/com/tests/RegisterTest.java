package com.tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.basepage.BasePage;
import com.functions.RegisterFunc;
import com.functions.SignInFunc;
import com.utilities.ExcelUtils;

public class RegisterTest extends BasePage {

	RegisterFunc register = new RegisterFunc();

	@DataProvider(name = "Register")
	public Object[][] registerData() {
		Object[][] data = ExcelUtils.excelData(".\\ExcelData\\GM.xls", "Register");
		return data;
	}

	@Test(dataProvider = "Register", description = "Validating by registering new User with proper data", priority = 1, enabled = false)
	public void signInVerification(String firstName, String lastName, String emailId, String userName, String password,
			String confPassword) {
		RegisterFunc reg = new RegisterFunc(firstName, lastName, emailId, userName, password, confPassword);
		try {
			reg.validUserRegister();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(description = "Validating close button should close Register window", priority = 2, enabled = false)
	public void registerWindowClosing() {

		try {
			register.closeBtnCheck();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(description = "Verify opening Register window from Sign In Create an Account link", priority = 3, enabled = false)
	public void verifyRegisterSignInPg() {

		try {
			register.registerWindowSignIn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(description = "Verify opening Register window from Register Now button on home page", priority = 4, enabled = false)
	public void verifyRegisterRegisterNowBtn() {

		try {
			register.registerWindowRegisterNowBtn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(description = "Verify by Signinig from Google Account", priority = 5, enabled = false)
	public void verifySignInGoogleId() {

		register.googleSignIn();

	}

	@Test(description = "Verify by Signinig from FaceBook Account", priority = 6, enabled = false)
	public void verifySignInFaceBookId() {

		register.facebookSignIn();

	}

	@Test(description = "Verify by Signinig from Apple Account", priority = 7, enabled = false)
	public void verifySignInAppleId() {

		register.appleSignIn();

	}

	@Test(description = "Verify by Signinig from Twitter Account", priority = 8, enabled = true)
	public void verifySignInTwitterId() {

		register.twitterSignIn();
	}

}