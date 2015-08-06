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
    public List<Element> elements;

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

    public List<Element> ReadElementData(InputStream inputStream, List<Element> elementsList) throws java.io.IOException {
        BufferedReader reader = null;
        try {
            elements = elementsList;
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            Integer location=0;
            while ((line = reader.readLine()) != null) {
                Log.e("ReadElementData", line);
                String[] list  = line.split(";");
                if(list.length>8) {
                    elementsList.add(location, new Element(list[0], list[1]));
                    elementsList.get(location).setSymbol(list[2]);
                    elementsList.get(location).setElement(list[3]);
                    elementsList.get(location).setOriginofName(list[4]);
                    elementsList.get(location).setPeriod(list[5]);
                    elementsList.get(location).setAtomicWeight(list[6]);
                    elementsList.get(location).setMeltingPoint(list[7]);
                    elementsList.get(location).setBoilingPoint(list[8]);
                    elementsList.get(location).setSpecificHeat(list[9]);

                }
                location=location+1;
            }
        }
        catch (java.io.IOException x)
        {
            Log.e("ReadTextData", x.getMessage());
        }

        return elementsList;
    }
}


