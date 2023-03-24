package com.example.calculatorforprogrammer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AboutAppActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button checkNewButton = (Button)findViewById(R.id.check_view_button);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);
        TextView versionName = (TextView)findViewById(R.id.versionNameTextView);
        TextView appName = (TextView)findViewById(R.id.appNameTextView);
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.about_developer_title_bacground);
        linearLayout.setBackgroundColor(getResources().getColor(R.color.blue_bright));
        try {
            versionName.setText("V " + getVersionName());
        }catch (Exception e){
        }
        appName.setText(getResources().getString(R.string.app_name));

    }

    private String getVersionName() throws Exception
    {
        PackageManager packageManager = getPackageManager();
        PackageInfo packInfo = packageManager.getPackageInfo(getPackageName(),0);
        String version = packInfo.versionName;
        return version;
    }

    public void onClickCheckNewButton(View view){
        //Toast toast = new Toast(this);
        Toast.makeText(this,getResources().getString(R.string.checking_new),Toast.LENGTH_SHORT).show();
    }
}
