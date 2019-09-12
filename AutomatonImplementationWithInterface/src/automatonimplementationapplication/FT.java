/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatonimplementationapplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Aluno
 */
public class FT {

    public static void IndentifyFT(String nome, String E[], String I[], String F[], String input[], FileWriter arqAuto) throws IOException {

        try {

            FileReader arq;
            BufferedReader lerArq;
            PrintWriter gravarArq = new PrintWriter(arqAuto);

            gravarArq.println();
            
            String aux1[] = {};
            String posQ = I[0];
            int posI = -1;
            int ver = 0;
            int lineCount = 5;
            System.out.println("Cheguei no CHECK");
            if (Check(E, input, gravarArq)) {
                gravarArq.println();

                System.out.println("Passei do CHECK");
                
                gravarArq.println("O valor inicial é (" + posQ + ").");
                gravarArq.println("Atualizei o posQ para (" + posQ + ") como a posição inicial.");
                gravarArq.println();
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
                        gravarArq.println("A posição no vetor INPUT é " + posI + " com valor igual a [" + input[posI] + "]");
                        while (lerArq.ready() && ver == 0) {
                            aux1 = linha.split(",");
                            
                            if (posQ.equals(aux1[0]) && aux1[1].equals(input[posI]) && ver == 0) {
                                posQ = aux1[2];
                                ver = 1;
                                gravarArq.println("Atualizei o posQ para (" + posQ + ") com a entrada [" + input[posI] + "]");
                                gravarArq.println();
                            } else if (ver == 0 && lerArq.ready()) {
                                linha = lerArq.readLine();
                            }
                        }
                    }
                } while (posI < input.length);
                if (posQ.equals(F[0])) {
                    gravarArq.println("O INPUT foi capaz de chegar no estado final (" + posQ + "), portanto, o INPUT é válido!");
                } else {
                    gravarArq.println("FIM DO VETOR INPUT!");
                    gravarArq.println("O INPUT não conseguiu chegar ao estado final terminando no estado (" + posQ + ").");
                    arqAuto.close();
                }
                gravarArq.println();
                arq.close();
            }
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

    }

    public static boolean Check(String E[], String input[], PrintWriter gravarArqFT) {

        int[] inputVer = new int[E.length];
        int inputTot = 0;

        for (int j = 0; j < E.length; j++) {
            for (int z = 0; z < input.length; z++) {
                if (E[j].equals(input[z])) {
                    inputVer[j]++;
                }
            }
            System.out.println(inputVer[j]);
        }
        

        for (int j = 0; j < E.length; j++) {
            inputTot = inputTot + inputVer[j];
        }

        if (inputTot == input.length) {
            gravarArqFT.println("INPUT válido!");
            return true;
        } else {
            gravarArqFT.println("O INPUT inserido não é válido!");
            return false;
        }
    }
}
