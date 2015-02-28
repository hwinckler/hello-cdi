package cdi.servlet;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cdi.hello.HelloWorld;

/**
 * Servlet implementation class HelloCDI
 */
@WebServlet(name = "hello", urlPatterns = { "/hello" })
public class HelloController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Inject
	private HelloWorld hello = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloController() {
        super();
        System.out.println("Instanciando a Servlet...");
    }
    
    @PostConstruct
    public void ok(){
    	System.out.println("Servlet pronta.");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String texto = hello.say();
		System.out.println(texto);
		
		response.getOutputStream().print(texto);
		System.out.println("Fim.");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	

}
