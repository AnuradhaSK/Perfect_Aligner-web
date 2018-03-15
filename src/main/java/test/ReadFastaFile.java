package test;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadFastaFile {

    public static void main(String[] args) throws IOException {

        /*boolean first = true;
        FileReader file = new FileReader("C:/Users/sudu/Desktop/test.fasta.txt");
        BufferedReader br = new BufferedReader(file);
        String currentLine;
        Integer counter = 0;
        while ((currentLine = br.readLine()) != null) {
            if (counter == 0 && currentLine.charAt(0) != '>') {
                System.out.println("This file is not in fasta format");
                break;
            }
            if (currentLine.charAt(0) == '>') {
                if (first)
                    first = false;
                else
                    System.out.println();
                System.out.printf("%s: ", currentLine.substring(1));
            } else {
                System.out.print(currentLine);
            }

            counter += 1;
        }*/
    }
}
