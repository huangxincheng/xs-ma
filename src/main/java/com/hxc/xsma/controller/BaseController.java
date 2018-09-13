package com.hxc.xsma.controller;

import com.hxc.xsma.annotation.BaseResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: huangxincheng
 * <p>
 * <p>
 **/
@Controller
@RequestMapping("/base")
public class BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    @RequestMapping
    @BaseResponseBody
    public Map index() {
        HashMap map = new HashMap();
        map.put("ok", "ok");
        return  map;
    }

}
