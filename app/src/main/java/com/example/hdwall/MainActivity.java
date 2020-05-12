package com.example.hdwall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.hdwall.backend.Bitcoin;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test();
    }

    private void test(){
        final TextView textView = this.findViewById(R.id.test);
        Bitcoin bitcoin = new Bitcoin();
        byte[] entropy = bitcoin.entropyGenerator();
        List<String> words = bitcoin.mnemonicGenerator(entropy);

        StringBuilder builder = new StringBuilder();
        for (String details : words) {
            //Log.e("Details: ",details);
            builder.append(details +  " ");
        }
        textView.setText(builder.toString());
    }
}
