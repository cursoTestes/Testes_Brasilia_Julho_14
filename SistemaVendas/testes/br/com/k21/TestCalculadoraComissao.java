package br.com.k21;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class TestCalculadoraComissao {
	
	@Test
	public void calculaComissaoVendaCemReais() {
		
		double valor = 100;
		double esperado = 5;
		
		double retorno = CalculadoraComissao.calcula(valor);
		
		assertEquals(esperado, retorno, 0);
	}
	
	@Test
	public void calculaComissaoVendaCentoEOnzeECinquentaReais() {
		
		double valor = 111.5;
		double esperado = 5.57;
		
		double retorno = CalculadoraComissao.calcula(valor);
		
		assertEquals(esperado, retorno, 0);
	}
	
	
	@Test
	public void calculaComissaoVendaUmReal() {
		
		int valor = 1;
		double esperado = 0.05;
		
		double retorno = CalculadoraComissao.calcula(valor);
		
		assertEquals(esperado, retorno,0);
	}
	
	
	@Test
	public void calculaComissaoVendaOnzeMillReais() {
		
		double valor = 11000;
		double esperado = 660;
		
		double retorno = CalculadoraComissao.calcula(valor);
		
		assertEquals(esperado, retorno, 0);
	}
	
	
	
}
