package com.clarkson.clarksworld.andelatestview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout btcLayout, ethLayout;

    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btcLayout = (LinearLayout)findViewById(R.id.btc);
        ethLayout = (LinearLayout) findViewById(R.id.eth);

        btcLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, BtcCoinActivity.class);
                startActivity(intent);
            }
        });

        ethLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, EthCoinActivity.class);
                startActivity(intent);
            }
        });



    }
}
