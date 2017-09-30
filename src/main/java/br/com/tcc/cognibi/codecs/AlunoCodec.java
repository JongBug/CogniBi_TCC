package br.com.tcc.cognibi.codecs;

import org.bson.BsonReader;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.types.ObjectId;

import br.com.tcc.cognibi.beans.DadosRequest;

public class AlunoCodec implements CollectibleCodec<DadosRequest> {

	public AlunoCodec(Codec<Document> codec) {
		this.codec = codec;
	}

	private Codec<Document> codec;

	public void encode(BsonWriter writer, DadosRequest aluno, EncoderContext encoder) {
		
		ObjectId id = aluno.getId();
		String nome = aluno.getNome();
		String escolaridade = aluno.getEscolaridade();
		String sexo = aluno.getSexo();
		String email = aluno.getEmail();
		String mensagem = aluno.getTextoPergunta();

		Document document = new Document();

		document.put("_id", id);
		document.put("nome", nome);
		document.put("escolaridade", escolaridade);
		document.put("sexo", sexo);
		document.put("email", email);
		document.put("mensagem", mensagem);
		
		codec.encode(writer, document, encoder);
	}


	public Class<DadosRequest> getEncoderClass() {
		return DadosRequest.class;
	}


	public boolean documentHasId(DadosRequest aluno) {
		return aluno.getId() == null;
	}


	public DadosRequest generateIdIfAbsentFromDocument(DadosRequest aluno) {
		return documentHasId(aluno) ? aluno.criarId() : aluno;
	}

	
	public BsonValue getDocumentId(DadosRequest aluno) {
		if (!documentHasId(aluno)) {
			throw new IllegalStateException("Esse documet nao tem Id");
		}
		return new BsonString(aluno.getId().toHexString());
	}

	
	public DadosRequest decode(BsonReader reader, DecoderContext decoder) {
		Document document = codec.decode(reader, decoder);

		DadosRequest aluno = new DadosRequest();

		aluno.setId(document.getObjectId("_id"));
		aluno.setNome(document.getString("nome"));
		aluno.setEscolaridade(document.getString("escolaridade"));
		aluno.setSexo(document.getString("sexo"));
		aluno.setEmail(document.getString("email"));
		aluno.setTextoPergunta(document.getString("mensagem"));
		
		return aluno;
	}

}

