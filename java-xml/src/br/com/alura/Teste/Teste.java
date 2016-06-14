package br.com.alura.Teste;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import br.com.alura.Model.Produto;

public class Teste {

	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbf.newDocumentBuilder();
		Document document = builder.parse("src/venda.xml");
		Element venda = document.getDocumentElement();
		String moeda = venda.getAttribute("moeda");
		NodeList formasDePagamento = document.getElementsByTagName("formaDePagamento");
		Element fdp = (Element) formasDePagamento.item(0);
		String formaDePagamento = fdp.getTextContent();
		System.out.println("Forma de Pagamento: " + formaDePagamento + "\nMoeda: " + moeda);
		
		/*Minha resposta funcionou muito bem e de uma forma menos verbosa*/
		
		NodeList produtos = document.getElementsByTagName("produto");
		
		for (int i = 0; i < produtos.getLength(); i++) {
			
			Element produto = (Element) produtos.item(i);
			 String nome = produto.getElementsByTagName("nome").item(0).getTextContent();
	         double preco = Double.parseDouble(produto.getElementsByTagName("preco").item(0).getTextContent());

			Produto prod = new Produto(nome, preco);
			
			System.out.println(prod);
		}
		
		
		/*
		NodeList produtos = document.getElementsByTagName("produto");

        for(int i =0; i < produtos.getLength(); i++) {
            Element produto = (Element) produtos.item(i);
            String nome = produto.getElementsByTagName("nome").item(0).getTextContent();
            String preco = produto.getElementsByTagName("preco").item(0).getTextContent();

            System.out.println("-----------");
            System.out.println("Nome do produto: "+ nome);
            System.out.println("Preco do produto: "+ preco);
            System.out.println("-----------");
        }
        */
		
	}
}
