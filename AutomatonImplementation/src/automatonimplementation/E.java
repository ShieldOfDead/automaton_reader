/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatonimplementation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class E {
    
    public static String[] IndentifyE(String nome, String E[]) {
        Scanner ler = new Scanner(System.in);
        StringBuilder sb = null;
        sb = new StringBuilder();

        try {
            FileReader arq = new FileReader(nome);
            BufferedReader lerArq = new BufferedReader(arq);
            char c;
            String linha = lerArq.readLine().trim();
            linha = lerArq.readLine();

            E = linha.split(",");

            System.out.print("Entradas: E = ");

            for (int i = 0; i < E.length; i++) {

                if (i == E.length - 1) {
                    System.out.print(E[i]);
                } else {
                    System.out.print(E[i] + ", ");
                }
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        System.out.println();
        return E;

    }

}
