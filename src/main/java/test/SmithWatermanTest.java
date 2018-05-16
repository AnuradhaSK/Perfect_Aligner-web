package test;

import com.anuradha.perfectaligner.util.SmithWaterman;
import org.junit.Test;

import static org.junit.Assert.*;

public class SmithWatermanTest {

    private final SmithWaterman SWObj = new SmithWaterman("GGTGT", "GGACT", 1, -1, 0);

    @Test
    public void initialize() {
    }

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
        assertEquals(null,SWObj.getInitialPointer(0,0));
        assertEquals(null,SWObj.getInitialPointer(1,0));
        assertEquals(null,SWObj.getInitialPointer(0,1));
        assertEquals(null,SWObj.getInitialPointer(-1,0));
        assertEquals(null,SWObj.getInitialPointer(0,-1));

    }

    @Test
    public void getInitialScore() {
        assertEquals(0,SWObj.getInitialScore(0,0));
        assertEquals(0,SWObj.getInitialScore(1,0));
        assertEquals(0,SWObj.getInitialScore(0,1));
        assertEquals(0,SWObj.getInitialScore(-1,0));
        assertEquals(0,SWObj.getInitialScore(0,-1));
    }
}