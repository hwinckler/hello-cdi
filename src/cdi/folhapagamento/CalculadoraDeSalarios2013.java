package cdi.folhapagamento;

import javax.enterprise.inject.Alternative;

@Alternative
public class CalculadoraDeSalarios2013 implements CalculadoraDeSalarios {

	@Override
	public double calculaSalario(Funcionario funcionario) {
		System.out.println("CalculadoraDeSalarios2013");
		return 0;
	}

}
