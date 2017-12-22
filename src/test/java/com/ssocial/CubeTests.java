package com.ssocial;

import com.ssocial.business.CubeBs;
import com.ssocial.exception.ControllerException;
import com.ssocial.model.request.SolveCubeRequest;
import org.junit.Assert;
import org.junit.Test;

import static com.ssocial.exception.ErrorResponses.*;


public class CubeTests {


    @Test
    public void nullEntry1(){
        SolveCubeRequest request = new SolveCubeRequest();
        CubeBs cubeBs = new CubeBs();
        try {
            cubeBs.solveCube(request);
        } catch (ControllerException e){
            Assert.assertEquals(new ControllerException(INVALID_SOLVE_CUBE_REQUEST).getErrorResponse(), e.getErrorResponse());
        }
    }

    @Test
    public void nullEntry2(){
        SolveCubeRequest request = new SolveCubeRequest();
        request.setInput("");
        CubeBs cubeBs = new CubeBs();
        try {
            cubeBs.solveCube(request);
        } catch (ControllerException e){
            Assert.assertEquals(new ControllerException(INVALID_SOLVE_CUBE_REQUEST).getErrorResponse(), e.getErrorResponse());
        }
    }

    @Test
    public void invalidCaseNumber1(){
        SolveCubeRequest request = new SolveCubeRequest();
        request.setInput("-1\n" +
                "4 5\n" +
                "QUERY 1 1 1 3 3 3");
        CubeBs cubeBs = new CubeBs();
        try {
            cubeBs.solveCube(request);
        } catch (ControllerException e){
            Assert.assertEquals(new ControllerException(INVALID_CASE_NUMBER).getErrorResponse(), e.getErrorResponse());
        }
    }

    @Test
    public void invalidCaseNumber2(){
        SolveCubeRequest request = new SolveCubeRequest();
        request.setInput("51\n" +
                "4 5\n" +
                "QUERY 1 1 1 3 3 3");
        CubeBs cubeBs = new CubeBs();
        try {
            cubeBs.solveCube(request);
        } catch (ControllerException e){
            Assert.assertEquals(new ControllerException(INVALID_CASE_NUMBER).getErrorResponse(), e.getErrorResponse());
        }
    }

    @Test
    public void invalidMainParams1(){
        SolveCubeRequest request = new SolveCubeRequest();
        request.setInput("1\n" +
                "4 5 4\n");
        CubeBs cubeBs = new CubeBs();
        try {
            cubeBs.solveCube(request);
        } catch (ControllerException e){
            Assert.assertEquals(new ControllerException(INVALID_MAIN_CASE_VALUES).getErrorResponse(), e.getErrorResponse());
        }
    }

    @Test
    public void invalidCubeSize1(){
        SolveCubeRequest request = new SolveCubeRequest();
        request.setInput("1\n" +
                "0 5\n");
        CubeBs cubeBs = new CubeBs();
        try {
            cubeBs.solveCube(request);
        } catch (ControllerException e){
            Assert.assertEquals(new ControllerException(INVALID_CUBE_NUMBER).getErrorResponse(), e.getErrorResponse());
        }
    }

    @Test
    public void invalidCubeSize2(){
        SolveCubeRequest request = new SolveCubeRequest();
        request.setInput("1\n" +
                "101 5\n");
        CubeBs cubeBs = new CubeBs();
        try {
            cubeBs.solveCube(request);
        } catch (ControllerException e){
            Assert.assertEquals(new ControllerException(INVALID_CUBE_NUMBER).getErrorResponse(), e.getErrorResponse());
        }
    }

    @Test
    public void invalidOperationSize1(){
        SolveCubeRequest request = new SolveCubeRequest();
        request.setInput("1\n" +
                "2 0\n");
        CubeBs cubeBs = new CubeBs();
        try {
            cubeBs.solveCube(request);
        } catch (ControllerException e){
            Assert.assertEquals(new ControllerException(INVALID_OPERATION_NUMBER).getErrorResponse(), e.getErrorResponse());
        }
    }

    @Test
    public void invalidOperationSize2(){
        SolveCubeRequest request = new SolveCubeRequest();
        request.setInput("1\n" +
                "2 1001\n");
        CubeBs cubeBs = new CubeBs();
        try {
            cubeBs.solveCube(request);
        } catch (ControllerException e){
            Assert.assertEquals(new ControllerException(INVALID_OPERATION_NUMBER).getErrorResponse(), e.getErrorResponse());
        }
    }

    @Test
    public void invalidOperationParams1(){
        SolveCubeRequest request = new SolveCubeRequest();
        request.setInput("1\n" +
                "4 5\n" +
                "UPDATE 2 2 2\n");

        CubeBs cubeBs = new CubeBs();
        try {
            cubeBs.solveCube(request);
        } catch (ControllerException e){
            Assert.assertEquals(new ControllerException(INVALID_OPERATION_QUERY_PARAMS).getErrorResponse(), e.getErrorResponse());
        }
    }

