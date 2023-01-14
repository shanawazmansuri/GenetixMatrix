package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.basepage.BasePage;

public class SignInPg extends BasePage {

	public static WebElement signInHP() {
		WebElement sihp = xpath("//a[contains(text(),'Sign In')]");
		return sihp;
	}

	public static WebElement signInTxt() {
		WebElement sit = xpath("//h3[text()='Sign In']");
		return sit;
	}

	public static WebElement createAnAccountlink() {
		WebElement caa = xpath("//a[contains(text(),'Create an account')]");
		return caa;
	}

	public static WebElement createAnAccountTxt() {
		WebElement caat = xpath("//h3[contains(text(),'Create an Account')]");
		return caat;

	}

	public static List<WebElement> closeBtn() {
		List<WebElement> cb = elements("//i[@id='close-icon']");
		return cb;
	}

	public static WebElement userName() {
		WebElement un = xpath("//input[@placeholder='Username or email']");
		return un;
	}

	public static WebElement pwd() {
		WebElement pd = id("pwd");
		return pd;
	}

	public static WebElement eye() {
		WebElement eye = xpath("//i[@class='bi bi-eye-slash-fill logpass-icon']");
		return eye;
	}

	public static WebElement keepMeSignIn() {
		WebElement kmsi = xpath("//input[@type='checkbox']");
		return kmsi;
	}

	public static WebElement signInButton() {
		WebElement si = xpath("//button[text()='Sign In']");
		return si;
	}

	public static WebElement afterLoginTxtVerify() {
		WebElement alText = xpath("//span[contains(text(),'Welcome,')]");
		return alText;
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
	
	public static WebElement logoutBtn() {
		WebElement lo = xpath("//a[contains(text(),'Logout')]");
		return lo;
	}

}