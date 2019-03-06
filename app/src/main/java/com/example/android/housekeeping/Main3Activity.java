package com.example.android.housekeeping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class Main3Activity extends AppCompatActivity {
    private Firebase mRef,cRef;
    EditText id,desc;
    String edit,edit1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Firebase.setAndroidContext(this);
    }
    public void cancel(View view)
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void ok(View view)
    {
        id=(EditText)findViewById(R.id.tid);
        desc=(EditText)findViewById(R.id.description);
        edit=id.getText().toString();
        edit1=desc.getText().toString();
       // mRef = new Firebase("https://housekeeping-aa448.firebaseio.com/");
        cRef=new Firebase("https://housekeeping-aa448.firebaseio.com/task");
       /* Firebase mRefChild=mRef.child("Task");
        Firebase cRefChild=mRefChild.child(edit);
        cRefChild.child(edit).setValue(edit1);*/

        Firebase d=cRef.child("Tasks");
        Firebase e=d.child(edit);
        e.child(edit).setValue(edit1);

        Toast.makeText(getApplicationContext(), "Task Added!", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
