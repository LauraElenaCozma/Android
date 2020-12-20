package com.example.androidfundamentalscourse1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {

    private static final String NAME_VALUE = "name";
    private static final String IACCEPT_VALUE = "accept";
    private EditText editTextPersonName;
    private CheckBox checkBoxIAccept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        editTextPersonName = findViewById(R.id.editTextPersonName);
        checkBoxIAccept = findViewById(R.id.checkBoxIAccept);

        addDynamicallyNewFragment(new BlankFragment());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        //vrem sa ne asiguram ca ii ramane textul si selectia din textBox
        super.onSaveInstanceState(outState);
        //metoda din super face singura, nu trebuie sa mai salvam noi
        outState.putString(NAME_VALUE, editTextPersonName.getText().toString());
        outState.putBoolean(IACCEPT_VALUE, checkBoxIAccept.isChecked());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        //super.onRestoreInstanceState(savedInstanceState);
        String name = savedInstanceState.getString(NAME_VALUE);
        editTextPersonName.setText(name);

        Boolean checked = savedInstanceState.getBoolean(IACCEPT_VALUE);
        checkBoxIAccept.setChecked(checked);
    }

    private void addDynamicallyNewFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.thePlaceholder, new BlankFragment());
        fragmentTransaction.commit();
    }
}