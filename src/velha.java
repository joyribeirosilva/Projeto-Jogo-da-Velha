import java.util.Scanner;
/**
 * Script para se basear durante o desenvolvimento:
 *
 * Repetir  o jogo
 * imprimir o jogo - ok
 * trocar de jogador - ok
 * informa qual jogador da vez - ok
 * ler jogada - ok
 * validar  jogada - ok
 * Se a posição existe - ok
 * Se alguem ganhou - ok
 * ver se o jogo acabou - ok
 * Se alguem ganhou - ok
 * verificar colunas - ok
 * verificar linhas - ok
 * verificar diagonais - ok
 * Se deu velha - ok
 * Se não acabou - ok
 *
 */

public class velha {
    private int [][] tabuleiro = new int[3][3];
  	private int jogador = 1;

          	public boolean jogar(int x, int y) {
        		if ((x < 0) || (x > 2) || (y < 0) || (y > 2)) {
            			return false;
            		}
       		if (tabuleiro[x][y] != 0) {
            			return false;
            		}
        		tabuleiro[x][y] = jogador;
        		jogador = (jogador == 1) ? 2 : 1;
        		return true;
        	}

         	public int vencedor() {
        		for (int j = 1; j < 3; j++) {
            			// Testa as linhas
            			for (int linha = 0; linha < 3; linha++) {
                				boolean fechou = true;
                				for (int coluna = 0; coluna < 3; coluna++) {
                    					if (tabuleiro[coluna][linha] != j) {
                        						fechou = false;
                        					}
                    			}
               				if (fechou) {
                   					return j;
                    				}
                			}
            			// Testa as colunas
            			for (int coluna = 0; coluna < 3; coluna++) {
                				boolean fechou = true;
                				for (int linha = 0; linha < 3; linha++) {
                    					if (tabuleiro[coluna][linha] != j) {
                        						fechou = false;
                        					}
                    				}
                				if (fechou) {
                    					return j;
                    				}
                			}
            			// Testar as diagonais
            			boolean fechou = true;
            			for (int posicao = 0; posicao < 3; posicao++) {
                				if (tabuleiro[posicao][posicao] != j) {
                    					fechou = false;
                    				}
                			}
            			if (fechou) {
                				return j;
                			}
            			fechou = true;
            			for (int posicao = 2; posicao >= 0; posicao--) {
                				if (tabuleiro[posicao][2-posicao] != j) {
                    					fechou = false;
                    				}
                			}
            			if (fechou) {
                				return j;
                			}
            		}
        		boolean empate = true;
        		for (int linha = 0; linha < 3; linha++) {
            			for (int coluna = 0; coluna < 3; coluna++) {
                				if (tabuleiro[coluna][linha] == 0) {
                    					empate = false;
                    				}
                			}
            		}
        		if (empate) {
            			return 3;
            		}
        		return 0;
        	}

         	public String toString() {
        		String out = "";
        		for (int linha = 0; linha < 3; linha++) {
            			for (int coluna = 0; coluna < 3; coluna++) {
                				switch (tabuleiro[coluna][linha]) {
                    				case 0 :
                        					out += "_ ";
                        					break;
                    				case 1 :
                        					out += "O ";
                        					break;
                    				case 2 :
                        					out += "X ";
                        					break;
                    				}
                			}
            			out += "\n";
            		}
        		return out;
        	}

         	public void executar() {
        		Scanner entrada = new Scanner(System.in);
        		while (vencedor() == 0) {
            			System.out.println(this);
            			System.out.println("Jogador: " + jogador);
            			System.out.print("Coluna: ");
            			int coluna = entrada.nextInt();
            			System.out.print("Linha: ");
            			int linha = entrada.nextInt();
            			if (!jogar(coluna, linha)) {
                				System.out.println("Jogada invalida, tente novamente...");
                			}
            		}
        		System.out.println(this);
        		System.out.println(vencedor());
        	}

        	public static void main(String [] args) {
        		velha jogo = new velha();
        		jogo.executar();
        	}

}






