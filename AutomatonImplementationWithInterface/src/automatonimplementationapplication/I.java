package automatonimplementationapplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
public class I {
    
    String I[] = {};
    
    public static String [] IdentifyI(String nome, String I[], FileWriter arqAuto) {

        Scanner ler = new Scanner(System.in);
        StringBuilder sb = null;
        sb = new StringBuilder();

        try {
            FileReader arq = new FileReader(nome);
            BufferedReader lerArq = new BufferedReader(arq);
            PrintWriter gravarArq = new PrintWriter(arqAuto);
            char c;
            String linha = lerArq.readLine();
            linha = lerArq.readLine();
            linha = lerArq.readLine().trim();

            I = linha.split(",");

            gravarArq.printf("Estado inicial:");
            gravarArq.println();
            gravarArq.printf("I = ");
                
            for (int i = 0; i < I.length; i++) {

                if (i == I.length-1) {
                    gravarArq.printf(I[i]);
                } else {
                    gravarArq.printf(I[i]+", ");
                }
            }
            gravarArq.println();
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        System.out.println();
        return I;
    }
    
}
