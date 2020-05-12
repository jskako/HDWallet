package com.example.hdwall.backend;

import org.bitcoinj.crypto.MnemonicCode;

import java.security.SecureRandom;
import java.util.List;

import static java.lang.String.join;

public class Bitcoin {

    public void bitcoin(){

    }

    //Entropy of 128Bits
    public byte[] entropyGenerator(){
        int entropyLen = 16;
        byte[] entropy = new byte[entropyLen];
        SecureRandom random = new SecureRandom();
        random.nextBytes(entropy);
        return entropy;
    }

    //Mnemonoic generator
    public List<String> mnemonicGenerator(byte[] entropy){
        List<String> words = null;
        try{
            words = MnemonicCode.INSTANCE.toMnemonic(entropy);
            String mnemonic = join(" ", words);
        }catch(Exception e){
            e.printStackTrace();
        }
        return words;
    }

}

