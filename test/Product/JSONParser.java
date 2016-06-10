package Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser {

    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";

    public static void main() throws JSONException {
        String url = "http://stagehudroid.happilyunmarried.com/uapi/index/fetchproductcategories/?secretkey=XmgobA7HyvrBLhjI74o5pqec2fDFSf4TWzmIhSYnkNU=";
        JSONParser jsonParser = new JSONParser();
        JSONObject category_data = jsonParser.getJSONFromUrl(url);
        JSONArray arr = category_data.getJSONArray("productcategories");

        for (int i = 0; i < arr.length(); i++) {
            String id = arr.getJSONObject(i).getString("id");
            String id2 = arr.getJSONObject(i).getString("category_name");
            System.out.println(id);
            System.out.println(id2);
        }

    }
// constructor

    public JSONParser() {

    }

    public JSONObject getJSONFromUrl(String url) {

        // Making HTTP request
        try {
            // defaultHttpClient
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);

            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();

        } catch (UnsupportedEncodingException e) {
        } catch (ClientProtocolException e) {
        } catch (IOException e) {
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
                //System.out.println(line);
            }
            is.close();
            json = sb.toString();

        } catch (Exception e) {
            // Log.e("Buffer Error", "Error converting result " + e.toString());
        }

        // try parse the string to a JSON object
        try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            // Log.e("JSON Parser", "Error parsing data " + e.toString());
            System.out.println("error on parse data in jsonparser.java");
        }

        // return JSON String
        return jObj;

    }

    public static ArrayList fetch_category() throws JSONException {
        ArrayList categoryList = new ArrayList();
        String id = null;
        String url = "http://stagehudroid.happilyunmarried.com/uapi/index/fetchproductcategories/?secretkey=XmgobA7HyvrBLhjI74o5pqec2fDFSf4TWzmIhSYnkNU=";
        JSONParser jsonParser = new JSONParser();
        JSONObject category_data = jsonParser.getJSONFromUrl(url);
        JSONArray arr = category_data.getJSONArray("productcategories");

        for (int i = 0; i < arr.length(); i++) {
            categoryList.add(id = arr.getJSONObject(i).getString("id"));
            //String id2 = arr.getJSONObject(i).getString("category_name");
            System.out.println(id);

        }

        return categoryList;

    }

    public static ArrayList fetch_ProductName() throws JSONException {
        {
            ArrayList Category_id = JSONParser.fetch_category();
            for (int i = 0; i < Category_id.size(); i++) {

                String id = null;
                String url = "http://stagehudroid.happilyunmarried.com/uapi/index/fetchproductbycategory/?secretkey=XmgobA7HyvrBLhjI74o5pqec2fDFSf4TWzmIhSYnkNU=&categoryid="+Category_id";
                JSONParser jsonParser = new JSONParser();
                JSONObject Product_list = jsonParser.getJSONFromUrl(url);
                JSONArray arr = Product_list.getJSONArray("productcategories");

                for (int j = 0; j < arr.length(); j++) {
                    categoryList.add(id = arr.getJSONObject(i).getString("id"));
                    //String id2 = arr.getJSONObject(i).getString("category_name");
                    System.out.println(id);

                }

                return categoryList;
            
        
    
}
