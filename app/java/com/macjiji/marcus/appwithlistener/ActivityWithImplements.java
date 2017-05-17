package com.macjiji.marcus.appwithlistener;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 *
 * @author Marcus
 * @version 1.0
 *
 * Classe permettant de gérer les listener via implémentation directe sur l'activité
 *
 */
public class ActivityWithImplements extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    protected Button activityWithImplements, activityWithMetods, buttonClickMe;
    protected EditText editText;
    protected SeekBar seekBar;
    protected TextView editTextPreview, seekBarPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeTextViews();
        initializeButtons();
        initializeEditText();
        initializeSeekBar();
    }

    /**
     * Méthode ici de l'interface OnClickListener
     * @see android.view.View.OnClickListener
     * @param view la vue cliqué
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_activity_with_implements:
                // YOUR CODE HERE
                break;
            case R.id.button_activity_with_methods:
                startActivity(new Intent(ActivityWithImplements.this, ActivityWithMethods.class));
                break;
            case R.id.button_click_me:
                Toast.makeText(this, "Clicked !!!!", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * Méthode issue de l'interface OnSeekBarChangeListener
     * @see android.widget.SeekBar.OnSeekBarChangeListener
     * @param seekBar
     * @param i
     * @param b
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        switch (seekBar.getId()){
            case R.id.seekbar:
                seekBarPreview.setText(String.valueOf(seekBar.getProgress()));
                break;
        }
    }

    /**
     * Méthode issue de l'interface OnSeekBarChangeListener
     * @see android.widget.SeekBar.OnSeekBarChangeListener
     * @param seekBar
     */
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        switch (seekBar.getId()){
            case R.id.seekbar:
                // YOUR CODE HERE
                break;
        }
    }

    /**
     * Méthode issue de l'interface OnSeekBarChangeListener
     * @see android.widget.SeekBar.OnSeekBarChangeListener
     * @param seekBar
     */
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        switch (seekBar.getId()){
            case R.id.seekbar:
                // YOUR CODE HERE
                break;
        }
    }

    /**
     * Méthode d'initialisation des boutons
     */
    private void initializeButtons(){
        // Etape 1 : Récupération des références via la classe R
        activityWithImplements = (Button)findViewById(R.id.button_activity_with_implements);
        activityWithMetods = (Button)findViewById(R.id.button_activity_with_methods);
        buttonClickMe = (Button)findViewById(R.id.button_click_me);
        // Etape 2 : Création des listener sur chaque élément
        activityWithImplements.setOnClickListener(this);
        activityWithMetods.setOnClickListener(this);
        buttonClickMe.setOnClickListener(this);
    }

    /**
     * Méthode d'initialisation des EditText
     */
    private void initializeEditText(){
        // Etape 1 : Récupération des références via la classe R
        editText = (EditText)findViewById(R.id.edittext);
        // Etape 2 : Création des listener sur chaque élément
        editText.addTextChangedListener(new OwnTextWatcher(editText));
    }

    /**
     * Méthode d'initialisation des SeekBar
     */
    private void initializeSeekBar(){
        // Etape 1 : Récupération des références via la classe R
        seekBar = (SeekBar)findViewById(R.id.seekbar);
        // Etape 2 : Création des listener sur chaque élément
        seekBar.setOnSeekBarChangeListener(this);
    }

    /**
     * Méthode d'initialisation des TextView
     */
    private void initializeTextViews(){
        editTextPreview = (TextView)findViewById(R.id.apercu_edittext);
        seekBarPreview = (TextView)findViewById(R.id.apercu_seekbar);
    }

    /**
     * Classe privée permettant de gérer les TextWatcher sur de multiples champs d'édition (même si ici, il n'y en a qu'un).
     */
    private class OwnTextWatcher implements TextWatcher{

        private View view;

        private OwnTextWatcher (View v) {
            view = v;
        }

        /**
         * Méthode issue de l'interface TextWatcher
         * @see TextWatcher
         * @param s
         * @param start
         * @param count
         * @param after
         */
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // YOUR CODE HERE
        }

        /**
         * Méthode issue de l'interface TextWatcher
         * @see TextWatcher
         * @param s
         * @param start
         * @param before
         * @param count
         */
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            switch (view.getId()) {
                case R.id.edittext:
                    editTextPreview.setText(s);
                    break;

            }
        }

        /**
         * Méthode issue de l'interface TextWatcher
         * @see TextWatcher
         * @param editable
         */
        @Override
        public void afterTextChanged(Editable editable) {
            // YOUR CODE HERE
        }

    }



}
