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

import br.com.tcc.cognibi.beans.DadosTabela;
import br.com.tcc.cognibi.codecs.DadosTabelaCodec;

public class DadosTabelaRepository {

	private MongoClient cliente;
	private MongoDatabase bancoDeDados;
	
	public void criarConexao() {
		Codec<Document> codec = MongoClient.getDefaultCodecRegistry().get(Document.class);

		DadosTabelaCodec dadosTabelaCodec = new DadosTabelaCodec(codec);

		CodecRegistry registro = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
				CodecRegistries.fromCodecs(dadosTabelaCodec));

		MongoClientOptions opcoes = MongoClientOptions.builder().codecRegistry(registro).build();

		this.cliente = new MongoClient("localhost:27017", opcoes);
		this.bancoDeDados = cliente.getDatabase("test");
	}
	
	public List<DadosTabela> obterTodosDialogos() {
		criarConexao();
		MongoCollection<DadosTabela> stat = bancoDeDados.getCollection("intencoes", DadosTabela.class);
		MongoCursor<DadosTabela> resultados = stat.find().iterator();
		List<DadosTabela> statisticasEncontradas = popularAlunos(resultados);
		fecharConexao();
		return statisticasEncontradas;
	}
	
	private List<DadosTabela> popularAlunos(MongoCursor<DadosTabela> resultados) {
		List<DadosTabela> dadosTabela = new ArrayList<DadosTabela>();
		while (resultados.hasNext()) {
			dadosTabela.add(resultados.next());
		}
		return dadosTabela;
	}

	public void fecharConexao() {
		this.cliente.close();
	}
}
