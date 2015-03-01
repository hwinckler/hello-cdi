package cdi.folhapagamento;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

@Alternative @Priority(Interceptor.Priority.APPLICATION + 2)
public class CalculadoraDeSalarios2005 implements CalculadoraDeSalarios {

	@Inject
	public CalculadoraDeSalarios2005() {
		System.out.println("Iniciando Calculadora de salários...");
	}

	@PostConstruct
	public void init(){
		System.out.println("Calculadora de salários pronta!");
	}

	@Override
	public double calculaSalario(Funcionario funcionario) {
		
		System.out.println("calculando salario de " + funcionario.getNome());

		double salario = funcionario.getCargo().getSalarioBase();
		Escolaridade escolaridadeFuncionario = funcionario.getEscolaridade();
		Escolaridade escolaridadeCargo = funcionario.getCargo().getEscolaridadeDesejada();
		// se o funcionário tem escolaridade inferior
		// à esperada para o cargo
		if (escolaridadeFuncionario.compareTo(escolaridadeCargo) < 0) {
			salario = salario * 0.8;
		}
		// se o funcionário tem escolaridade superior
		// à esperada para o cargo
		else if (escolaridadeFuncionario.compareTo(escolaridadeCargo) > 0) {
			salario = salario * 1.2;
		}
		int anoAtual = getAnoAtual();
		int anoAdmissao = funcionario.getAnoAdmissao();
		// dá 1% de aumento para cada ano trabalhado na empresa
		double anosTrabalhados = anoAtual - anoAdmissao;
		double aumentoAntiguidade = anosTrabalhados / 100;
		salario = salario * (1 + aumentoAntiguidade);
		// se tem mais de 5 anos na empresa tem aumento de 10%
		if (anosTrabalhados > 5) {
			salario = salario * 1.1;
		}
		return salario;
	}


	private int getAnoAtual() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}
}
