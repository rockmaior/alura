package br.com.alura.Teste;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import br.com.alura.Model.Produto;

public class Teste {

	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		dbf.setValidating(true);
		dbf.setNamespaceAware(true);
		dbf.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");

		DocumentBuilder builder = dbf.newDocumentBuilder();
		Document document = builder.parse("src/venda.xml");

		List<Produto> produtos = new ArrayList<>();
		XPath xPath = XPathFactory.newInstance().newXPath();
		String expression = "/venda/produtos/produto[2]";
		XPathExpression xPathExpression = xPath.compile(expression);
		NodeList lista = (NodeList) xPathExpression.evaluate(document, XPathConstants.NODESET);
		/*
		 * Element venda = document.getDocumentElement(); String moeda =
		 * venda.getAttribute("moeda"); // NodeList formasDePagamento = //
		 * document.getElementsByTagName("formaDePagamento"); NodeList lista =
		 * (NodeList) xPathExpression.evaluate(document,
		 * XPathConstants.NODESET); for (int i = 0; i < args.length; i++) {
		 * String string = args[i];
		 * 
		 * } Element fdp = (Element) formasDePagamento.item(0); String
		 * formaDePagamento = fdp.getTextContent(); System.out.println(
		 * "Forma de Pagamento: " + formaDePagamento + "\nMoeda: " + moeda);
		 * 
		 * /* Minha resposta funcionou muito bem e de uma forma menos verbosa
		 * 
		 * NodeList produtos = document.getElementsByTagName("produto");
		 */

		for (int i = 0; i < lista.getLength(); i++) {
			Element produto = (Element) lista.item(i);

			String nome = produto.getElementsByTagName("nome").item(0).getTextContent();
			Double preco = Double.parseDouble(produto.getElementsByTagName("preco").item(0).getTextContent());

			Produto prod = new Produto();
			prod.setNome(nome);
			prod.setPreco(preco);

			produtos.add(prod);
		}

		System.out.println(produtos);
		/*
		 * for (int i = 0; i < produtos.getLength(); i++) {
		 * 
		 * Element produto = (Element) produtos.item(i); String nome =
		 * produto.getElementsByTagName("nome").item(0).getTextContent(); double
		 * preco =
		 * Double.parseDouble(produto.getElementsByTagName("preco").item(0).
		 * getTextContent());
		 * 
		 * Produto prod = new Produto(nome, preco);
		 * 
		 * System.out.println(prod); }
		 * 
		 * /* NodeList produtos = document.getElementsByTagName("produto");
		 * 
		 * for(int i =0; i < produtos.getLength(); i++) { Element produto =
		 * (Element) produtos.item(i); String nome =
		 * produto.getElementsByTagName("nome").item(0).getTextContent(); String
		 * preco =
		 * produto.getElementsByTagName("preco").item(0).getTextContent();
		 * 
		 * System.out.println("-----------"); System.out.println(
		 * "Nome do produto: "+ nome); System.out.println("Preco do produto: "+
		 * preco); System.out.println("-----------"); }
		 */

	}
}
