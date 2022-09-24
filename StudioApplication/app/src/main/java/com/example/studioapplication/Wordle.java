package com.example.studioapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.Toast;

public class Wordle extends AppCompatActivity {

    int row_counter = 0, col_counter=0;
    View[][] rows ={
            {findViewById(R.id.wordle_11), findViewById(R.id.wordle_12), findViewById(R.id.wordle_13), findViewById(R.id.wordle_14), findViewById(R.id.wordle_15)},
            {findViewById(R.id.wordle_21),findViewById(R.id.wordle_22),findViewById(R.id.wordle_23),findViewById(R.id.wordle_24),findViewById(R.id.wordle_25)},
            {findViewById(R.id.wordle_31),findViewById(R.id.wordle_32),findViewById(R.id.wordle_33),findViewById(R.id.wordle_34),findViewById(R.id.wordle_35)},
            {findViewById(R.id.wordle_41),findViewById(R.id.wordle_42),findViewById(R.id.wordle_43),findViewById(R.id.wordle_44),findViewById(R.id.wordle_45)},
            {findViewById(R.id.wordle_51),findViewById(R.id.wordle_52),findViewById(R.id.wordle_53),findViewById(R.id.wordle_54),findViewById(R.id.wordle_55)},
            {findViewById(R.id.wordle_61),findViewById(R.id.wordle_62),findViewById(R.id.wordle_63),findViewById(R.id.wordle_64),findViewById(R.id.wordle_65)}
    };

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
                if(myEditText.requestFocus()) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
                }
                Log.d("Click","asdfgh");
            }
        });
        myEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // showMyDialog();
            }
        });
    }

}