package com.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.basepage.BasePage;
import com.functions.LanguageFunc;

public class LanguageTest extends BasePage {
	
	LanguageFunc lf = new LanguageFunc();
	
	@Test
	public void verifyLanguage() throws IOException
	{
		lf.selectLanguage();
	}

}
