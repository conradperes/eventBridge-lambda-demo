
import java.util.Scanner;

import javax.swing.JOptionPane;

public class AqueceAlgoritmos implements Cloneable {
	private static final int EXERCICIO7 = 7;
	private static final int EXERCICIO4 = 4;
	private static final int EXERCICIO6 = 6;
	private static final int EXERCICIO5 = 5;
	private static final int EXERCICIO8 = 8;
	private int a;
	private int b;
	private static final int EXERCICIO9 = 9;
	private static final int EXERCICIO3 = 3;
	private static final int EXERCICIO2 = 2;
	private static final int EXERCICIO1 = 1;
	private static final int EXERCICIO0 = 0;
	private static final String PEDRA = "d";
	private static final String PAPEL = "p";
	private static final String TESOURA = "t";
	static Scanner sc = null;

	public static void main(String[] args) {
		AqueceAlgoritmos algoritmos = new AqueceAlgoritmos();
		sc = new Scanner(System.in);
		while (sc.hasNext()) {
			algoritmos.escolheAlgoritmo(sc.nextInt());
		}
	}

	public AqueceAlgoritmos clone() throws CloneNotSupportedException {
		return (AqueceAlgoritmos) super.clone();
	}

	public static int exercicio5Fatorial(int num) {
		if (num <= 1)
			return 1;
		else
			return exercicio5Fatorial(num - 1) * num;
	}

	private void escolheAlgoritmo(int exercicio) {
		switch (exercicio) {
		case EXERCICIO0:
			exercicio0HellloWorld();
			break;
		case EXERCICIO1:
			exercicio1Intervalo(sc.nextInt(), sc.nextInt());
			break;
		case EXERCICIO2:
			int[] candidatos = new int[sc.nextInt()];
			for (int i = 0; i < candidatos.length; i++) {
				candidatos[i] = sc.nextInt();
			}
			print(exercicio2IdentificaCampeao(candidatos));
			break;
		case EXERCICIO3:
			double numeros[] = new double[sc.nextInt()];
			for (int i = 0; i < numeros.length; i++) {
				numeros[i] = sc.nextDouble();
			}
			exercicio3Calculos(numeros.length, numeros);
			break;
		case EXERCICIO4:
			Aluno[] alunos = new Aluno[sc.nextInt()];
			Object nota = 0;
			sc.nextLine();
			String nomeAluno = null;
			for (int i = 0; i < alunos.length; i++) {
				String linha = sc.nextLine();
				nota = linha.split(" ")[0];
				if (linha.split(" ").length == 3) {
					nomeAluno = linha.split(" ")[1] + " " + linha.split(" ")[2];
					alunos[i] = new Aluno(nomeAluno, nota);
				} else {
					nomeAluno = linha.split(" ")[1];
					alunos[i] = new Aluno(nomeAluno, nota);
				}
			}
			print(exercicio4Kesimo(sc.nextInt(), alunos));
			break;
		case EXERCICIO5:
			print(exercicio5Fatorial(sc.nextInt()));
			break;
		case EXERCICIO6:
			print(exercicio6Fibonacci(sc.nextInt()));
			break;
		case EXERCICIO7:
			int pesoPedra = 2;
			int pesoTesoura = 1;
			int pesoPapel = 0;
			int linhas = sc.nextInt();
			int qtdeElementos = linhas;
			String[] JokenpoArray = new String[qtdeElementos * 2];
			for (int i = 0; i < JokenpoArray.length; i++) {
				JokenpoArray[i] = sc.next();
			}
			exercicio7Variante(JokenpoArray);

			// { { pesoTesoura, pesoPapel }, { pesoPedra, pesoPapel }, { pesoPedra,
			// pesoTesoura } };
			// print(exercicio7MatrizJokenpo(matriz));
			break;
		case EXERCICIO8:
			exerciocio8Clones(sc.nextInt(), sc.nextInt(), this, new AqueceAlgoritmos());
			break;
		case EXERCICIO9:
			int[] array = new int[sc.nextInt()];
			for (int i = 0; i < array.length; i++) {
				array[i] = sc.nextInt();
			}
			exercicio9OrdenacaoInsertSort(array);
			break;
		default:
			JOptionPane.showMessageDialog(null, "Digite somente de 1 a 9");
			System.exit(0);
			break;
		}
	}

