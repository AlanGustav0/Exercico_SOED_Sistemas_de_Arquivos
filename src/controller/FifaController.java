package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class FifaController implements IFifaController {

	@Override
	public Stack<String> empilhaBrasileiros(String caminho, String nome) throws IOException {

		File arquivo = new File(caminho, nome);
		Stack<String> pilha = new Stack<String>();
		String[] conteudoLinha;

		FileInputStream fluxo = new FileInputStream(arquivo);
		InputStreamReader leitor = new InputStreamReader(fluxo);
		BufferedReader buffer = new BufferedReader(leitor);

		String linha = buffer.readLine();

		buffer.readLine();
		while (linha != null) {
			conteudoLinha = linha.split(",");

			if (conteudoLinha[5].equals("Brazil")) {
				pilha.push(linha);
			}

			linha = buffer.readLine();

		}
		fluxo.close();
		leitor.close();
		buffer.close();

		return pilha;
	}

	@Override
	public void desmpilhaBonsBrasileiros(Stack<String> pilha) throws IOException {
		int tamnhoPilha = pilha.size();
		String[] jogador;
		String nomeJogador;

		for (int i = 0; i < tamnhoPilha; i++) {

			jogador = pilha.pop().split(",");
			nomeJogador = jogador[2];

			if (Integer.parseInt(jogador[7]) > 80) {
				System.out.println("Nome: " + nomeJogador + "\n" + "Overall: " + jogador[7] + "\n--------");
			}

		}

	}

	@Override
	public List<String> listaRevelacoes(String caminho, String nome) throws IOException {

		File arquivo = new File(caminho, nome);
		List<String> lista = new LinkedList<String>();
		String[] conteudoLinha;

		FileInputStream fluxo = new FileInputStream(arquivo);
		InputStreamReader leitor = new InputStreamReader(fluxo);
		BufferedReader buffer = new BufferedReader(leitor);

		String linha = buffer.readLine();
		linha = buffer.readLine();

		while (linha != null) {
			
			conteudoLinha = linha.split(",");

			if (Integer.parseInt(conteudoLinha[3]) <= 20) {
				lista.add(linha);
			}

			linha = buffer.readLine();
		}

		return lista;
	}

	@Override
	public void buscaListaBonsJovens(List<String> lista) throws IOException {
		
		Iterator<String> iterator = lista.iterator();
		
		while(iterator.hasNext()) {
			String []jogador = iterator.next().split(",");
			
			if(Integer.parseInt(jogador[3]) <= 20 && Integer.parseInt(jogador[7]) > 80) {
				
				System.out.println("Nome: " + jogador[2] + "\nIdade: " + jogador[3] + "\nOverall: " + jogador[7] +
						"\n------------------");
				
			}
			
			
		}

	}

}
