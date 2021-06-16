package com.example.mirimiter;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

public class CommentData {
    private String documentId;
    private String comment;
    @ServerTimestamp
    private Date date;

    public CommentData(String documentId, String comments) {
        this.documentId = documentId;
        this.comment = comments;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}