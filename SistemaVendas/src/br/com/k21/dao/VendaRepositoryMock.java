package br.com.k21.dao;

import java.util.Arrays;
import java.util.List;

import br.com.k21.modelo.Venda;

public class VendaRepositoryMock implements IVendaRepository {

	public List<Venda> obterVendasPorMesEAno(int ano , int mes ){
		
		List<Venda> retorno = Arrays.asList(new Venda(1,1,mes,ano,100));
		return retorno;
		
	}
	
}
