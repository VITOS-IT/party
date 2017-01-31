package com.vitos.a8ofmarch;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.FOCUS_DOWN;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    EditText code;
    Button confirm, clea;

    LinearLayout llMain;
    ScrollView s;
    String chacked;


    SharedPreferences sPref;
    final String SAVED_TEXT = "saved_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        code = (EditText)findViewById(R.id.editText);

        confirm = (Button)findViewById(R.id.confirm);
        llMain = (LinearLayout)findViewById(R.id.llMain);
        clea = (Button)findViewById(R.id.clea);
        clea.setOnClickListener(this);
        confirm.setOnClickListener(this);

        s=(ScrollView) findViewById(R.id.scroll);
        loadText();
        for (int i=0;i<chacked.length();i++){
            if(chacked.charAt(i)=='1') createAnswer(String.valueOf(i+1));
        }

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.clea:

               chacked = "00000";
               saveText();

                break;
            case R.id.confirm:
            String answer = code.getText().toString();
            createAnswer(answer);
                break;
        }
    }


    public void createAnswer(String answer){
        TextView tView = new TextView(this);
        tView.setTextSize(20);
        switch (answer){
            case "1":

                tView.setText(R.string.choise_1);

                llMain.addView(tView);
                code.setText("");
                chacked="10000";
                saveText();
                break;
            case "2":
                tView.setText(R.string.choise_2);
                llMain.addView(tView);
                code.setText("");
                chacked="01000";
                saveText();
                break;
            case "3":
                tView.setText(R.string.choise_3);
                llMain.addView(tView);
                code.setText("");
                chacked="00100";
                saveText();
                break;
            case "4":
                tView.setText(R.string.choise_4);
                llMain.addView(tView);
                code.setText("");
                chacked="00010";
                saveText();
                break;
            case "5":
                tView.setText(R.string.choise_5);
                llMain.addView(tView);
                code.setText("");
                chacked="00001";
                saveText();
                break;
            default:
                Toast.makeText(this,"Невірний код",Toast.LENGTH_SHORT).show();
                code.setText("");
                break;
        }
        s.fullScroll(FOCUS_DOWN);
    }

   void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT,chacked);
        ed.commit();

    }

    void loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        chacked = sPref.getString(SAVED_TEXT, "");

    }
}
