    package com.graduationproject.mybatisdemo.demo.controller;

    import com.graduationproject.mybatisdemo.demo.RequestDao.userRequestDao;
    import com.graduationproject.mybatisdemo.demo.config.JwtConfig;
    import com.graduationproject.mybatisdemo.demo.entity.User;
    import com.graduationproject.mybatisdemo.demo.service.LoginService;
    import com.graduationproject.mybatisdemo.demo.service.UserService;
    import io.jsonwebtoken.Claims;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import javax.annotation.Resource;
    import javax.naming.AuthenticationException;
    import java.util.List;

    /**
    * (User)表控制层
    *
    * @since 2020-03-25 20:05:02
    */
    @RestController
    @RequestMapping("/user")
    public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @Resource
    private LoginService loginService;

    @Autowired
    private JwtConfig jwtConfig;

    @GetMapping(value = "/list", produces = "application/json;charset=UTF-8")
    public List<User> list(@RequestHeader("Auth") String auth) throws AuthenticationException {
        if(this.tokenCheck(auth)){
            throw new AuthenticationException("token不可用");
        }
        return this.userService.list();
    }

    @PostMapping(value = "/new", produces = "application/json;charset=UTF-8")
    public User newUser(@RequestHeader("Auth") String auth, @RequestBody userRequestDao userRequestDao)throws AuthenticationException{
        if(this.tokenCheck(auth)){
            throw new AuthenticationException("token不可用");
        }
        if(this.loginService.loginCheck(userRequestDao.getUsername(),userRequestDao.getPassword())!=null){
            throw new RuntimeException("用户已注册");
        }
        return this.userService.newUser(userRequestDao);
    }

    @PostMapping(value = "/showEdit", produces = "application/json;charset=UTF-8")
    public User newUser(@RequestHeader("Auth") String auth,
                        @RequestBody String username)throws AuthenticationException{
        if(this.tokenCheck(auth)){
            throw new AuthenticationException("token不可用");
        }
        User user = this.userService.selectUser(username);
        if( user== null){
            throw new RuntimeException("用户不存在");
        }
        return user;
    }

    @PostMapping(value = "/edit", produces = "application/json;charset=UTF-8")
    public User editByUsername(@RequestHeader("Auth") String auth, @RequestBody userRequestDao userRequestDao)throws AuthenticationException{
        if(this.tokenCheck(auth)){
            throw new AuthenticationException("token不可用");
        }
        if(this.editAdmin(auth,userRequestDao.getUsername())){
            throw new RuntimeException("不可编辑自己");
        }
        return this.userService.editUserByUsername(userRequestDao);
    }

    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public Boolean deleteByUsername(@RequestHeader("Auth") String auth,
                                 @RequestBody String  username)throws AuthenticationException{
        if(this.tokenCheck(auth)){
            throw new AuthenticationException("token不可用");
        }
        if(this.editAdmin(auth,username)){
            throw new RuntimeException("不可删除自己");
        }
        return this.userService.deleteByUsername(username);
    }

    public Boolean tokenCheck(String auth){
        Claims claims = jwtConfig.getClaimByToken(auth);
        return claims == null || JwtConfig.isTokenExpired(claims.getExpiration());
    }

    public Boolean editAdmin(String auth,String username){
        Claims claims = jwtConfig.getClaimByToken(auth);
        String subject=claims.getSubject();
        return subject.equals(username);
    }
    }