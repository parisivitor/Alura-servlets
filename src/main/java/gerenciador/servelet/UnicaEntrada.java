package gerenciador.servelet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gerenciador.acao.Acao;
import gerenciador.acao.AlteraEmpresas;
import gerenciador.acao.ListaEmpresas;
import gerenciador.acao.MostraEmpresas;
import gerenciador.acao.NovaEmpresas;
import gerenciador.acao.NovaEmpresasForm;
import gerenciador.acao.RemoveEmpresas;

@WebServlet("/entrada")
public class UnicaEntrada extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paraAcao = request.getParameter("acao");

		String nomeDaClasse = "gerenciador.acao." + paraAcao;
		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse); // carrega a cl;asse com seu respppectivo nome
			Acao acao = (Acao) classe.newInstance(); // instancia um objeto e faz type cast para o tipo acao
			nome = acao.executa(request, response); // faz o metodo que esta assinado
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}

		String[] tipoEndereco = nome.split(":");
		if (tipoEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEndereco[1]);
		}

//		if(paraAcao.equals("ListaEmpresas")) {
//			ListaEmpresas acao = new ListaEmpresas();
//			nome = acao.executa(request,response);
//						
//		} else if(paraAcao.equals("RemoveEmpresas")) {
//			RemoveEmpresas acao = new RemoveEmpresas();
//			nome = acao.executa(request,response);
//			
//		}else if(paraAcao.equals("MostraEmpresas")) {
//			MostraEmpresas acao = new MostraEmpresas();
//			nome = acao.executa(request,response);
//			
//		}else if(paraAcao.equals("AlteraEmpresas")) {
//			AlteraEmpresas acao = new AlteraEmpresas();
//			nome = acao.executa(request,response);
//			
//		}else if(paraAcao.equals("NovaEmpresas")) {
//			NovaEmpresas acao = new NovaEmpresas();
//			nome = acao.executa(request,response);
//			
//		}else if(paraAcao.equals("NovaEmpresasForm")) {
//			NovaEmpresasForm acao = new NovaEmpresasForm();
//			nome = acao.executa(request,response);
//		}

	}

}
