package pucrs.s2b.tesouro.verificationpoint;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import pucrs.s2b.tesouro.framework.Report;
import pucrs.s2b.tesouro.framework.ScreenShot;

public class RedemptionVerificationPoint {
	
	private static final String REDEMPTION_MESSAGE = "Operação cancelada.";
	
	private WebDriver driver;
	
	public RedemptionVerificationPoint(WebDriver driver) {
		this.driver = driver;
	}
	
	public void checkRescueMessage() {
		if(this.pageContains(REDEMPTION_MESSAGE)) {
			Report.log(Status.PASS, "A mensagem de erro foi exibida corretamente.", ScreenShot.capture(driver));
		}		
		else {
			Report.log(Status.FAIL, "A mensagem de erro não foi exibida corretamente.", ScreenShot.capture(driver));
		}
	}

	private boolean pageContains(String text){
		return this.driver.getPageSource().contains(text);
	}
	
}

