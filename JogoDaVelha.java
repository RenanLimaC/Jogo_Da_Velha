import java.util.Locale;
import java.util.Scanner;

public class JogoDaVelha {
    static String bloco1 = "1", bloco2 = "2", bloco3 = "3",

    bloco4 = "4", bloco5 = "5", bloco6 = "6",
            bloco7 = "7", bloco8 = "8", bloco9 = "9",

    coluna1 = bloco1 + bloco4 + bloco7,
            coluna2 = bloco2 + bloco5 + bloco8,
            coluna3 = bloco3 + bloco6 + bloco9,
            coluna4 = bloco1 + bloco2 + bloco3,
            coluna5 = bloco4 + bloco5 + bloco6,
            coluna6 = bloco7 + bloco8 + bloco9,
            coluna7 = bloco1 + bloco5 + bloco9,
            coluna8 = bloco3 + bloco5 + bloco7,

    jogador1, jogador2;
    static int jogador = 1;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("BEM VINDO AO JOGO DA VELHA.\n" +
                "DIGITE O NOME DO PRIMEIRO JOGADOR.");
        jogador1 = scanner.next();
        System.out.println("DIGITE O NOME DO SEGUNDO JOGADOR.");
        jogador2 = scanner.next();
        boolean controlador = true;
        while (controlador) {
            jogar();
            if (verificarSeTemVencedor()) {
                controlador = false;
            } else if (verificarSeDeuVelha()) {
                controlador = false;
            }

        }
    }


    private static void imprimeTabuleiro(String bloco1, String bloco2, String bloco3,
                                         String bloco4, String bloco5, String bloco6,
                                         String bloco7, String bloco8, String bloco9) {

        System.out.println(bloco1 + " | " + bloco2 + " | " + bloco3 + "\n" +
                "---------- \n" +
                bloco4 + " | " + bloco5 + " | " + bloco6 + "\n" +
                "---------- \n" +
                bloco7 + " | " + bloco8 + " | " + bloco9);
    }

    private static boolean verificarSeDeuVelha() {

        if (bloco1 != "1" && bloco2 != "2" && bloco3 != "3" &&
                bloco4 != "4" && bloco5 != "5" && bloco6 != "6" &&
                bloco7 != "7" && bloco8 != "8" && bloco9 != "9"
        ) {
            System.out.println("DEU VELHA!");
            return true;
        } else {
            return false;
        }


    }

    private static void colunas() {
        coluna1 = bloco1 + bloco4 + bloco7;
        coluna2 = bloco2 + bloco5 + bloco8;
        coluna3 = bloco3 + bloco6 + bloco9;
        coluna4 = bloco1 + bloco2 + bloco3;
        coluna5 = bloco4 + bloco5 + bloco6;
        coluna6 = bloco7 + bloco8 + bloco9;
        coluna7 = bloco1 + bloco5 + bloco9;
        coluna8 = bloco3 + bloco5 + bloco7;

    }

    private static void jogar() {
        imprimeTabuleiro(bloco1, bloco2, bloco3,
                bloco4, bloco5, bloco6,
                bloco7, bloco8, bloco9);
        boolean validarJogada = true;
        while (validarJogada) {
            System.out.println((jogador == 1) ? jogador1.toUpperCase() + " É A SUA VEZ." : jogador2.toUpperCase() + " É A SUA VEZ.");
            int jogada = scanner.nextInt();
            if (jogada <= 9 && jogada >= 1) {
                validarJogada = false;
            }
            try {
                definirJogada(jogada);
            } catch (Exception e) {
                validarJogada = true;
                System.out.println(e.getMessage());
            }


        }
        colunas();
        alternarJogador();

    }

    private static boolean verificarSeTemVencedor() {

        colunas();
        if (
                coluna1.equals("XXX") || coluna1.equals("OOO") ||
                        coluna2.equals("XXX") || coluna2.equals("OOO") ||
                        coluna3.equals("XXX") || coluna3.equals("OOO") ||
                        coluna4.equals("XXX") || coluna4.equals("OOO") ||
                        coluna5.equals("XXX") || coluna5.equals("OOO") ||
                        coluna6.equals("XXX") || coluna6.equals("OOO") ||
                        coluna7.equals("XXX") || coluna7.equals("OOO") ||
                        coluna8.equals("XXX") || coluna8.equals("OOO")) {
            System.out.println((jogador == 1) ? jogador1.toUpperCase() +
                    " VENCEU !!" : jogador2.toUpperCase() + " VENCEU !!");
            return true;
        } else {
            return false;
        }
    }
       private static String validarBloco (String bloco, String time, String jogada) throws Exception {
                if (bloco.equalsIgnoreCase(jogada)){
                    return time;
                }else{
                    throw new Exception("ESSE BLOCO JA FOI SELECIONADO.");
                }



       }


    private static void alternarJogador() {
        if (jogador == 1) {
            jogador = 2;
        } else {
            jogador = 1;
        }

    }

    private static void definirJogada(Integer jogada) throws Exception {
        String time = null;
        if (jogador == 1) {
            time = "X";
        } else if (jogador == 2) {
            time = "O";
        }
        switch (jogada) {
            case 1:
                bloco1 = validarBloco(bloco1, time, jogada.toString());
                break;
            case 2:
                bloco2 = time;
                break;
            case 3:
                bloco3 = time;
                break;
            case 4:
                bloco4 = time;
                break;
            case 5:
                bloco5 = time;
                break;
            case 6:
                bloco6 = time;
                break;
            case 7:
                bloco7 = time;
                break;
            case 8:
                bloco8 = time;
                break;
            case 9:
                bloco9 = time;
                break;

        }


    }


}
