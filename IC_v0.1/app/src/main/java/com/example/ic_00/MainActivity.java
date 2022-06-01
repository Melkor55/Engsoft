package com.example.ic_00;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;


public class MainActivity extends AppCompatActivity {

    private Button LoginButton,RegisterButton,DarkMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);

        }
        //InetAddress myIP=InetAddress.getLocalHost();
        try {
            IPAdress.setMyIP();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println("My IP Address is:");
        System.out.println(IPAdress.getMyIP());
        RegisterButton = (Button) findViewById(R.id.registerButton);
        LoginButton = (Button) findViewById(R.id.loginButton);
        DarkMode = (Button) findViewById(R.id.dark_light);

        RegisterButton.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {


                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });



        LoginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });

        DarkMode.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
            //if(isNightModeOn())
            if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                //DarkMode.text = "Enable Dark Mode";
            } else
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                //DarkMode.text = "Disable Dark Mode";
            }
        }
        });
    }

    public static String getLocalIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}