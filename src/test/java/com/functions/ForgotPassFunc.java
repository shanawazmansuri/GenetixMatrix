package com.functions;

import java.io.IOException;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.basepage.BasePage;
import com.pages.ForgotPasswordPg;
import com.pages.SignInPg;
import com.utilities.ExtentReportConf;
import com.utilities.ScreenShot;

public class ForgotPassFunc extends BasePage {

	ExtentTest ForgetPwd;
	ExtentTest cancelButton;


	public void validateForPwd() throws IOException {

		try {
			ForgetPwd = ExtentReportConf.createTest("Forgot Password");

			click(SignInPg.signInHP());
			ForgetPwd.pass("Clicked on SignIn button of Home Page");
			
			waitTovisibleElement(ForgotPasswordPg.forgotPassLnk(), 10);
			click(ForgotPasswordPg.forgotPassLnk());
			ForgetPwd.pass("Clicked on Forgot Password link on Sign In Page");
			
			waitTovisibleElement(ForgotPasswordPg.verifyForgotPassTxt(), 10);
			assertEquals(ForgotPasswordPg.verifyForgotPassTxt(), "Forgotten Login Details?");
			ForgetPwd.pass("Landed on the Forgot Password Page");

			String emailId = pro.prop.getProperty("forgotPwd");
			enterText(ForgotPasswordPg.forgotPassEmail(), emailId);
			ForgetPwd.pass("Email Address entered in the Email text box as "+ emailId);

			click(ForgotPasswordPg.sendBtn());
			ForgetPwd.pass("Clicked on the Send button on Create an Account popup");
			
			assertTrueContains(ForgotPasswordPg.fpMessage(), "A password reset link has been sent to your email.");
			ForgetPwd.pass("Asserted Text message after password change as "+gettext(ForgotPasswordPg.fpMessage()));
			
			
			
			
		} catch (Exception e) {
			String fp = ScreenShot.screenShotExtentReport(driver, "ForPwd");
			ForgetPwd.fail(e);
			ForgetPwd.addScreenCaptureFromPath(fp);
		}
	}
	
	
	

		
}
