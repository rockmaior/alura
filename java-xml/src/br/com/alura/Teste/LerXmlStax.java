package br.com.alura.Teste;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;

import br.com.alura.Model.Produto;

public class LerXmlStax {
	public static void main(String[] args) throws FactoryConfigurationError, Exception {

		List<Produto> produtos = new ArrayList<>();
		InputStream arquivo = new FileInputStream("src/venda.xml");

		XMLEventReader eventos = XMLInputFactory.newInstance().createXMLEventReader(arquivo);

		

		while (eventos.hasNext()) {
			XMLEvent event = eventos.nextEvent();

			if (event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("produto")) {
				Produto prod = ProcessaProduto(eventos);
				produtos.add(prod);
			}
		}

		System.out.println(produtos);

	}

	private static Produto ProcessaProduto(XMLEventReader eventos) throws Exception {

		Produto prod = new Produto();

		while (eventos.hasNext()) {
			XMLEvent event = eventos.nextEvent();
			if (event.isEndElement() && event.asEndElement().getName().getLocalPart().equals("produto")) {
				break;
			}

			if (event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("nome")) {
				event = eventos.nextEvent();
				String nome = event.asCharacters().getData();
				prod.setNome(nome);
			}

			if (event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("preco")) {
				event = eventos.nextEvent();
				Double preco = Double.parseDouble(event.asCharacters().getData());
				prod.setPreco(preco);
			}

		}

		return prod;
	}
}
