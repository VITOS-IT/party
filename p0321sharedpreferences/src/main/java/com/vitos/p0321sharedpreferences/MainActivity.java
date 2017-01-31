package com.vitos.p0321sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etText;
    Button btnSave, btnLoad;
    SharedPreferences sPref;
    final String SAVED_TEXT = "saved text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etText = (EditText)findViewById(R.id.etText);
        btnSave = (Button)findViewById(R.id.btnSave);
        btnLoad = (Button)findViewById(R.id.btnLoad);
        btnSave.setOnClickListener(this);
        btnLoad.setOnClickListener(this);

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnSave:
                saveText();
                etText.setText("");
                break;
            case R.id.btnLoad:
                loadText();
                break;
            default:
                break;
        }
    }

    void saveText(){
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, etText.getText().toString());
        ed.commit();
        Toast.makeText(this,"text saved",Toast.LENGTH_SHORT).show();
    }

    void loadText(){
        sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT,"");
        etText.setText(savedText);
        Toast.makeText(this,"Text loaded",Toast.LENGTH_SHORT).show();
    }

}
