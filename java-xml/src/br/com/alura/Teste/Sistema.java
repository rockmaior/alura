package br.com.alura.Teste;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import br.com.alura.Handlers.ProdutoHandler;

public class Sistema {

	public static void main(String[] args) throws SAXException, IOException {
		XMLReader reader = XMLReaderFactory.createXMLReader();
		ProdutoHandler pp = new ProdutoHandler();
		reader.setContentHandler(pp);

		InputStream is = new FileInputStream("src/venda.xml");
		InputSource arquivo = new InputSource(is);

		reader.parse(arquivo);

		System.out.println(pp.getProdutos());
	}

}
