package br.com.alura.Model;

public class Produto {
	private String nome;
	private double preco;

//	public Produto(String nome, double preco) {
//		this.nome = nome;
//		this.preco = preco;
//	}
//
//	public Produto() {
//	}

	public String getNome() {
		return nome;
	}

	public Double getPreco() {
		return preco;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nome: " + nome + "\nPreco: " + preco + "\n";
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
