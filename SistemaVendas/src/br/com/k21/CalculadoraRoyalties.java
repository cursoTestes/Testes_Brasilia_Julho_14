package br.com.k21;

import java.util.List;

import br.com.k21.dao.VendaRepository;
import br.com.k21.modelo.Venda;

public class CalculadoraRoyalties {

	private VendaRepository vr = new VendaRepository();
	private CalculadoraComissao calculadoraComissao = new CalculadoraComissao();

	public double calcula(int mes, int ano) {
		List<Venda> vendas = vr.obterVendasPorMesEAno(ano, mes);
				
		double valor = 0.0d;
		for (Venda venda : vendas) {
			double valorLiquido = venda.getValor() ;
			valor += valorLiquido;
		}
		
		return valor * 0.2;
	}
	
	public VendaRepository getVr() {
		return vr;
	}

	public void setVr(VendaRepository vr) {
		this.vr = vr;
	}

	public CalculadoraComissao getCalculadoraComissao() {
		return calculadoraComissao;
	}

	public void setCalculadoraComissao(CalculadoraComissao calculadoraComissao) {
		this.calculadoraComissao = calculadoraComissao;
	}
	
}
