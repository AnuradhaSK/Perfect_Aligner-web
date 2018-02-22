package com.anuradha.perfectaligner.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.anuradha.perfectaligner.util.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.util.List;

@RestController
public class ActivityController {

    @CrossOrigin
    @GetMapping("/test")
    public String  getVal(String sequence1, String sequence2, String match, String mismatch, String gap) {

        SequenceAlignment nw=new NeedlemanWunsch(sequence1.toString(), sequence2.toString(), Integer.parseInt(match), Integer.parseInt(mismatch), Integer.parseInt(gap));
        JSONArray jsonArray = new JSONArray();

        Cell[][]cellgrid=nw.getCellTabel();
        for (int i = 1; i < cellgrid.length; i++) {

            for (int j = 1; j < cellgrid[i].length; j++) {
                JSONObject jsonObject = new JSONObject();

                try {
                    jsonObject.put("row",cellgrid[i][j].getRow());
                    jsonObject.put("col",cellgrid[i][j].getCol());
                    jsonObject.put("score",cellgrid[i][j].getScore());
                    jsonObject.put("preRow",cellgrid[i][j].getPrevCell().getRow());
                    jsonObject.put("preCol",cellgrid[i][j].getPrevCell().getCol());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                jsonArray.put(jsonObject);


            }
        }

        List<Cell> finalcell = nw.getTracebackCells();

        for (int i = 0; i < finalcell.size(); i++) {
            JSONObject jsonObject3 = new JSONObject();
            try {
                jsonObject3.put("row", finalcell.get(i).getRow());
                jsonObject3.put("col", finalcell.get(i).getCol());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jsonArray.put(jsonObject3);
        }


        String[] sequences= nw.getAlignment();
        JSONObject jsonObject2 = new JSONObject();

        try {
            jsonObject2.put("sequence1", sequences[0]);
            jsonObject2.put("sequence2", sequences[1]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(jsonObject2);


        //return "pass" + sequence1;

        return jsonArray.toString();

      // return sequence1+","+sequence2+","+match+","+mismatch+","+gap;
    }



}