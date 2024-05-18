package com.example.myproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<String> {

    private ArrayList<String> tasks;

    public TaskAdapter(Context context, ArrayList<String> tasks) {
        super(context, 0, tasks);
        this.tasks = tasks;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem, parent, false);
        }

        String task = getItem(position);

        TextView taskTextView = convertView.findViewById(R.id.taskTextView);
        taskTextView.setText(task);

        Button deleteButton = convertView.findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(v -> {
            tasks.remove(position);
            notifyDataSetChanged();
        });

        return convertView;
    }
}