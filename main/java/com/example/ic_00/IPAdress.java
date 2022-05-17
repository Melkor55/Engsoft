package com.example.ic_00;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAdress
{
    public static InetAddress myIP;

    public static InetAddress getMyIP() {
        return myIP;
    }

    public static void setMyIP() throws UnknownHostException {
        IPAdress.myIP = InetAddress.getLocalHost();
    }

}
