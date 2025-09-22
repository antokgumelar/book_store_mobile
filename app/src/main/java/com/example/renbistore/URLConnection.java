package com.example.renbistore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLConnection {
    public static void main(String[] args) {
        // Ganti URL dengan URL yang sesuai
        String apiUrl = "https://renbi.my.id/getUser.php";

        try {
            String response = makeServiceCall(apiUrl);
            System.out.println("Response from server:\n" + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String makeServiceCall(String urlString) throws IOException {
        StringBuilder response = new StringBuilder();
        HttpURLConnection connection = null;
        InputStream inputStream = null;

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Baca respons dari server
            inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return response.toString();
    }
}
