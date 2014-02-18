import java.util.Random;

public class PasseioCavalo {
	private Tabuleiro tabuleiro;
	private Random randomNumber = new Random();
	
	public PasseioCavalo (int posx, int posy){
		tabuleiro = new Tabuleiro(posx, posy);
	}
	
	public void run(){		
		int moveNumber; 
		while(!tabuleiro.isFinished()){
			moveNumber = randomNumber.nextInt(8);
			
			if(tabuleiro.isMovimentoValido(moveNumber)){
				tabuleiro.setMovimento(moveNumber);
			}
		}
		
		tabuleiro.imprimeTabuleiro();
	}
	
	private class Tabuleiro {
		private final int[] HORIZONTAL = { 2,  1, -1, -2, -2, -1, 1, 2};
		private final int[] VERTICAL   = {-1, -2, -2, -1,  1,  2, 2, 1};
		
		int[][] tabuleiro = {{0,0,0,0,0,0,0,0},
		                     {0,0,0,0,0,0,0,0},
		                     {0,0,0,0,0,0,0,0},
		                     {0,0,0,0,0,0,0,0},
		                     {0,0,0,0,0,0,0,0},
		                     {0,0,0,0,0,0,0,0},
		                     {0,0,0,0,0,0,0,0},
		                     {0,0,0,0,0,0,0,0}};
		
		int linhaCorrente;
		int colunaCorrente;
		
		int counter = 0;
		
		public Tabuleiro (int posx, int posy){
			if (posx >= 1 && posx <= 8 && posy >= 1 && posy <= 8){
				linhaCorrente = posx - 1;
				colunaCorrente = posy - 1;
				
				tabuleiro[linhaCorrente][colunaCorrente] = ++counter;
				
				//logPosicao();
			} else {
				throw new IllegalArgumentException("Posições devem ser entre 1 e 8.");
			}
		}
		
		public void setMovimento(int idx){
			linhaCorrente += VERTICAL[idx];
			colunaCorrente += HORIZONTAL[idx];
			
			//System.out.printf("\nh: %d, v: %d\n",HORIZONTAL[idx], VERTICAL[idx]);
			
			//logPosicao();
			
			tabuleiro[linhaCorrente][colunaCorrente] = ++counter;
			
			//imprimeTabuleiro();
		}
		
		public boolean isMovimentoValido(int idx){
			return (colunaCorrente + HORIZONTAL[idx] >= 0 && colunaCorrente + HORIZONTAL[idx] < 8)
				&& (linhaCorrente + VERTICAL[idx] >= 0 && linhaCorrente + VERTICAL[idx] < 8)
				&& (tabuleiro[linhaCorrente + VERTICAL[idx]][colunaCorrente + HORIZONTAL[idx]] == 0);
		}
		
		public boolean isFinished(){
			return counter == 64 || !haMovimentoLivre();
		}
		
		public boolean haMovimentoLivre(){
			for(int i=0; i < 8; i++){
				if(isMovimentoValido(i)){
					return true;
				}
			}
			return false;
		}
		
		public void imprimeTabuleiro(){
			System.out.printf("\nTotal de movimentos: %d.\n", counter);
			
			for(int i=0; i < 8; i++){
				for(int j=0; j< 8; j++){
					System.out.printf("%4d", tabuleiro[i][j]);
				}
				System.out.println();
			}
		}
		
		public void logPosicao(){
			System.out.printf("#%d: %d, %d\n", counter, linhaCorrente, colunaCorrente);
		}
	}
}
