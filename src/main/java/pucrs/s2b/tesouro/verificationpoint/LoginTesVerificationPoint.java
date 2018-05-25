package pucrs.s2b.tesouro.verificationpoint;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

public class LoginTesVerificationPoint {

	private WebDriver driver;

	public LoginTesVerificationPoint(WebDriver driver) {
		this.driver = driver;
	}

	public void checkHelloMessage() {
		final String expectedMessage = "Hi demo";
		assertTrue(this.driver.getPageSource().contains(expectedMessage));
	}
}