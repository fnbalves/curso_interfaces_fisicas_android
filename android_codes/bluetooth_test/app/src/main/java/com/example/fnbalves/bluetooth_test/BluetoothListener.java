package com.example.fnbalves.bluetooth_test;

import android.widget.Toast;

import java.io.InputStream;

public class BluetoothListener extends Thread {
    BluetoothController myController;
    boolean isRunning = false;
    InputStream bluetoothIn;

    BluetoothListener(BluetoothController controller){
        this.myController = controller;

        try {
            this.bluetoothIn = this.myController.getSocket().getInputStream();
            this.isRunning = true;

        }catch(Exception ex){
            Toast.makeText(this.myController.getParent().getApplicationContext(),
                    "Problemas ao ler o socket",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void run(){
        byte[] buffer = new byte[256];
        int bytesRead = 0;

        while(this.isRunning){
            try {
                int bytesAvailable = this.bluetoothIn.available();

                if(bytesAvailable > 0){
                    bytesRead = this.bluetoothIn.read(buffer, 0, bytesAvailable);
                    String readText = new String(buffer);

                    this.myController.getParent().runOnUiThread(
                            new actionToDo(this.myController,readText));
                }
            }catch(Exception ex){

            }
        }
    }

    public void stopThread(){
        this.isRunning = false;
    }

    class actionToDo implements Runnable{
        BluetoothController myController;
        String received;

        actionToDo(BluetoothController controller, String received){
            this.myController = controller;
            this.received = received;
        }
        public void run(){
            Toast.makeText(this.myController.getParent().getApplicationContext(),
                    "Recebi: " + received,
                    Toast.LENGTH_LONG).show();
        }
    }

}
