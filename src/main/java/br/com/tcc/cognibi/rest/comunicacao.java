package br.com.tcc.cognibi.rest;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

import br.com.tcc.cognibi.beans.DadosComunicacao;

@Path("/cognibi")
public class comunicacao {
	
	@GET
	@Path("/chat/{textoPergunta}")
	//@Produces(MediaType.APPLICATION_JSON)
	public DadosComunicacao conversa(@PathParam("textoPergunta") String texto) {
		DadosComunicacao conversa = new DadosComunicacao();
		
		
		MessageResponse response = null;
		Map context = new HashMap();
		
		response = conversationAPI(texto, context); 
		conversa.setConversa( response.getText().get(0));
		context = response.getContext();
		
		return conversa;
	}
	
	public static MessageResponse conversationAPI(String input,Map context){
		ConversationService service = new ConversationService("2017-02-03");
		service.setUsernameAndPassword("6de4ed4e-74ea-43eb-9002-8b788f3b2d4f", "gOX60XnFxpmA");
		MessageRequest newMessage = new MessageRequest.Builder()
				.inputText(input).context(context).build();
		String workspaceId = "0d10283e-5cf9-43e6-95fd-1f7f7b276ac6";
		MessageResponse response = service.message(workspaceId, newMessage).execute();
		return response;
	}
}
