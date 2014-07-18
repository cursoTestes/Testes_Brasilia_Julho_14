package br.com.k21;

public class CalculadoraComissao {

	public double calcula(double valor) {
		double comissao=0;
		if(valor <= 10000){
			comissao = valor * 0.05;
			comissao = trataArrendondamento(comissao);
		}
		else{
			comissao = 660;
		}
		
		return comissao;
	}

	private static double trataArrendondamento(double comissao) {
		comissao = comissao*100;
		comissao = Math.floor(comissao);
		comissao = comissao/100.0;
		return comissao;
	}
	
}
