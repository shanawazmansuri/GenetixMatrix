package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.basepage.BasePage;

public class ForgotPasswordPg extends BasePage {

	public static WebElement forgotPassLnk() {
		WebElement fpl = xpath("//a[text()='Forgot password?']");
		return fpl;
	}

	public static WebElement verifyForgotPassTxt() {
		WebElement vfpt = xpath("//h3[text()='Forgotten Login Details?']");
		return vfpt;
	}

	public static WebElement forgotPassEmail() {
		WebElement fpe = xpath("//input[@placeholder='Email']");
		return fpe;
	}

	public static WebElement sendBtn() {
		WebElement sb = xpath("//button[text()='Send']");
		return sb;
	}

	public static WebElement forPwdCloseBtn() {

		List<WebElement> cb = elements("//i[@id = 'close-icon']//following::i");
		return cb.get(3);
	}
	
	public static WebElement fpMessage() {
		WebElement fpm = xpath("//p[contains(text(),'A password reset link has been sent')]");
		return fpm;
	}
}