	private int exercicio7Variante(String[] array) {
		int countMaria = 0;
		int countJoao = 0;
		String maria =null;
		for (int i = 0; i < array.length; i++) {
			if(i<array.length-1) {
				if (array[i].equals(array[i+1])) {
					countJoao++;
					countMaria++;
				}
				if (array[i ].equals(TESOURA) && array[i+1].equals(PAPEL))
					countMaria++;
				if (array[i ].equals(PEDRA) && array[i+1].equals(PAPEL))
					countJoao++;
				if (array[i ].equals(PAPEL) && array[i+1].equals(PEDRA))
					countMaria++;
				if (array[i ].equals(PEDRA) && array[i+1].equals(TESOURA))
					countMaria++;
				if (array[i ].equals(TESOURA) && array[i+1].equals(PEDRA))
					countJoao++;
				if (array[i].equals(PAPEL) && array[i+1].equals(TESOURA))
					countJoao++;
			}else if(i==array.length-1){
				if (array[i - 1].equals(array[i])) {
					countJoao++;
					countMaria++;
				}
				if (array[i - 1].equals(TESOURA) && array[i].equals(PAPEL))
					countMaria++;
				if (array[i - 1].equals(PEDRA) && array[i].equals(PAPEL))
					countJoao++;
				if (array[i - 1].equals(PAPEL) && array[i].equals(PEDRA))
					countMaria++;
				if (array[i - 1].equals(PEDRA) && array[i].equals(TESOURA))
					countMaria++;
				if (array[i - 1].equals(TESOURA) && array[i].equals(PEDRA))
					countJoao++;
				if (array[i - 1].equals(PAPEL) && array[i].equals(TESOURA))
					countJoao++;
			}
		}
		if (countJoao == countMaria)
			print("Empate");
		if (countJoao > countMaria) {
			print("João");
			return countJoao;
		}
		if (countMaria > countJoao) {
			print("Maria");
		}
		return countMaria;

	}

	/**
	 * As variáveis pedra, papel e tesoura são apenas documentação, para distringuir
	 * o que cada um dos pesos atribuídos a matriz representa em relação ao conceito
	 * pedra , papel e tesoura. A solução de contagem do jogo esta toda abrangida em
	 * cima da contagem de ganhos de cada personagem feita pela Matriz(3,2) exposta
	 * no algoritmo abaixo
	 * 
	 * @return String com o nome do ganhador do Jogo Jokenpô
	 */
	private String exercicio7MatrizJokenpo(String[][] matriz) {
		int countMaria = 0;
		int countJoao = 0;
		int countEmpate = 0;
		String elementoAnterior = null;
		String elementoCorrente = null;
		boolean pode = false;
		for (int linhas = 0; linhas < matriz.length; linhas++) {
			for (int colunas = 0; colunas < matriz[linhas].length; colunas++) {
				elementoCorrente = matriz[linhas][colunas];
				print(elementoCorrente);
				if (elementoAnterior == null) {
					if (matriz[linhas][colunas].equals(matriz[linhas][colunas + 1])) {
						countMaria++;
						countJoao++;
					}
					if (matriz[linhas][colunas].equals(PEDRA))
						countMaria++;
					if (matriz[linhas][colunas].equals(TESOURA) && matriz[linhas][colunas + 1].equals(PAPEL))
						countMaria++;
					if (matriz[linhas][colunas].equals(TESOURA) && matriz[linhas][colunas + 1].equals(PEDRA))
						countJoao++;
					if (matriz[linhas][colunas + 1].equals(PEDRA))
						countJoao++;
					if (matriz[linhas][colunas + 1].equals(TESOURA) && matriz[linhas][colunas].equals(PAPEL))
						countJoao++;
					if (matriz[linhas][colunas].equals(PAPEL))
						countJoao++;
					pode = true;
				}
				if (linhas == 0)
					elementoAnterior = matriz[linhas][colunas];
				else
					elementoAnterior = null;
			}
		}
		// print(countMaria);
		// print(countJoao);
		if (countMaria > countJoao)
			return "Maria";
		if (countJoao > countMaria)
			return "João";
		if (countMaria == countJoao)
			return "Empate";
		return null;
	}

	private int exercicio2IdentificaCampeao(int[] vetor) {
		int cont = 1;
		int num = 0;
		for (int i = 0; i < vetor.length; i++) {
			cont = 0;
			for (int j = 0; j < vetor.length; j++) {
				if (vetor[i] == vetor[j] && vetor[i] != 0)
					cont++;
				num = vetor[i];
				if (cont >= num)
					return num;
				break;
			}

			print(" repeticoes numero " + num + ": " + cont + " vezes");
		}
		return num;
	}

