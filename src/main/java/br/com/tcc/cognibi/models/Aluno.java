package br.com.tcc.cognibi.models;

import org.bson.types.ObjectId;

public class Aluno {

	private ObjectId id;
	private String nome;
	private String escolaridade;
	private String sexo;
	private String email;
	private String mensagem;
	
	public Aluno() {
		
	}
	
	public Aluno(String nome, String escolaridade, String sexo, String email, String mensagem) {
		this.nome = nome;
		this.escolaridade = escolaridade;
		this.sexo = sexo;
		this.email = email;
		this.mensagem = mensagem;
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
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Aluno criarId() {
		setId(new ObjectId());
		return this;
	}

}

