package com.example.crudoperations;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class arrayAdapter<S> extends ArrayAdapter {

    public arrayAdapter(@NonNull Context context, ArrayList<Student> studentText) {
        super(context, 0,studentText);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Student student = (Student) getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_layout,parent,false);
        TextView text = convertView.findViewById(R.id.textView3);
        text.setText("Name: "+ student.getName()+"\n Rollno: "+ student.getRollNmber());
        return  convertView;
    }
}
