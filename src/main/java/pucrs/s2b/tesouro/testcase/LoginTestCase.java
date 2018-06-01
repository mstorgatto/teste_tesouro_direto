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
import pucrs.s2b.tesouro.verificationpoint.LoginVerificationPoint;

public class LoginTestCase {
	
	private WebDriver driver;
	
	private HomeTasks homePage;
	private LoginVerificationPoint verificationPoint;
	
	@Before
	public void setUp() {
		Report.startTest("Login");
		driver = Drivers.getChromeDriver();
		
		homePage = new HomeTasks(driver);
		verificationPoint = new LoginVerificationPoint(driver);
	}
	
	@Test
	public void testMain() {
		driver.get("https://tesourodireto.bmfbovespa.com.br/PortalInvestidor/login.aspx");
		driver.manage().window().maximize();
		
		Report.log(Status.INFO, "The website was loaded.", ScreenShot.capture(driver));
		
		homePage.login("02561004031", "livroroxo27#@");
		
		Report.log(Status.INFO, "Password and login data.", ScreenShot.capture(driver));
		
		verificationPoint.checkValidLoginMessage();
	}	

	@After
	public void tearDown() {
	driver.quit();
	}
}