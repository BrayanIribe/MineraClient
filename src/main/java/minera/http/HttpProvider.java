/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minera.http;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author braya
 */
public class HttpProvider {
    
     public static HttpResult Get(String targetUrl) {
        HttpURLConnection connection = null;

        try {
            //Create connection
            URL url = new URL("http://localhost:8080" + targetUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Get Response  
            InputStream is = connection.getInputStream();
            String response = new String(is.readAllBytes());

            HttpResult result = new HttpResult();
            result.data = response;
            result.responseCode = connection.getResponseCode();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    public static HttpResult Post(String targetUrl, String data) {
        HttpURLConnection connection = null;

        try {
            //Create connection
            URL url = new URL("http://localhost:8080" + targetUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Length", Integer.toString(data.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
            wr.writeBytes(data);
            wr.close();

            //Get Response  
            InputStream is = connection.getInputStream();
            String response = new String(is.readAllBytes());

            HttpResult result = new HttpResult();
            result.data = response;
            result.responseCode = connection.getResponseCode();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

}
