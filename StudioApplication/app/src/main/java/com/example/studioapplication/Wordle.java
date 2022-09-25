package com.example.studioapplication;


import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;

import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TableLayout;

import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Wordle extends AppCompatActivity {
    int row_counter = 0, col_counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordle);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
        TableLayout a = (TableLayout)findViewById(R.id.wordle_tbL1);
        EditText myEditText = (EditText)findViewById(R.id.wordle_et1);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText myEditText = (EditText)findViewById(R.id.wordle_et1);
                if(myEditText.requestFocus()) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
                }
                Log.d("Click","asdfgh");
            }
        });
        View[][] wordls ={
                {findViewById(R.id.wordle_11), findViewById(R.id.wordle_12), findViewById(R.id.wordle_13), findViewById(R.id.wordle_14), findViewById(R.id.wordle_15)},
                {findViewById(R.id.wordle_21),findViewById(R.id.wordle_22),findViewById(R.id.wordle_23),findViewById(R.id.wordle_24),findViewById(R.id.wordle_25)},
                {findViewById(R.id.wordle_31),findViewById(R.id.wordle_32),findViewById(R.id.wordle_33),findViewById(R.id.wordle_34),findViewById(R.id.wordle_35)},
                {findViewById(R.id.wordle_41),findViewById(R.id.wordle_42),findViewById(R.id.wordle_43),findViewById(R.id.wordle_44),findViewById(R.id.wordle_45)},
                {findViewById(R.id.wordle_51),findViewById(R.id.wordle_52),findViewById(R.id.wordle_53),findViewById(R.id.wordle_54),findViewById(R.id.wordle_55)},
                {findViewById(R.id.wordle_61),findViewById(R.id.wordle_62),findViewById(R.id.wordle_63),findViewById(R.id.wordle_64),findViewById(R.id.wordle_65)}
        };
        myEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("textChanged len :",Integer.toString(charSequence.length()));
                Log.d("textChanged i :",Integer.toString(i));
                Log.d("textChanged i1:",Integer.toString(i1));
                Log.d("textChanged i2:",Integer.toString(i2));
                Log.d("textChanged :",charSequence.toString());
//                Log.d("textChanged seq:",charSequence.toString().substring(i1,i1+1)+"\n++++++\n");

                if(i1<5) {
                    if(i2<i1) ((TextView)wordls[row_counter][i2]).setText("");
                    else ((TextView)wordls[row_counter][i1]).setText(charSequence.toString().substring(i1,i1+1));
                }else{
                    ((EditText)findViewById(R.id.wordle_et1)).setText(charSequence.subSequence(i,i2));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
        myEditText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    Log.d("key:::::::","true"+Integer.toString(keyCode));
                    if (((EditText) findViewById(R.id.wordle_et1)).getText().toString().toUpperCase(Locale.ROOT).equals("AIKYA")){
                        Intent I = new Intent(v.getContext(),MainActivity.class);
                        startActivityForResult(I,0);
                    }
                    row_counter++;
                    if(row_counter>=6){
                        for (int i=0;i<6;i++){
                            for(int j=0;j<5;j++){
                                ((EditText)wordls[i][j]).setText("");
                            }
                        }
                        row_counter=0;
                    }
                    myEditText.setText("");
                    return true;
                }
                return false;
            }
        });
    }

}