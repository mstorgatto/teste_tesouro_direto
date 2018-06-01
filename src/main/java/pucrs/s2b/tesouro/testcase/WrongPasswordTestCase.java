package pucrs.s2b.tesouro.testcase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import pucrs.s2b.tesouro.framework.Drivers;
import pucrs.s2b.tesouro.framework.Report;
import pucrs.s2b.tesouro.framework.ScreenShot;
import pucrs.s2b.tesouro.tasks.AccountTasks;
import pucrs.s2b.tesouro.tasks.HomeTasks;
import pucrs.s2b.tesouro.verificationpoint.AccountVerificationPoint;

public class WrongPasswordTestCase {

	private WebDriver driver;

	private HomeTasks homePage;
	private AccountTasks accountPage;
	private AccountVerificationPoint verificationPoint;

	@Before
	public void setUp() {
		Report.startTest("Register Fails");
		driver = Drivers.getChromeDriver();

		homePage = new HomeTasks(driver);
		accountPage = new AccountTasks(driver);
		verificationPoint = new AccountVerificationPoint(driver);
	}

	@Test
	public void testMain() {
		driver.get("https://tesourodireto.bmfbovespa.com.br/PortalInvestidor/login.aspx");
		driver.manage().window().maximize();

		Report.log(Status.INFO, "The website has started.", ScreenShot.capture(driver));

		homePage.accessRegistrationPage();

		Report.log(Status.INFO, "Register Page loaded.", ScreenShot.capture(driver));

		accountPage.fillForm("02561004032", "abc12@");
		
		Report.log(Status.INFO, "Filling in the Fields.", ScreenShot.capture(driver));
		
		accountPage.toLogar();
		
		Report.log(Status.INFO, "logged in", ScreenShot.capture(driver));
				
		verificationPoint.checkPasswordFieldErrorMessage();
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}