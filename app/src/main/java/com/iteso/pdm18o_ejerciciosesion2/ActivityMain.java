package com.iteso.pdm18o_ejerciciosesion2;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.iteso.pdm18o_ejerciciosesion2.utils.Commons;

public class ActivityMain extends AppCompatActivity {

    EditText name;
    EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(Commons.APPNAME, "onCreate()");

        name = findViewById(R.id.activity_main_name);
        phone = findViewById(R.id.activity_main_phone);

        if(savedInstanceState != null){
            restore(savedInstanceState);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(Commons.APPNAME, "onStar()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(Commons.APPNAME, "onResume()");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putString("NAME", name.getText().toString());
        outState.putString("PHONE", phone.getText().toString());

        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }

    private void restore(Bundle savedInstanceState){
        name.setText(savedInstanceState.getString("NAME"));
        phone.setText(savedInstanceState.getString("PHONE"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(Commons.APPNAME, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(Commons.APPNAME, "onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(Commons.APPNAME, "onRestart()");
    }

    public void guardar(View v){
        switch (v.getId()){
            case R.id.activity_main_save:

                if(name.getText().toString().trim().length() == 0)
                    name.setError(getString(R.string.activity_main_name_required));

                if(phone.getText().toString().trim().length() == 0)
                    phone.setError(getString(R.string.activity_main_name_required));

                if(name.getText().toString().trim().equalsIgnoreCase(getString(R.string.activity_main_name_hint)))
                    return;

                if(phone.getText().toString().trim().equalsIgnoreCase(getString(R.string.activity_main_name_hint)))
                    return;

                Toast.makeText(this, name.getText().toString() + "\n" + phone.getText().toString(),
                    Toast.LENGTH_LONG).show();
                clean();
                break;
        }
    }

    public void clean(){
        name.setText("");
        phone.setText("");
        phone.setError(null);
        name.setError(null);
    }
}
