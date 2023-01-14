package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.basepage.BasePage;

public class RegisterPg extends BasePage {

	public static WebElement registerBtnHP() {
		WebElement reg = xpath("//button[@class='btn registerbtn']");
		return reg;
	}

	public static WebElement crAnAccHeading() {
		WebElement head = xpath("//h3[contains(text(),'Create an Account')]");
		return head;
	}

	public static WebElement firstName() {
		WebElement fn = id("reg-fname");
		return fn;
	}

	public static WebElement lastName() {
		WebElement ln = id("reg-lname");
		return ln;
	}

	public static WebElement emailId() {
		WebElement email = id("reg-email");
		return email;
	}

	public static WebElement userName() {
		WebElement un = id("reg-name");
		return un;
	}

	public static WebElement password() {
		WebElement pwd = id("reg-pass");
		return pwd;
	}

	public static WebElement confPassword() {
		WebElement cpwd = id("reg-conf");
		return cpwd;
	}

	public static WebElement passwordEye() {
		WebElement pwde = xpath("//div[@class='btn regpass']");
		return pwde;
	}

	public static WebElement confPasswordEye() {
		WebElement cpwde = xpath("//div[@class='btn forgetpass']");
		return cpwde;
	}

	public static WebElement capchaChkBx() {
		WebElement cap = xpath("//span[@id='recaptcha-anchor']");
		return cap;
	}

	public static WebElement registerBtn() {
		WebElement reg = id("gmInput signInBtn");
		return reg;
	}

	public static WebElement closeBtnReg() {

		List<WebElement> cb = elements("//span[@class='modalclose']");
		return cb.get(3);

	}

	public static WebElement successfullyRegMsg() {
		WebElement msg = id("error");
		return msg;
	}

	public static WebElement homePageLanding() {
		WebElement hp = xpath("//a[@class='navbar-brand logo']");
		return hp;
	}

	public static WebElement signInHP() {
		List<WebElement> sihp = elements("//a[contains(text(),'Sign In')]");
		return sihp.get(0);
	}

	public static WebElement signInTxt() {
		WebElement sit = xpath("//h3[text()='Sign In']");
		return sit;
	}

	public static WebElement createAnAccountlink() {
		WebElement caa = xpath("//a[contains(text(),\"Create an account\")]");
		return caa;
	}

	public static WebElement createAnAccountTxt() {
		WebElement caat = xpath("//h3[contains(text(),'Create an Account')]");
		return caat;

	}

	public static WebElement registerNowBtnHP() {
		WebElement rn = xpath("//div[@class='btn sliderbtn register-btn']");
		return rn;

	}

	public static List<WebElement> socialMediaLogin() {
		List<WebElement> sm = elements("//img[@id='socialMediaIcon']");
		return sm;
	}

	public static WebElement googleText() {
		WebElement gt = xpath("//div[@class='kHn9Lb']");
		return gt;
	}

	public static WebElement faceBookText() {
		WebElement fb = xpath("//div[@class='_9axz']");
		return fb;
	}

	public static WebElement appleText() {
		WebElement ap = xpath("//h1[@class='si-container-title tk-intro  ']");
		return ap;
	}

	public static WebElement twitterText() {
		WebElement tw = xpath("//h2[contains(text(),'Authorize Gm Live to access your account?')]");
		return tw;
	}

}
