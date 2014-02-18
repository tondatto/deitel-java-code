/**
 * Programa que quantifica o total de vezes que uma
 * soma do lançamento de dois dados numa certa 
 * quantidade de lançamentos.
 * 
 * Exercicio 7.17 - Deitel - Java HTP
 * Autor: Ricidleiv
 * Data : 15/02/2014
 */
import java.util.Random;

public class LancaDoisDados {
	private int[] somasPossiveis = new int[13];
	private Random randomNumber = new Random();;
	private int qtdeLancamentos;
	
	public LancaDoisDados(int qtdeLancamentos){
		this.qtdeLancamentos = qtdeLancamentos;
		
		for(int i=0; i<qtdeLancamentos; i++){
			++somasPossiveis[rolaDados()];
		}
		
		imprimeResultado();
	}
	
	public int rolaDados(){
		int dado1 = randomNumber.nextInt(6) + 1;
		int dado2 = randomNumber.nextInt(6) + 1;
		return dado1 + dado2;
	}
	
	public void imprimeResultado(){
		System.out.printf("2 dados lançados %,d vezes.\n\n", qtdeLancamentos);
		System.out.printf("%10s %10s %10s\n","Soma", "Vezes", "Perc");
		
		for(int i=2; i<13; i++)
			System.out.printf("%10d %,10d %10.1f%%\n", i, somasPossiveis[i], (1.0*somasPossiveis[i]/qtdeLancamentos)*100);
	}
	
	public static void main(String[] args){
		new LancaDoisDados(Integer.parseInt(args[0]));
	}
}
