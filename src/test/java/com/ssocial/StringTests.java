package com.ssocial;

import com.ssocial.util.StringUtil;
import org.junit.Test;
import twitter4j.TwitterFactory;
import twitter4j.UploadedMedia;
import twitter4j.conf.ConfigurationBuilder;

import java.io.File;

import static org.junit.Assert.assertNotNull;


public class StringTests {

    @Test
    public void generateURL() throws Exception{
        StringUtil util = new StringUtil();
        System.out.println(util.generateURL(5));
    }
}
