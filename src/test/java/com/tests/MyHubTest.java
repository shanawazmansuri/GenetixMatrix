package com.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.basepage.BasePage;
import com.functions.MyHubFunc;
import com.functions.RegisterFunc;

public class MyHubTest extends BasePage {

	MyHubFunc mh = new MyHubFunc();

	@Test(description = "Validating My Hub after successfully login", priority = 0, enabled = true)
	public void myHubVerifications() {

		try {
			mh.verifyMyHub();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
