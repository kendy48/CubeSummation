package com.ssocial.model.request;

public class SolveCubeRequest {

    private String input;

    public boolean isValid() {
        if(null != input && input.length() > 0){
            return true;
        }
        return false;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
