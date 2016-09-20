package cn.jshop.ssm.web.tb;

import cn.jshop.ssm.domain.tb.EasyUIResult;
import cn.jshop.ssm.service.tb.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("user")
@Controller
public class UserController {

    // @Autowired
    // private UserService userService;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public EasyUIResult queryUserList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                      @RequestParam(value = "rows", defaultValue = "5") Integer rows) {
        return this.userService.queryUserList(page, rows);
    }

}
