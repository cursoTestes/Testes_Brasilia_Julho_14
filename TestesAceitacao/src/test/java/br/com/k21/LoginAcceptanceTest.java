package br.com.k21;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.k21.infraestrutura.BaseAcceptanceTest;

public class LoginAcceptanceTest extends BaseAcceptanceTest {
	
	@Test
	public void teste_login_com_sucesso() {
		Integer entradasEsperadasNaTabela = 1;
		String texto_mensagem_sucesso = "Welcome, cfc!";

		// act
		driver.get("http://localhost:8080/AceitacaoComJava/login.seam");

		driver.findElement(By.id("loginForm:username")).sendKeys("cfc");
		driver.findElement(By.id("loginForm:password")).sendKeys("123456");
		driver.findElement(By.id("loginForm:submit")).click();

		WebElement element = driver.findElement(By
				.xpath("id('messages')/li[2]"));

		Assert.assertEquals(texto_mensagem_sucesso, element.getText());

		Integer resultadoEntradasSucessoLog = (Integer) emf.createEntityManager()
				.createNativeQuery("select count(*) from SucessoLogin")
				.getSingleResult();

		Assert.assertEquals(entradasEsperadasNaTabela,
				resultadoEntradasSucessoLog);

	}
	
	@Test
	public void teste_login_com_senha_errada() {
		Integer entradasEsperadasNaTabela = 1;
		String texto_mensagem_sucesso = "Login failed";

		// act
		driver.get("http://localhost:8080/AceitacaoComJava/login.seam");

		driver.findElement(By.id("loginForm:username")).sendKeys("cfc");
		driver.findElement(By.id("loginForm:password")).sendKeys("1");
		driver.findElement(By.id("loginForm:submit")).click();

		WebElement element = driver.findElement(By
				.xpath("id('messages')/li[2]"));

		Assert.assertEquals(texto_mensagem_sucesso, element.getText());

		Integer resultadoEntradasSucessoLog = (Integer) emf.createEntityManager()
				.createNativeQuery("select count(*) from FalhaLogin")
				.getSingleResult();

		Assert.assertEquals(entradasEsperadasNaTabela,
				resultadoEntradasSucessoLog);

	}

	
}
