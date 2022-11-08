package bases;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;



public class BaseWebDriver {
	
	private static WebDriver driver;
	private static Logger logger = Logger.getLogger(BaseWebDriver.class);
	
	
	
	
	public static WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	
	/**
	 * @param campo - Elemento responsavel por receber o elemento da tela.
	 * @param textoCampo - Recebe o texto referente ao campo informado na planilha.
	 * @param wait - Tempo que o script deve esperar ate o elemento ficar disponivel na tela.
	 * @author javan.azevedo
	 */
	@Step("Preenchendo campo:{0} com valor {1}")
	public void inseriTextoCampo(String campo, String textoCampo, int wait) {		
		if(textoCampo != "")
		{	WebElement elementoTexto = null;
			salvarTextoEmLog(getClass().getSimpleName()+" - "+"Iniciando o método de preenchimento do campo ["+campo+"] com valor ["+textoCampo+"]");
			try {   
			       elementoTexto =  (new WebDriverWait(getDriver(), wait))
			       .until(ExpectedConditions.visibilityOfElementLocated(By.name(campo)));			   
			       /**Verifica se o elemento estão desativado na tela */
			       if(!elementoTexto.isEnabled()) {
			    	   try{		    		      
			    		     salvarTextoEmLog(getClass().getSimpleName()+" - "+"Erro. O campo ["+campo+ "] estar desabilitado para preenchimento.");	
			    	   	  }
				    	   catch (NoSuchWindowException e) {							
								salvarTextoEmLog(getClass().getSimpleName()+" - "+"Erro de comunicação com o navegador remoto. Ele pode ter sido fechado.\n "+e.getCause());						
								assertEquals("Chencando elemento:", elementoTexto.getText(),campo);
				    	   }
			    	   
						  catch(org.openqa.selenium.remote.UnreachableBrowserException e){								
								salvarTextoEmLog(getClass().getSimpleName()+" - "+"Erro de comunicação com o navegador remoto. Ele pode ter sido fechado.\n "+e.getCause());										
						  }
			       }
			       else{
			    	   elementoTexto.clear();
				       elementoTexto.sendKeys(textoCampo);				      
				       salvarTextoEmLog(getClass().getSimpleName()+" - "+"Finalizando o método de preenchimento do campo ["+campo+"] com valor ["+textoCampo+"]");
			       }     
		      }
			  catch (NoSuchWindowException e) {					
					salvarTextoEmLog(getClass().getSimpleName()+" - "+"Erro de comunicação com o navegador remoto. Ele pode ter sido fechado.\n "+e.getCause());
			  }
			  catch(org.openqa.selenium.remote.UnreachableBrowserException e){				
					salvarTextoEmLog(getClass().getSimpleName()+" - "+"Erro de comunicação com o navegador remoto. Ele pode ter sido fechado.\n "+e.getCause());	
			  }
			  catch(org.openqa.selenium.TimeoutException e) {		
				salvarTextoEmLog(getClass().getSimpleName()+" - "+"Erro. Tempo de localização do elemento ["+campo+ "] expirado. Elemento indisponivel.\n "+e.getCause());				
				//assertEquals("Chencando elemento:", elementoTexto.getText(),campo);
			  }
 			  catch(WebDriverException e){
 				 salvarTextoEmLog(getClass().getSimpleName()+" - "+"Erro. Não foi possivel limpar o campo ["+campo+"]: "+textoCampo+ ". O elemento precisa ser editável pelo usuário para ser limpado.\n "+e.getCause());	  
			  }
			  catch (NullPointerException e) {
				salvarTextoEmLog(getClass().getSimpleName()+" - "+"Erro ao inserir texto no campo ["+textoCampo+"].\n "+e.getCause());
			 }
		}
		else{
				salvarTextoEmLog(getClass().getSimpleName()+" - "+"Erro. Campo ["+textoCampo+ "] não preenchido no arquivo.");
			}
	}
	@Step("{0}. Elemento [{1}]. Tempo de espera [{2}]")
	public String clickElemento(String observacao, String elemento, int wait) {
		
		WebElement elementoClick = null;
		if(elemento != "")
		{		//logger.debug("Iniciando o método para clicar no elemento: "+elemento);	
				salvarTextoEmLog(getClass().getSimpleName()+" - "+"Iniciando o método para clicar no elemento: ["+elemento+"]");	
				try{	
						//isElementPresentBy(By.id("ajaxStatusLoadingBackground"),Tempo.getTempoEsperaConsulta());
						elementoClick =  (new WebDriverWait(getDriver(), wait))
						.until(ExpectedConditions.elementToBeClickable(By.name(elemento)));
						elementoClick.click();
						//logger.debug("Finalizando o método para clicar no elemento: "+elemento);
						salvarTextoEmLog(getClass().getSimpleName()+" - "+"Finalizando o método para clicar no elemento: ["+elemento+"]");	
				  }			 
				catch (org.openqa.selenium.NoSuchWindowException e) {
					salvarTextoEmLog(getClass().getSimpleName()+" - "+"Erro de comunicação com o navegador remoto. A janela do navegador pode ter sido fechada.\n "+e.getCause());
				  }
			  	 catch(org.openqa.selenium.remote.UnreachableBrowserException e){
			  		salvarTextoEmLog(getClass().getSimpleName()+" - "+"Erro de comunicação com o navegador remoto. Ele pode ter sido fechado.\n "+e.getCause());						  
			  	 }
				 
				 catch(TimeoutException e){			
					//logger.error("Botão ["+observacao+"] não encontrado. Tempo de ["+wait+"s] para localização do elemento ["+elemento+"] expirado. ");		
					salvarTextoEmLog(getClass().getSimpleName()+" - "+"Erro. Botão ["+observacao+"] não encontrado. Tempo de ["+wait+"s] para localização do elemento ["+elemento+"] expirado.\n "+e.getCause());		
					//assertEquals("Chencando elemento:", elementoClick.getText(),elemento);	
				 }
				 catch(NoSuchElementException e){						
				 	//logger.error("Elemento ["+elemento+"] não encontrado na tela.");
				 	salvarTextoEmLog(getClass().getSimpleName()+" - "+"Erro. Elemento ["+elemento+"] não encontrado na tela.\n "+e.getCause());
				 }
				 catch(java.lang.NullPointerException e){						
					// logger.error("Erro ao clicar no elemento ["+observacao+"] do campo ["+elemento+"."+e.getStackTrace());
					 salvarTextoEmLog(getClass().getSimpleName()+" - "+"Erro ao clicar no elemento ["+observacao+"] do campo ["+elemento+".\n "+e.getCause());
				}
				catch(org.openqa.selenium.ElementClickInterceptedException e){
					//logger.debug("Não foi possivel clicar no elemento ["+elemento+"]. ");
					salvarTextoEmLog(getClass().getSimpleName()+" - "+"Erro. Não foi possivel clicar no elemento ["+elemento+"]. ");
				}
				catch(org.openqa.selenium.WebDriverException e){						
					// logger.error("Erro ao clicar no elemento ["+observacao+"] do campo ["+elemento+"."+e.getStackTrace());
					 salvarTextoEmLog(getClass().getSimpleName()+" - "+"Erro ao clicar no elemento ["+observacao+"] do campo ["+elemento+".\n "+e.getCause());
				}
				
			}
			else{
				//logger.error("Elemento referente " +observacao+ "não foi encontrado.");
				salvarTextoEmLog(getClass().getSimpleName()+" - "+"Erro. Elemento referente a [" +observacao+ "] não foi encontrado. ");
			}
			return elemento;
		
	}
	
