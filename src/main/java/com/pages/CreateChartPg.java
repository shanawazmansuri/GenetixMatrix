package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.basepage.BasePage;

public class CreateChartPg extends BasePage {

	public static WebElement createChartBtn() {
		WebElement ccb = xpath("//button[@data-target='.createchartmodel']");
		return ccb;
	}
	
	public static WebElement closeBtn() {
		List<WebElement> cb = elements("//span[@class='modalclose']");
		return cb.get(1);
	}

	public static WebElement personOrAnimalBtn() {
		WebElement pa = xpath("//button[@data-chartform='FoundationChartModal']");
		return pa;
	}

	public static WebElement persondropDown() {
		WebElement pdd = id("select2-pet-type-container");
		return pdd;
	}
	
	public static WebElement search() {
		WebElement ps = xpath("//input[@type='search']");
		return ps;
	}
	
	public static List<WebElement> personOptions() {
		List<WebElement> po = elements("//ul[@id='select2-pet-type-results']/li");
		return po;
	}
	
	public static WebElement myFolders() {
		WebElement fo = id("select2-tree_folder-container");
		return fo;
	}
	
	public static List<WebElement> myFoldersOptions() {
		List<WebElement> fo = elements("//ul[@id='select2-tree_folder-results']/li");
		return fo;
	}
	
	public static WebElement createBtn() {
		WebElement ccb = name("_submit_foundation_chart_hybrid");
		return ccb;
	}
	
	public static WebElement tile() {
		WebElement tile = id("tab876910");
		return tile;
	}
	
	

}
