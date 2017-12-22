package com.ssocial;

import com.ssocial.task.AssignPostTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class SsocialApplicationTests {

    @Autowired
    AssignPostTask assignPostTask;


//	@Test
	public void contextLoads() {
	}

//    @Test
    public void assignPosts() throws Exception{
        assignPostTask.postAssigner();
    }

//    @Test
//    public void createFacebookTemplate() throws Exception{
//        Facebook facebook = new FacebookTemplate("EAASjBUhF46EBAOlpliawcM8240wFfhjHwgQl4A3IXWARUH02JMrLU1lvRazthtJYRcWfe5oqCmvUCbUjEcFpWbFHaxjS0HtSEe2SoBmNPtlP7EGrC7t5IMzbCxwhQTrkCIgk3CStunwNQGZBJiydgWGhpa8bTDE6QwMZCiNcGiWCk69xs2ES1SWFTOTgIZD\",\"userID\":\"10154309453731169\",\"expiresIn\":5953,\"signedRequest\":\"MqK3wzmsgfRZjdbV3yjqgfPdAklsbyk9tx3scUjR3HM.eyJhbGdvcml0aG0iOiJITUFDLVNIQTI1NiIsImNvZGUiOiJBUUFXZkcwZ01KeHNDRkJKQWp0N2FUai1UMHBBMDhQUmVnWjRaVXJyei1kU2tjNDFnU2Y2LTJYLWpJOWVvX1kxY0RTdFRpOWw4ZVFVRVJTczkydjJ1NDc2dUVILTVQYW1RT3pwekFvNEJGSlVKLVo3SWNUVHJ3RTNRWW9UcHgwdjBtT05CODE5YVQzOVhCT0tTMGFiTW53LTRscV9qdU1iSUdKUVJ3SUdNRFJ5U2x4cHVrNm5wM0NqYjNiWlJubnVubHRpdk5EcHRqVG9odUU0c3ZHVkZKV3JLLXFaWUNURkpGRFRaRWlNQjR1X3lEeDUtVXlkZ094a2M0NmZ2TEd3TVJUeTloR3R3Nnc2eC11VlhWVkNiTjM4ZU5iRnBoNTEySnJ3eXpvWGxsUFZEUmk1NzBuUnZNYmFEY2pqcThIS3FVckpHUzlTc09MLWljM0E2V1N0c093UyIsImlzc3VlZF9hdCI6MTQ5MDk3MzY0NywidXNlcl9pZCI6IjEwMTU0MzA5NDUzNzMxMTY5In0");
//        System.out.println(facebook.userOperations().getUserProfile().getAbout());
//        System.out.println("done");
//    }
}
