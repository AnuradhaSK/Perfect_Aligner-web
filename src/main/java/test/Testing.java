package test;

import com.anuradha.perfectaligner.util.Cell;
import com.anuradha.perfectaligner.util.NeedlemanWunsch;
import com.anuradha.perfectaligner.util.SequenceAlignment;
import com.anuradha.perfectaligner.util.SmithWaterman;

import java.util.List;

public class Testing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        SequenceAlignment nwObject= new NeedlemanWunsch("GGTTGACTA", "TGTTA", 1, -1, -1);
        nwObject.printScoreTable();

        String[] alignedSequences= nwObject.getAlignment();
        for (int k=0;k<alignedSequences.length;k++){
            System.out.println(alignedSequences[k]);
        }

        Cell[][] cells=nwObject.getCellTabel();
        for (int i = 1; i < cells.length; i++) {
            for (int j = 1; j < cells[i].length; j++) {
                System.out.print(cells[i][j].getRow());
                System.out.print(cells[i][j].getCol());
                System.out.print(cells[i][j].getPrevCell().getRow());
                System.out.print(cells[i][j].getPrevCell().getCol());
                System.out.print(cells[i][j].getScore());
                System.out.println();
            }
            System.out.println("\n");
        }



        SequenceAlignment swObject= new SmithWaterman("GGTTGACTA", "TGTTA", 1, -1, -1);
        swObject.printScoreTable();
        String[] alignedSequences1= swObject.getAlignment();
        for (int k=0;k<alignedSequences1.length;k++){
            System.out.println(alignedSequences1[k]);
        }

        Cell[][] swcells=swObject.getCellTabel();
        for (int i = 1; i <  swcells.length; i++) {
            for (int j = 1; j <  swcells[i].length; j++) {
                System.out.print( swcells[i][j].getRow());
                System.out.print( swcells[i][j].getCol());
                if (swcells[i][j].getPrevCell() !=null) {
                    System.out.print(swcells[i][j].getPrevCell().getRow());
                    System.out.print(swcells[i][j].getPrevCell().getCol());
                }
                System.out.print( swcells[i][j].getScore());
                System.out.println();
            }
            System.out.println("\n");
        }


        List<Cell> finalcell = swObject.getTracebackCells();
        for (int i = 0; i < finalcell.size(); i++) {
            System.out.print(finalcell.get(i).getRow());
            System.out.print(finalcell.get(i).getCol());
        }


    }
}

