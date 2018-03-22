package com.example.a0koraj06.sqlite;


//import android.database.sqlite.SQLiteOpenHelper;
import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    MyHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        helper = new MyHelper(this);

        Button one = (Button) findViewById(R.id.button);
        one.setOnClickListener(this); // calling onClick() method

        Button two = (Button) findViewById(R.id.button2);
        two.setOnClickListener(this);

        Button three = (Button) findViewById(R.id.button3);
        three.setOnClickListener(this);

        Button four = (Button) findViewById(R.id.button4);
        four.setOnClickListener(this);


    }

    public void onClick(View view) {

        EditText Title = (EditText) findViewById(R.id.title);
        String title = Title.getText().toString() ;

        EditText Artist = (EditText) findViewById(R.id.artist);
        String artist = Artist.getText().toString();

        EditText Year = (EditText) findViewById(R.id.year);
        long year = Long.parseLong(Year.getText().toString());

        long id =  helper.insertRecord(title,artist,year);

        new AlertDialog.Builder(this).setPositiveButton("OK", null).
                setMessage(""+id).show();

    }
}