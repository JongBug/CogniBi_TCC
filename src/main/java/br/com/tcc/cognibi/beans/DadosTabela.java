package br.com.tcc.cognibi.beans;

import java.util.Map;

import org.bson.types.ObjectId;

public class DadosRequest {

	private String textoPergunta;
	private String taxa1;
	private String taxa2;
	private String taxa3;
	private String taxa4;
	private String resposta;
	
	public DadosRequest() {
		
	}
	
	public DadosRequest(String textoPergunta, String taxa1, String taxa2, String taxa3, String taxa4, String resposta) {
		this.textoPergunta = textoPergunta;
		this.taxa1 = taxa1;
		this.taxa2 = taxa2;
		this.taxa3 = taxa3;
		this.taxa4 = taxa4;
		this.resposta = resposta;
	}
	
	//Getters and Setters
	public String getTextoPergunta() {
		return textoPergunta;
	}
	public void setTextoPergunta(String textoPergunta) {
		this.textoPergunta = textoPergunta;
	}	
	public String getTaxa1() {
		return taxa1;
	}
	public void setTaxa1(String taxa1) {
		this.taxa1 = taxa1;
	}
	public String getTaxa2() {
		return taxa2;
	}
	public void setTaxa2(String taxa2) {
		this.taxa2 = taxa2;
	}
	public String getTaxa3() {
		return taxa3;
	}
	public void setTaxa3(String taxa3) {
		this.taxa3 = taxa3;
	}
	public String getTaxa4() {
		return taxa4;
	}
	public void setTaxa4(String taxa4) {
		this.taxa4 = taxa4;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public String getResposta() {
		return resposta;
	}

}

