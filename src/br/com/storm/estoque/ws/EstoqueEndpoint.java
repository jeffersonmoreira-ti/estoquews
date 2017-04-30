package br.com.storm.estoque.ws;

import javax.xml.ws.Endpoint;

public class EstoqueEndpoint {

	public static void main(String[] args) {
		EstoqueWS implementacaoWS = new EstoqueWS();
		String URL = "http://localhost:8080/estoquews";

		System.out.println("Web Service EstoqueWS rodando: " + URL+"?wsdl");

		//associando URL com a implementacao
		Endpoint.publish(URL, implementacaoWS);

	}

}
