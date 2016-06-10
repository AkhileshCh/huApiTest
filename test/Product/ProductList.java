/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author Achauhan
 * 
 * this fetch product list on the basis of category id
 */
public class ProductList {
    public static void main(String[] args) throws Exception {
        ProductList pro = new ProductList();
        ArrayList Category_id = JSONParser.fetch_category();
        for (int i=0 ; i<Category_id.size() ;i++){
           pro.Fetch_Ustra_product((String) Category_id.get(i));  
        }
       
    }

    
    private void Fetch_Ustra_product(String Category_id) throws Exception {
       
      
        String url = "http://stagehudroid.happilyunmarried.com/uapi/index/fetchproductbycategory/?secretkey=XmgobA7HyvrBLhjI74o5pqec2fDFSf4TWzmIhSYnkNU=&categoryid="+Category_id;

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
    

