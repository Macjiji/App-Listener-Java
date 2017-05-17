package com.macjiji.marcus.appwithlistener;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 *
 * @author Marcus
 * @version 1.0
 *
 * Classe permettant de gérer les listener par les méthodes
 *
 */

public class ActivityWithMethods extends AppCompatActivity {


    protected Button activityWithImplements, activityWithMetods, buttonClickMe;
    protected EditText editText;
    protected SeekBar seekBar;
    protected TextView editTextPreview, seekBarPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeButtons();
        initializeEditText();
        initializeSeekBar();
        initializeTextViews();
    }

    /**
     * Méthode d'initialisation des boutons
     */
    private void initializeButtons(){
        activityWithImplements = (Button)findViewById(R.id.button_activity_with_implements);
        activityWithMetods = (Button)findViewById(R.id.button_activity_with_methods);
        buttonClickMe = (Button)findViewById(R.id.button_click_me);

        activityWithImplements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityWithMethods.this, ActivityWithImplements.class));
            }
        });


        activityWithMetods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // DO NOTHING
            }
        });


        buttonClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ActivityWithMethods.this, "Clicked !!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Méthode d'initialisation des EditText
     */
    private void initializeEditText(){
        editText = (EditText)findViewById(R.id.edittext);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // YOUR CODE HERE
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editTextPreview.setText(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // YOUR CODE HERE
            }
        });
    }

    /**
     * Méthode d'initialisation des SeekBar
     */
    private void initializeSeekBar(){
        seekBar = (SeekBar)findViewById(R.id.seekbar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekBarPreview.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // YOUR CODE HERE
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // YOUR CODE HERE
            }
        });
    }

    /**
     * Méthode d'initialisation des TextView
     */
    private void initializeTextViews(){
        editTextPreview = (TextView)findViewById(R.id.apercu_edittext);
        seekBarPreview = (TextView)findViewById(R.id.apercu_seekbar);
    }

}
