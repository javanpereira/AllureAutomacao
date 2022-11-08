package scripts;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;

import bases.BaseWebDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import pages.LoginPages;


public class RealizaLoginTest extends BaseWebDriver{
	private static Logger logger = Logger.getLogger(RealizaLoginTest.class);
	private LoginPages login = new LoginPages();


	@DisplayName("Realizar login no sistema praia de moitas")
	@Description("Este teste tem o objetivo de realizar login com sucesso no sistema Praia de Moitas. FB - Fluxo Básico.")
	@Severity(SeverityLevel.TRIVIAL)
	@Test
	public void realizarLoginComFalha() {
		
		getDriver().get("http://localhost/prototype");
		inseriTextoCampo("usuario", "jpa", 5);
		inseriTextoCampo("senha", "10151", 5);
		clickElemento("Acionando bot�o de Login", "acessar", 5);
		String resultado =  "Logout";
		espera(2);
		if(isElementPresent(By.linkText("Logout"))) {
			resultado =  "Logout";
			logger.info("login realizado com sucesso!");
		}else {
			resultado = "Erro";
			logger.error("login n�o realizado!");
		}	
		
		assertEquals("Checando login", "Logout",resultado);
	}
	
	


	@DisplayName("Realizar login no sistema praia de moitas")
	@Description("Este teste tem o objetivo de realizar login com sucesso no sistema Praia de Moitas. FB - Fluxo Básico.")
	@Severity(SeverityLevel.TRIVIAL)
	@Test
	public void realizarLoginSucesso() {
		
		getDriver().get("http://localhost/prototype");
		inseriTextoCampo("usuario", "10151", 5);
		inseriTextoCampo("10151", "senha", 5);
		clickElemento("Acionando bot�o de Login", "acessar", 5);
		String resultado =  "Logout";
		espera(3);
		if(isElementPresent(By.linkText("Logout"))) {
			resultado =  "Logout";
			logger.info("login realizado com sucesso!");
		}else {
			resultado = "Erro";
			logger.error("login n�o realizado!");
		}	
		assertEquals("Checando login", "Logout",resultado);
	}
	
	
	
	
	@DisplayName("Realizar login no sistema praia de moitas")
	@Description("Este teste tem o objetivo de realizar login com sucesso no sistema Praia de Moitas. FB - Fluxo Básico.")
	@Severity(SeverityLevel.TRIVIAL)
	@Test
	public void realizaLoginComSucesso() {
		getDriver().get("http://localhost/prototype");
		login.informarLogin();
		login.informarSenha();
		login.clicdfdfdfdarEmBotaoLogin();
		login.checarResultado();
		
	}
}
