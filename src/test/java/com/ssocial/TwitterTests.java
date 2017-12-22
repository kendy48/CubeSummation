package com.ssocial;

import org.junit.Test;
import twitter4j.IDs;
import twitter4j.TwitterFactory;
import twitter4j.UploadedMedia;
import twitter4j.User;
import twitter4j.api.FriendsFollowersResources;
import twitter4j.conf.ConfigurationBuilder;

import java.io.File;

import static org.junit.Assert.assertNotNull;


public class TwitterTests {

//    @Test
    public void testUploadMediaChunked() throws Exception{
        String file = "/home/kendy/Videos/Test_Video_2.mp4";
        File mp4File = new File(file);

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("8YDD22BYxFc1KDYgg8dqzQQ4O")
                .setOAuthConsumerSecret("cjHge6Pc3f6biBzlzQSOFnwN4whDVITuJfHhuJbUTsqJ9EVsoA")
                .setOAuthAccessToken("112582446-nmFmZZRaUckhyg3j6PIDdYF75cDcnFVKL9deFaVZ")
                .setOAuthAccessTokenSecret("PdJykAAX2iBUYRXiAim8e2RO2rmYXZI7cQOzhtloZNj90");
        twitter4j.Twitter twitter1 = new TwitterFactory(cb.build()).getInstance();
        UploadedMedia media = twitter1.uploadMediaChunked(mp4File, "video/mp4");
        assertNotNull(media.getMediaId());
        assertNotNull(media.getSize());
//        StatusUpdate statusUpdate = new StatusUpdate("Test 3");
////        statusUpdate.placeId(String.valueOf(media.getMediaId()));
//        statusUpdate.media(mp4File);
//        Status status = twitter1.updateStatus(statusUpdate);
//        assertNotNull(status.getId());
    }

    @Test
    public void getFollowers(){
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("8YDD22BYxFc1KDYgg8dqzQQ4O")
                .setOAuthConsumerSecret("cjHge6Pc3f6biBzlzQSOFnwN4whDVITuJfHhuJbUTsqJ9EVsoA")
                .setOAuthAccessToken("112582446-nmFmZZRaUckhyg3j6PIDdYF75cDcnFVKL9deFaV")
                .setOAuthAccessTokenSecret("PdJykAAX2iBUYRXiAim8e2RO2rmYXZI7cQOzhtloZNj90");
        twitter4j.Twitter twitter1 = new TwitterFactory(cb.build()).getInstance();

        try {
            User user = twitter1.showUser(twitter1.getId());
            System.out.println(user.getFollowersCount());
        } catch (twitter4j.TwitterException e) {
            System.out.println("twitter: failed");
            e.printStackTrace();
        }

    }
}
