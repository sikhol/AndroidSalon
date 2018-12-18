package com.kreasikode.muslimahsalon.view;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v4.print.PrintHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kreasikode.muslimahsalon.R;
import com.kreasikode.muslimahsalon.printer.PrinterCommands;
import com.kreasikode.muslimahsalon.printer.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class PrintActivity extends AppCompatActivity {

    TextView txtBiaya;
    TextView tvBiaya;
    TextView txtDiskon;
    EditText etDiskon;
    TextView txtTotalBiaya;
    TextView tvTotalBiaya;
    TextView txtBayar;
    EditText etBayar;
    TextView txtKembalian;
    TextView tvKembalian;
    TextView status;
    Button btnPrint;
    Button btnBluetooth;

    // android built in classes for bluetooth operations
    BluetoothAdapter bluetoothAdapter;
    BluetoothSocket bluetoothSocket;
    BluetoothDevice bluetoothDevice;

    // needed for communication to bluetooth device / network
    OutputStream outputStream;
    InputStream inputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);

        txtBiaya = findViewById(R.id.txt_biaya);
        tvBiaya = findViewById(R.id.tv_biaya);
        txtDiskon = findViewById(R.id.txt_diskon);
        etDiskon = findViewById(R.id.et_diskon);
        txtTotalBiaya = findViewById(R.id.txt_total_biaya);
        tvTotalBiaya = findViewById(R.id.tv_total_biaya);
        txtBayar = findViewById(R.id.txt_bayar);
        etBayar = findViewById(R.id.et_bayar);
        txtKembalian = findViewById(R.id.txt_kembalian);
        tvKembalian = findViewById(R.id.tv_kembalian);
        status = findViewById(R.id.label);
        btnPrint = findViewById(R.id.btnPrint);
        btnBluetooth = findViewById(R.id.btn_hubungkan_printer);

        btnBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    findBT();
                    hubungkanBT();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    printBill();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    void findBT(){
        try {
            bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            if (!bluetoothAdapter.isEnabled()){
                Intent enableBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBluetooth, 0);
            }

            Set<BluetoothDevice> perangkatTerpasang = bluetoothAdapter.getBondedDevices();

            if (perangkatTerpasang.size() > 0 ){
                for (BluetoothDevice device : perangkatTerpasang){
                    if (device.getName().equals("BlueTooth Printer")){
                        bluetoothDevice = device;
                        break;
                    }
                }
            }
            status.setText("Bluetooth Dihidupkan");

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    void hubungkanBT() throws IOException{
        try {
            UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
            bluetoothSocket = bluetoothDevice.createRfcommSocketToServiceRecord(uuid);
            bluetoothSocket.connect();
            outputStream = bluetoothSocket.getOutputStream();
            inputStream = bluetoothSocket.getInputStream();
            status.setText("Bluetooth Terhubung");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    void sendData() throws IOException {
        try {
            // the text typed by the user
            String msg;
            //myTextbox.getText().toString();
            msg = "         Muslimah Salon\n" +
                    "     Jl. Garuda 78a, Manukan\n" +
                    "    Condong Catur, Yogyakarta\n" +
                    "       Telp. 0274-4983758\n";
            msg = msg+
                    "--------------------------------\n";
            msg = msg + String.format("%1$-10s %2$10s %3$9s", "Layanan", "Qty", "Total");
            msg = msg + "\n";
            msg = msg+
                    "--------------------------------";
            msg = msg + "\n" + String.format("%1$-10s %2$9s %3$11s", "Potong", "1", "50.000");
            msg = msg + "\n" + String.format("%1$-10s %2$9s %3$11s", "Creambath", "1", "50.000");
            msg = msg + "\n" + String.format("%1$-10s %2$9s %3$11s", "Facial", "1", "50.000");
            msg = msg + "\n" + String.format("%1$-10s %2$9s %3$11s", "Pedicure", "1", "50.000");

            msg = msg +
                    "\n--------------------------------";
            msg = msg + "\n" + String.format("%1$-10s %2$9s %3$11s", "Biaya", ":", "200.000");
            msg = msg + "\n" + String.format("%1$-10s %2$9s %3$11s", "Diskon", ":", "20.000");
            msg = msg + "\n" + String.format("%1$-10s %2$8s %3$11s", "Total Biaya", ":", "180.000");
            msg = msg +
                    "\n--------------------------------";
            msg = msg + "\n" + String.format("%1$-10s %2$9s %3$11s", "Bayar", ":", "200.000");
            msg = msg + "\n" + String.format("%1$-10s %2$9s %3$11s", "Kembali", ":", "20.000");
            msg = msg + "\n\n\n";

            outputStream.write(msg.getBytes());

            // tell the user data were sent
            status.setText("Status : Print Sukses");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void printBill() throws IOException {
        try {


        //print command
        printPhoto(R.drawable.salon);
        printCustom("Muslimah Salon", 2, 1);
        printCustom("Jl. Garuda 78a, Manukan, Condong Catur", 0, 1);
        printCustom("Sleman - Yogyakarta", 0, 1);
        printCustom("Telp. 0274-4983758", 0, 1);
        String dateTime[] = getDateTime();
        printText(leftRightAlign(dateTime[0], dateTime[1]));
        printNewLine();
        printNewLine();
        printNewLine();
//                printText(leftRightAlign("Qty: Name" , "Price "));
//                printCustom(new String(new char[32]).replace("\0", "."),0,1);
//                printText(leftRightAlign("Total" , "2,0000/="));
//                printNewLine();
//                printCustom("Thank you for coming & we look",0,1);
//                printCustom("forward to serve you again",0,1);
//                printNewLine();
//                printNewLine();
    }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    //print custom
    private void printCustom(String msg, int size, int align) {
        //Print config "mode"
        byte[] cc = new byte[]{0x1B,0x21,0x03};  // 0- normal size text
        //byte[] cc1 = new byte[]{0x1B,0x21,0x00};  // 0- normal size text
        byte[] bb = new byte[]{0x1B,0x21,0x08};  // 1- only bold text
        byte[] bb2 = new byte[]{0x1B,0x21,0x20}; // 2- bold with medium text
        byte[] bb3 = new byte[]{0x1B,0x21,0x10}; // 3- bold with large text
        try {
            switch (size){
                case 0:
                    outputStream.write(cc);
                    break;
                case 1:
                    outputStream.write(bb);
                    break;
                case 2:
                    outputStream.write(bb2);
                    break;
                case 3:
                    outputStream.write(bb3);
                    break;
            }

            switch (align){
                case 0:
                    //left align
                    outputStream.write(PrinterCommands.ESC_ALIGN_LEFT);
                    break;
                case 1:
                    //center align
                    outputStream.write(PrinterCommands.ESC_ALIGN_CENTER);
                    break;
                case 2:
                    //right align
                    outputStream.write(PrinterCommands.ESC_ALIGN_RIGHT);
                    break;
            }
            outputStream.write(msg.getBytes());
            outputStream.write(PrinterCommands.LF);
            //outputStream.write(cc);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //print photo
    public void printPhoto(int img) {
        try {
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), img);
            if(bmp!=null){
                byte[] command = Utils.decodeBitmap(bmp);
                outputStream.write(PrinterCommands.ESC_ALIGN_CENTER);
                printText(command);
            }else{
                Log.e("Print Photo error", "the file isn't exists");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("PrintTools", "the file isn't exists");
        }
    }

    //print new line
    private void printNewLine() {
        try {
            outputStream.write(PrinterCommands.FEED_LINE);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //print text
    private void printText(String msg) {
        try {
            // Print normal text
            outputStream.write(msg.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //print byte[]
    private void printText(byte[] msg) {
        try {
            // Print normal text
            outputStream.write(msg);
            printNewLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String leftRightAlign(String str1, String str2) {
        String ans = str1 +str2;
        if(ans.length() <31){
            int n = (31 - str1.length() + str2.length());
            ans = str1 + new String(new char[n]).replace("\0", " ") + str2;
        }
        return ans;
    }


    private String[] getDateTime() {
        final Calendar c = Calendar.getInstance();
        String dateTime [] = new String[2];
        dateTime[0] = c.get(Calendar.DAY_OF_MONTH) +"/"+ c.get(Calendar.MONTH) +"/"+ c.get(Calendar.YEAR);
        dateTime[1] = c.get(Calendar.HOUR_OF_DAY) +":"+ c.get(Calendar.MINUTE);
        return dateTime;
    }

}
