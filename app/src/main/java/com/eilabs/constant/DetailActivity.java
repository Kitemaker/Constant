package com.eilabs.constant;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.util.Xml;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class DetailActivity extends ActionBarActivity {
    public final static String EXTRA_MESSAGE_DETAIL = "com.eilabs.Constant.MESSAGE";



    public List<Entry> entries;
    Entry itemClicked=null;
    InputStream inStream=null;
    XmlPullParser parser=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        entries=new ArrayList<Entry>();
        setContentView(R.layout.activity_detail);
       // final List<ConstItem> datalist = DataProvider.getData();
        readData();
        ArrayAdapter<Entry> courseArrayAdapter = new ArrayAdapter<Entry>(this, android.R.layout.simple_expandable_list_item_1, entries);
        final ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(courseArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Entry constitem = entries.get(position);
                itemClicked = (Entry) listView.getItemAtPosition(position);
                Toast.makeText(getBaseContext(), itemClicked.getName(), Toast.LENGTH_SHORT).show();

                showConstantDetails(itemClicked.getID() + ";" + itemClicked.getName() + ";" + itemClicked.getValue());
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private  void showConstantDetails(String itemDetails)
    {
        Intent intent =new Intent(this,ConstDetailActivity.class);
        intent.putExtra(EXTRA_MESSAGE_DETAIL, itemDetails);
        startActivity(intent);
    }

    private  void readData()
    {
        AssetManager amr=getAssets();
        try {
            inStream = amr.open("constants.xml");
            ConsSaxParser parser=new ConsSaxParser();
            parser.ReadData(inStream,entries);
        } catch (IOException e) {
            Log.e("tag", e.getMessage());
        }

    }
    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

}
