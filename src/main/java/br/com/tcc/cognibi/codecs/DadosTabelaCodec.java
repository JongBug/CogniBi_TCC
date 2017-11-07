package br.com.tcc.cognibi.codecs;

import org.bson.BsonReader;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

import br.com.tcc.cognibi.beans.DadosTabela;

public class DadosTabelaCodec implements CollectibleCodec<DadosTabela> {
	
	private Codec<Document> codec;
	
	public DadosTabelaCodec(Codec<Document> codec) {
		this.codec = codec;
	}

	public void encode(BsonWriter arg0, DadosTabela arg1, EncoderContext arg2) {
		// TODO Auto-generated method stub
		
	}

	public Class<DadosTabela> getEncoderClass() {
		return DadosTabela.class;
	}

	public DadosTabela decode(BsonReader reader, DecoderContext decoder) {
		Document document = codec.decode(reader, decoder);

		DadosTabela statisticas = new DadosTabela();
		
		statisticas.setTextoPergunta(document.getString("textoPergunta"));
		statisticas.setTaxaOneVsOne(String.valueOf(document.getInteger("taxaOneVsOne")));
		statisticas.setTaxaOneVsRest(String.valueOf(document.getInteger("taxaOneVsRest")));
		statisticas.setTaxaNayveBayes(String.valueOf(document.getInteger("taxaNayveBayes")));
		statisticas.setTaxaAdaboost(String.valueOf(document.getInteger("taxaAdaboost")));
		statisticas.setResposta(document.getString("resposta"));
		
		//aluno.setId(document.getObjectId("_id"));
		
		return statisticas;
	}

	public boolean documentHasId(DadosTabela arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public DadosTabela generateIdIfAbsentFromDocument(DadosTabela arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public BsonValue getDocumentId(DadosTabela arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
