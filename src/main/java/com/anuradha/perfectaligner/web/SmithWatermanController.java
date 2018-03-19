package com.anuradha.perfectaligner.web;

import com.anuradha.perfectaligner.util.Cell;
import com.anuradha.perfectaligner.util.SequenceAlignment;
import com.anuradha.perfectaligner.util.SmithWaterman;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SmithWatermanController {
    @CrossOrigin
    @GetMapping("/smithwaterman")
    public String getVal(String sequence1, String sequence2, String match, String mismatch, String gap) {

        // create smithwaterman object
        SequenceAlignment swObject = new SmithWaterman(sequence1.toString(), sequence2.toString(), Integer.parseInt(match), Integer.parseInt(mismatch), Integer.parseInt(gap));
        // create a json Array
        JSONArray jsonArray = new JSONArray();

        // call getCellTable method which contains all grid values
        Cell[][] cellgrid = swObject.getCellTabel();
        for (int i = 1; i < cellgrid.length; i++) {

            for (int j = 1; j < cellgrid[i].length; j++) {
                // create a json object for each cell
                JSONObject jsonObject = new JSONObject();

                try {
                    // put row,column,score value of the cell to the json object
                    jsonObject.put("row", cellgrid[i][j].getRow());
                    jsonObject.put("col", cellgrid[i][j].getCol());
                    jsonObject.put("score", cellgrid[i][j].getScore());
                    jsonObject.put("upScore", cellgrid[i][j].getScoreFromUp());
                    jsonObject.put("leftScore", cellgrid[i][j].getScoreFromLeft());
                    jsonObject.put("diagonalScore", cellgrid[i][j].getScoreFromDiagonal());
                    // if the cell has a reference cell
                    if (cellgrid[i][j].getPrevCell() != null) {
                        // put the row and the column number of the reference cell
                        jsonObject.put("preRow", cellgrid[i][j].getPrevCell().getRow());
                        jsonObject.put("preCol", cellgrid[i][j].getPrevCell().getCol());
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                jsonArray.put(jsonObject);


            }
        }

        // call traceback
        List<Cell> finalcell = swObject.getTracebackCells();

        for (int i = 0; i < finalcell.size(); i++) {
            // create a json object and put the row column values of the traceback path's cells
            JSONObject jsonObject3 = new JSONObject();
            try {
                jsonObject3.put("row", finalcell.get(i).getRow());
                jsonObject3.put("col", finalcell.get(i).getCol());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jsonArray.put(jsonObject3);
        }

        String[] sequences = swObject.getAlignment();
        JSONObject jsonObject2 = new JSONObject();

        try {
            // put aligned sequences to a json object
            jsonObject2.put("sequence1", sequences[0]);
            jsonObject2.put("sequence2", sequences[1]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(jsonObject2);


        return jsonArray.toString();

    }
}
