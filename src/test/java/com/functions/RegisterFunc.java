package com.functions;

import java.io.IOException;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.basepage.BasePage;
import com.pages.RegisterPg;
import com.pages.SignInPg;
import com.utilities.ExtentReportConf;
import com.utilities.ScreenShot;

public class RegisterFunc extends BasePage {

	ExtentTest reg;
	ExtentTest can;
	ExtentTest si;
	ExtentTest regNow;
	ExtentTest socialMedia;
	ExtentTest tc;

	private String firstName;
	private String lastName;
	private String emailId;
	private String userName;
	private String password;
	private String confPassword;

	public RegisterFunc(String firstName, String lastName, String emailId, String userName, String password,
			String confPassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.userName = userName;
		this.password = password;
		this.confPassword = confPassword;
	}

	public RegisterFunc() {

	}

	public void validUserRegister() throws IOException {

		try {

			reg = ExtentReportConf.createTest("Valid Registration");

			click(RegisterPg.registerBtnHP());
			reg.pass("Clicked on Register button of Home Page");

			waitTovisibleElement(RegisterPg.crAnAccHeading(), 30);
			String headTxt = RegisterPg.crAnAccHeading().getText().trim();
			Assert.assertEquals(headTxt, "Create an Account");
			reg.pass("Landed successfully on Register Page");

			enterText(RegisterPg.firstName(), firstName);
			reg.pass("Entered First Name as " + firstName);

			enterText(RegisterPg.lastName(), lastName);
			reg.pass("Entered Last Name as " + lastName);

			enterText(RegisterPg.userName(), userName);
			reg.pass("Entered User Name as " + userName);

			enterText(RegisterPg.emailId(), emailId);
			reg.pass("Entered Email Address as " + emailId);

			enterText(RegisterPg.password(), password);
			reg.pass("Entered Password as " + password);

			String eyeStat = gettextByAttribute(RegisterPg.password(), "type");
			if (eyeStat.equals("password")) {
				click(RegisterPg.passwordEye());
				reg.pass("Clicked on Eye Icon of Password field");
				
				eyeStat = gettextByAttribute(RegisterPg.password(), "type");
				Assert.assertEquals(eyeStat, "text");
				reg.pass("Asserted Password is visible");

			}

			enterText(RegisterPg.confPassword(), confPassword);
			reg.pass("Entered Confirm Password as " + confPassword);

			String eye2Stat = gettextByAttribute(RegisterPg.confPassword(), "type");
			if (eye2Stat.equals("password")) {
				click(RegisterPg.confPasswordEye());
				reg.pass("Clicked on Eye Icon of Confirm Password field");
				
				eye2Stat = gettextByAttribute(RegisterPg.password(), "type");
				Assert.assertEquals(eye2Stat, "text");
				reg.pass("Asserted Confirm Password is visible");


			}

			click(RegisterPg.registerBtn());
			reg.pass("Click on Register Button");

			waitTovisibleElement(RegisterPg.successfullyRegMsg(), 10);
			assertEquals(RegisterPg.successfullyRegMsg(),
					"Registered Successfully. Please click on the Activation Link sent to your registered email address.");
			reg.pass("Verified Registration successful msg as " + gettext(RegisterPg.successfullyRegMsg()));

		} catch (Exception e) {

			String re = ScreenShot.screenShotExtentReport(driver, "Register");
			reg.fail(e);
			reg.addScreenCaptureFromPath(re);

		}
	}

	public void closeBtnCheck() throws IOException {

		try {

			can = ExtentReportConf.createTest("Verify Cancel button Register Window");

			click(RegisterPg.registerBtnHP());
			can.pass("Clicked on Register button of Home Page");

			waitTovisibleElement(RegisterPg.crAnAccHeading(), 30);
			String headTxt = RegisterPg.crAnAccHeading().getText().trim();
			Assert.assertEquals(headTxt, "Create an Account");
			can.pass("Landed successfully on Register Page");

			click(RegisterPg.closeBtnReg());
			can.pass("Clicked on Close button of Register Page");

			waitTovisibleElement(RegisterPg.homePageLanding(), 30);
			boolean homePg = isDisplayed(RegisterPg.homePageLanding());
			assertTrue(homePg);
			can.pass("Successfully landed on Home Page after closing Register window");
			
			
			
			
		} catch (Exception e) {

			String reCancel = ScreenShot.screenShotExtentReport(driver, "RegCancel");
			can.fail(e);
			can.addScreenCaptureFromPath(reCancel);

		}

	}

	public void registerWindowSignIn() throws IOException {

		try {
			si = ExtentReportConf.createTest("Register Window access from SignIn Page");


			click(RegisterPg.signInHP());
			si.pass("Clicked on SignIn button of Home Page");


			waitTovisibleElement(RegisterPg.createAnAccountlink(), 30);
			click(RegisterPg.createAnAccountlink());
			si.pass("Clicked on Create an Account link");


			waitTovisibleElement(RegisterPg.createAnAccountTxt(), 10);
			String crAccTxt = gettext(RegisterPg.createAnAccountTxt()).trim();
			Assert.assertEquals(crAccTxt, "Create an Account");
			si.pass("Successfully landed on Create an Account window");


			click(RegisterPg.closeBtnReg());
			si.pass("Clicked on Close button of Register Page");


			waitTovisibleElement(RegisterPg.homePageLanding(), 30);
			boolean homePg = isDisplayed(RegisterPg.homePageLanding());
			assertTrue(homePg);
			si.pass("Successfully landed on Home Page after closing Register window");
			
			
		} catch (Exception e) {

			String signReg = ScreenShot.screenShotExtentReport(driver, "SignInReg");
			si.fail(e);
			si.addScreenCaptureFromPath(signReg);
		}

	}

