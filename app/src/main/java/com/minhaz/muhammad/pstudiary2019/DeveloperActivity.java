package com.minhaz.muhammad.pstudiary2019;

import android.Manifest;
import android.animation.Animator;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

public class DeveloperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);

        ShimmerTextView textView = findViewById(R.id.text);
        ShimmerTextView textView1 = findViewById(R.id.text1);
        ShimmerTextView textView2 = findViewById(R.id.text2);
        ShimmerTextView textView3 = findViewById(R.id.text3);
        Shimmer shimmer = new Shimmer();

        shimmer.start(textView);
        shimmer.start(textView1);
        shimmer.start(textView2);
        shimmer.start(textView3);


        shimmer.setRepeatCount(50)
                .setDuration(1200)
                .setStartDelay(300)
                .setDirection(Shimmer.ANIMATION_DIRECTION_RTL).setAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
/*
        ImageButton callSir = findViewById(R.id.call_dev);
        ImageButton msgSir = findViewById(R.id.message_dev);
        ImageButton mailSir = findViewById(R.id.email_dev);
        ImageButton callGian = findViewById(R.id.call_gian);
        ImageButton msgGian = findViewById(R.id.msg_gian);
        ImageButton mailGian = findViewById(R.id.mail_gian);
        ImageButton callMinhaz = findViewById(R.id.call_minhaz);
        ImageButton msgMinhaz = findViewById(R.id.msg_minhaz);
        ImageButton mailMinhaz = findViewById(R.id.mail_minhaz);


        callSir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel:01556449873"));
                if (ContextCompat.checkSelfPermission(DeveloperActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(DeveloperActivity.this, new String[]{Manifest.permission.CALL_PHONE},1);
                }
                else
                {
                    startActivity(call);
                }
            }
        });

        msgSir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sendIntent = new Intent("android.intent.action.VIEW");
                sendIntent.setData(Uri.parse("sms:01556449873"));
                startActivity(sendIntent);
            }
        });

        mailSir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("mailto:mahabub.cse.pstu@gmail.com" + "?subject=" + "Feedback" + "&body="));
                startActivity(intent);
            }
        });

        callGian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel:01764814448"));
                if (ContextCompat.checkSelfPermission(DeveloperActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(DeveloperActivity.this, new String[]{Manifest.permission.CALL_PHONE},1);
                }
                else
                {
                    startActivity(call);
                }
            }
        });

        msgGian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sendIntent = new Intent("android.intent.action.VIEW");
                sendIntent.setData(Uri.parse("sms:01764814448"));
                startActivity(sendIntent);
            }
        });

        mailGian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("mailto:zulfikaralizehan@gmail.com" + "?subject=" + "Feedback" + "&body="));
                startActivity(intent);
            }
        });

        callMinhaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel:01757551132"));
                if (ContextCompat.checkSelfPermission(DeveloperActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(DeveloperActivity.this, new String[]{Manifest.permission.CALL_PHONE},1);
                }
                else
                {
                    startActivity(call);
                }
            }
        });

        msgMinhaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sendIntent = new Intent("android.intent.action.VIEW");
                sendIntent.setData(Uri.parse("sms:01757551132"));
                startActivity(sendIntent);
            }
        });

        mailMinhaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("mailto:mminhazurrahman0@gmail.com" + "?subject=" + "Feedback" + "&body="));
                startActivity(intent);
            }
        });


        }
*/
    }
}

