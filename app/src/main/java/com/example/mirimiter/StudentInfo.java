package com.example.mirimiter;

import java.util.HashMap;
import java.util.Map;

public class StudentInfo {
    private String id;
    private String pw;

    public StudentInfo(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public Map<String, Object> getHash(){
        Map<String, Object> student = new HashMap<>();
        student.put("id", getId());
        student.put("pw", getPw());
        return student;
    }
}
