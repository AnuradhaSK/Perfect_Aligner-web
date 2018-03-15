package com.anuradha.perfectaligner.util;

public class Gene {
    private String id;
    private String seq;

    public Gene(String id, String seq) {
        this.id = id;
        this.seq = seq;
    }

    public String getId() {
        return id;
    }

    public String getSeq() {
        return seq;
    }
}
