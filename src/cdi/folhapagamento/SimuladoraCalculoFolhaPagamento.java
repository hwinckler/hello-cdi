package cdi.folhapagamento;

import java.util.List;

@Simulador
public class SimuladoraCalculoFolhaPagamento implements CalculadoraFolhaPagamento {

	@Override
	public Folha calculaFolha(List<Funcionario> funcionarios) {
		
		System.out.println("Simula��o com 2005");
		
		return null;
	}

}
