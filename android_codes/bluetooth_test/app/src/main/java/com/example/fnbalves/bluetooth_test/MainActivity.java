package com.example.fnbalves.bluetooth_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnConnect;
    Button btnSend;

    static BluetoothController myController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (myController == null) {
            myController = new BluetoothController(this);
        }

        btnConnect = (Button)findViewById(R.id.btn_connect);
        btnSend = (Button)findViewById(R.id.btn_send);

        btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> pairedDevices = myController.getPairedDevices();

                for(String deviceInfo : pairedDevices){
                    if(deviceInfo.contains("Amarino")){
                        String[] splittedInfo = deviceInfo.split("_");
                        String address = splittedInfo[1];
                        myController.connect(address);
                    }
                }
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myController.send("ABCD");
            }
        });
    }
}
