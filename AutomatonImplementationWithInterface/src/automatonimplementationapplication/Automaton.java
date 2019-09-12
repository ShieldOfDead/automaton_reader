/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatonimplementationapplication;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yuri Willians
 */
public class Automaton {

    public static void Run(String pathConfig, String pathOut, String inputTXT) {
        Scanner ler = new Scanner(System.in);
        FileWriter arq = null;
        try {
            arq = new FileWriter(pathOut);
        } catch (IOException ex) {
            Logger.getLogger(Automaton.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintWriter gravarArq = new PrintWriter(arq);
        System.out.println("Entrei no AUTOMATON");
        String q[] = {};
        String e[] = {};
        String i[] = {};
        String f[] = {};

        String input[] = inputTXT.split(",");

        String nome = pathConfig;

        q = Q.IdentifyQ(nome, q, arq);
        e = E.IndentifyE(nome, e, arq);
        i = I.IdentifyI(nome, i, arq);
        f = F.IdentifyF(nome, f, arq);

        System.out.println("Cheguei no FT");
        
        gravarArq.println();
        gravarArq.printf("Vetor INPUT: ");
        gravarArq.println();

        gravarArq.printf(Arrays.toString(input));

        gravarArq.println();

        try {
            FT.IndentifyFT(nome, e, i, f, input, arq);
        } catch (IOException ex) {
            Logger.getLogger(Automaton.class.getName()).log(Level.SEVERE, null, ex);
        }
        gravarArq.close();
    }

}
