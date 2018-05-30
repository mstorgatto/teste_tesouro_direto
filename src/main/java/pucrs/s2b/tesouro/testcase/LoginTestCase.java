package pucrs.s2b.tesouro.testcase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pucrs.s2b.tesouro.verificationpoint.LoginTesVerificationPoint;

public class LoginTestCase {
	private WebDriver driver;
	private LoginTesVerificationPoint verificationPoint;

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		this.driver.get("https://tesourodireto.bmfbovespa.com.br/PortalInvestidor/login.aspx");
		this.driver.manage().window().maximize();

		this.verificationPoint = new LoginTesVerificationPoint(driver);
	}

	@Test
	public void testMain() throws InterruptedException {
		WebElement usernameTextField = this.driver.findElement(By.id("BodyContent_txtLogin"));
		usernameTextField.sendKeys("02561004031");

		WebElement passwordTextField = this.driver.findElement(By.id("BodyContent_txtSenha"));
		passwordTextField.sendKeys("livroroxo27#@");

		Thread.sleep(4000);	
		
		WebElement SubmitButton = this.driver.findElement(By.id("BodyContent_btnLogar"));
		SubmitButton.click();

		WebElement ButtonEntrar = this.driver
				.findElement(By.xpath("//*[@id=\"barra-top-bar\"]/div/nav/section/ul/li[5]"));
		ButtonEntrar.click();

		Thread.sleep(7000);

		WebElement ButtonExtrato = this.driver
				.findElement(By.xpath("//*[@id=\"barra-top-bar\"]/div/nav/section/ul/li[5]/ul/li[6]/a"));
		ButtonExtrato.click();

		Thread.sleep(7000);

		WebElement ButtonMes = this.driver.findElement(By.xpath("//*[@id=\"BodyContent_ddlMes\"]/option[4]"));
		ButtonMes.click();

		Thread.sleep(7000);

		WebElement ButtonConsultar = this.driver.findElement(By.xpath("//*[@id=\"BodyContent_btnConsultar\"]"));
		ButtonConsultar.click();

		Thread.sleep(7000);

		WebElement ButtonSair = this.driver.findElement(By.xpath("//*[@id=\"Topo_lkbSair1\"]"));
		ButtonSair.click();

		Thread.sleep(2000);
	}
		
		@After
		public void tearDown() throws InterruptedException {
		this.driver.close();

	}

}
