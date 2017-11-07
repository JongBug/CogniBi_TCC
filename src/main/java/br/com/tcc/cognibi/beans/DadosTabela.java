

package br.com.tcc.cognibi.beans;

import java.util.Map;

import org.bson.types.ObjectId;

public class DadosTabela {

	private String textoPergunta;
	private String taxaOneVsOne;
	private String taxaOneVsRest;
	private String taxaNayveBayes;
	private String taxaAdaboost;
	private String resposta;
	
	public DadosTabela() {
		
	}
	
	public DadosTabela(String textoPergunta, String taxaOneVsOne, String taxaOneVsRest, String taxaNayveBayes, String taxaAdaboost, String resposta) {
		this.textoPergunta = textoPergunta;
		this.taxaOneVsOne = taxaOneVsOne;
		this.taxaOneVsRest = taxaOneVsRest;
		this.taxaNayveBayes = taxaNayveBayes;
		this.taxaAdaboost = taxaAdaboost;
		this.resposta = resposta;
	}
	
	//Getters and Setters
	public String getTextoPergunta() {
		return textoPergunta;
	}
	public void setTextoPergunta(String textoPergunta) {
		this.textoPergunta = textoPergunta;
	}	
	public String getTaxaOneVsOne() {
		return taxaOneVsOne;
	}
	public void setTaxaOneVsOne(String taxaOneVsOne) {
		this.taxaOneVsOne = taxaOneVsOne;
	}
	public String getTaxaOneVsRest() {
		return taxaOneVsRest;
	}
	public void setTaxaOneVsRest(String taxaOneVsRest) {
		this.taxaOneVsRest = taxaOneVsRest;
	}
	public String getTaxaNayveBayes() {
		return taxaNayveBayes;
	}
	public void setTaxaNayveBayes(String taxaNayveBayes) {
		this.taxaNayveBayes = taxaNayveBayes;
	}
	public String getTaxaAdaboost() {
		return taxaAdaboost;
	}
	public void setTaxaAdaboost(String taxaAdaboost) {
		this.taxaAdaboost = taxaAdaboost;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public String getResposta() {
		return resposta;
	}

}

