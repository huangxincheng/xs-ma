package com.hxc.xsma.controller;

import com.hxc.xsma.annotation.BaseResponseBody;
import com.hxc.xsma.annotation.BaseRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: huangxincheng
 * <p>
 * <p>
 **/
@RequestMapping("/base")
@BaseRestController
public class BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    @RequestMapping
    public Map index(@RequestParam(required = false) String param) {
        HashMap map = new HashMap();
        map.put("ok", "ok");
        map.put("hehe", "heh");
        map.put("param", param);
        return  map;
    }

}
