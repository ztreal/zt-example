package com.zt.example.web.action;

import com.zt.example.util.spring.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
* 首页action.
* User: zhangtan
* Date: 13-6-4
* Time: 下午5:07
*/
@Controller
public class IndexAction extends BaseAction{

    @RequestMapping(value = "/index", method = { RequestMethod.GET,
                RequestMethod.POST })
    public String index() throws Exception {
//        response.setDateHeader("Expires", 0);
//        response.setHeader("Cache-Control", "no-cache");
//        response.setHeader("Pragma", "no-cache");
        return "index";
    }


}
