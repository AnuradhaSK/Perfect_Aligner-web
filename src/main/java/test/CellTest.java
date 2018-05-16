package test;

import com.anuradha.perfectaligner.util.Cell;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CellTest {


    private final Cell CELL = new Cell(0,5);
    @Test
    public void setScore() {
        CELL.setScore(-10);
        assertEquals(-10,CELL.getScore());
        CELL.setScore(0);
        assertEquals(0,CELL.getScore());
        CELL.setScore(10);
        assertEquals(10,CELL.getScore());
    }

    @Test
    public void getScore() {
        CELL.setScore(-1);
        assertEquals(-1,CELL.getScore());
        CELL.setScore(0);
        assertEquals(0,CELL.getScore());
        CELL.setScore(1);
        assertEquals(1,CELL.getScore());
    }

    @Test
    public void setPrevCell() {
        CELL.setPrevCell(new Cell(3,-5));
        assertEquals(3,CELL.getPrevCell().getRow());
        assertEquals(-5,CELL.getPrevCell().getCol());
    }

    @Test
    public void getRow() {
        assertEquals(0,CELL.getRow());
    }

    @Test
    public void getCol() {
        assertEquals(5,CELL.getCol());
    }

    @Test
    public void getPrevCell() {
        CELL.setPrevCell(new Cell(2,8));
        assertEquals(2,CELL.getPrevCell().getRow());
        assertEquals(8,CELL.getPrevCell().getCol());
    }

    @Test
    public void setScoreFromLeft() {
        CELL. setScoreFromLeft(-3);
        assertEquals(-3,CELL.getScoreFromLeft());
        CELL. setScoreFromLeft(0);
        assertEquals(0,CELL.getScoreFromLeft());
        CELL. setScoreFromLeft(2);
        assertEquals(2,CELL.getScoreFromLeft());
    }

    @Test
    public void getScoreFromLeft() {
        CELL. setScoreFromLeft(-2);
        assertEquals(-2,CELL.getScoreFromLeft());
        CELL. setScoreFromLeft(0);
        assertEquals(0,CELL.getScoreFromLeft());
        CELL. setScoreFromLeft(1);
        assertEquals(1,CELL.getScoreFromLeft());
    }

    @Test
    public void setScoreFromUp() {
        CELL. setScoreFromUp(4);
        assertEquals(4,CELL.getScoreFromUp());
        CELL. setScoreFromUp(0);
        assertEquals(0,CELL.getScoreFromUp());
        CELL. setScoreFromUp(-2);
        assertEquals(-2,CELL.getScoreFromUp());
    }

    @Test
    public void getScoreFromUp() {
        CELL. setScoreFromUp(0);
        assertEquals(0,CELL.getScoreFromUp());
        CELL. setScoreFromUp(-5);
        assertEquals(-5,CELL.getScoreFromUp());
        CELL. setScoreFromUp(4);
        assertEquals(4,CELL.getScoreFromUp());
    }

    @Test
    public void setScoreFromDiagonal() {
        CELL. setScoreFromDiagonal(3);
        assertEquals(3,CELL.getScoreFromDiagonal());
        CELL. setScoreFromDiagonal(0);
        assertEquals(0,CELL.getScoreFromDiagonal());
        CELL. setScoreFromDiagonal(-1);
        assertEquals(-1,CELL.getScoreFromDiagonal());
    }

    @Test
    public void getScoreFromDiagonal() {
        CELL. setScoreFromDiagonal(3);
        assertEquals(3,CELL.getScoreFromDiagonal());
        CELL. setScoreFromDiagonal(0);
        assertEquals(0,CELL.getScoreFromDiagonal());
        CELL. setScoreFromDiagonal(-3);
        assertEquals(-3,CELL.getScoreFromDiagonal());
    }

}