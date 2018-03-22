package aqueceUERJ;

import java.util.Scanner;

public class Matriz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int linhas = sc.nextInt();
		String matriz[][] = new String[linhas][2];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < 2; j++)
				matriz[i][j] = sc.next();
		}
		String anterior=null;
		String atual=null;
		for (String[] strings : matriz) {
			for (String string : strings) {
				System.out.println("Elemento corrente="+string);
			}
		}
		String[] array = {"t","p"};
		for (int i = 0; i < array.length; i++) {
			String atual1 = array[i];
			if(i>0) {
				if(array[i-1].equals(array[i])) {
					System.out.println("igual");
				}else
					System.out.println("Diferente");
			}
		}
		
	}

}
