package com.anuradha.perfectaligner.web;

import com.anuradha.perfectaligner.util.FastaReader;
import com.anuradha.perfectaligner.util.Gene;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

@RestController
public class DialignController {
    @CrossOrigin
    @GetMapping("/dialign")
    public String getVal() throws IOException, JSONException {
        FastaReader dialignObject = new FastaReader();
        ArrayList<Gene> array = dialignObject.read();
        JSONArray jsonArray = new JSONArray();
        for (int i=0; i<array.size();i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", array.get(i).getId());
            jsonObject.put("seq", array.get(i).getSeq());
            jsonArray.put(jsonObject);
        }
        return jsonArray.toString();
    }
}
