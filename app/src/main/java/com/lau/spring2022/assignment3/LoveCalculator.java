package com.lau.spring2022.assignment3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

public class LoveCalculator extends AppCompatActivity {

    Spinner sp1;
    EditText name;
    TextView percentage_result;
    ImageView img1;
    ImageView img2;
    String java_result, javascript_result, c_result, python_result, sql_result, cpp_result, html_result, css_result;
    String n;
    Button cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_love_calculator);

        sp1 = (Spinner) findViewById(R.id.spinner_bar1);
        name = (EditText) findViewById(R.id.name);
        percentage_result = (TextView) findViewById(R.id.percentage);
        img1 = (ImageView) findViewById(R.id.programmer_img);
        img2 = (ImageView) findViewById(R.id.language_img);
        cal = (Button)  findViewById(R.id.calculate);

        // spinner to choose the currency
        String[] from = {"Java", "JavaScript", "C", "Python", "SQL", "C++", "HTML5", "CSS"};
        ArrayAdapter<String> adp1 = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, from);
        sp1.setAdapter(adp1);
    }

    public void calculate(View view){

        n = name.getText().toString();

        String sum = n + sp1.getSelectedItem().toString();
        int value = sum.hashCode();

        Random rand = new Random(value);

        img1.setTranslationY(-1500);
        img2.setTranslationY(-1500);

        if(!n.isEmpty()){
            name.setEnabled(false);
            if((sp1.getSelectedItem().toString().equalsIgnoreCase("Java"))){
                java_result = (rand.nextInt(100)+ 1) + "%";
                percentage_result.setText(java_result);
                img1.setImageResource(R.drawable.programmer);
                img2.setImageResource(R.drawable.java);
            } else if((sp1.getSelectedItem().toString().equalsIgnoreCase("JavaScript"))){
                javascript_result = (rand.nextInt(100)+ 1) + "%";
                percentage_result.setText(javascript_result);
                img1.setImageResource(R.drawable.programmer);
                img2.setImageResource(R.drawable.java_script);
            } else if(sp1.getSelectedItem().toString().equalsIgnoreCase("C")){
                c_result = (rand.nextInt(100)+ 1) + "%";
                percentage_result.setText(c_result);
                img1.setImageResource(R.drawable.programmer);
                img2.setImageResource(R.drawable.c_);
            } else if((sp1.getSelectedItem().toString().equalsIgnoreCase("Python"))){
                python_result = (rand.nextInt(100)+ 1) + "%";
                percentage_result.setText(python_result);
                img1.setImageResource(R.drawable.programmer);
                img2.setImageResource(R.drawable.python);
            } else if((sp1.getSelectedItem().toString().equalsIgnoreCase("SQL"))){
                sql_result = (rand.nextInt(100)+ 1) + "%";
                percentage_result.setText(sql_result);
                img1.setImageResource(R.drawable.programmer);
                img2.setImageResource(R.drawable.sql);
            } else if((sp1.getSelectedItem().toString().equalsIgnoreCase("C++"))){
                cpp_result = (rand.nextInt(100)+ 1) + "%";
                percentage_result.setText(cpp_result);
                img1.setImageResource(R.drawable.programmer);
                img2.setImageResource(R.drawable.c_pp);
            } else if((sp1.getSelectedItem().toString().equalsIgnoreCase("HTML5"))){
                html_result = (rand.nextInt(100)+ 1) + "%";
                percentage_result.setText(html_result);
                img1.setImageResource(R.drawable.programmer);
                img2.setImageResource(R.drawable.html);
            } else if((sp1.getSelectedItem().toString().equalsIgnoreCase("CSS"))){
                css_result = (rand.nextInt(100)+ 1) + "%";
                percentage_result.setText(css_result);
                img1.setImageResource(R.drawable.programmer);
                img2.setImageResource(R.drawable.css);
            }
        } else if(n.isEmpty()){
            name.setError("Enter a name");
            img1.setVisibility(View.INVISIBLE);
            img2.setVisibility(View.INVISIBLE);
        } else {
            img1.setVisibility(View.INVISIBLE);
            img2.setVisibility(View.INVISIBLE);
        }

        img1.animate().translationYBy(1500).rotation(3600).setDuration(600);
        img2.animate().translationYBy(1500).rotation(3600).setDuration(600);

        cal.onEditorAction(EditorInfo.IME_ACTION_DONE);
    }

    public void seeResults(View view){
        Intent intent = new Intent(this, ResultsTable.class);
        intent.putExtra("java_val", java_result);
        intent.putExtra("javascript_val", javascript_result);
        intent.putExtra("c_val", c_result);
        intent.putExtra("python_val", python_result);
        intent.putExtra("sql_val", sql_result);
        intent.putExtra("cpp_val", cpp_result);
        intent.putExtra("html_val", html_result);
        intent.putExtra("css_val", css_result);
        startActivity(intent);
    }

    public void playAgain(View view){
        name.setEnabled(true);
        name.setText("");
        percentage_result.setText("");
        img1.setVisibility(View.INVISIBLE);
        img2.setVisibility(View.INVISIBLE);
        Intent intent = new Intent(this, LoveCalculator.class);
        intent.putExtra("java_val", "");
        intent.putExtra("javascript_val", "");
        intent.putExtra("c_val", c_result);
        intent.putExtra("python_val", "");
        intent.putExtra("sql_val", "");
        intent.putExtra("cpp_val", "");
        intent.putExtra("html_val", "");
        intent.putExtra("css_val", "");
        startActivity(intent);
    }
}