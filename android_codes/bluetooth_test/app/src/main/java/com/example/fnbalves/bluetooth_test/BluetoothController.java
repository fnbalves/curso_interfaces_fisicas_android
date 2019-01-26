package com.example.fnbalves.bluetooth_test;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class BluetoothController {
    Activity parent;
    BluetoothAdapter myAdapter;
    BluetoothSocket mySocket;

    public void setSocket(BluetoothSocket socket){
        this.mySocket = socket;
    }

    public BluetoothSocket getSocket(){
        return this.mySocket;
    }

    public void connect(String address){
        BluetoothConnection myConnection = new BluetoothConnection(this, address);
        myConnection.execute();
    }

    public void send(String s){
        try{
            this.mySocket.getOutputStream().write(s.getBytes());
        }catch(Exception ex){
            Toast.makeText(this.parent.getApplicationContext(),
                    "Problemas no envio",
                    Toast.LENGTH_LONG).show();
        }
    }

    BluetoothController(Activity parent){
        this.parent = parent;

        myAdapter = BluetoothAdapter.getDefaultAdapter();

        if(myAdapter == null){
            Toast.makeText(this.parent.getApplicationContext(),
                    "Não tem Bluetooth",
                    Toast.LENGTH_LONG).show();
        }else if(!myAdapter.isEnabled()){
            Intent bluetoothPerm = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            this.parent.startActivityForResult(bluetoothPerm, 1);
        }
    }

    public ArrayList<String> getPairedDevices(){
        ArrayList<String> pairedDevices = new ArrayList<String>();

        Set pairedObj = this.myAdapter.getBondedDevices();

        for (Object obj: pairedObj){
            BluetoothDevice bd = (BluetoothDevice)obj;

            String newInfo = bd.getName() + "_" + bd.getAddress();
            pairedDevices.add(newInfo);
            Log.d("BLE", newInfo);
        }

        return pairedDevices;
    }
    public Activity getParent(){
        return this.parent;
    }

    public BluetoothAdapter getAdapter(){
        return this.myAdapter;
    }
}
