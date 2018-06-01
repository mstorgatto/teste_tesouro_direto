package pucrs.s2b.tesouro.tasks;

import pucrs.s2b.tesouro.appobjects.AccountAppObject;

import org.openqa.selenium.WebDriver;

public class AccountTasks {
	
	public AccountAppObject appObjects;
	
	public AccountTasks(WebDriver driver){
		this.appObjects = new AccountAppObject(driver);
	}
	
	public void fillForm(String login, String senha){
		appObjects.getLoginTextField().sendKeys(login);
		appObjects.getSenhaTextField().sendKeys(senha);
	
	}
	
	public void toLogar(){
		appObjects.getLogarButton().click();
	}
}
