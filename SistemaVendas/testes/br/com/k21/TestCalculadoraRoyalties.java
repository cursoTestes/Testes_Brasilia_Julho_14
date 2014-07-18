package br.com.k21;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.k21.dao.VendaRepository;
import br.com.k21.modelo.Venda;

public class TestCalculadoraRoyalties {
	
	private VendaRepository vrMock;
	
	@Test
	public void testaMesEAnoSemVendas() {
		
		int mes =0, ano = 0 ;
		double totalRoyaltiesEsperado = 0.0;
		
		CalculadoraRoyalties cr = new CalculadoraRoyalties();

		Mockito.when(vrMock.obterVendasPorMesEAno(ano, mes)).thenReturn(new ArrayList<Venda>(0));
		cr.setVr(vrMock);

		double totalRoyalties = cr.calcula(mes,ano);

		assertEquals(totalRoyaltiesEsperado, totalRoyalties,0);
		
	}
	
	@Test
	public void testaMesEAnoComUmaVendaDeCem(){
		
		int mes = 11, ano=2002;
		
		double totalRoyaltiesEsperado = 19.0;
		
		CalculadoraRoyalties cr = new CalculadoraRoyalties();
		
		List<Venda> vendas = new ArrayList<Venda>(1);
		vendas.add(new Venda(1, 1, mes, ano, 100.0));
		
		Mockito.when(vrMock.obterVendasPorMesEAno(ano, mes)).thenReturn(vendas);
		cr.setVr(vrMock);
		
		double totalRoyalties = cr.calcula(mes,ano);

		assertEquals(totalRoyaltiesEsperado, totalRoyalties,0);
		
	}

	@Test
	public void testaMesEAnoComDuasVendasDeCem(){
		
		int mes = 11, ano=2002;
		
		double totalRoyaltiesEsperado = 40.0;
		
		CalculadoraRoyalties cr = new CalculadoraRoyalties();
		
		CalculadoraComissao cc = Mockito.mock(CalculadoraComissao.class);
		Mockito.when(cc.calcula(Mockito.anyDouble())).thenReturn(0.0);
		cr.setCalculadoraComissao(cc);
		
		List<Venda> vendas = new ArrayList<Venda>(1);
		vendas.add(new Venda(1, 1, mes, ano, 100.0));
		vendas.add(new Venda(2, 2, mes, ano, 100.0));
		
		Mockito.when(vrMock.obterVendasPorMesEAno(ano, mes)).thenReturn(vendas);
		cr.setVr(vrMock);
		
		double totalRoyalties = cr.calcula(mes,ano);

		assertEquals(totalRoyaltiesEsperado, totalRoyalties,0);
		Mockito.verify(cc, Mockito.times(1)).calcula(Mockito.anyDouble());
	}

	
	@Before
	private void inicializaMock() {
		vrMock = Mockito.mock(VendaRepository.class);
	}

	
}
