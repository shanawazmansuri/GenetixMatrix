package com.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.basepage.BasePage;
import com.functions.ForgotPassFunc;

public class ForgotPassTest extends BasePage {

	@Test(description = "To validate the forgot password functionality on Sign In Page", priority = 1, enabled = true)
	public void verifyForgotPassword() {

		ForgotPassFunc fp = new ForgotPassFunc();
		try {
			fp.validateForPwd();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
