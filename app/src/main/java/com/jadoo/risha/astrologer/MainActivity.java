package com.jadoo.risha.astrologer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button selectDate;
    //private TextView name;
    private RadioGroup group;
    private RadioButton gender;
    public TextView showDate;
    private TextView showCharacter;
    private EditText nameText;
    private Button show;
    private RadioButton male;
    private RadioButton female;
    private int s=0;
    private AlertDialog.Builder build;

    String a;
    String b;
    int age;
    String data;
    String c;
    String n=null;
    int d, m, y, cy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameText.setText(R.string.Empty);
                male.setChecked(false);
                female.setChecked(false);
                d=0; m=0; y=0; cy=0;
                showDate.setText(R.string.Empty);
                showCharacter.setText(R.string.Empty);
            }
        });

        nameText = (EditText) findViewById(R.id.nameId);
        group = (RadioGroup) findViewById(R.id.radioGroupId);
        selectDate = (Button) findViewById(R.id.dateId);
        selectDate.setOnClickListener(this);
        showDate = (TextView) findViewById(R.id.dateShowId);
        show = (Button) findViewById(R.id.showId);
        show.setOnClickListener(this);
        showCharacter = (TextView) findViewById(R.id.characterId);
        male = (RadioButton) findViewById(R.id.maleId);
        female = (RadioButton) findViewById(R.id.femaleId);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                gender = (RadioButton) findViewById(checkedId);
                switch(gender.getId()){
                    case R.id.maleId :
                        s=1;
                        break;

                    case R.id.femaleId :
                        s=2;
                        break;

                    default :
                       // male.setChecked(false);
                        //female.setChecked(false);
                }
            }
        });
    }

    @Override
    public void onClick(View view){

        switch(view.getId()){
            case R.id.dateId :
                showDatePickerDialog(view);
                break;
            case R.id.showId :
                CalculateData();
                if(n==null){
                    createDialog("Error", "OOps!! You haven't selected your name...");
                }
                else
                    if(s==0){
                        createDialog("Error", "OOps!! You haven't selected your gender...");
                    }
                    else
                    if(d==0){
                        createDialog("Error", "What will I tell you without your birth date");
                    }
                    else
                if(age<=0 || age>=100) {
                    createDialog("Error", "Please!! Select your correct birth of date...");
                    d=0;
                    m=0;
                    y=0;
                    showDate.setText(R.string.Empty);
                }
                else{
                showCharacter.setText(data);
            }
                break;
        }
    }

    public void showDatePickerDialog(View v) {
        calendar newFragment = new calendar();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void ShowDate(String data, int d, int m, int y, int cy)

    {
        showDate.setText(data);
        this.d = d;
        this.m = m;
        this.y = y;
        this.cy = cy;
    }

    public void CalculateData(){

        String name = nameText.getText().toString();
        String[] word = name.split(" ");
        this.n = word[0].toUpperCase();

        if(d%4==0 && m%4==0)
        {
            if(s==1)
            {
                a="You are a handsome guy and lucky also";
                b="";
            }
            else
            if(s==2)
            {
                a="You are very beautiful and very cute also";
                b="";
            }
        }
        else
        if(d%4==1 && m%4==1)
        {
            a="you are very smart and blessed with Intelligence";
            b="";
        }
        else
        if(d%4==2 && m%4==2)
        {
            a="you are short tempered... control your anger";
            b="";
        }
        else
        if(d%4==3 && m%4==3)
        {
            a="you can talk to hours... very talkative";
            b="";
        }
        else
        {
            if(d%4==0)
            {
                if(s==1)
                    a="you are a Handsome guy and";
                else
                if(s==2)
                    a="you are very beautiful and";
            }
            else
            if(d%4==1)
                a="you are very intelligent and";
            else
            if(d%4==2)
                a="your anger is always on your nose and";
            else
            if(d%4==3)
                a="you are very talkative and";


            if(m%4==0)
            {
                if(s==1)
                    b=" you're handsome too";
                else
                if(s==2)
                    b=" you're beautiful";
            }
            else
            if(m%4==1)
                b=" intelligent too";
            else
            if(m%4==2)
                b=" became angry on small things";
            else
            if(m%4==3)
                b=" very talkative";
        }
        /*if(y<20)
            age=(100-(80+y))+18;
        else
            age=18-(y-20);*/
        age = cy-y;
        if(s==1)
        {
            if(age<13)
                c=("Hi... "+n+" "+age+" years old!! kid");
            else
            if(age<18)
                c=("Hi... "+n+" "+age+" years old!! teenager");
            else
            if(age<30)
                c=("Hi... "+n+" "+age+" years old!! bachelor");
            else
                c=("Hi... "+n+" "+age+" years old!! adult");
        }
        else
        if(s==2)
        {
            if(age<13)
                c=("Hi... "+n+" "+age+" years old!! cute girl");
            else
            if(age<18)
                c=("Hi... "+n+" "+age+" years old!! teenager");
            else
            if(age<30)
                c=("Hi... "+n+" "+age+" years old!! independent girl");
            else
                c=("Hi... "+n+" "+age+" years old!! lady");
        }
        this.data = c+(" "+a+b);
    }

    public void createDialog(String title, String message){
        build = new AlertDialog.Builder(this);
        build.setTitle(title);
        build.setMessage(message);
        build.setCancelable(false);
        build.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = build.create();
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, Copyright.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
