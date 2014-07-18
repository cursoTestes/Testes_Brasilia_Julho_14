package br.com.k21.dao;

import java.util.List;

import br.com.k21.modelo.Venda;

public interface IVendaRepository {

	public List<Venda> obterVendasPorMesEAno(int ano , int mes );
	
}