package com.ssocial.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ssocial.business.CubeBs;
import com.ssocial.exception.ControllerException;
import com.ssocial.model.request.SolveCubeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by kendy on 22/12/17.
 */
@CrossOrigin
@RestController
public class MainController{


    @Autowired
    private CubeBs cubeBs;

    @RequestMapping(value = "/cube/solve", method = RequestMethod.POST)
    @ResponseBody
    public String solveCube(@RequestBody SolveCubeRequest request) throws JsonProcessingException, ControllerException {
        return cubeBs.solveCube(request);
    }

}