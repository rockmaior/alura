package br.com.caelum.livraria.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;

@ManagedBean
@ViewScoped
public class AutorBean {

	private Autor autor = new Autor();

	public Autor getAutor() {
		return autor;
	}
	
	public void carregar(Autor autor) {
		System.out.println("Carregando autor " + autor.getNome());
		this.autor = autor;
	}

	public String gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());

		if (this.autor.getId() == null) {
			System.out.println("Atualizando autor " + this.autor.getNome());
			new DAO<Autor>(Autor.class).atualiza(this.autor);
		} else {
			new DAO<Autor>(Autor.class).adiciona(this.autor);
		}

		this.autor = new Autor();
		return "autor?faces-redirect=true";
	}

	public void remover(Autor autor) {
		System.out.println("Removendo livro " + autor.getNome());
		new DAO<Autor>(Autor.class).remove(autor);
	}
}
