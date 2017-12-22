package com.ssocial;

import com.restfb.*;
import com.restfb.exception.FacebookOAuthException;
import com.restfb.types.FacebookType;
import com.restfb.types.Post;
import com.restfb.types.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;


public class FacebookTests {

    private String longAccesToken = "EAAbv7XQie6cBAPCgNzVvt3VTcLYbpUB35l3nZAcnpo8iul9NAgpAuykJn5iWxNeiYx76Vpg3pzSd50pnVDrT9Cjx9HfhZB87jkuEnUZAV3V6V8ddRyx4PoKd0FXQBq0xBzjZAPVD76JD9msZAOFQf";

//    @Test
    public void restfbGetSessionToken() throws FileNotFoundException, JSONException{
        String accesToken = "EAAbv7XQie6cBABycXmuO7g805KBkQjfgxebZBO1t0BJaZCHbZALPk5ZAWCScX36ehU6JBryGDcRR4wZCIQmHSoThQOKOUZAE4Ucp0bCplOa4HJ5OtigJSDA8RvU322wTqaYLc3U5yb9hYE59z6YLL9xZBxAMy9wvBoZD";

        final String uri = "https://graph.facebook.com/oauth/access_token?grant_type=fb_exchange_token&fb_exchange_token="+
                accesToken+"&client_id=1952652994968487&client_secret=a6d668b0e405576b8df5b97fdf205fa9";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        JSONObject jsonObj = new JSONObject(result);

        System.out.println(jsonObj.get("access_token"));

    }

//    @Test
    public void restfbImage() throws FileNotFoundException{
        try{
            //Publish a Photo
            FacebookClient fbClient = new DefaultFacebookClient(longAccesToken);
            FileInputStream fis = new FileInputStream(new File("/home/kendy/Pictures/Kendy_Perfil3.jpg"));

            FacebookType resp = fbClient.publish("me/photos", FacebookType.class,
                    BinaryAttachment.with("Kendy_Perfil3.jpg", fis), Parameter.with("message", "http://www.hikidsweb.com"),
                    Parameter.with("link", "https://www.hikidsweb.com"));

            System.out.println(resp.getId());

        } catch (FacebookOAuthException e){
            System.out.println(e.toString());
        }
    }

//    @Test
    public void restfbVideo() throws FileNotFoundException{
        String accesToken = longAccesToken;


        try{
            //Publish a Video
            FacebookClient fbClient = new DefaultFacebookClient(accesToken);
            FileInputStream fis = new FileInputStream(new File("/home/kendy/Videos/Test_Video_2.mp4"));

            FacebookType resp = fbClient.publish("me/videos", FacebookType.class,
                    BinaryAttachment.with("Test_Video_2.mp4", fis),
                    Parameter.with("description", "description"),
                    Parameter.with("link", "http://www.google.com"));

            System.out.println(resp.getId());
        } catch (FacebookOAuthException e){
            System.out.println(e.toString());
        }
    }

//    @Test
    public void likePost(){
        DefaultFacebookClient client = new DefaultFacebookClient(longAccesToken);
//        client.publish("275988882852411/likes", Boolean.class);


        Post.Likes likes = client.fetchObject("275988882852411/likes", Post.Likes.class,
                Parameter.with("summary", 1), Parameter.with("limit", 0));
        System.out.println(likes.getCount());
    }

//    @Test
    public void getUserData(){
        FacebookClient fbClient = new DefaultFacebookClient(longAccesToken);
        User me = fbClient.fetchObject("me", User.class, Parameter.with("fields", "about,birthday,education,email," +
                "first_name,gender,hometown,languages,last_name,link,locale,location,name," +
                "political,quotes,religion,sports,timezone,verified,website,work"));
        System.out.println(me);
        Connection<User> myFriends = fbClient.fetchConnection("me/friends", User.class);


        System.out.println("First item in my feed: " + myFriends.getData().get(0));

// Connections support paging and are iterable
        for (List<User> user : myFriends)
            System.out.println("User: " + user);
    }

//    @Test
    public void getPictureInfo(){
        FacebookClient fbClient = new DefaultFacebookClient(longAccesToken);
        Post.Likes image = fbClient.fetchObject("10154539228871169/likes", Post.Likes.class);
        System.out.println(image.getData().size());
        System.out.println(image.getData().get(0).getId().equals("10154537681416169"));

        fbClient = new DefaultFacebookClient(longAccesToken);
        image = fbClient.fetchObject("10154537681416169/fees", Post.Likes.class);
        System.out.println(image.getData().size());
        System.out.println(image.getData().get(0).getId().equals("10154537681416169"));
    }


//    @Test
    public void likeaPost(){
        FacebookClient fbClient = new DefaultFacebookClient(longAccesToken);
        fbClient.publish("10154539375651169"+"/likes", Boolean.class);
    }

//    @Test
    public void findPost(){
        FacebookClient fbClient = new DefaultFacebookClient(longAccesToken);
        Connection<Post> pageFeed = fbClient.fetchConnection("10154537681416169/feed", Post.class);
        for (List<Post> myFeedPage : pageFeed) {
            for (Post post : myFeedPage) {
                System.out.println(post.getId().equals("10154537681416169"));
            }
        }
    }

//    @Test
    public void sharePost(){
        FacebookClient fbClient = new DefaultFacebookClient(longAccesToken);
        fbClient.publish("me/feed", FacebookType.class, Parameter.with("link", "https://www.facebook.com/10154539228871169"));
    }

}
