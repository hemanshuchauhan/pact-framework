package com.client;

import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;

public class PostCode
{
    int port=8111;

    PostCode() {
        // Will use default port.
        System.out.println("Default port "+port);
    }

    PostCode(int port) {
        this.port=port;
        System.out.println("Custom port "+port);
    }

    public static void main( String[] args ) {
        String address = new PostCode().getAddress("IG27JY");
        System.out.println("address = " + address);
    }
    
    public String getAddress(String postCode) {
        try {
            String url=String.format("Http://localhost:%d/get-address/%s", port, postCode);
            System.out.println("using url: "+url);
            HttpResponse r = Request.Get(url).execute().returnResponse();
            String json = EntityUtils.toString(r.getEntity());
            System.out.println("json="+json);
            JSONObject jsonObject = new JSONObject(json);
            String address = jsonObject.get("address").toString();
            return address;

        }
        catch (Exception e) {
            System.out.println("Unable to getAddress  " + e);
            return null;
        }
    }
    
    public String getAddressErr(String postCode) {
        try {
            String url=String.format("Http://localhost:%d/get-address1/%s", port, postCode);
            System.out.println("using url: "+url);
            HttpResponse r = Request.Get(url).execute().returnResponse();
            String json = EntityUtils.toString(r.getEntity());
            System.out.println("json="+json);
            JSONObject jsonObject = new JSONObject(json);
            String address = jsonObject.get("address").toString();
            return address;

        }
        catch (Exception e) {
            System.out.println("Unable to getAddress  " + e);
            return null;
        }
    }
}
