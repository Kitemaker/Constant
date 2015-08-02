package com.eilabs.constant;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Farheena on 27-07-2015.
 */
public class ConsSaxParser {
    public Entry entry;
    public List<Entry> entryLocal;

    public void ConsSaxParser() {

    }

    public List<Entry> ReadTextData(InputStream inputStream, List<Entry> entries) throws java.io.IOException {
        BufferedReader reader = null;
        try {
            entryLocal = entries;
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line = null;
            while ((line = reader.readLine()) != null) {
                Log.e("ReadTextData", line);
             String[] list  = line.split(";");
                if(list.length>3) {
                    entries.add(new Entry(list[0].trim(), list[1].trim(), list[2].trim(),list[3]));
                }

            }
        }
        catch (java.io.IOException x)
        {
            Log.e("ReadTextData", x.getMessage());
        }

        return entries;
    }
}


