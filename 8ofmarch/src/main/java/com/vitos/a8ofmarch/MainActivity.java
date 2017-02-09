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
    TextView youtube;
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
        youtube = (TextView)findViewById(R.id.youtube);
        confirm = (Button)findViewById(R.id.confirm);
        llMain = (LinearLayout)findViewById(R.id.llMain);
        clea = (Button)findViewById(R.id.clea);
        clea.setOnClickListener(this);
        confirm.setOnClickListener(this);

        s=(ScrollView) findViewById(R.id.scroll);
        loadText();
         if(chacked!="")createAnswer(String.valueOf(chacked));
        else userChoise(R.string.choise_start,R.string.a00);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.clea:
               chacked = "";
               saveText();
               break;
            case R.id.confirm:
                String answer = code.getText().toString();
                createAnswer(answer);
                break;
        }
    }


    public void createAnswer(String answer){

        switch (answer){
            case "1":
                userChoise(R.string.choise_1,R.string.answer_1);
                chacked="1";
                saveText();
                break;
            case "2":
                userChoise(R.string.choise_2,R.string.answer_2);
                chacked="2";
                saveText();
                break;
            case "3":
                userChoise(R.string.choise_3,R.string.answer_3);
                chacked="3";
                saveText();
                break;
            case "4":
                userChoise(R.string.choise_4,R.string.answer_4);
                chacked="4";
                saveText();
                break;
            case "5":
                userChoise(R.string.choise_5,R.string.answer_5);
                chacked="5";
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
    void userChoise(int s,int you){
        TextView tView = new TextView(this);
        tView.setTextSize(20);
        tView.setText(s);
        youtube.setText(you);
        llMain.addView(tView);
        code.setText("");
    }
}
