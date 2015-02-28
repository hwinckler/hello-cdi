package cdi.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cdi.folhapagamento.CalculadoraDeSalarios;
import cdi.folhapagamento.FuncionarioBuilder;

/**
 * Servlet implementation class CalcularSalarioController
 */
@WebServlet(name = "calcular-salario", urlPatterns = { "/calcular-salario" })
public class CalcularSalarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private CalculadoraDeSalarios calculadoraDeSalarios = null;
	
    public CalcularSalarioController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		calculadoraDeSalarios.calculaSalario(new FuncionarioBuilder().build());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
