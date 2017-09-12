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
import br.com.tcc.cognibi.beans.DadosRequest;

@Path("/cognibi")
public class comunicacao {
	
	@POST
	@Path("/chat")
	@Produces(MediaType.APPLICATION_JSON)
	public DadosComunicacao conversa(DadosRequest data) {
		
		DadosComunicacao conversa = new DadosComunicacao();

		MessageResponse response = null;
		Map<String, Object> context = new HashMap<String, Object>();
		
		response = conversationAPI(data.getTextoPergunta(), data.getContext()); 

		conversa.setConversa(response.getText().get(0));
		conversa.setContext(response.getContext());

		return conversa;
	}
	
	public static MessageResponse conversationAPI(String input,Map<String, Object> context){

		ConversationService service = new ConversationService("2017-02-03");
		service.setUsernameAndPassword("<<USERNAME>>", "<<PASSWORD>>");
		
		MessageRequest newMessage = new MessageRequest.Builder()
				.inputText(input)
				.context(context)
				.build();
		
		String workspaceId = "WORKSPACE_ID";
		MessageResponse response = service.message(workspaceId, newMessage).execute();
		
		return response;
	}
}
