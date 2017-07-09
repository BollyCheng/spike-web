package com.bolly.spike.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author   : Bolly
 * CreateAt : 2017/05/13 16:45:48
 */
public class TestHttpClientUtli {

    @Test
    public void testGet() throws IOException {
        String url = "http://www.baidu.com/";

        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("wd", "微信"));

        String result = HttpClientUtil.get(url, nvps);

        Assert.assertNotNull(result);
    }

    @Test
    public void testPost() throws IOException {
        String url = "http://www.baidu.com/";

        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("wd", "微信"));

        HttpEntity httpEntity = EntityBuilder.create().setParameters(nvps).build();

        String result = HttpClientUtil.post(url, httpEntity);

        Assert.assertNotNull(result);
    }

}
