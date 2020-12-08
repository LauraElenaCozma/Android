package com.example.androidfundamentalscourse1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //definim o constanta cu private final
    private final String ANDROID_DOCS = "https://developer.android.com/";

    private TextView firstTextView;
    private EditText editTextUserFullName;
    private CheckBox checkBoxTermsAndConditions;
    private SeekBar seekBarCountChallenges;
    private TextView textViewPurpleContent;
    private Button buttonGetContent;
    private WebView webViewAndroid;
    private Spinner spinnerAndroidVersions;
    private List<Email> emails;
    private RecyclerView recyclerViewEmails;
    private final Object TAG = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //seteaza layout-ul asociat activitatii MainActivity
        //setContentView(R.layout.activity_main);
        //asociem views_sample_1
        //setContentView(R.layout.views_sample_1);

        //run ScrollView sample
        //setContentView(R.layout.views_sample_scroll_view);
        //TODO: finish the implementation
        //CTRL + B sau CTRL + Click => go to definition
        //CTRL + P pe param functiei => show the params of a method
        //CTRL + Q => show documentation
        //CTRL + ALT + L => format the code

        /*int countStudents = 28;
        if (countStudents % 2 == 0) {
            countStudents++;
            Log.e("MainActivity", "numar par"); //afisat cu rosu pentru ca e de eroare
            Log.d("MainActivity", countStudents + ""); //concatenat cu empty string se transforma in string
        } else if (countStudents % 3 == 0) {
            Log.i("MainActivity", "numar divizibil cu 3");
        }*/

        //displayViewsSample1();

        //run web View sample
        /*setContentView(R.layout.views_sample_web_view);
        loadUrlInWebView();*/

        //pentru spinner
        /*setContentView(R.layout.views_sample_spinner);
        setupSpinnerAdapter();*/

        //run RecyclerView sample
        /*setContentView(R.layout.views_sample_recycler_view);
        displayEmailsList();*/

        int result = sum(10, 5, 4);
        Logging.show("MainActivity result = ", result + "");
        result++;

        setContentView(R.layout.activity_main);
        Logging.show(TAG, "onCreate");
    }

    private int sum(int a, int b, int c) {
        int result = a / b;
        return result + c;
    }



    @Override
    protected void onStart() {
        super.onStart();
        Logging.show(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logging.show(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logging.show(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logging.show(TAG, "onStop");
    }

    private ArrayAdapter<String> getSpinnerAdapter() {
        //step 2
        //o clasa predefinita
        //this e contextul actual; activitatea in care noi ne aflam
        //fiecare element de ui trebuie sa supravietuiasca intr-o activitate
        //layout: android. inseamna ca acest layout exista deja definit in android
        return new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                getSpinnerAndroidDataSource());
    }

    private List<String> getSpinnerAndroidDataSource() {
        //step 1 for spinner: get the data source for the spinner
        // (se poate lua din baza de date sau api)
        List<String> androidVersions = new ArrayList<>();
        androidVersions.add("Cupcake");
        androidVersions.add("Donut");
        androidVersions.add("Eclair");
        androidVersions.add("KitKat");
        androidVersions.add("Pie");
        return androidVersions;
    }

    private void setupSpinnerAdapter() {
        //step3
        spinnerAndroidVersions = findViewById(R.id.spinnerAndroidVersions);
        spinnerAndroidVersions.setAdapter(getSpinnerAdapter());
        //ii spunem ca am implementat evenimentul de select
        spinnerAndroidVersions.setOnItemSelectedListener(this);
    }

    private void loadUrlInWebView() {
        webViewAndroid = findViewById(R.id.webViewAndroid);
        WebSettings webSettings = webViewAndroid.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webViewAndroid.loadUrl(ANDROID_DOCS);
    }

    public void buttonGetContentOnClick(View view) {
        //vezi proprietatea OnClick din Button in view
        //preluam textul din editText(editable) si il convertim in String
        String contentFromEditText = editTextUserFullName.getText().toString();
        //vrem sa ne asiguram ca e diferit de null si ca e completat ceva
        if (contentFromEditText != null && contentFromEditText.length() > 0) {
            textViewPurpleContent.setText(contentFromEditText);
        } else {
            //daca nu a scris niciun caracter ii afisam o eroare
            editTextUserFullName.setError(getString(R.string.error_missing_text));
        }
    }

    private void displayViewsSample1() {
        firstTextView = findViewById(R.id.firstTextView);
        firstTextView.setText(R.string.new_text);

        editTextUserFullName = findViewById(R.id.editTextFullName);
        editTextUserFullName.setText(R.string.default_name);

        checkBoxTermsAndConditions = findViewById(R.id.checkboxTermsAndConditions);
        if (checkBoxTermsAndConditions.isChecked()) {
            checkBoxTermsAndConditions.setChecked(false);
            firstTextView.setText(R.string.checkbox_checked);
        } else {
            checkBoxTermsAndConditions.setChecked(true);
            firstTextView.setText(R.string.checkbox_unchecked);
        }

        //Event Listener
        checkBoxTermsAndConditions.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (compoundButton.isChecked()) {
                    editTextUserFullName.setText(R.string.checkbox_state_checked);
                } else {
                    editTextUserFullName.setText(R.string.checkbox_state_unchecked);
                }
            }
        });

        seekBarCountChallenges = findViewById(R.id.seekBarChallenges);
        seekBarCountChallenges.setProgress(5);

        //Scriu ceva in editText, apas pe buton si afisez in TextView mare
        textViewPurpleContent = findViewById(R.id.textViewPurpleContent);

        buttonGetContent = findViewById(R.id.buttonGetContent);
        //Ctrl + Shift + / = comment
        /*buttonGetContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //preluam textul din editText(editable) si il convertim in String
                String contentFromEditText = editTextUserFullName.getText().toString();
                //vrem sa ne asiguram ca e diferit de null si ca e completat ceva
                if (contentFromEditText != null && contentFromEditText.length() > 0) {
                    textViewPurpleContent.setText(contentFromEditText);
                } else {
                    //daca nu a scris niciun caracter ii afisam o eroare
                    editTextUserFullName.setError(getString(R.string.error_missing_text));
                }
            }
        });*/

        //!! INTERVIEW QUESTION: WHAT IS ANR? Application Not Responding
    }

    @Override
    //list, child, position, adapter, getItemId(position)
    public void onItemSelected(AdapterView<?> parent, View view, int position, long itemId) {
        //varianta 1 pentru select spinner
        //ca sa putem afla elementul selectat ne legam de acel position
        List<String> androidVersions = getSpinnerAndroidDataSource();
        String selectedVersion = androidVersions.get(position); //luam elementul de pe pozitia respectiva
        //un pop-up care apare pentru length_long timp
        Toast.makeText(MainActivity.this, selectedVersion, Toast.LENGTH_LONG).show();
        //apoi ii spunem lui spinner ca am implementat evenimentul in setSpinnerAdapter
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // ne trebuie daca implementam onItemSelected
    }

    //Recycler view implementation
    //get data source
    private void inbox() {
        emails = new ArrayList<>();
        Email email = null;
        for (int i = 0; i < 25; i++) {
            email = new Email(0, "Magda " + i, "Hello, Android " + i, "This is an intro about Android");
            emails.add(email);
        }
        //importam in gradle recicler view
    }

    //set the layout manager, in our case LinearLayoutManager because it's a list of emails
    private void setEmailsLayoutManager() {
        //trebuie sa definim recycler view
        recyclerViewEmails = findViewById(R.id.recyclerViewEmails);
        //vrem varianta liniara
        //MainActivity.this = this cand nu suntem in listener
        recyclerViewEmails.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    private void setEmailsAdapter() {
        recyclerViewEmails.setAdapter(new EmailAdapter(this, emails));
    }

    private void displayEmailsList() {
        inbox();
        setEmailsLayoutManager();
        setEmailsAdapter();
    }

    public void buttonOpenSecondActivityOnClick(View view) {
        Intent secondActivity = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(secondActivity);
    }
}