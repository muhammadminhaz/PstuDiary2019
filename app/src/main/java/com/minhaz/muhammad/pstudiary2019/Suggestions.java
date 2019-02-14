package com.minhaz.muhammad.pstudiary2019;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Suggestions extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_developer,container,false);
        final EditText msgbox = rootView.findViewById(R.id.suggestionText);
        ImageButton button = rootView.findViewById(R.id.sendButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = msgbox.getText().toString();
                if(((ConnectivityManager)Suggestions.this.getActivity().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo()!=null){

                    String action;
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse("mailto:mahbub.cse@pstu.ac.bd?subject=Feedback&body="+message));
                    startActivity(intent);
                    msgbox.setText("");
                    return;
                }

                Toast.makeText(getActivity(), "আপনার ইন্টারনেট কানেকশন বন্ধ। সাজেশনটি মেইলের মাধ্যমে যাবে তাই আগে ইন্টারনেট চালু করে নিন",
                        Toast.LENGTH_LONG).show();
            }
        });

        return rootView;
    }
}
