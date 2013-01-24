package com.zt.example.util.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

/**
 * Created with IntelliJ IDEA.
 * User: zhangtan
 * Date: 13-1-24
 * Time: 上午11:19
 * To change this template use File | Settings | File Templates.
 */
public class GetHttpThread extends Thread{
    private final HttpClient httpClient;
       private final HttpContext context;
       private final HttpGet httpget;

       public GetHttpThread(HttpClient httpClient, HttpGet httpget) {
           this.httpClient = httpClient;
           this.context = new BasicHttpContext();
           this.httpget = httpget;
       }

       @Override
       public void run() {
           try {
               HttpResponse response = this.httpClient.execute(this.httpget, this.context);
               HttpEntity entity = response.getEntity();
               if (entity != null) {
                   // do something useful with the entity
               }
               // ensure the connection gets released to the manager
               EntityUtils.consume(entity);
           } catch (Exception ex) {
               this.httpget.abort();
           }
       }

}
