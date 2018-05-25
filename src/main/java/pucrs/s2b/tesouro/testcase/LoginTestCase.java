package pucrs.s2b.tesouro.testcase;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pucrs.s2b.tesouro.verificationpoint.LoginTesVerificationPoint;

public class LoginTestCase {
	private WebDriver driver ;
	private LoginTesVerificationPoint verificationPoint;
	
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		this.driver.get("https://tesourodireto.bmfbovespa.com.br/PortalInvestidor/login.aspx");
		
		this.verificationPoint = new LoginTesVerificationPoint(driver);
	}	
	
	@Test
	public void testMain() {
		WebElement usernameTextField = this.driver.findElement(By.id("BodyContent_txtLogin"));
		usernameTextField.sendKeys("02561004031");
		
		WebElement passwordTextField = this.driver.findElement(By.id("BodyContent_txtSenha"));
		passwordTextField.sendKeys("livroroxo27#@");
		
		WebElement SubmitButton = this.driver.findElement(By.id("BodyContent_btnLogar"));
		SubmitButton.click();
		
		verificationPoint.checkHelloMessage();
	}
	}
