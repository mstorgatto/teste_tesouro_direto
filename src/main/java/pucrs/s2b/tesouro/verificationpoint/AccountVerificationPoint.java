package pucrs.s2b.tesouro.verificationpoint;

import pucrs.s2b.tesouro.framework.Report;
import pucrs.s2b.tesouro.framework.ScreenShot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

public class AccountVerificationPoint {
	
	private static final String PASSWORD_ERROR_MESSAGE = "The password you entered do not match.";
	
	private WebDriver driver;
	
	public AccountVerificationPoint(WebDriver driver) {
		this.driver = driver;
	}
	
	public void checkLoginFieldErrorMessage() {
		if(this.pageContains(PASSWORD_ERROR_MESSAGE)) {
			Report.log(Status.FAIL, "A mensagem de erro nao foi exibida conforme esperado.", ScreenShot.capture(driver));
		}
		
		else {
			Report.log(Status.PASS, "A mensagem de erro foi exibida corretamente.", ScreenShot.capture(driver));
		}
	}

	private boolean pageContains(String text){
		return this.driver.getPageSource().contains(text);
	}
	
}