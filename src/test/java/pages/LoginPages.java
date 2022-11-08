package pages;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import bases.BaseWebDriver;
import bases.ReportUtils;
import bases.Tempo;
import io.qameta.allure.Step;

public class LoginPages extends BaseWebDriver{
	private static Logger logger = Logger.getLogger(LoginPages.class);

	@Step("Informar o login")
	public void informarLogin() {
		inseriTextoCampo("usuario","jpa",  Tempo.getTempoWait());
	}
	@Step("Informar a senha")
	public void informarSenha() {
		inseriTextoCampo("senha","10151", Tempo.getTempoEspera());
	}
	@Step("Clicar no botão Login")
	public void clicarEmBotaoLogin() {
		clickElemento("Acessar", "cessar", Tempo.getTempoEspera());
	}
	
	@Step("Chegar o resultado do teste")
	public void checarResultado() {
		String resultado =  "Logout";
		espera(2);
		if(isElementPresent(By.linkText("Logout"))) {
			resultado =  "Logout";
			salvarTextoEmLog("login realizado com sucesso!");
		}else {
			resultado = "Erro";		
			salvarTextoEmLog("Erro: login não realizado!");
			salvarEvidencia("Teste screnshot");
			
		}	
		assertEquals("Checando login", "Logout",resultado);
	}
}
