/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatonimplementation;

import java.util.Arrays;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class AutomatonImplementation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        Scanner ler = new Scanner(System.in);

        String q[] = {};
        String e[] = {};
        String i[] = {};
        String f[] = {};

        String input[] = {"a", "a", "b", "b", "b", "c", "c", "c", "c"};

        System.out.printf("Informe o nome de arquivo texto:\n");
        String nome = ler.nextLine();
        System.out.println("");
        q = Q.IdentifyQ(nome, q);
        e = E.IndentifyE(nome, e);
        i = I.IdentifyI(nome, i);
        f = F.IdentifyF(nome, f);
        System.out.println("");
        System.out.println("Vetor INPUT: ");
        
        System.out.println(Arrays.toString(input));
        
        System.out.println("");

        FT.IndentifyFT(nome, e, i, f, input);
    }
}
