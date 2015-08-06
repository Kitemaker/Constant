package com.eilabs.constant;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class ElementDetailActivity extends ActionBarActivity {
    protected String itemDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element_detail);
        Intent intent = getIntent();
        itemDetails = intent.getStringExtra(DetailActivity.EXTRA_MESSAGE_DETAIL);
        setElementDetails(itemDetails);
    }


    private void setElementDetails(String itemDetails)
    {
        TextView telement = (TextView)findViewById(R.id.textElement);
        TextView tAtomicNr = (TextView)findViewById(R.id.textAtomicNr);
        TextView tAtomicWt = (TextView)findViewById(R.id.textAtomicWt);
        TextView tPeriod = (TextView)findViewById(R.id.textPeriod);
        TextView tMeltingPoint = (TextView)findViewById(R.id.textMeltingPoint);
        TextView tBoilingPoint = (TextView)findViewById(R.id.textBoilingPoint);
        TextView tSpecificHeat = (TextView)findViewById(R.id.textSpecificHeat);
        TextView tOriginOfName = (TextView)findViewById(R.id.textOriginOfName);



        String[] itemData=itemDetails.split(";");
        if(itemData.length>3)
        {
            Log.d("READ_HTML", itemData[1] + itemData[2] + itemData[3]);
            tAtomicNr.setText(Html.fromHtml(itemData[1]));
            telement.setText(Html.fromHtml(itemData[2]) + "\t" + itemData[3]);
            tOriginOfName.setText(Html.fromHtml(itemData[4]));
            tPeriod.setText(Html.fromHtml(itemData[5]));
            tAtomicWt.setText(Html.fromHtml(itemData[6]));
            tMeltingPoint.setText(Html.fromHtml(itemData[7]));
            tBoilingPoint.setText(Html.fromHtml(itemData[8]));
            tSpecificHeat.setText(Html.fromHtml(itemData[9]));


        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_element_detail, menu);
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
                getIntent().putExtra("ElementDetailActivity",getString(R.string.action_periodicTable));
                setResult(RESULT_OK,getIntent());
                finish();
                return true;

        }
        return super.onOptionsItemSelected(item);

    }

    public void onShareClick(MenuItem item) {
        Intent i=new Intent(android.content.Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(android.content.Intent.EXTRA_SUBJECT,"Subject test");
        i.putExtra(android.content.Intent.EXTRA_TEXT, itemDetails);
        startActivity(Intent.createChooser(i,"Share via"));
    }
}
