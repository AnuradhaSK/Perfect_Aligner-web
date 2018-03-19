package com.anuradha.perfectaligner.util;

public class Cell {
    private Cell prevCell;
    private int score;
    private int row;
    private int col;
    private int scoreFromUp;
    private int scoreFromLeft;
    private int scoreFromDiagonal;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * @param score
     *           the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param prevCell
     *           the prevCell to set
     */
    public void setPrevCell(Cell prevCell) {
        this.prevCell = prevCell;
    }

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @return the col
     */
    public int getCol() {
        return col;
    }

    /**
     * @return the prevCell
     */
    public Cell getPrevCell() {
        return prevCell;
    }

    public void setScoreFromLeft(int score) {
        this.scoreFromLeft = score;
    }

    /**
     * @return the scoreFromLeft
     */
    public int getScoreFromLeft() {
        return scoreFromLeft;
    }

    public void setScoreFromUp(int score) {
        this.scoreFromUp = score;
    }

    /**
     * @return the scoreFromUp
     */
    public int getScoreFromUp() {
        return scoreFromUp;
    }

    public void setScoreFromDiagonal(int score) {
        this.scoreFromDiagonal = score;
    }

    /**
     * @return the scoreFromDiagonal
     */
    public int getScoreFromDiagonal() {
        return scoreFromDiagonal;
    }
    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Cell(" + row + ", " + col + "): score=" + score + ", prevCell="
                + prevCell + "]";
    }
}
