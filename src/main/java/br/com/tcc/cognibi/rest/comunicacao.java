package br.com.tcc.cognibi.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.com.tcc.cognibi.beans.DadosComunicacao;

@Path("/cognibi")
public class comunicacao {
	
	@GET
	@Path("/chat/{textoPergunta}")
	//@Produces(MediaType.APPLICATION_JSON)
	public DadosComunicacao conversa(@PathParam("textoPergunta") String texto) {
		DadosComunicacao conversa = new DadosComunicacao();
		conversa.setConversa("seu bobo");
		return conversa;
	}
	
}
