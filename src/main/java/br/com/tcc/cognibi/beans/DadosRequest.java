package br.com.tcc.cognibi.beans;

import java.util.Map;

import org.bson.types.ObjectId;

public class DadosRequest {

	private ObjectId id;
	private String nome;
	private String escolaridade;
	private String sexo;
	private String email;
	private String textoPergunta;
	private Map<String, Object> context;
	private String textoResposta;
	
	public DadosRequest() {
		
	}
	
	public DadosRequest(String nome, String escolaridade, String sexo, String email, String textoPergunta, String textoResposta) {
		this.nome = nome;
		this.escolaridade = escolaridade;
		this.sexo = sexo;
		this.email = email;
		this.textoPergunta = textoPergunta;
		this.textoResposta = textoResposta;
	}
	
	//Getters and Setters
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
	
	public void setTextoResposta(String textoResposta) {
		this.textoResposta = textoResposta;
	}
	
	public String getTextoResposta() {
		return textoResposta;
	}

	public DadosRequest criarId() {
		setId(new ObjectId());
		return this;
	}

}

