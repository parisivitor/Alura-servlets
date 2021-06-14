package gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.modelo.Banco;
import gerenciador.modelo.Empresa;

public class NovaEmpresas implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

//		PrintWriter out = response.getWriter();

		String nome = request.getParameter("nome");
		String paramDataEmpresa = request.getParameter("data");
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa emp = new Empresa(nome);
		emp.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(emp);
		
		request.setAttribute("empresa", emp.getNome());
		
		System.out.println("Empresa " + nome + " cadastrada!");
//		redirecionando pelo navegador
		return "redirect:entrada?acao=ListaEmpresas";
		
		
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresa");
//		rd.forward(request, response);

		
		
	}

}
