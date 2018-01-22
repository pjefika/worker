/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ResourceBundle;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import util.JacksonMapper;

public class HttpDAOImpl implements HttpDAO {

    @Override
    public String get(String url, String contentType, Charset responseCharset) throws Exception {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(url);
        get.addHeader("Content-Type", contentType);

        HttpResponse response = httpClient.execute(get);

        if (response.getStatusLine().getStatusCode() != 200) {

            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatusLine().getStatusCode());
        }

        InputStreamReader reader;
        if (responseCharset != null) {
            reader = new InputStreamReader(response.getEntity().getContent(), responseCharset);
        } else {
            reader = new InputStreamReader(response.getEntity().getContent());
        }
        BufferedReader br = new BufferedReader(reader);

        String output;
        StringBuffer result = new StringBuffer();
        while ((output = br.readLine()) != null) {
            result.append(output);
        }

        httpClient.close();

        return result.toString();
    }

    @Override
    public String post(String url, Object obj, String contentType, Charset responseCharset) throws Exception {

        ResourceBundle rb = ResourceBundle.getBundle("credentials");

        responseCharset = responseCharset == null ? Charset.defaultCharset() : responseCharset;

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpHost targetHost = new HttpHost("192.168.25.89", 8080, "http");
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(targetHost.getHostName(), targetHost.getPort()),
                new UsernamePasswordCredentials(rb.getString("login"), rb.getString("password")));
// Create AuthCache instance
        AuthCache authCache = new BasicAuthCache();
// Generate BASIC scheme object and add it to the local auth cache
        BasicScheme basicAuth = new BasicScheme();
        authCache.put(targetHost, basicAuth);
        // Add AuthCache to the execution context
        HttpClientContext context = HttpClientContext.create();
        context.setCredentialsProvider(credsProvider);
        context.setAuthCache(authCache);

        HttpPost post = new HttpPost(url);
        post.addHeader("Content-Type", contentType + "; charset=UTF-8");

        String json = new JacksonMapper(Object.class).serialize(obj);

        System.out.println("POST -> " + json);
        post.setEntity(new StringEntity(json, Charset.forName("UTF-8")));

        CloseableHttpResponse response = httpClient.execute(targetHost, post, context);

        if (response.getStatusLine().getStatusCode() != 200) {

            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatusLine().getStatusCode());
        }
        InputStreamReader reader;
        if (responseCharset != null) {
            reader = new InputStreamReader(response.getEntity().getContent(), responseCharset);
        } else {
            reader = new InputStreamReader(response.getEntity().getContent());
        }
        BufferedReader br = new BufferedReader(reader);

        String output;
        StringBuffer result = new StringBuffer();
        while ((output = br.readLine()) != null) {
            System.out.println("OUTPUT -> " + output);
            result.append(output);
        }
        httpClient.close();

        return result.toString();
    }

}