	/**
	 * Verifica se o elemento informado estar presente na tela.
	 * @param local - Recebe o nome no elemento to tipo By. Ex: By.name("nome")).
	 * @return - true se o elemento estar disponivel, do contr�rio, false.
	 */
	public boolean isElementPresent(By local) {
		boolean present = false;
		try {
			getDriver().findElement(local);
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			logger.warn("Elemento [" + local+ "] não encontrado na tela. Elemento indisponivel.");
			present = false;
		} catch (TimeoutException e) {
			logger.info("Tempo de localização do elemento [" + local+ "] expirado.");
			present = false;
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			present = false;
			logger.info("Nenhum elemento [" + local + "] encontrado.");
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			logger.error("Erro ao acessar elemento [" + local + "]. ");
			present = false;
		}
		return present;
	}
	/**
	 * M�todo de espera para continuar execuo do script. 
	 * M�todo espera a quantidade de segundos informados para liberar a execuo da pr�xima ao.
	 * @param segundos - recebe X segundos e converte para milissegundos.
	 * @author javan.azevedo
	 * @return 
	 */
	public int espera(int segundos){
	 try {
		  segundos = segundos * 1000;
		  Thread.sleep(segundos);
	 } 
	 catch (InterruptedException e) {
		 logger.error("Erro método espera." +e.getStackTrace());
	  }
	return segundos;
	}
	
	
	
	@Before
	public void iniciarWebDriver() {
		
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver-v0.27.0-win64/geckodriver.exe");	        		        	
		//bloqueia a exibição de log do marionnete/webdriver = System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true"); 
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		//return new FirefoxDriver();
		FirefoxOptions fOptions = new FirefoxOptions();        	      
		setDriver(new FirefoxDriver(fOptions));		
	}
	
	@After
	public void fechaDriver() {
		getDriver().quit();
	}
	
	
	@Attachment(value="{descricaoScreenShot}", type="image/png")
	public static byte[] salvarEvidencia(String descricaoScreenShot) {
		
		WebDriver driver = BaseWebDriver.getDriver();
		TakesScreenshot screenshotTaker = ((TakesScreenshot)driver);
		String imagemFileDir = System.getProperty("selenium.screenshot.dir");
		if(imagemFileDir == null) 
			imagemFileDir = System.getProperty("java.io.tmpdir");	
		try {
			FileUtils.copyFile(screenshotTaker.getScreenshotAs(OutputType.FILE), new File(imagemFileDir, "evidencia.png"));
		}catch (WebDriverException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotTaker.getScreenshotAs(OutputType.BYTES);
		
	}
	@Attachment(value="{0}", type="text/plain")
	public static String salvarTextoEmLog(String mensagem) {
		if(mensagem.contains("Erro") || mensagem.contains("ERRO")) {
			logger.error(mensagem);
			salvarEvidencia("evidencia");
		}else {
			logger.info(mensagem);
		}
		return mensagem;
		
	}
	
	@Attachment(value="{titulo}", type="text/plain")
	public static String saveTextLog(String titulo, String mensagem) {
		logger.info(titulo);
		return mensagem;
		
	}
	
		
	
	
	
}
