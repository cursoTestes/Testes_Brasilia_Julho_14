package br.com.k21;

import junit.framework.Assert;

import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LoginPJETest extends FluentTest{

	public static final String URL = "";	
	
	 public WebDriver getDefaultDriver() {
	        return new InternetExplorerDriver();
	    }
	
	@Test
	public void testeLoginComSucesso(){
		
		logar();
		
		Assert.assertEquals("Desconectar", findFirst("a[href=\"/pje16_t/logout.seam\"]").getText().trim()); 
		
	}
	
	@Test
	public void testePessoaFisica(){
		
		logar();
		goTo("http://listView.seam");
		fill("#pessoaFisicaGridSearchForm:j_id1004:j_id1006:nome").with("Crucis");
		submit("#pessoaFisicaGridSearchForm:search");
		
	}

	private void logar() {
		goTo(URL);
		fill("#username").with("");
		fill("#password").with("");
		
		submit("#btnEntrar");
	}
	
}
