package com.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.page.BooktrialPage;
import com.utils.BrowserUtil;


public class FormFillingTest extends BrowserUtil {

	@Test(priority=0)
	public void verifyParenField() throws InterruptedException {
		BooktrialPage btp = PageFactory.initElements(driver, BooktrialPage.class);
		btp.verifyParentField("1232142131");

	}

	
	@Test(priority=1)
	public void verifyBooking() throws InterruptedException {
		BooktrialPage btp = PageFactory.initElements(driver, BooktrialPage.class);

		btp.fillDetails("naresh", "nareshg@yopmail.com", "8375843378", "yukthaa");

	}
}
