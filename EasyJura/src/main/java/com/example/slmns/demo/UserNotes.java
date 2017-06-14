package com.example.slmns.demo;

/**
 * Created by slmns on 18-05-2017.
 */

// This class will be used to create Note Objects to NotesAdd.class

public class UserNotes {

     String note;
     String noteName;

    public UserNotes() {
    }

    public UserNotes(String note, String noteName) {
        this.note = note;
        this.noteName = noteName;
    }

    public String getNote() {
        return note;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }
}
