package com.example.slmns.demo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by slmns on 31-05-2017.
 */
public class NotesAddTest {
    @Test
    public void saveNote() throws Exception {
        // Her tester vi NoteName
        String input1 = "AAA";
        String output;
        String expected = "AAA";

        UserNotes userNotes = new UserNotes(input1);

        output = userNotes.Note;

        assertEquals(expected,output);









    }
}