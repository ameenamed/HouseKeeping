package com.example.android.housekeeping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

public class Main5Activity extends AppCompatActivity {
    ListView listView;
    private ListView mValueView;
    private Firebase mRef;
    private ArrayList<String> mkeys = new ArrayList<>();
    private ArrayList<String> lat = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Firebase.setAndroidContext(this);
        listView=(ListView)findViewById(R.id.list);
        mRef=new Firebase("https://housekeeping-aa448.firebaseio.com/");
        mValueView=(ListView) findViewById(R.id.listview);
        final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lat);
        mValueView.setAdapter(arrayAdapter);
        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value=dataSnapshot.getValue(String.class);
                lat.add(value);
                String key=dataSnapshot.getKey();
                mkeys.add(key);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                String value=dataSnapshot.getValue(String.class);
                String key=dataSnapshot.getKey();
                int index=mkeys.indexOf(key);
                lat.set(index,value);
                arrayAdapter.notifyDataSetChanged();
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