    @Test
    public void invalidOperationParams2(){
        SolveCubeRequest request = new SolveCubeRequest();
        request.setInput("1\n" +
                "4 5\n" +
                "UPDATE 2 2 2 4 1\n");

        CubeBs cubeBs = new CubeBs();
        try {
            cubeBs.solveCube(request);
        } catch (ControllerException e){
            Assert.assertEquals(new ControllerException(INVALID_OPERATION_QUERY_PARAMS).getErrorResponse(), e.getErrorResponse());
        }
    }

    @Test
    public void invalidOperationParams3(){
        SolveCubeRequest request = new SolveCubeRequest();
        request.setInput("1\n" +
                "4 5\n" +
                "QUERY 1 1 1 3 3");

        CubeBs cubeBs = new CubeBs();
        try {
            cubeBs.solveCube(request);
        } catch (ControllerException e){
            Assert.assertEquals(new ControllerException(INVALID_OPERATION_QUERY_PARAMS).getErrorResponse(), e.getErrorResponse());
        }
    }

      @Test
    public void invalidOperationParams4(){
        SolveCubeRequest request = new SolveCubeRequest();
        request.setInput("1\n" +
                "4 5\n" +
                "QUERY 1 1 1 3 3 3 1");

        CubeBs cubeBs = new CubeBs();
        try {
            cubeBs.solveCube(request);
        } catch (ControllerException e){
            Assert.assertEquals(new ControllerException(INVALID_OPERATION_QUERY_PARAMS).getErrorResponse(), e.getErrorResponse());
        }
    }

    @Test
    public void invalidValueNumber1(){
        SolveCubeRequest request = new SolveCubeRequest();
        request.setInput("1\n" +
                "4 5\n" +
                "UPDATE 1 1 1 -10000000001");

        CubeBs cubeBs = new CubeBs();
        try {
            cubeBs.solveCube(request);
        } catch (ControllerException e){
            Assert.assertEquals(new ControllerException(INVALID_VALUE_NUMBER).getErrorResponse(), e.getErrorResponse());
        }
    }

    @Test
    public void invalidValueNumber2(){
        SolveCubeRequest request = new SolveCubeRequest();
        request.setInput("1\n" +
                "4 5\n" +
                "UPDATE 1 1 1 10000000001");

        CubeBs cubeBs = new CubeBs();
        try {
            cubeBs.solveCube(request);
        } catch (ControllerException e){
            Assert.assertEquals(new ControllerException(INVALID_VALUE_NUMBER).getErrorResponse(), e.getErrorResponse());
        }
    }

    @Test
    public void validTest1() throws ControllerException{
        SolveCubeRequest request = new SolveCubeRequest();
        request.setInput("1\n" +
                "4 5\n" +
                "UPDATE 2 2 2 4\n" +
                "QUERY 1 1 1 3 3 3\n" +
                "UPDATE 1 1 1 23\n" +
                "QUERY 2 2 2 4 4 4\n" +
                "QUERY 1 1 1 3 3 3");

        StringBuffer response = new StringBuffer();
        response.append("4\n");
        response.append("4\n");
        response.append("27\n");

        CubeBs cubeBs = new CubeBs();
        Assert.assertEquals(response.toString(), cubeBs.solveCube(request));
    }

    @Test
    public void validTest2() throws ControllerException{
        SolveCubeRequest request = new SolveCubeRequest();
        request.setInput("1\n" +
                "2 4\n" +
                "UPDATE 2 2 2 1\n" +
                "QUERY 1 1 1 1 1 1\n" +
                "QUERY 1 1 1 2 2 2\n" +
                "QUERY 2 2 2 2 2 2");

        StringBuffer response = new StringBuffer();
        response.append("0\n");
        response.append("1\n");
        response.append("1\n");

        CubeBs cubeBs = new CubeBs();
        Assert.assertEquals(response.toString(), cubeBs.solveCube(request));
    }

    @Test
    public void validTest3() throws ControllerException{
        SolveCubeRequest request = new SolveCubeRequest();
        request.setInput("2\n" +
                "4 5\n" +
                "UPDATE 2 2 2 4\n" +
                "QUERY 1 1 1 3 3 3\n" +
                "UPDATE 1 1 1 23\n" +
                "QUERY 2 2 2 4 4 4\n" +
                "QUERY 1 1 1 3 3 3\n" +
                "2 4\n" +
                "UPDATE 2 2 2 1\n" +
                "QUERY 1 1 1 1 1 1\n" +
                "QUERY 1 1 1 2 2 2\n" +
                "QUERY 2 2 2 2 2 2");

        StringBuffer response = new StringBuffer();
        response.append("4\n");
        response.append("4\n");
        response.append("27\n");
        response.append("0\n");
        response.append("1\n");
        response.append("1\n");

        CubeBs cubeBs = new CubeBs();
        Assert.assertEquals(response.toString(), cubeBs.solveCube(request));
    }


}
