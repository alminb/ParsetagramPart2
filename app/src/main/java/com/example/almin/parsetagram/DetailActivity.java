package com.example.almin.parsetagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

public class DetailActivity extends AppCompatActivity {

    TextView tvDesc;
    TextView tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTime=findViewById(R.id.tvTime);
        tvDesc=findViewById(R.id.tvDesc);

        String desc = getIntent().getStringExtra("description");
        tvDesc.setText(desc);
        String time = getIntent().getStringExtra("time");
        tvTime.setText("Posted "+time+" ago");
    }
}