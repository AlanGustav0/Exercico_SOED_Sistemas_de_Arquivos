package view;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import controller.FifaController;
import controller.IFifaController;

public class Principal {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		IFifaController controleArquivos = new FifaController();
		String nomeArquivo = "data.csv";
		String caminho = "C:\\TEMP\\";
		Stack<String> pilha;
		List<String> lista;
		int opc = 0;

		while (opc != 9) {

			System.out.println(
					"1-Empilhar Brasileiros \n2-Desempilhar bons Brasileiros\n3-Listar Revelações\n4-Busca bons jovens\n9-Finalizar");
			opc = sc.nextInt();

			switch (opc) {

			case 1:
				pilha = controleArquivos.empilhaBrasileiros(caminho, nomeArquivo);
				for (String valores : pilha) {
					System.out.println(valores);
				}
				break;

			case 2:
				pilha = controleArquivos.empilhaBrasileiros(caminho, nomeArquivo);
				controleArquivos.desmpilhaBonsBrasileiros(pilha);
				break;

			case 3:
				lista = controleArquivos.listaRevelacoes(caminho, nomeArquivo);

				for (String jogador : lista) {
					System.out.println(jogador);
				}
				break;
			case 4:
				lista = controleArquivos.listaRevelacoes(caminho, nomeArquivo);
				controleArquivos.buscaListaBonsJovens(lista);
				break;
				
			default:
				System.out.println("Opção inválida!");
				break;
				
			case 9:
				System.out.println("Programa Finalizado!");
				break;
				
			}

		}

		sc.close();

	}

}
