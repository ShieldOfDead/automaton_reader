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
public class F {

    public static String[] IdentifyF(String nome, String F[]) {

        Scanner ler = new Scanner(System.in);
        StringBuilder sb = null;
        sb = new StringBuilder();

        try {
            FileReader arq = new FileReader(nome);
            BufferedReader lerArq = new BufferedReader(arq);
            char c;
            String linha = lerArq.readLine();
            linha = lerArq.readLine();
            linha = lerArq.readLine();
            linha = lerArq.readLine().trim();

            F = linha.split(",");

            System.out.print("Estado final: F = ");

            for (int i = 0; i < F.length; i++) {

                if (i == F.length - 1) {
                    System.out.print(F[i]);
                } else {
                    System.out.print(F[i] + ", ");
                }
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        System.out.println();
        return F;
    }

}
