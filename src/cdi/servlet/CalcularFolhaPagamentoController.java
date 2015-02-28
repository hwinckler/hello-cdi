package cdi.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cdi.folhapagamento.CalculadoraFolhaPagamento;
import cdi.folhapagamento.Folha;
import cdi.folhapagamento.Funcionario;
import cdi.folhapagamento.FuncionarioBuilder;
import cdi.folhapagamento.PlanoDeCargos;
import cdi.folhapagamento.Simulador;

@WebServlet(name = "calcular-folha", urlPatterns = { "/calcular-folha" })
public class CalcularFolhaPagamentoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Inject @Simulador(planoDeCargos = PlanoDeCargos.VERSAO_2013)
	private CalculadoraFolhaPagamento calculadoraFolha;
       
    public CalcularFolhaPagamentoController() {
    	System.out.println("Inicializando a servlet CalcularFolhaPagamento");
    }

    @PostConstruct
    public void ok(){
    	System.out.println("CalcularFolhaPagamento ok");
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FuncionarioBuilder builder = new FuncionarioBuilder();
		Funcionario f1 = builder.comSalarioBaseDe(1000.0).build();
		Funcionario f2 = builder.comSalarioBaseDe(2000.0).build();
		Funcionario f3 = builder.comSalarioBaseDe(3000.0).build();
		List<Funcionario> funcionarios = Arrays.asList(f1, f2, f3);
		System.out.println("Efetuando o cálculo...");
		Folha folha = calculadoraFolha.calculaFolha(funcionarios);
		
		//mensagem para o usuário
		response.getOutputStream().print("Calculo da folha executado com sucesso");
		//saída no console
		System.out.println("Fim.");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
