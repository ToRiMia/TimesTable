package com.example.timestable;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listViewNumbers;
    private SeekBar seekBar;

    private ArrayList<Integer> numbers;
    private int max = 20;
    private int min = 1;
    private int count = 10;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewNumbers = findViewById(R.id.listViewNumbers);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(max);
        seekBar.setMin(min);
        numbers = new ArrayList<>();
        final ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, numbers);
        listViewNumbers.setAdapter(arrayAdapter);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                numbers.clear();
                for (int i = min; i <= count; i++){
                    numbers.add(seekBar.getProgress() * i);
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar.setProgress(10);
    }
}