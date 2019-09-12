/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatonimplementation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class FT {

    public static void IndentifyFT(String nome, String E[], String I[], String F[], String input[]) throws IOException {

        try {

            FileReader arq;
            BufferedReader lerArq;

            String aux1[] = {};
            String posQ = I[0];
            int posI = -1;
            int ver = 0;
            int lineCount = 5;
            Check(E, input);
            System.out.println("");

            System.out.println("O valor inicial é (" + posQ + ").");
            System.out.println("Atualizei o posQ para (" + posQ + ") como a posição inicial.");
            System.out.println("");
            do {
                arq = new FileReader(nome);
                lerArq = new BufferedReader(arq);
                String linha = null;
                for (int i = 0; i < lineCount; i++) {
                    linha = lerArq.readLine();
                }
                posI++;
                ver = 0;
                if (posI < input.length) {
                    System.out.println("A posição no vetor INPUT é " + posI + " com valor igual a [" + input[posI] + "]");
                    while (lerArq.ready() && ver == 0) {
                        aux1 = linha.split(",");
                        if (posQ.equals(aux1[0]) && aux1[1].equals(input[posI]) && ver == 0) {
                            posQ = aux1[2];
                            ver = 1;
                            System.out.println("Atualizei o posQ para (" + posQ + ") com a entrada [" + input[posI] + "]");
                            System.out.println("");
                        } else if (ver == 0 && lerArq.ready()) {
                            linha = lerArq.readLine();
                        }
                    }
                }
            } while (posI < input.length);
            if (posQ.equals(F[0])) {
                System.out.println("O INPUT foi capaz de chegar no estado final (" + posQ + "), portanto, o INPUT é válido!");
                System.exit(0);
            } else {
                System.out.println("FIM DO VETOR INPUT!");
                System.out.println("O INPUT não conseguiu chegar ao estado final terminando no estado (" + posQ + ").");
                System.exit(0);
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
    }

    public static void Check(String E[], String input[]) {

        int[] inputVer = new int[input.length];
        int inputTot = 0;

        for (int j = 0; j < E.length; j++) {
            for (int z = 0; z < input.length; z++) {
                if (E[j].equals(input[z])) {
                    inputVer[z]++;
                }
            }
        }

        for (int j = 0; j < input.length; j++) {
            inputTot = inputTot + inputVer[j];
        }

        if (inputTot == input.length) {
            System.out.println("INPUT válido!");
        } else {
            System.out.println("O INPUT inserido não é válido!");
            System.exit(0);
        }

    }
}
