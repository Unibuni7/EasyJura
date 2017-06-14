package com.example.slmns.demo;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by slmns on 14-06-2017.
 */

public class NoteList extends ArrayAdapter<UserNotes> {

    // Here we create the content of the ListView
    private Activity context;
    // context is the context of current state of the application/object. it lets newly-created
    // objects understand what has been going on. We invoke it by using "this".
    private List<UserNotes> notesList;
    // We create an array the will hold our notename and note

    public NoteList(Activity context,List<UserNotes> notesList){
        super(context, R.layout.notes_list, notesList);
        this.context = context;
        this.notesList = notesList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewNotes = inflater.inflate(R.layout.notes_list,null,true);
        // inflate method will lets us render the xml file, with these contents.


        TextView textViewReadName = (TextView) listViewNotes.findViewById(R.id.textViewReadNoteName);
        TextView textViewReadNote = (TextView) listViewNotes.findViewById(R.id.textViewReadNote);

        UserNotes userNotes = notesList.get(position);

        textViewReadName.setText(userNotes.getNoteName());
        textViewReadNote.setText(userNotes.getNote());

        return listViewNotes;
    }
}
