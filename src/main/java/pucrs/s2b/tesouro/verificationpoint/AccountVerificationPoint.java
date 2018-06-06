package pucrs.s2b.tesouro.verificationpoint;

import pucrs.s2b.tesouro.framework.Report;
import pucrs.s2b.tesouro.framework.ScreenShot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

public class AccountVerificationPoint {
	
	private static final String LOGIN_ERROR_MESSAGE = "The login you entered is incorrect.";
	
	private WebDriver driver;
	
	public AccountVerificationPoint(WebDriver driver) {
		this.driver = driver;
	}
	
	public void checkLoginFieldErrorMessage() {
		if(this.pageContains(LOGIN_ERROR_MESSAGE)) {
			Report.log(Status.FAIL, "Mensagem de login invalido não foi exibida corretamente.", ScreenShot.capture(driver));
		}
		
		else {
			Report.log(Status.PASS, "Mensagem de login invalido foi exibida corretamente.", ScreenShot.capture(driver));
		}
	}

	private boolean pageContains(String text){
		return this.driver.getPageSource().contains(text);
	}
	
}