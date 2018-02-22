package test;

import com.anuradha.perfectaligner.util.Cell;
import com.anuradha.perfectaligner.util.NeedlemanWunsch;
import com.anuradha.perfectaligner.util.SequenceAlignment;

public class Testing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        SequenceAlignment nw= new NeedlemanWunsch("GGTTGACTA", "TGTTA", 1, -1, -1);
        nw.printScoreTable();

        String[] d= nw.getAlignment();
        for (int k=0;k<d.length;k++){
            System.out.println(d[k]);
        }

        Cell[][] c=nw.getCellTabel();
        for (int i = 1; i < c.length; i++) {
            for (int j = 1; j < c[i].length; j++) {
                System.out.print(c[i][j].getRow());
                System.out.print(c[i][j].getCol());
                System.out.print(c[i][j].getPrevCell().getRow());
                System.out.print(c[i][j].getPrevCell().getCol());
                System.out.print(c[i][j].getScore());
                System.out.println();
            }
            System.out.println("\n");
        }



    }
}