	/**
	 * Algoritmo que pega um Array de 6 alunos, e com isso checa se suas nota é
	 * maior ou igual a 7, e identifica o segundo kesimo(colocado) da turma
	 * 
	 * @param kesimo
	 *            colocação numérica da Turma
	 * @return Nome do aluno representando o kesimo
	 */
	private String exercicio4Kesimo(int kesimo, Aluno[] alunos) {
		int countKesimos = 0;
		String nomeAluno = null;
		for (Aluno aluno : alunos) {
			Object nota = aluno.getNota();
			if (Double.parseDouble(nota.toString()) >= 7)
				nomeAluno = aluno.getNome() + " Aprovado";
			else
				nomeAluno = aluno.getNome() + " Reprovado";
			countKesimos++;
			if (countKesimos == kesimo) {
				return nomeAluno;
			}

		}
		return nomeAluno;
	}

	/**
	 * Cálculo recursivo do Fibonacci
	 * 
	 * @param n
	 *            número a ser calculado
	 * @return
	 */
	private long exercicio6Fibonacci(int n) {
		if (n < 2) {
			return n;
		} else {
			return exercicio6Fibonacci(n - 1) + exercicio6Fibonacci(n - 2);
		}
	}

	/**
	 * Impressão de intervalor de número entre a e b inclusive
	 */
	private void exercicio1Intervalo(int a, int b) {
		for (; a <= b; a++) {
			print(a);
		}
	}

	private void exercicio0HellloWorld() {
		print("Hello World");
	}

	private void print(Object o) {
		System.out.println(o);
	}

	/**
	 * Algoritmo que realiza clones nos objetos passados por parâmetro, sem alterar
	 * o valor das variáveis a e b. Preservando assim a integridade solicitada pelo
	 * algoritmo.
	 * 
	 * @param a
	 *            número a que será passado para outro objeto clonado
	 * @param b
	 *            número b que será passado para outro objeto clonado
	 * @param objeto1
	 *            Instância própria do algoritmo a ser clonada
	 * @param objeto2
	 *            Nova instância a ser clonada para troca de valores
	 */
	public void exerciocio8Clones(int a, int b, AqueceAlgoritmos objeto1, AqueceAlgoritmos objeto2) {
		objeto1.a = a;
		objeto1.b = b;
		objeto2.b = b;
		objeto2.a = a;
		try {
			AqueceAlgoritmos copia1 = objeto1.clone();
			AqueceAlgoritmos copia2 = objeto2.clone();
			copia1.a = objeto1.b;
			copia2.b = objeto2.a;
			print(copia1.a);
			print(copia2.b);

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Utilização de algoritmo InsertionSort
	 * 
	 * @param array
	 */
	public void exercicio9OrdenacaoInsertSort(int[] array) {
		int j;
		int key;
		int i;
		for (j = 1; j < array.length; j++) {
			key = array[j];
			for (i = j - 1; (i >= 0) && (array[i] > key); i--) {
				array[i + 1] = array[i];
			}
			array[i + 1] = key;
		}
		for (int numerosEmOrdem : array)
			print(numerosEmOrdem);
	}

	/**
	 * Operações simples de soma, média, maior e menor da quantidade solicitada na
	 * variável qtde.
	 * 
	 * @param num2
	 *            Número 1
	 * @param num3
	 *            Número 2
	 * @param num4
	 *            Número 3
	 * @param num5
	 *            Número 4
	 * @param qtde
	 *            quantidade de números envolvidos na operação
	 */
	public void exercicio3Calculos(int qtde, double[] numeros) {
		soma(numeros);
		media(numeros, qtde);
		maiorEMenor(numeros);
	}

	private void maiorEMenor(double[] numeros) {
		double maior = 0, menor = 0;
		for (int j = 1; j < numeros.length; j++) {
			if (numeros[j] > maior) {
				maior = numeros[j];
			}
		}
		menor = maior;
		for (int j = 0; j < numeros.length; j++) {
			if (numeros[j] < menor) {
				menor = numeros[j];
			}
		}
		print(maior);
		print(menor);
	}

	private void media(double[] numeros, int qtde) {
		double total = 0;
		for (double d : numeros) {
			total += d;
		}
		print(total / qtde);
	}

	private void soma(double[] numeros) {
		double total = 0;
		for (double d : numeros) {
			total += d;
		}
		print(total);
	}

	public class Aluno {

		private String nome;
		private Object nota;

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Object getNota() {
			return nota;
		}

		public void setNota(Object nota) {
			this.nota = nota;
		}

		public Aluno(String nome, Object nota) {
			super();
			this.nome = nome;
			this.nota = nota;
		}

	}

}
