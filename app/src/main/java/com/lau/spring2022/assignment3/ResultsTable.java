package com.lau.spring2022.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class ResultsTable extends AppCompatActivity {

    TextView java_result;
    TextView javascript_result;
    TextView c_result;
    TextView python_result;
    TextView sql_result;
    TextView cpp_result;
    TextView html_result;
    TextView css_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_results_table);

        java_result = (TextView) findViewById(R.id.java_text);
        javascript_result = (TextView) findViewById(R.id.javascript_text);
        c_result = (TextView) findViewById(R.id.c_text);
        python_result = (TextView) findViewById(R.id.python_text);
        sql_result = (TextView) findViewById(R.id.sql_text);
        cpp_result = (TextView) findViewById(R.id.cpp_text);
        html_result = (TextView) findViewById(R.id.html_text);
        css_result = (TextView) findViewById(R.id.css_text);

        Intent intent = getIntent();

        String java_value = intent.getStringExtra("java_val");
        java_result.setText(java_value);

        String javascript_value = intent.getStringExtra("javascript_val");
        javascript_result.setText(javascript_value);

        String c_value = intent.getStringExtra("c_val");
        c_result.setText(c_value);

        String python_value = intent.getStringExtra("python_val");
        python_result.setText(python_value);

        String sql_value = intent.getStringExtra("sql_val");
        sql_result.setText(sql_value);

        String cpp_value = intent.getStringExtra("cpp_val");
        cpp_result.setText(cpp_value);

        String html_value = intent.getStringExtra("html_val");
        html_result.setText(html_value);

        String css_value = intent.getStringExtra("css_val");
        css_result.setText(css_value);

    }
}