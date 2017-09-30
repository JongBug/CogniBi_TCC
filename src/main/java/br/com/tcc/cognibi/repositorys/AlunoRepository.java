package br.com.tcc.cognibi.repositorys;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import br.com.tcc.cognibi.beans.DadosRequest;
import br.com.tcc.cognibi.codecs.AlunoCodec;

public class AlunoRepository {

	private MongoClient cliente;
	private MongoDatabase bancoDeDados;

	public void criarConexao() {
		Codec<Document> codec = MongoClient.getDefaultCodecRegistry().get(Document.class);

		AlunoCodec alunoCodec = new AlunoCodec(codec);

		CodecRegistry registro = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
				CodecRegistries.fromCodecs(alunoCodec));

		MongoClientOptions opcoes = MongoClientOptions.builder().codecRegistry(registro).build();

		this.cliente = new MongoClient("localhost:27017", opcoes);
		this.bancoDeDados = cliente.getDatabase("test");
	}

	public void salvar(DadosRequest aluno) {

		criarConexao();
		MongoCollection<DadosRequest> alunos = bancoDeDados.getCollection("alunos", DadosRequest.class);

		if (aluno.getId() == null) {
			alunos.insertOne(aluno);
		} else {
			alunos.updateOne(Filters.eq("_id", aluno.getId()), new Document("$set", aluno));
		}

		fecharConexao();
	}

	public List<DadosRequest> obterTodosAlunos() {
		criarConexao();
		MongoCollection<DadosRequest> alunos = bancoDeDados.getCollection("alunos", DadosRequest.class);
		MongoCursor<DadosRequest> resultados = alunos.find().iterator();
		List<DadosRequest> alunosEncontrados = popularAlunos(resultados);
		fecharConexao();
		return alunosEncontrados;
	}

	private List<DadosRequest> popularAlunos(MongoCursor<DadosRequest> resultados) {
		List<DadosRequest> alunos = new ArrayList<DadosRequest>();
		while (resultados.hasNext()) {
			alunos.add(resultados.next());
		}
		return alunos;
	}

	public void fecharConexao() {
		this.cliente.close();
	}
}
