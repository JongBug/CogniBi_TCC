package br.com.tcc.cognibi.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import br.com.tcc.cognibi.beans.DadosTabela;
import br.com.tcc.cognibi.repositorys.AlunoRepository;
import br.com.tcc.cognibi.repositorys.DadosTabelaRepository;

@Path("/cognibi")
public class comunicacao {

	@GET
	@Path("/allList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DadosRequest> getAllList() {
		AlunoRepository alunoDados = new AlunoRepository();
		return alunoDados.obterTodosDialogos();
	}
	
	@GET
	@Path("/tabela")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DadosTabela> getAllStatistics() {
//		DadosTabelaRepository dadosTabela = new DadosTabelaRepository();
//		return dadosTabela.obterTodosDialogos();
		
		//teste
		List<DadosTabela> list = new ArrayList<DadosTabela>();
		DadosTabela tabela = new DadosTabela();
		tabela.setResposta("Caique viado");
		tabela.setTaxaAdaboost("10");
		tabela.setTaxaNayveBayes("20");
		tabela.setTaxaOneVsOne("30");
		tabela.setTaxaOneVsRest("70");
		tabela.setTextoPergunta("caique eh viado?");
		
		list.add(tabela);
		
		DadosTabela tabela2 = new DadosTabela();
		tabela2.setResposta("2 Caique viado");
		tabela2.setTaxaAdaboost("20");
		tabela2.setTaxaNayveBayes("30");
		tabela2.setTaxaOneVsOne("40");
		tabela2.setTaxaOneVsRest("80");
		tabela2.setTextoPergunta("2 caique eh viado?");
		list.add(tabela2);
		return list;
		
	}

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
		String respostaCognibi = null;
		respostaCognibi = response.getText().get(0);
		
		//Persistindo dados
		AlunoRepository alunoDados = new AlunoRepository();
		DadosRequest dadosRequest = new DadosRequest(
				data.getNome(), 
				data.getEscolaridade(), 
				data.getSexo(), 
				data.getEmail(), 
				data.getTextoPergunta(), 
				respostaCognibi);
		alunoDados.salvarDados(dadosRequest);
		

		return conversa;
	}

	public static MessageResponse conversationAPI(String input, Map<String, Object> context) {

		ConversationService service = new ConversationService("2017-02-03");
		service.setUsernameAndPassword("6de4ed4e-74ea-43eb-9002-8b788f3b2d4f", "gOX60XnFxpmA");

		MessageRequest newMessage = new MessageRequest.Builder().inputText(input).context(context).build();

		String workspaceId = "0d10283e-5cf9-43e6-95fd-1f7f7b276ac6";
		MessageResponse response = service.message(workspaceId, newMessage).execute();

		return response;
	}
}
