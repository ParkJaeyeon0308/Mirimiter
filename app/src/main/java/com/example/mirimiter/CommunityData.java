package com.example.mirimiter;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

public class CommunityData {
    private String documentId;
    private String content;
    @ServerTimestamp
    private Date date;

    public CommunityData() {
    }

    public CommunityData(String documentId, String content) {
        this.documentId = documentId;
        this.content = content;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
