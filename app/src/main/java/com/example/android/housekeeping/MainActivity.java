package com.example.android.housekeeping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addasset(View view)
    {
        Intent intent=new Intent(this,Main2Activity.class);
        startActivity(intent);

    }
    public void addtask(View view)
    {
        Intent intent=new Intent(this,Main3Activity.class);
        startActivity(intent);
    }

    public void addworker(View view)
    {
        Intent intent=new Intent(this,Main4Activity.class);
        startActivity(intent);
    }
    public void list(View view)
    {
        Intent intent=new Intent(this,Main5Activity.class);
        startActivity(intent);
    }
    public void allocate(View view)
    {
        Intent intent=new Intent(this,Main6Activity.class);
        startActivity(intent);
    }
    public void taskalloc(View view)
    {
        Intent intent=new Intent(this,Main7Activity.class);
        startActivity(intent);
    }
}
