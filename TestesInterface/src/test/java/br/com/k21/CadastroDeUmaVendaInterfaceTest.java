package br.com.k21;

import junit.framework.Assert;

import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;

public class CadastroDeUmaVendaInterfaceTest extends FluentTest {

	@Test
	public void teste_cadastra_uma_venda_Sem_preencher_campos_obrigatorios() {
		goTo("http://localhost:58034/Venda/Add");
		fill("#Vendedor").with("");
		fill("#DataVenda").with("");
		fill("#Valor").with("");
		
		submit("input[type=\"submit\"]");
		
		Assert.assertEquals("O campo Id Vendedor é obrigatório.", findFirst("#validacaoVendedor").getText()); 
		Assert.assertEquals("O campo Valor é obrigatório.", findFirst("#validacaoValor").getText()); 
		Assert.assertEquals("O campo Data Venda é obrigatório.", findFirst("#validacaoDataVenda").getText());
					
	}
	
	@Test
	public void teste_cadastra_uma_venda_preenchendo_campo_IdVendendor_NaoNumerico() {
		goTo("http://localhost:58034/Venda/Add");
		fill("#Vendedor").with("asdasd");
		fill("#DataVenda").with("18/07/2014");
		fill("#Valor").with("100,00");
		
		submit("input[type=\"submit\"]");
		
		Assert.assertEquals("O campo Id Vendedor deve ser numerico.", findFirst("#validacaoVendedor").getText()); 
					
	}
	
}
