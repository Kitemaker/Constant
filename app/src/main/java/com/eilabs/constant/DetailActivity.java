package com.eilabs.constant;

import android.app.LauncherActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class DetailActivity extends ActionBarActivity {
    public final static String EXTRA_MESSAGE_DETAIL = "com.eilabs.Constant.MESSAGE";
    ConstItem itemClicked=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        final List<ConstItem> datalist = DataProvider.getData();
        ArrayAdapter<ConstItem> courseArrayAdapter = new ArrayAdapter<ConstItem>(this, android.R.layout.simple_expandable_list_item_1, datalist);
        final ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(courseArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ConstItem constitem = datalist.get(position);
                 itemClicked = (ConstItem)listView.getItemAtPosition(position);
                Toast.makeText(getBaseContext(),itemClicked.getName(),Toast.LENGTH_SHORT).show();
                showConstantDetails();
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

    private  void showConstantDetails()
    {
        Intent intent =new Intent(this,ConstDetailActivity.class);
        TextView edittext=(TextView)findViewById(R.id.consText);
        String message = getString(itemClicked.getConstItemID()+ itemClicked.getConstItemID() );
        intent.putExtra(EXTRA_MESSAGE_DETAIL, message);
        startActivity(intent);

    }
}
