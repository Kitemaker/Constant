package com.eilabs.constant;
import android.util.Log;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.SAXException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Farheena on 27-07-2015.
 */
public class ConsSaxParser {
    public Entry entry;
    public List<Entry> entryLocal;

    public void ConsSaxParser() {

    }

    public List<Entry> ReadData(InputStream inputStream, List<Entry> entries) {

        try {
            entryLocal = entries;
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {

                boolean bfname = false;
                boolean blname = false;
                boolean bnname = false;
                boolean bsalary = false;

                public void startElement(String uri, String localName, String qName,
                                         Attributes attributes) throws SAXException {

                    System.out.println("ReadData:Start Element :" + qName);

                    if (qName.equalsIgnoreCase("constant")) {
                        bfname = true;
                        entry = new Entry(attributes.getValue("id"), attributes.getValue("name"), "","");
                        entryLocal.add(entry);
                    }

                }

                public void endElement(String uri, String localName,
                                       String qName) throws SAXException {

                    System.out.println("ReadData :endElement:" + qName);

                }

                public void characters(char ch[], int start, int length) throws SAXException {

                    if (bfname) {
                        System.out.println("ReadData :characters " + new String(ch, start, length));
                        entry.setValue(new String(ch, start, length));
                        bfname = false;
                    }
                }

            };
            parser.parse(inputStream, handler);

        } catch (SAXException e) {
            e.fillInStackTrace();
        } finally {
            return entries;
        }
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


