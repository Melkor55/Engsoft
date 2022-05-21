package com.example.ic_00;

public class Database_URL
{
    private String header = "http://" ;
    private String ip = getIP.getIp();
    private String folder ;
    private String phpFile ;
    private String URL;

    public Database_URL(String folder, String phpFile)
    {
        this.folder = folder;
        this.phpFile = phpFile;
        this.URL = header + ip + folder + phpFile;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getPhpFile() {
        return phpFile;
    }

    public void setPhpFile(String phpFile) {
        this.phpFile = phpFile;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
