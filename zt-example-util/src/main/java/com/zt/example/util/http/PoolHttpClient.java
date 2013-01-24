package com.zt.example.util.http;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;

/**
 * Created with IntelliJ IDEA.
 * User: zhangtan
 * Date: 13-1-24
 * Time: 上午11:15
 * To change this template use File | Settings | File Templates.
 */
public class PoolHttpClient {
    public static void main() throws InterruptedException {
        SchemeRegistry schemeRegistry = new SchemeRegistry();
      schemeRegistry.register(new
              Scheme("http", 80, PlainSocketFactory.getSocketFactory()));

      ClientConnectionManager cm = new PoolingClientConnectionManager(schemeRegistry);
      HttpClient httpClient = new DefaultHttpClient(cm);

      // URIs to perform GETs on
      String[] urisToGet = {
          "http://www.baidu.com/",
          "http://www.sohu.com/",
          "http://www.sina.com/",
          "http://www.qq.com/"
      };

      // create a thread for each URI
      GetHttpThread[] threads = new GetHttpThread[urisToGet.length];
      for (int i = 0; i < threads.length; i++) {
          HttpGet httpget = new HttpGet(urisToGet[i]);
          threads[i] = new GetHttpThread(httpClient, httpget);
      }

      // start the threads
        for (GetHttpThread thread : threads) {
            thread.start();
        }

      // join the threads
        int j = 0;
        while (j < threads.length) {
            threads[j].join();
            j++;
        }
    }

}
