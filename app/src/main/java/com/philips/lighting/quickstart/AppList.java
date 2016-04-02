package com.philips.lighting.quickstart;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.philips.lighting.beans.InstalledApp;
import com.philips.lighting.data.AppListAdapter;

import java.util.ArrayList;
import java.util.List;
import android.content.pm.ApplicationInfo;
import android.widget.TextView;


public class AppList extends Activity implements AdapterView.OnItemClickListener  {
    private List<ApplicationInfo> applist;
    private ArrayList<String> appNameList = new ArrayList<String>();
    private PackageManager packageManager = null;
    private AppListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_list);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        ListView appViewList = (ListView) findViewById(R.id.appList);

        //final Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        //List<ResolveInfo> relInfo = getPackageManager().queryIntentActivities( mainIntent, 0);
        applist = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);

        listAdapter = new AppListAdapter(AppList.this, R.layout.selectbridge_item ,applist);
        //listAdapter.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.directoryEntries));
        appViewList.setOnItemClickListener(this);
        //appList.setOnItemClickListener();
    }

    //@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){

        TextView temp = (TextView)view;
        String tempStr = temp.getText().toString();

        Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
        intent.putExtra("PACKAGE_NAME", tempStr);

        startActivity(intent);


    }


}

