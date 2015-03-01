package cdi.folhapagamento;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;
import javax.interceptor.Interceptor;

@Alternative @Priority(Interceptor.Priority.APPLICATION + 1)
public class CalculadoraDeSalarios2013 implements CalculadoraDeSalarios {

	@Override
	public double calculaSalario(Funcionario funcionario) {
		System.out.println("CalculadoraDeSalarios2013");
		return 0;
	}

}
