package com.example.android.housekeeping;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main5Activity extends AppCompatActivity {
    ListView listView;
   FirebaseDatabase database=FirebaseDatabase.getInstance();
    //atabaseReference databaseReference=database.getReference("Asset");
    ArrayList<String> list;
    ArrayAdapter<String> arrayAdapter;
    Firebase mRef;
    private ArrayList<String> mkeys = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        //FirebaseApp.initializeApp(this);
        Firebase.setAndroidContext(this);
        listView=(ListView)findViewById(R.id.listView);
        mRef = new Firebase("https://vitbus1.firebaseio.com/asset");

        list=new ArrayList<>();
        arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);
        mRef.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                for(DataSnapshot ds:dataSnapshot.getChildren())
                {
                    Map<String,String>h=ds.getValue(Map.class);
                    Log.d("gjh",h.keySet().toString());
                    //Toast.makeText(getApplicationContext(),h.keySet(),Toast.LENGTH_SHORT).show();
                    //list.add();
                }
                listView.setAdapter(arrayAdapter);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {


            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    public void cancel(View view)
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
