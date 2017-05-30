package com.bolly.spike.util;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

import java.io.Closeable;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Http请求的工具类
 * <p>
 * Author   : Bolly
 * CreateAt : 2017/05/13 15:45:19
 */
public class HttpClientUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    /**
     * @param url
     * @return
     */
    public static String get(final String url, List<NameValuePair> nvps) throws IOException {
        HttpClient httpClient = null;
        HttpResponse httpResponse = null;

        try {
            httpClient = HttpClients.createDefault();

            URIBuilder uriBuilder = new URIBuilder(url);
            if (CollectionUtils.isNotEmpty(nvps)) {
                uriBuilder.addParameters(nvps);
            }

            HttpGet httpGet = new HttpGet(uriBuilder.build());

            httpResponse = httpClient.execute(httpGet);

            return EntityUtils.toString(httpResponse.getEntity());
        } catch (URISyntaxException e) {
            logger.error(e.getMessage(), e);
            return null;
        } finally {
            closeHttpResponse(httpResponse);
            closeHttpClient(httpClient);
        }
    }


    public static String post(String url, HttpEntity httpEntity) throws IOException {
        HttpClient httpClient = null;
        HttpResponse httpResponse = null;
        try {
            httpClient = HttpClients.createDefault();

            HttpPost httpPost = new HttpPost(url);

            httpPost.setEntity(httpEntity);

            httpResponse = httpClient.execute(httpPost);

            return EntityUtils.toString(httpResponse.getEntity());
        } finally {
            closeHttpResponse(httpResponse);
            closeHttpClient(httpClient);
        }
    }


    private static void closeHttpClient(HttpClient httpClient) {
        if (httpClient == null)
            return;

        if (httpClient instanceof Closeable) {
            try {
                ((Closeable) httpClient).close();
            } catch (IOException e) {
                logger.error("Close http client failed.", e);
            }
        }
    }

    private static void closeHttpResponse(HttpResponse httpResponse) {
        if (httpResponse == null)
            return;

        if (httpResponse instanceof Closeable) {
            try {
                ((Closeable) httpResponse).close();
            } catch (IOException e) {
                logger.error("Close http response failed.", e);
            }
        }
    }


}
