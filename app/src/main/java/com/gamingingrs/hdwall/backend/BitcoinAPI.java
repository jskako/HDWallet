package com.gamingingrs.hdwall.backend;

import android.util.Log;

import org.bitcoinj.crypto.ChildNumber;
import org.bitcoinj.crypto.DeterministicHierarchy;
import org.bitcoinj.crypto.DeterministicKey;
import org.bitcoinj.crypto.HDKeyDerivation;
import org.bitcoinj.crypto.HDUtils;
import org.bitcoinj.crypto.MnemonicCode;

import java.security.SecureRandom;
import java.util.List;

import static java.lang.String.join;

public class BitcoinAPI {

    private static final String BIP44PATH = "44H/0H/0H";

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
        }catch(Exception e){
            Log.e("Error","Couldn't generate mnemonic");
        }
        return words;
    }

    //Seed generator
    public byte[] seedGenerator(List<String> words){
        String passphrase = "";
        byte seed[] = MnemonicCode.toSeed(words, passphrase);
        return seed;
    }

    //Generate master key
    public DeterministicKey generateMasterKey(byte seed[]){
        DeterministicKey masterKey = HDKeyDerivation.createMasterPrivateKey(seed);
        return masterKey;
    }

    //Derive bitcoin root key
    public DeterministicKey deriveBitcoinRootKey(DeterministicKey masterKey){
        List<ChildNumber> keyPath = HDUtils.parsePath(BIP44PATH);
        DeterministicHierarchy hierarchy = new DeterministicHierarchy(masterKey);
        DeterministicKey walletKey = hierarchy.get(keyPath, false, true);
        return walletKey;
    }
}

