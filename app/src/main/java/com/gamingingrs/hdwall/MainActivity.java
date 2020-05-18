package com.gamingingrs.hdwall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.gamingingrs.hdwall.backend.AutomateBoringStuff;
import com.gamingingrs.hdwall.backend.BitcoinAPI;

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
        BitcoinAPI bc = new BitcoinAPI();
        byte[] entropy = bc.entropyGenerator();
        List<String> words = bc.mnemonicGenerator(entropy);
        AutomateBoringStuff abs = new AutomateBoringStuff();
        String myWords = abs.convertListToString(words, " ");
        textView.setText(myWords);
    }
}