	public void registerWindowRegisterNowBtn() throws IOException {

		try {
			regNow = ExtentReportConf.createTest("Register Window access from Register Now button from Home Page");

			waitToClick(RegisterPg.registerNowBtnHP(), 10);
			click(RegisterPg.registerNowBtnHP());
			regNow.pass("Clicked on Register Now button of Home Page");

			waitTovisibleElement(RegisterPg.createAnAccountTxt(), 10);
			String crAccTxt = gettext(RegisterPg.createAnAccountTxt()).trim();
			Assert.assertEquals(crAccTxt, "Create an Account");
			regNow.pass("Successfully landed on Create an Account window");

			click(RegisterPg.closeBtnReg());
			regNow.pass("Clicked on Close button of Register Page");

			waitTovisibleElement(RegisterPg.homePageLanding(), 30);
			boolean homePg = isDisplayed(RegisterPg.homePageLanding());
			assertTrue(homePg);
			regNow.pass("Successfully landed on Home Page after closing Register window");
		} catch (Exception e) {

			String regisNowBtn = ScreenShot.screenShotExtentReport(driver, "RegisterNowBtn");
			regNow.fail(e);
			regNow.addScreenCaptureFromPath(regisNowBtn);
		}

	}

	public void googleSignIn() {

		socialMedia = ExtentReportConf.createTest("Google SignIn");

		click(RegisterPg.registerBtnHP());
		socialMedia.pass("Clicked on Register button of Home Page");

		waitTovisibleElement(RegisterPg.crAnAccHeading(), 30);
		String headTxt = RegisterPg.crAnAccHeading().getText().trim();
		Assert.assertEquals(headTxt, "Create an Account");
		socialMedia.pass("Landed successfully on Register Page");

		click(RegisterPg.socialMediaLogin().get(4));
		socialMedia.pass("Clicked on Google Icon");

		waitTovisibleElement(RegisterPg.googleText(), 30);
		assertEquals(RegisterPg.googleText(), "Sign in with Google");
		socialMedia.pass("Successfully Landed on Google Sign In page");

	}

	public void facebookSignIn() {

		socialMedia = ExtentReportConf.createTest("Facebook SignIn");

		click(RegisterPg.registerBtnHP());
		socialMedia.pass("Clicked on Register button of Home Page");

		waitTovisibleElement(RegisterPg.crAnAccHeading(), 30);
		String headTxt = RegisterPg.crAnAccHeading().getText().trim();
		Assert.assertEquals(headTxt, "Create an Account");
		socialMedia.pass("Landed successfully on Register Page");

		click(RegisterPg.socialMediaLogin().get(5));
		socialMedia.pass("Clicked on FaceBook Icon");

		waitTovisibleElement(RegisterPg.faceBookText(), 30);
		assertEquals(RegisterPg.faceBookText(), "Log in to Facebook");
		socialMedia.pass("Successfully Landed on FaceBook Sign In page");

	}

	public void appleSignIn() {

		socialMedia = ExtentReportConf.createTest("Apple SignIn");

		click(RegisterPg.registerBtnHP());
		socialMedia.pass("Clicked on Register button of Home Page");

		waitTovisibleElement(RegisterPg.crAnAccHeading(), 30);
		String headTxt = RegisterPg.crAnAccHeading().getText().trim();
		Assert.assertEquals(headTxt, "Create an Account");
		socialMedia.pass("Landed successfully on Register Page");

		click(RegisterPg.socialMediaLogin().get(6));
		socialMedia.pass("Clicked on Apple Icon");

		waitTovisibleElement(RegisterPg.appleText(), 30);
		assertEquals(RegisterPg.appleText(), "Use your Apple ID to sign in to Genetic Matrix.");
		socialMedia.pass("Successfully Landed on Apple Sign In page");

	}

	public void twitterSignIn() {

		socialMedia = ExtentReportConf.createTest("Twitter SignIn");
		click(RegisterPg.registerBtnHP());
		socialMedia.pass("Clicked on Register button of Home Page");

		waitTovisibleElement(RegisterPg.crAnAccHeading(), 30);
		String headTxt = RegisterPg.crAnAccHeading().getText().trim();
		Assert.assertEquals(headTxt, "Create an Account");
		socialMedia.pass("Landed successfully on Register Page");

		click(RegisterPg.socialMediaLogin().get(7));
		socialMedia.pass("Clicked on Twitter Icon");

		waitTovisibleElement(RegisterPg.twitterText(), 30);
		assertEquals(RegisterPg.twitterText(), "Authorize Gm Live to access your account?");
		socialMedia.pass("Successfully Landed on Twitter Sign In page");

	}
	
	public void termsCondition() {

		tc = ExtentReportConf.createTest("RegTermsCondition");
		click(RegisterPg.registerBtnHP());
		tc.pass("Clicked on Register button of Home Page");

		waitTovisibleElement(RegisterPg.crAnAccHeading(), 30);
		String headTxt = RegisterPg.crAnAccHeading().getText().trim();
		Assert.assertEquals(headTxt, "Create an Account");
		tc.pass("Landed successfully on Register Page");

		click(RegisterPg.regTermsCond());
		tc.pass("Clicked on Terms And Condition Link");

		waitTovisibleElement(RegisterPg.termsCondCaption(), 30);
		Assert.assertTrue(gettext(RegisterPg.termsCondCaption()).contains("Privacy, Terms & Conditions:"));
		tc.pass("Successfully Landed on Register Terms and Condition Page");
		
		back();
		tc.pass("Navigated Back to Home Page");

	}
}