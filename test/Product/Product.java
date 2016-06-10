/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


/**
 *
 * @author Akhilesh Chauhan 
 * this script will give you the list of product categories
 */
public class Product {

    public static void main(String[] args) throws Exception {
        Product pro = new Product();
        pro.Fetch_Ustra_product_categories();

    }

    private void Fetch_Ustra_product_categories() throws Exception {

        String url = "http://stagehudroid.happilyunmarried.com/uapi/index/fetchproductcategories/?secretkey=XmgobA7HyvrBLhjI74o5pqec2fDFSf4TWzmIhSYnkNU=";

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
             
            // TODO add test methods here.
            // The methods must be annotated with annotation @Test. For example:
            //
            // @Test
            // public void hello() {}


    


}