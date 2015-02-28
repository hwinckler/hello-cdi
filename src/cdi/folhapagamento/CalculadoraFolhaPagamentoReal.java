package cdi.folhapagamento;

import java.util.List;

public class CalculadoraFolhaPagamentoReal implements CalculadoraFolhaPagamento {

	@Override
	public Folha calculaFolha(List<Funcionario> funcionarios) {
		
		System.out.println("Efetua o cálculo real da folha de pagamentos");
		
		return null;
	}

}
