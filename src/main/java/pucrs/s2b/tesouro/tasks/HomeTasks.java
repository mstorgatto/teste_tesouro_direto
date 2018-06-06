package pucrs.s2b.tesouro.tasks;

import org.openqa.selenium.WebDriver;

import pucrs.s2b.tesouro.appobjects.HomeAppObject;

public class HomeTasks {
	public HomeAppObject home;

	public HomeTasks(WebDriver driver) {
		this.home = new HomeAppObject(driver);
	}
	
	public void login(String login, String senha){
		home.getLoginTextField().sendKeys(login);
		home.getSenhaTextField().sendKeys(senha);
		home.getLogarButton().click();
		
	}

	public void extrato() {
		home.getBarraButton().click();
		home.getExtratoButton().click();
		home.getMesButton().click();
		home.getConsultarButton().click();
		
	}
	
	public void logout(){

		home.getSairButton().click();
	}
}