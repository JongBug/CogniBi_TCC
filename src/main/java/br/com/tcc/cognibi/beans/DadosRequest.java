package br.com.tcc.cognibi.beans;

import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DadosRequest {
	private String textoPergunta;
	private Map<String, Object> context;
	
	public String getTextoPergunta() {
		return textoPergunta;
	}
	public void setTextoPergunta(String textoPergunta) {
		this.textoPergunta = textoPergunta;
	}
	public Map<String, Object> getContext() {
		return context;
	}
	public void setContext(Map<String, Object> context) {
		this.context = context;
	}
	
	
	
}
