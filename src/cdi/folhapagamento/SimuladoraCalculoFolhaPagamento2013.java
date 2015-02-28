package cdi.folhapagamento;

import java.util.List;

@Simulador(planoDeCargos = PlanoDeCargos.VERSAO_2013)
public class SimuladoraCalculoFolhaPagamento2013 implements CalculadoraFolhaPagamento {

	@Override
	public Folha calculaFolha(List<Funcionario> funcionarios) {
		
		System.out.println("Simulação com 2013");
		
		return null;
	}

}
