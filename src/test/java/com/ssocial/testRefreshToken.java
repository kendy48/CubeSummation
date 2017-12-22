package com.ssocial;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import java.io.IOException;

/**
 * Created by orlando on 27/03/17.
 */
public class testRefreshToken {

    /** Global instance of the HTTP transport. */
    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

    /** Global instance of the JSON factory. */
    private static final JsonFactory JSON_FACTORY = new JacksonFactory();
    //private static GoogleClientSecrets CLIENT_ID;
    private static String refreshToken = "1/Het7fm-SeynM7kBH8AV1XE5Szc0XumiurVkfBeI6hhk";
    private static String REFRESH_TOKEN = "1/Het7fm-SeynM7kBH8AV1XE5Szc0XumiurVkfBeI6hhk";

    private static String CLIENT_ID = "1030680502832-cpppnoo7f10m4cn6u5k5gju5q1bril9e.apps.googleusercontent.com";
    private static String CLIENT_SECRET = "GxDYC3TiCTJGojWIuFHIYA1O";





    public static void main(String[] args) throws IOException {

        //GoogleCredential credential = createCredentialWithRefreshToken(HTTP_TRANSPORT, JSON_FACTORY, new TokenResponse().setRefreshToken(refreshToken));

        //String newAccessToken = credential.getAccessToken();
        //System.out.println(newAccessToken);
        getAccessTokenFromRefreshToken();
    }



    private static void getAccessTokenFromRefreshToken() throws IOException {
        GoogleCredential credentials = new GoogleCredential.Builder()
                .setClientSecrets(CLIENT_ID, CLIENT_SECRET)
                .setJsonFactory(JSON_FACTORY).setTransport(HTTP_TRANSPORT).build()
                .setRefreshToken(REFRESH_TOKEN);

        String accessToken = credentials.getAccessToken();
        System.out.println("Access token before: " + accessToken);

        credentials.refreshToken();

        accessToken = credentials.getAccessToken();
        System.out.println("Access token after: " + accessToken);
    }


}
