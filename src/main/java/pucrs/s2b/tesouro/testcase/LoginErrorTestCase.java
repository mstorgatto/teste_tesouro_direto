package pucrs.s2b.tesouro.testcase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import pucrs.s2b.tesouro.framework.Drivers;
import pucrs.s2b.tesouro.framework.Report;
import pucrs.s2b.tesouro.framework.ScreenShot;
import pucrs.s2b.tesouro.tasks.HomeTasks;
import pucrs.s2b.tesouro.verificationpoint.AccountVerificationPoint;

public class LoginErrorTestCase {

	private WebDriver driver;

	public HomeTasks homePage;
	private AccountVerificationPoint verificationPoint;

	@Before
	public void setUp() {
		Report.startTest("Login");
		driver = Drivers.getChromeDriver();

		homePage = new HomeTasks(driver);
		verificationPoint = new AccountVerificationPoint(driver);
	}

	@Test
	public void testMain() throws InterruptedException {
		driver.get("https://tesourodireto.bmfbovespa.com.br/PortalInvestidor/login.aspx");
		driver.manage().window().maximize();

		Report.log(Status.INFO, "The website has started.", ScreenShot.capture(driver));

		Thread.sleep(2000);

		homePage.login("02561004122", "abcd1#@");

		Thread.sleep(2000);
		
		Report.log(Status.INFO, "Incorrect password warning.", ScreenShot.capture(driver));
		
		verificationPoint.checkLoginFieldErrorMessage();

	}

	@After
	public void tearDown() throws InterruptedException {

		Thread.sleep(2000);

		driver.quit();
	}
}