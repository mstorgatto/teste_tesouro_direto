package pucrs.s2b.tesouro.verificationpoint;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import pucrs.s2b.tesouro.framework.Report;
import pucrs.s2b.tesouro.framework.ScreenShot;

public class LoginVerificationPoint {

	private static final String LOGIN_MESSAGE = "Login and Password performed successful.";

	private WebDriver driver;

	public LoginVerificationPoint(WebDriver driver) {
		this.driver = driver;
	}

	public void checkValidLoginMessage() {
		if(this.pageContains(LOGIN_MESSAGE)) {
			Report.log(Status.FAIL, "Message not displayed as expected. Error in executing the function.", ScreenShot.capture(driver));
		} 
		
		else {
			Report.log(Status.PASS, "Message displayed correctly. Functionality executed successfully.", ScreenShot.capture(driver));
		}
	}

	private boolean pageContains(String text){
		return this.driver.getPageSource().contains(text);
	}

}
