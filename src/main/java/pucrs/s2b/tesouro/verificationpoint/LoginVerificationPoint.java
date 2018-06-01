package pucrs.s2b.tesouro.verificationpoint;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import pucrs.s2b.tesouro.framework.Report;
import pucrs.s2b.tesouro.framework.ScreenShot;

public class LoginVerificationPoint {

	private static final String LOGIN_MESSAGE = "Login Performed Successful.";

	private WebDriver driver;

	public LoginVerificationPoint(WebDriver driver) {
		this.driver = driver;
	}

	public void checkValidLoginMessage() {
		if(this.pageContains(LOGIN_MESSAGE)) {
			Report.log(Status.PASS, "Mensagem exibida corretamente.", ScreenShot.capture(driver));
		} else {
			Report.log(Status.FAIL, "Mensagem nao exibida conforme esperado.", ScreenShot.capture(driver));
		}
	}

	private boolean pageContains(String text){
		return this.driver.getPageSource().contains(text);
	}

}
