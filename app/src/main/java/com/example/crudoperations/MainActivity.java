package com.example.crudoperations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button buttonAdd, buttonViewAll, buttonDelete, buttonUpdate;
    EditText editName, editRollNumber;
    Switch switchIsActive;
    ListView listViewStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout22);

        buttonUpdate = findViewById(R.id.button4);
        buttonDelete= findViewById(R.id.button3);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonViewAll = findViewById(R.id.ViewAll);
        editName = findViewById(R.id.editTextName);
        editRollNumber = findViewById(R.id.editTextRollNumber);
        switchIsActive = findViewById(R.id.switchStudent);
        listViewStudent = findViewById(R.id.listViewStudent);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            Student student;

            @Override
            public void onClick(View v) {
                try {
                    student = new Student(editName.getText().toString(), Integer.parseInt(editRollNumber.getText().toString()), switchIsActive.isChecked());
                    //Toast.makeText(MainActivity.this, studentModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
                dbHelper dbHelper  = new dbHelper(MainActivity.this);
                dbHelper.addStudent(student);

            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener()
        {
            Student student;

            @Override
            public void onClick(View v) {
                try {
                    student = new Student(editName.getText().toString(), Integer.parseInt(editRollNumber.getText().toString()), switchIsActive.isChecked());
                    //Toast.makeText(MainActivity.this, studentModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
                dbHelper dbHelper  = new dbHelper(MainActivity.this);

                dbHelper.deleteStudent(student);
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            Student student;

            @Override
            public void onClick(View v) {
                try {
                    student = new Student(editName.getText().toString(), Integer.parseInt(editRollNumber.getText().toString()), switchIsActive.isChecked());
                    //Toast.makeText(MainActivity.this, studentModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
                dbHelper dbHelper  = new dbHelper(MainActivity.this);

                dbHelper.updateStudent(student);
            }
        });

        buttonViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper dbHelper = new dbHelper(MainActivity.this);
                ArrayList<Student> list = dbHelper.getAllStudents();
//                ArrayAdapter arrayAdapter1 = new ArrayAdapter<Student>
//                        (MainActivity.this, android.R.layout.simple_list_item_1,list);
//                listViewStudent.setAdapter(arrayAdapter1);
                arrayAdapter adapter = new arrayAdapter(MainActivity.this,list);
                listViewStudent.setAdapter(adapter);
            }
        });

    }

}
