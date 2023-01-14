package com.pages;

import org.openqa.selenium.WebElement;

import com.basepage.BasePage;

public class MyHubPg extends BasePage {
	
	public static WebElement tabs() {
		WebElement tab = id("tab460777");
		return tab;
	}
	
	
	public static WebElement charts() {
		WebElement ch = xpath("//*[@id='_frame']");
		return ch;
	}
	

}
