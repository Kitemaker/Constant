package com.eilabs.constant;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.List;


public class DetailActivity extends ActionBarActivity {
    public final static String EXTRA_MESSAGE_DETAIL = "com.eilabs.Constant.MESSAGE";
    public static final int ELEMENT_REQUEST_CODE = 101;
    public static final int PHYSICS_REQUEST_CODE = 100;
    public static final int MATHS_REQUEST_CODE = 102;



    public List<Entry> entries;
    public List<com.eilabs.constant.Element> elementList;
    Entry itemClicked = null;
    Element elementClicked;
    InputStream inStream = null;
    XmlPullParser parser = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = this.getIntent();
        String msg = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        BuildListItems(msg);

    }

    private void BuildListItems(String message) {
        try {
            entries = new ArrayList<Entry>();
            elementList = new ArrayList<Element>();
            readData();
            if (message.equals(getString(R.string.action_periodicTable))) {
                this.setTitle(getString(R.string.action_periodicTable));
                ArrayAdapter<Element> courseArrayAdapter = new ArrayAdapter<Element>(this, android.R.layout.simple_expandable_list_item_1, elementList);
                final ListView listView = (ListView) findViewById(android.R.id.list);
                listView.setAdapter(courseArrayAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //Entry constitem = entries.get(position);
                        elementClicked = (Element) listView.getItemAtPosition(position);
                        //Toast.makeText(getBaseContext(), elementClicked.getElement(), Toast.LENGTH_SHORT).show();
                        showElementDetails(getElemnentData(elementClicked));

                    }
                });
            } else {
                this.setTitle(getString(R.string.label_constants));
                ArrayAdapter<Entry> courseArrayAdapter = new ArrayAdapter<Entry>(this, android.R.layout.simple_expandable_list_item_1, entries);
                final ListView listView = (ListView) findViewById(android.R.id.list);
                listView.setAdapter(courseArrayAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //Entry constitem = entries.get(position);
                        itemClicked = (Entry) listView.getItemAtPosition(position);
                        //Toast.makeText(getBaseContext(), itemClicked.getName(), Toast.LENGTH_SHORT).show();

                        showConstantDetails(itemClicked.getID() + ";" + itemClicked.getName() + ";" + itemClicked.getValue() + ";" + itemClicked.getUnit());
                    }
                });
            }
        } catch (Exception e) {
            Log.e("DetailActivity", "onCreate");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == ELEMENT_REQUEST_CODE) {
            BuildListItems(getString(R.string.action_periodicTable));
        } else
        {
            BuildListItems(getString(R.string.action_physics));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_detail, menu);

        //search action code
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_detail,menu);
       // SearchManager searchManager=(SearchManager)getSystemService(Context.SEARCH_SERVICE);
      //  SearchView searchView=(SearchView)menu.findItem(R.id.search).getActionView();
      //  searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    private void showConstantDetails(String itemDetails) {
        Intent intent = new Intent(this, ConstItemActivity.class);
        intent.putExtra(EXTRA_MESSAGE_DETAIL, itemDetails);
        startActivityForResult(intent, PHYSICS_REQUEST_CODE);
    }

    private void showElementDetails(String elementDetails) {
        Intent intent = new Intent(this, ElementDetailActivity.class);
        intent.putExtra(EXTRA_MESSAGE_DETAIL, elementDetails);
        startActivityForResult(intent, ELEMENT_REQUEST_CODE);

    }

    private void readData() throws java.io.IOException {
        AssetManager amr = getAssets();
        try {
            Intent intent = this.getIntent();
            String msg = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
            ConsSaxParser parser = new ConsSaxParser();
            if (msg.equals(R.string.action_physics)) {
                inStream = amr.open("Constants.txt");
                parser.ReadTextData(inStream, entries);
            } else if (msg.equals(getString(R.string.action_maths))) {
                inStream = amr.open("ConstantsMaths.txt");
                parser.ReadTextData(inStream, entries);
            } else if (msg.equals(getString(R.string.action_periodicTable))) {
                inStream = amr.open("PeriodicTable.txt");
                parser.ReadElementData(inStream, elementList);
            } else {
                inStream = amr.open("Constants.txt");
                parser.ReadTextData(inStream, entries);
            }

        } catch (IOException e) {
            Log.e("tag", e.getMessage());
        }

    }

    private String getElemnentData(Element element) {
        String elData = element.getID() + ";" + //0
                element.getAtomicNumer() + ";" +//1
                element.getSymbol() + ";" + //2
                element.getElement() + ";" +//3
                element.getOriginofName() + ";" + //4
                element.getPeriod() + ";" + //5
                element.getAtomicWeight() + ";" +//6
                element.getMeltingPoint() + ";" +//7
                element.getBoilingPoint() + ";" + //8
                element.getSpecificHeat();//9

        return elData;
    }


    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

}
