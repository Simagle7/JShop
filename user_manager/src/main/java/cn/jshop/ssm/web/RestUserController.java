package cn.jshop.ssm.web;

import cn.jshop.ssm.domain.tb.User;
import cn.jshop.ssm.param.tb.UserParam;
import cn.jshop.ssm.service.tb.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("restful/user")
@Controller
public class RestUserController {

    @Autowired
    private IUserService userService;

    /**
     * 根据用户id查询用户数据
     *
     * @param id 用户id
     * @return  返回，用户信息实体
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<User> queryUserById(@PathVariable("id") Long id) {
        try {
            User user = (User) userService.findOne(UserParam.F_ID, id);
            if (null == user) {
                // 资源不存在，响应404
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            // 200
            // return ResponseEntity.status(HttpStatus.OK).body(user);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> saveUser(User user) {
        try {
            userService.insert(user);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
    /**
     * 更新用户资源
     *
     * @param user  用户更新实体
     * @return  返回，操作码
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateUser(User user) {
        try {
            userService.update(user);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 删除用户资源
     *
     * @param id    用户id
     * @return  返回，操作码
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@RequestParam(value = "id", defaultValue = "0") Long id) {
        try {
            if (id.intValue() == 0) {
                // 请求参数有误
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            userService.deleteById(id);
            // 204
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
