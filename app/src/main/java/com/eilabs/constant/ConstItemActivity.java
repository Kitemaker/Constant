package com.eilabs.constant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class ConstItemActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_const_item);
        Intent intent = getIntent();
        String itemDetails = intent.getStringExtra(DetailActivity.EXTRA_MESSAGE_DETAIL);
        setItemDetails(itemDetails);
    }

    private void setItemDetails(String itemDetails)
    {
        TextView tview1 = (TextView)findViewById(R.id.textViewName);
        TextView tview2 = (TextView)findViewById(R.id.textViewValue);
        TextView tview3 = (TextView)findViewById(R.id.textViewUnit);
        String[] itemData=itemDetails.split(";");
        if(itemData.length>3)
        {Log.d("READ_HTML",itemData[1]+itemData[2]+itemData[3]);
        tview1.setText(Html.fromHtml(itemData[1]));
        tview2.setText(Html.fromHtml(itemData[2]));
        tview3.setText(Html.fromHtml(itemData[3]));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_const_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                getIntent().putExtra("ConstItemActivity",getString(R.string.action_physics));
                setResult(RESULT_OK,getIntent());
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
