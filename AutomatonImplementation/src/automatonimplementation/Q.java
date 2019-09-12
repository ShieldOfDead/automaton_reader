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
public class Q {
    
    public static String[] IdentifyQ(String nome, String Q[]) {

        Scanner ler = new Scanner(System.in);
        StringBuilder sb = null;
        sb = new StringBuilder();

        try {
            FileReader arq = new FileReader(nome);
            BufferedReader lerArq = new BufferedReader(arq);
            char c;
            String linha = lerArq.readLine();
            Q = linha.split(",");

            System.out.print("Estados: Q = ");
                
            for (int i = 0; i < Q.length; i++) {

                if (i == Q.length-1) {
                    System.out.print(Q[i]);
                } else {
                    System.out.print(Q[i]+", ");
                }
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        System.out.println();
        return Q;
    }

}
