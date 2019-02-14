package com.minhaz.muhammad.pstudiary2019;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CustomDialog extends Dialog implements View.OnClickListener {

    public Activity f1c;

    public Dialog f2d;
    String dept;
    String occupation;
    String mail;
    String mobile;
    String name;
    public Button no;
    public Button yes;

    public CustomDialog(Activity activity, String name, String occupation, String mobile, String mail, String dept) {
        super(activity);
        this.f1c = activity;
        this.name = name;
        this.occupation = occupation;
        this.mobile = mobile;
        this.mail = mail;
        this.dept = dept;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        setContentView(R.layout.dialog);
        TextView occupation = findViewById(R.id.occupationD);
        TextView mobile = findViewById(R.id.phone_numberD);
        TextView mail = findViewById(R.id.emailD);
        TextView dept = findViewById(R.id.deptD);

        TextView name = findViewById(R.id.nameD);
        name.setText(this.name);
        occupation.setText(this.occupation);
        dept.setText(this.dept);
        mail.setText(this.mail);
        mobile.setText(this.mobile);

        Button message = findViewById(R.id.messageD);
        Button mailbtn = findViewById(R.id.mailD);
        Button phoneCall = findViewById(R.id.callD);
        phoneCall.setOnClickListener(this);
        message.setOnClickListener(this);
        mailbtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.callD:
                try {



                    if (ContextCompat.checkSelfPermission(this.f1c,Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
                    {
                        ActivityCompat.requestPermissions(this.f1c,new String[] {Manifest.permission.CALL_PHONE},1);
                    }
                    else
                    {

                        Intent phoneIntent = new Intent(Intent.ACTION_CALL);
                        phoneIntent.setData(Uri.parse("tel:" + this.mobile));
                        this.f1c.startActivity(phoneIntent);
                    }


                    return;
                } catch (Exception e){
                    e.printStackTrace();
                    return;
                }

            case R.id.messageD:
                try {
                    Intent sendIntent = new Intent("android.intent.action.VIEW");
                    sendIntent.setData(Uri.parse("sms:" + this.mobile));
                    this.f1c.startActivity(sendIntent);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.mailD:
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse("mailto:" + this.mail + "?subject=" + "Feedback" + "&body="));
                    this.f1c.startActivity(intent);
                    return;
                } catch (Exception e22) {
                    e22.printStackTrace();
                    return;
                }
                default:
                    return;
        }
    }
}
