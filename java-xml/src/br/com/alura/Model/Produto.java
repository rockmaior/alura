package br.com.alura.Model;

public class Produto {
	private String nome;
	private double preco;

	public Produto(String nome, double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public Double getPreco() {
		return preco;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nome: "+ nome + "\nPreço" + preco + "\n";
	}

}
