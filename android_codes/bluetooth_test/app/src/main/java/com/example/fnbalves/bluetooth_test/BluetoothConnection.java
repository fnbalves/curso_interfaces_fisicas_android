package com.example.fnbalves.bluetooth_test;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.util.UUID;

public class BluetoothConnection extends AsyncTask<Void, Void, Void> {

    BluetoothController myController;
    String addressToConnect;
    boolean connectionSuccess;

    static final UUID serialUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    BluetoothConnection(BluetoothController controller, String address){
        this.myController = controller;
        this.addressToConnect = address;
    }

    @Override
    protected Void doInBackground(Void... devices) {
        try {
            if (this.myController.getSocket() == null) {
                Log.d("BLE", this.addressToConnect);

                BluetoothDevice remoteDev = this.myController.getAdapter().getRemoteDevice(addressToConnect);
                BluetoothSocket btSocket = remoteDev.createInsecureRfcommSocketToServiceRecord(serialUUID);
                btSocket.connect();
                this.myController.setSocket(btSocket);
            }

            this.connectionSuccess = true;
        }catch(Exception ex){
            Log.d("BLE", ex.getMessage());
            this.connectionSuccess = false;
        }

        return null;
    }

    @Override
    protected void onPreExecute(){
        Toast.makeText(this.myController.getParent().getApplicationContext(),
                "Conectando ao Bluetooth",
                Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPostExecute(Void result){
        if(this.connectionSuccess){
            Toast.makeText(this.myController.getParent().getApplicationContext(),
                    "Conexao feita com sucesso",
                    Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this.myController.getParent().getApplicationContext(),
                    "Conexao falhou",
                    Toast.LENGTH_LONG).show();
        }
    }

}
