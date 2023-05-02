package com.functions;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.basepage.BasePage;
import com.pages.SignInPg;
import com.utilities.ExtentReportConf;
import com.utilities.ScreenShot;

public class SignInFunc extends BasePage {

	public SignInFunc() {

	}

	ExtentTest signIn;
	ExtentTest cancel;
	ExtentTest socialMedia;
	ExtentTest LogOut;

	public void validSignIn() throws IOException {

		try {

			signIn = ExtentReportConf.createTest("Valid SignIn");

			click(SignInPg.signInHP());
			signIn.pass("Clicked on SignIn button of Home Page");

			waitTovisibleElement(SignInPg.signInTxt(), 30);
			System.out.println(SignInPg.signInTxt().getText());
			assertEquals(SignInPg.signInTxt(), "Sign In");
			signIn.pass("Landed successfully on SignIn Page");

			String username = pro.prop.getProperty("username2");
			enterText(SignInPg.userName(), username);
			signIn.pass("Entered User name as " + username);

			String password = pro.prop.getProperty("password2");
			enterText(SignInPg.pwd(), password);
			signIn.pass("Entered Password as " + password);

			click(SignInPg.eye());
			signIn.pass("Clicked on Eye button");

			String pwdDisplay = gettextByAttribute(SignInPg.pwd(), "type");
			Assert.assertEquals(pwdDisplay, "text");
			signIn.pass("Password displayed after clicking on Eye button");

			boolean kmsiStatus = isSelected(SignInPg.keepMeSignIn());
			Assert.assertEquals(kmsiStatus, true);
			signIn.pass("Keep me Sign in check box is selected");

			click(SignInPg.signInButton());
			signIn.pass("Clicked on SignIn Button");

			try {

				click(SignInPg.closeBtn().get(0));

			} catch (Exception e) {
				click(SignInPg.closeBtn().get(0));
				signIn.pass("Closed Create Foundation Chart");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			assertTrueContains(SignInPg.afterLoginTxtVerify(), "Welcome,");
			signIn.pass("Logged In successfully with User Name");

		} catch (Exception e) {

			String si = ScreenShot.screenShotExtentReport(driver, "SignIn");
			signIn.fail(e);
			signIn.addScreenCaptureFromPath(si);

		}
	}

	public void validateCancelBtnSIReg() {
		cancel = ExtentReportConf.createTest("Cancel SignInPage");

		click(SignInPg.signInHP());
		cancel.pass("Clicked on SignIn button of Home Page");

		waitToClick(SignInPg.createAnAccountlink(), 10);
		click(SignInPg.createAnAccountlink());
		cancel.pass("Clicked on Create an Account link");

		waitTovisibleElement(SignInPg.createAnAccountTxt(), 10);
		String crAccTxt = gettext(SignInPg.createAnAccountTxt()).trim();
		Assert.assertEquals(crAccTxt, "Create an Account");

		click(SignInPg.closeBtn().get(3));
		cancel.pass("Clicked on the close button on Create an Account Page");

		waitToClick(SignInPg.signInHP(), 10);
		click(SignInPg.signInHP());
		cancel.pass("Clicked on SignIn button of Home Page");

		waitToClick(SignInPg.closeBtn().get(2), 10);
		click(SignInPg.closeBtn().get(2));
		cancel.pass("Clicked on the close button on SignIn Page");

	}

	public void googleSignIn() {

		socialMedia = ExtentReportConf.createTest("Google SignIn");
		click(SignInPg.signInHP());
		socialMedia.pass("Clicked on SignIn button of Home Page");

		waitTovisibleElement(SignInPg.signInTxt(), 30);
		System.out.println(SignInPg.signInTxt().getText());
		assertEquals(SignInPg.signInTxt(), "Sign In");
		socialMedia.pass("Landed successfully on SignIn Page");

		click(SignInPg.socialMediaLogin().get(0));
		socialMedia.pass("Clicked on Google Icon");

		waitTovisibleElement(SignInPg.googleText(), 30);
		assertEquals(SignInPg.googleText(), "Sign in with Google");
		socialMedia.pass("Successfully Landed on Google Sign In page");

	}

	public void facebookSignIn() {

		socialMedia = ExtentReportConf.createTest("FaceBook SignIn");
		click(SignInPg.signInHP());
		socialMedia.pass("Clicked on SignIn button of Home Page");

		waitTovisibleElement(SignInPg.signInTxt(), 30);
		System.out.println(SignInPg.signInTxt().getText());
		assertEquals(SignInPg.signInTxt(), "Sign In");
		socialMedia.pass("Landed successfully on SignIn Page");

		click(SignInPg.socialMediaLogin().get(1));
		socialMedia.pass("Clicked on FaceBook Icon");

		waitTovisibleElement(SignInPg.faceBookText(), 30);
		assertEquals(SignInPg.faceBookText(), "Log in to Facebook");
		socialMedia.pass("Successfully Landed on FaceBook Sign In page");

	}

	public void appleSignIn() {

		socialMedia = ExtentReportConf.createTest("Apple SignIn");
		click(SignInPg.signInHP());
		socialMedia.pass("Clicked on SignIn button of Home Page");

		waitTovisibleElement(SignInPg.signInTxt(), 30);
		System.out.println(SignInPg.signInTxt().getText());
		assertEquals(SignInPg.signInTxt(), "Sign In");
		socialMedia.pass("Landed successfully on SignIn Page");

		click(SignInPg.socialMediaLogin().get(2));
		socialMedia.pass("Clicked on Apple Icon");

		waitTovisibleElement(SignInPg.appleText(), 30);
		assertEquals(SignInPg.appleText(), "Use your Apple ID to sign in to Genetic Matrix.");
		socialMedia.pass("Successfully Landed on Apple Sign In page");

	}

	public void twitterSignIn() {

		socialMedia = ExtentReportConf.createTest("Twitter SignIn");
		click(SignInPg.signInHP());
		socialMedia.pass("Clicked on SignIn button of Home Page");

		waitTovisibleElement(SignInPg.signInTxt(), 30);
		System.out.println(SignInPg.signInTxt().getText());
		assertEquals(SignInPg.signInTxt(), "Sign In");
		socialMedia.pass("Landed successfully on SignIn Page");

		click(SignInPg.socialMediaLogin().get(3));
		socialMedia.pass("Clicked on Twitter Icon");

		waitTovisibleElement(SignInPg.twitterText(), 30);
		assertTrueContains(SignInPg.twitterText(), "Gm Live to access your account?");
		socialMedia.pass("Successfully Landed on Twitter Sign In page");

	}

	public void signOutFunction() throws IOException {

		LogOut = ExtentReportConf.createTest("Verify Logout");

		click(SignInPg.logoutBtn());
		LogOut.pass("Clicked on Logout button at home page");

		boolean siStatus = isDisplayed(SignInPg.signInHP());
		assertTrue(siStatus);
		LogOut.pass("Successfully Logged out and SignIn button is displayed");

	}

}
