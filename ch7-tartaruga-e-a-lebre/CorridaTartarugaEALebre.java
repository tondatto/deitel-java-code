import java.util.Random;

public class CorridaTartarugaEALebre {
	private Random randomNumber = new Random();

	private final int POSICOES = 70;
	
	private final int TARTARUGA = 0;
	private final int LEBRE = 1;
	
	private final int TART_CAMINHADA_RAPIDA = 3;
	private final int TART_ESCORREGAO = -6;
	private final int TART_CAMINHADA_LENTA = 1;
	
	private final int LEBRE_DORMIR = 0;
	private final int LEBRE_SALTO_GRANDE = 9;
	private final int LEBRE_ESCORREGAO_GRANDE = -12;
	private final int LEBRE_SALTO_PEQUENO = 1;
	private final int LEBRE_ESCORREGAO_PEQUENO = -2;
	
	private int[] posicoes;
	private int posicaoTartaruga;
	private int posicaoLebre;
	
	public CorridaTartarugaEALebre(){
		posicoes = new int[POSICOES];
		posicaoTartaruga = 0;
		posicaoLebre = 0;
	}
	
	private void init(){
		System.out.println("BANG !!!!");
		System.out.println("A corrida começou !!!!\n");
	}
	
	public void play(){
		init();
		
		boolean finished = false;
		int sorteio;
		
		while(!finished){
		
			// vez da Tartaruga
			sorteio = randomNumber.nextInt(10) + 1;
			
			if(sorteio >= 1 && sorteio <= 5){
				posicaoTartaruga = 
					Math.min(posicaoTartaruga + TART_CAMINHADA_RAPIDA, POSICOES -1 );
			} else if (sorteio == 6 || sorteio == 7) {
				posicaoTartaruga = Math.max(posicaoTartaruga + TART_ESCORREGAO, 0);
			} else {
				posicaoTartaruga = 
					Math.min(posicaoTartaruga + TART_CAMINHADA_LENTA, POSICOES -1 );
			}
			
			// vez da Lebre
			sorteio = randomNumber.nextInt(10) + 1;
			
			if(sorteio == 1 || sorteio == 2){
				posicaoLebre = 
					Math.max(Math.min(posicaoLebre + LEBRE_DORMIR, POSICOES -1 ),0);
			} else if (sorteio == 3 || sorteio == 4) {
				posicaoLebre = 
					Math.min(posicaoLebre + LEBRE_SALTO_GRANDE, POSICOES -1 );
			} else if (sorteio == 5) {
				posicaoLebre = Math.max(posicaoLebre + LEBRE_ESCORREGAO_GRANDE, 0);
			} else if (sorteio >= 6 && sorteio <= 8) {
				posicaoLebre = 
					Math.min(posicaoLebre + LEBRE_SALTO_PEQUENO, POSICOES -1 );
			} else {
				posicaoLebre = 
					Math.max(posicaoLebre + LEBRE_ESCORREGAO_PEQUENO, 0 );
			}
			
			
			// analisa posições
			
			if (posicaoTartaruga == 69) {
				tartarugaWins();
				finished = true;
			} else if (posicaoLebre == 69) {
				lebreWins();
				finished = true;
			} else {
				printCorrida(posicaoTartaruga, posicaoLebre);
				//System.out.println();
			}
		}
	}
	
	private void printCorrida(int posTartaruga, int posLebre){
		System.out.println("+---------+---------+---------+---------+---------+---------+---------+");
		System.out.print("|");
		
		if(posTartaruga == posLebre){
			for(int i=0; i < posTartaruga; i++)
				System.out.print(" ");
			
			System.out.print("AI!!!");
			
			for(int i=0; i < (POSICOES - posTartaruga - 6); i++)
				System.out.print(" ");
				
		} else {
			
			for(int i = 0; i < POSICOES -1; i++){
				if(i == posTartaruga){
					System.out.print("T");
				} else if(i == posLebre){
					System.out.print("L");
				} else {
					System.out.print(" ");
				}
			}
		}
		
		System.out.println("|");
		//System.out.println("+---------+---------+---------+---------+---------+---------+---------+");
	}
	
	private void tartarugaWins(){
		System.out.println("+---------+---------+---------+---------+---------+---------+---------+");
		System.out.println();
		System.out.println("A TARTARUGA VENCEU!!! EH!!!");
		System.out.println();
	}
	
	private void lebreWins(){
		System.out.println("+---------+---------+---------+---------+---------+---------+---------+");
		System.out.println();
		System.out.println("A LEBRE GANHOU. OH!");
		System.out.println();
	}
	
}
