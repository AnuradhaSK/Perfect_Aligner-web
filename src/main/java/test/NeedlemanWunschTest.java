package test;

import com.anuradha.perfectaligner.util.NeedlemanWunsch;
import org.junit.Test;

import static org.junit.Assert.*;

public class NeedlemanWunschTest {

    private final NeedlemanWunsch NWObj=new NeedlemanWunsch("GGTG","GATC",1,-1,-1);
    @Test
    public void fillInCell() {
    }

    @Test
    public void traceBackIsNotDone() {
    }

    @Test
    public void getTracebackStartingCell() {

    }


    @Test
    public void getInitialPointer() {
        NWObj.printScoreTable();
        assertEquals(null, NWObj.getInitialPointer(0, 0));
    }

    @Test
    public void getInitialScore() {
        assertEquals(0,NWObj.getInitialScore(0,0));
        assertEquals(-1,NWObj.getInitialScore(1,0));
        assertEquals(-5,NWObj.getInitialScore(0,5));
    }
}