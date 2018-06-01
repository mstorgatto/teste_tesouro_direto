package pucrs.s2b.tesouro.verificationpoint;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import pucrs.s2b.tesouro.framework.Report;
import pucrs.s2b.tesouro.framework.ScreenShot;

public class PasswordErrorVerificationPoint {
	
	private static final String PASSWORD_ERROR_MESSAGE = "The password you entered is incorrect.";
	
	private WebDriver driver;
	
	public PasswordErrorVerificationPoint(WebDriver driver) {
		this.driver = driver;
	}
	
	public void checkLoginFieldErrorMessage() {
		if(this.pageContains(PASSWORD_ERROR_MESSAGE)) {
			Report.log(Status.FAIL, "The error message did not display as expected.", ScreenShot.capture(driver));
		}
		
		else {
			Report.log(Status.PASS, "The error message was displayed correctly.", ScreenShot.capture(driver));
		}
	}

	private boolean pageContains(String text){
		return this.driver.getPageSource().contains(text);
	}
	
}