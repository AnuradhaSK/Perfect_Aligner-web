package com.anuradha.perfectaligner.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FastaReader {

    protected ArrayList<Gene> geneArray;

    public FastaReader(){
        geneArray = new ArrayList<Gene>();
    }
    public ArrayList<Gene> read(String path) throws IOException {
        boolean first = true;
        FileReader file = new FileReader(path);
        BufferedReader br = new BufferedReader(file);
        String currentLine;
        Integer counter = 0;
        String id=null;
        String sequence = null;
        while ((currentLine = br.readLine()) != null) {
            if (counter == 0 && currentLine.charAt(0) != '>') {
                System.out.println("This file is not in fasta format");
                break;
            }
            if (currentLine.charAt(0) == '>') {
                if (counter>0){
                    geneArray.add(new Gene(id,sequence));
                }
                if (first)
                    first = false;
                else
                    System.out.println();
                System.out.printf("%s: ", currentLine.substring(1));
                id=currentLine.substring(1);
                sequence = "";
            } else {
                System.out.print(currentLine);
                sequence+=currentLine;
            }
            counter += 1;
        }
        geneArray.add(new Gene(id,sequence));
        return geneArray;
    }
}
