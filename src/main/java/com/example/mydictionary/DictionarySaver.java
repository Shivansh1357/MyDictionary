package com.example.mydictionary;

import java.io.*;
import java.util.HashMap;

public class DictionarySaver {
    private HashMap<String,String> dictionaryList;
    DictionarySaver(){
        dictionaryList=new HashMap<>();
    }
    HashMap<String,String> getDictionaryList(){
        return dictionaryList;
    }
    void serialize() throws IOException {
        FileOutputStream fos=new FileOutputStream("dictionaryData");
        ObjectOutputStream oos=new ObjectOutputStream(fos);

        oos.writeObject(dictionaryList);
        oos.close();
        fos.close();
    }
    void deserialize() throws IOException, ClassNotFoundException {
        FileInputStream file=new FileInputStream("dictionaryData");
        ObjectInputStream ois=new ObjectInputStream(file);
        dictionaryList=(HashMap<String, String>) ois.readObject();
    }
}
