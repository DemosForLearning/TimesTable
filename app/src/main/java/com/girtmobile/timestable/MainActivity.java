package com.girtmobile.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesList;

    public void generateTimesTable(int timesTable) {
        ArrayList<String> timesArray = new ArrayList<String>();

        for (int i=1; i<=10; i++) {
            timesArray.add(Integer.toString(i* timesTable));
        }

        ArrayAdapter<String> timesAdpt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesArray);
        timesList.setAdapter(timesAdpt);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesCtrl = (SeekBar) findViewById(R.id.timesSeek);
        timesList = (ListView) findViewById(R.id.listView);

        timesCtrl.setMax(12);
        timesCtrl.setProgress(6);

        timesCtrl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTable;

                if (progress < min) {
                    timesTable = min;
                    timesCtrl.setProgress(min);
                } else {
                    timesTable = progress;
                }

                generateTimesTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generateTimesTable(6);
    }
}
