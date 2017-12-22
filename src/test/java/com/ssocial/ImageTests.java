package com.ssocial;

import org.junit.Test;
import twitter4j.TwitterFactory;
import twitter4j.UploadedMedia;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;


public class ImageTests {

    @Test
    public void resizeImage(){
        try {
            BufferedImage bimg = ImageIO.read(new File("/home/kendy/trofiventures/projects/systemSocial/ssocial/src/main/resources/387H.jpg"));
            int width          = bimg.getWidth();
            int height         = bimg.getHeight();
            double ratio = width / (height+0.0);
            Double newHeight = (600 / ratio);
            System.out.println("width: "+width+" height: "+height+" > width: "+600+" height: "+newHeight.intValue());
        } catch (IOException e){
            System.out.println(e.toString());
        }

    }
}
