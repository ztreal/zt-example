package com.zt.example.web.action;

import com.zt.example.domain.user.User;
import com.zt.example.dto.UserIndexDto;
import com.zt.example.service.UserService;
import com.zt.example.util.spring.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
* 首页action.
* User: zhangtan
* Date: 13-6-4
* Time: 下午5:07
*/
@Controller
public class IndexAction extends BaseAction{
    @Resource
   private UserService UserService;

    @RequestMapping(value = "/index", method = { RequestMethod.GET,
                RequestMethod.POST })
    public ModelAndView index() throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        UserIndexDto userIndexDto = new UserIndexDto();
        User user = new User();
        userIndexDto.setUserList(UserService.queryAll(user));
        mav.addObject("userIndexDto", userIndexDto);
        return mav;
    }


}
