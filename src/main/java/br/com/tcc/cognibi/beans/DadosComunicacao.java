package br.com.tcc.cognibi.beans;

import java.util.Map;

import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

public class DadosComunicacao {
	private String conversa;
	Map<String, Object> context;
	
	public String getConversa() {
		return conversa;
	}

	public void setConversa(String conversa) {
		this.conversa = conversa;
	}

	public Map<String, Object> getContext() {
		return context;
	}

	public void setContext(Map<String, Object> map) {
		this.context = map;
	}
	
}
