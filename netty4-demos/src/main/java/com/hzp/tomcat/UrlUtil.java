package com.hzp.tomcat;

public class UrlUtil {
    public UrlBean readString(String info) {
        UrlBean url = null;
        int tag1 = info.indexOf(":");
        int tag2 = info.lastIndexOf(":");
        int tag3 = info.indexOf("/", tag2);
        int tag4 = info.lastIndexOf("/");
        int tag5 = info.indexOf("?");
        int tag6=info.lastIndexOf(".");
        String Protocol = info.substring(0, tag1);
        String Host = info.substring(tag1 + 3, tag2);
        String Port = info.substring(tag2 + 1, tag3);
        String Path = info.substring(tag3 + 1, tag4);
        String FileName = info.substring(tag4 + 1, tag6);
        String Parameter = info.substring(tag5 + 1, info.trim().length());
        if (Host != null && Path != null && FileName != null) {
            if (Protocol == null) {
                Protocol = "http";
            }
            if (Port == null) {
                Port = "8080";
            }
            url = new UrlBean(Protocol, Host, Port, Path, FileName, Parameter);
            return url;
        }
        return url;
    }
}
