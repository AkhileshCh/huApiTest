package Login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author kaustav
 */
public class HULogin {

    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {
        HULogin test = new HULogin();
        test.Register();

    }

    private void Login() throws Exception {
        String fileName = "/Users/cdp/Desktop/Aksh/TestFile.xls";

        System.out.println(fileName);
        List sheetData = new ArrayList();
        try (FileInputStream fis = new FileInputStream(fileName)) {

            HSSFWorkbook workbook = new HSSFWorkbook(fis);

            HSSFSheet sheet = workbook.getSheetAt(0);

            Iterator rows = sheet.rowIterator();
            while (rows.hasNext()) {
                HSSFRow row = (HSSFRow) rows.next();
                Iterator cells = row.cellIterator();

                List data = new ArrayList();
                while (cells.hasNext()) {
                    HSSFCell cell = (HSSFCell) cells.next();
                    data.add(cell);
                }

                sheetData.add(data);
            }
        } catch (IOException e) {
        }

        loginData(sheetData);
    }
       public void loginData(List sheetData) throws UnsupportedEncodingException, IOException{
           
        String url = "http://stagehudroid.happilyunmarried.com/huapi/index/login";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        for (int i = 0; i < sheetData.size(); i++) {
            List list = (List) sheetData.get(i);
            //for (int j = 0; j < list.size(); j++) {
            HSSFCell email = (HSSFCell) list.get(0);
            //System.out.println(email);
            HSSFCell password = (HSSFCell) list.get(1);
            if (email.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                String mail = email.getStringCellValue();
                System.out.println(mail);
                urlParameters.add(new BasicNameValuePair("email", mail));

            }
        
            if (password.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                String Password = password.getStringCellValue();
                urlParameters.add(new BasicNameValuePair("password", Password));
            }
        
        urlParameters.add(new BasicNameValuePair("secretkey", "XmgobA7HyvrBLhjI74o5pqec2fDFSf4TWzmIhSYnkNU="));
        //urlParameters.add(new BasicNameValuePair("caller", ""));
        //urlParameters.add(new BasicNameValuePair("num", "12345"));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        HttpResponse response = client.execute(post);
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + post.getEntity());
        System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        System.out.println(result.toString());

    }
      
}

    
private void Register() throws Exception {
        String fileName = "/Users/cdp/Desktop/Aksh/TestData/register.xls";

        System.out.println(fileName);
        List sheetData = new ArrayList();
        try (FileInputStream fis = new FileInputStream(fileName)) {

            HSSFWorkbook workbook = new HSSFWorkbook(fis);

            HSSFSheet sheet = workbook.getSheetAt(0);

            Iterator rows = sheet.rowIterator();
            while (rows.hasNext()) {
                HSSFRow row = (HSSFRow) rows.next();
                Iterator cells = row.cellIterator();

                List data = new ArrayList();
                while (cells.hasNext()) {
                    HSSFCell cell = (HSSFCell) cells.next();
                    data.add(cell);
                }

                sheetData.add(data);
            }
        } catch (IOException e) {
        }

        UserData(sheetData);
    }

    private static void UserData(List sheetData) throws UnsupportedEncodingException, IOException {

        String url = "http://pp.happly.in//huapi/index/register";
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        //post.setHeader("User-Agent", USER_AGENT);  
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();

        for (int i = 0; i < sheetData.size(); i++) {
            List list = (List) sheetData.get(i);
            //for (int j = 0; j < list.size(); j++) {
            HSSFCell email = (HSSFCell) list.get(0);
            //System.out.println(email);
            HSSFCell password = (HSSFCell) list.get(1);
            HSSFCell gender = (HSSFCell) list.get(2);
            HSSFCell firstname = (HSSFCell) list.get(3);
            HSSFCell lastname = (HSSFCell) list.get(4);
            HSSFCell location = (HSSFCell) list.get(5);
            HSSFCell phone = (HSSFCell) list.get(6);

            if (email.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                String mail = email.getStringCellValue();
                System.out.println(mail);
                urlParameters.add(new BasicNameValuePair("email", mail));

            }

            if (password.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                String Password = password.getStringCellValue();
                urlParameters.add(new BasicNameValuePair("password", Password));
            }
            if (gender.getCellType() == HSSFCell.CELL_TYPE_STRING) {

                String Gender = gender.getStringCellValue();
                urlParameters.add(new BasicNameValuePair("gender", Gender));

            }
            if (firstname.getCellType() == HSSFCell.CELL_TYPE_STRING) {

                String Firstname = firstname.getStringCellValue();
                urlParameters.add(new BasicNameValuePair("firstname", Firstname));

            }
            if (lastname.getCellType() == HSSFCell.CELL_TYPE_STRING) {

                String Lastname = lastname.getStringCellValue();
                urlParameters.add(new BasicNameValuePair("lastname", Lastname));

            }
            urlParameters.add(new BasicNameValuePair("newsletter", "true"));
            urlParameters.add(new BasicNameValuePair("licence", "ok"));
            urlParameters.add(new BasicNameValuePair("secretkey", "XmgobA7HyvrBLhjI74o5pqec2fDFSf4TWzmIhSYnkNU="));
            urlParameters.add(new BasicNameValuePair("gender", "M"));
            urlParameters.add(new BasicNameValuePair("dob", "08-22-2015"));
            if (location.getCellType() == HSSFCell.CELL_TYPE_STRING) {

                String Location = location.getStringCellValue();
                urlParameters.add(new BasicNameValuePair("location", Location));

            }
            if (phone.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                phone.setCellType(phone.CELL_TYPE_STRING);
                String Phone = phone.getStringCellValue();

                urlParameters.add(new BasicNameValuePair("phone", Phone));
            }

            post.setEntity(new UrlEncodedFormEntity(urlParameters));

            HttpResponse response = client.execute(post);
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post parameters : " + post.getEntity());
            System.out.println("Response Code : "
                    + response.getStatusLine().getStatusCode());

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            System.out.println(result.toString());

        }
    }

    private void ResetPass() throws Exception {

        String url = "http://stagehudroid.happilyunmarried.com/huapi/index/resetpassword";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("secretkey", "XmgobA7HyvrBLhjI74o5pqec2fDFSf4TWzmIhSYnkNU="));
        urlParameters.add(new BasicNameValuePair("email", "ak12@tek.com"));
        urlParameters.add(new BasicNameValuePair("newpassword", "test12345"));
        urlParameters.add(new BasicNameValuePair("passwordconfirm", "test12345"));
        urlParameters.add(new BasicNameValuePair("currentpassword", "test1234"));
        /*urlParameters.add(new BasicNameValuePair("gender", "m"));
                urlParameters.add(new BasicNameValuePair("firstname", "was"));
                urlParameters.add(new BasicNameValuePair("lastname", "res"));
                urlParameters.add(new BasicNameValuePair("newsletter", "true"));
                urlParameters.add(new BasicNameValuePair("licence", "ok"));
		
                urlParameters.add(new BasicNameValuePair("gender", "M"));
                urlParameters.add(new BasicNameValuePair("dob", "08-22-2015"));
		urlParameters.add(new BasicNameValuePair("location", "Delhi"));
                urlParameters.add(new BasicNameValuePair("phone", "8130013564"));*/

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        HttpResponse response = client.execute(post);
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + post.getEntity());
        System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        System.out.println(result.toString());

    }

    private void ForgetPass() throws Exception {

        String url = "http://stagehudroid.happilyunmarried.com/huapi/index/forgot_password";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("email", "akhilesh@happilyunmarried.com"));
        urlParameters.add(new BasicNameValuePair("secretkey", "XmgobA7HyvrBLhjI74o5pqec2fDFSf4TWzmIhSYnkNU="));
        post.setEntity(new UrlEncodedFormEntity(urlParameters));
        HttpResponse response = client.execute(post);
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + post.getEntity());
        System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        System.out.println(result.toString());

    }

    private void Logout() throws Exception {

        String url = "http://stagehudroid.happilyunmarried.com/huapi/index/logout";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("secretkey", "XmgobA7HyvrBLhjI74o5pqec2fDFSf4TWzmIhSYnkNU="));
        post.setEntity(new UrlEncodedFormEntity(urlParameters));
        HttpResponse response = client.execute(post);
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + post.getEntity());
        System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        System.out.println(result.toString());

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
