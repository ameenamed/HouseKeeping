package com.example.android.housekeeping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import com.firebase.client.Firebase;

public class Main6Activity extends AppCompatActivity {
    private Firebase mRef,cRef;
    EditText aid,tid,wid,curr,jk;
    String a,b,c,d,e;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        Firebase.setAndroidContext(this);
    }
    public void cancel(View view)
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void ok(View view)
    {
        aid=(EditText)findViewById(R.id.asssetid);
        tid=(EditText)findViewById(R.id.taskid);
        wid=(EditText)findViewById(R.id.workerid);
        curr=(EditText) findViewById(R.id.tak);
        jk=(EditText)findViewById(R.id.curr);
        a=aid.getText().toString();
        b=tid.getText().toString();
        c=wid.getText().toString();
        d=curr.getText().toString();
        e=jk.getText().toString();
        mRef = new Firebase("https://housekeeping-aa448.firebaseio.com/");
        Firebase mRefChild=mRef.child("Allocated");
        Firebase cRefChild=mRefChild.child(c);
        cRefChild.child(c).setValue(b);

        Firebase dRefChild=cRefChild.child(b);
        dRefChild.child(b).setValue(a);

        Firebase eRefChild=dRefChild.child(a);
        eRefChild.child(a).setValue(d);

        Firebase fRefChild=eRefChild.child(d);
        fRefChild.child(d).setValue(e);



        //cRefChild.child(a).setValue(c);
        //cRefChild.child(a).setValue(d);
        //Firebase dRefChild=cRefChild.child(b);
        //Firebase eRefChild=cRefChild.setValue(d);
       // Firebase fRefChild=eRefChild.setValue(d);
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);

    }

}
