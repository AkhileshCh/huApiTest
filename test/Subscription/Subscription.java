/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Subscription;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.testng.annotations.Test;

/**
 *
 * @author kaustav
 */
public class Subscription {
    
    public static void main(String[] args) throws Exception {
        Subscription sub = new Subscription();
        //sub.Fetch_Fetch_subscription_packs();
        sub.Fetch_my_subscription_packs();
        
    }
    
    
     private void Fetch_Fetch_subscription_packs() throws Exception {
    
       
        String url = "http://stagehudroid.happilyunmarried.com/uapi/index/fetchsubscriptionpackinfo/?secretkey=XmgobA7HyvrBLhjI74o5pqec2fDFSf4TWzmIhSYnkNU=";

        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);
        HttpEntity entity = response.getEntity();
        

            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : "
            + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
            new InputStreamReader(response.getEntity().getContent()));
            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
            result.append(line);
            result.append(line + "\n");
            }
            System.out.println(result);
            }
     
    private void Fetch_my_subscription_packs() throws IOException{
        for (int i=0 ; i<=10000 ;i++){
            
         String url = "http://stagehudroid.happilyunmarried.com/uapi/index/fetchsubscriptioninformation/?secretkey=XmgobA7HyvrBLhjI74o5pqec2fDFSf4TWzmIhSYnkNU=&customerid="+i;

        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);
        HttpEntity entity = response.getEntity();
        

            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : "
            + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
            new InputStreamReader(response.getEntity().getContent()));
            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
            result.append(line);
            result.append(line + "\n");
            }
            System.out.println(result);
            }
    }
    
    private void Cancel_a_Subscription() throws IOException{
        for (int i=0 ; i<=10000 ;i++){
            
         String url = "http://stagehudroid.happilyunmarried.com/uapi/index/fetchsubscriptioninformation/?secretkey=XmgobA7HyvrBLhjI74o5pqec2fDFSf4TWzmIhSYnkNU=&customerid="+i;

        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);
        HttpEntity entity = response.getEntity();
        

            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : "
            + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(
            new InputStreamReader(response.getEntity().getContent()));
            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
            result.append(line);
            result.append(line + "\n");
            }
            System.out.println(result);
            }
    }
        
    

}
    

