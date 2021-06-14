package gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> listaUsuario = new ArrayList<>();
	private static Integer id = 1;

	static {
		Empresa emp = new Empresa("Alura");
		emp.setId(id++);
		Empresa emp2 = new Empresa("Caelum");
		emp2.setId(id++);
		Banco.lista.add(emp);
		Banco.lista.add(emp2);
		
		Usuario u1 = new Usuario();
		u1.setLogin("vitor");
		u1.setSenha("123123");
		Usuario u2 = new Usuario();
		u2.setLogin("carol");
		u2.setSenha("123123");
		Banco.listaUsuario.add(u1);
		Banco.listaUsuario.add(u2);
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(id++);
		Banco.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {
		Iterator<Empresa> it = lista.iterator();
		
		while(it.hasNext()) {
			Empresa emp =  it.next();
			if(emp.getId() == id) {
				it.remove();
			}
		}
	}

	public Empresa buscaEmpresaPorId(Integer id) {
		for (Empresa empresa : lista) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : listaUsuario) {
			if(usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}
	
	
}
