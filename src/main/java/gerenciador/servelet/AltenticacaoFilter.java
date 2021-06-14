package gerenciador.servelet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AltenticacaoFilter
 */
@WebFilter("/entrada")
public class AltenticacaoFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void destroy() {}

	public void doFilter(ServletRequest serveletRequest, ServletResponse serveletResponse, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) serveletRequest;
		HttpServletResponse response = (HttpServletResponse) serveletResponse;

		String paraAcao = request.getParameter("acao");

		HttpSession sessao = request.getSession();
		boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
		boolean naoEhUmaAcaoProtegida = !(paraAcao.equals("Login") || paraAcao.equals("LoginForm"));

		if (naoEhUmaAcaoProtegida && usuarioNaoEstaLogado) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}

		chain.doFilter(request, response);
	}

}
