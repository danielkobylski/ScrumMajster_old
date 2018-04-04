package com.ciastkaipiwo.android.scrummajster;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;

public class BacklogActivity extends AppCompatActivity {

    //private static final String BACKLOG = "com.ciastkaipiwo.android.scrummajster.backlog";
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backlog);
        Button add = (Button) findViewById(R.id.add_task);

        ListView listView = (ListView) findViewById(R.id.listview);
        final String[] items={"It's working!"};
        arrayList = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<String>(BacklogActivity.this, R.layout.list_items, R.id.txtitem, arrayList);
        listView.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(BacklogActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_box, null);
                final EditText Input = (EditText) mView.findViewById((R.id.input));
                Button OK = (Button) mView.findViewById((R.id.OK));
                Button Cancel = (Button) mView.findViewById((R.id.cancel));
                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                OK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String newBacklog = Input.getText().toString();
                        arrayList.add(newBacklog);
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }

                });

                Cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View w) {
                        dialog.dismiss();
                    }

                });
            }
        });

    }

}
