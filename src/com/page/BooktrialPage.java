package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BooktrialPage {

	@FindBy(xpath = "//input[@name='name']") WebElement parentName;
	@FindBy(xpath = "//input[@name='email']") WebElement emailId;
	@FindBy(xpath = "//input[@name='phone_number']") WebElement phoneNumber;
	@FindBy(xpath = "//input[@name='studentName']") WebElement studentName;
	@FindBy(xpath = "//div[@class='dd-header-title']") WebElement studentGrade;
	@FindBy(xpath = "//ul[@class='dd-list']/li[10]") WebElement gradeTen;
	@FindBy(xpath = "//div[@class='radio-contain']/label[@for='yes']") WebElement pcYes;
	@FindBy(xpath = "//button[@id=\"lead-submission\"]") WebElement bookClass;
	@FindBy(xpath = ".//div[@class='error']") WebElement errorMessage;
	@FindBy(xpath = ".//div[@class='congrats-text']") WebElement thankYouMessage;

	WebDriver driver;

	public BooktrialPage(WebDriver driver) {
		this.driver = driver;

	}


	public void verifyParentField(String parentNameText) throws InterruptedException{
		parentName.sendKeys(parentNameText);
		String errormessageActual=errorMessage.getText();
		Assert.assertTrue(errormessageActual.equals("Please enter a valid full name"));
		Thread.sleep(5000);
	}

	public void fillDetails(String textParentName, String textEmailId, String phoneNumberText, String textStudentName) throws InterruptedException {

		parentName.sendKeys(textParentName);
		emailId.sendKeys(textEmailId);
		phoneNumber.sendKeys(phoneNumberText);
		studentName.sendKeys(textStudentName);
		studentGrade.click();
		gradeTen.click();
		pcYes.click();
		bookClass.click();
		Thread.sleep(15000);
	}
	public void verifyAfterBooking(){
		
		String thankText=thankYouMessage.getText();
		Assert.assertTrue(thankText.equals("Thank you for registering."));
	}

}
