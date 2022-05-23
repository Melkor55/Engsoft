package com.example.ic_00;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class getIP {
    public static String ip = "192.168.1.103";
    public static String getIp(){
        return ip;
    }
/*
    public static void get_IP()
{

        //ProcessBuilder processBuilder = new ProcessBuilder("cmd start getIP.bat");



        try
        {

            //Process process = Runtime.getRuntime().exec(
            //        "cmd /c getIP.bat");

            Process process = Runtime.getRuntime().exec("cmd /c start E:\\Projects\\AndroidStudio\\Engsoft\\IC_v0.1\\app\\src\\main\\java\\com\\example\\ic_00\\getIP.bat");
            //Process process = processBuilder.start();

            StringBuilder output = new StringBuilder();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            System.out.println("----+ " + reader.readLine());
            while ((line = reader.readLine()) != null) {
                System.out.println("----+ " + line);
                output.append(line + "\n");
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println(output);
                System.exit(0);
            } else {
                //abnormal...
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }
*/
}
