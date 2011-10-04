package sportsbook.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyConnection {
    private HttpClient client;
    private HttpGet get;
    private HttpContext context;

    public MyConnection(String url) {
        context = new BasicHttpContext();
        client = new DefaultHttpClient();
        get = new HttpGet(url);
    }

    public String getSource() {
        String out = "";
        try {
            HttpResponse res = client.execute(get, context);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                        res.getEntity().getContent()
                    )
            );
            String line;
            while ((line = reader.readLine()) != null) {
                out += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return out;
    }
}
