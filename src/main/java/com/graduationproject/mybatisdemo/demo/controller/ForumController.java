package com.graduationproject.mybatisdemo.demo.controller;

import com.graduationproject.mybatisdemo.demo.RequestDao.forumRequestDao;
import com.graduationproject.mybatisdemo.demo.config.JwtConfig;
import com.graduationproject.mybatisdemo.demo.entity.Forum;
import com.graduationproject.mybatisdemo.demo.entity.Goods;
import com.graduationproject.mybatisdemo.demo.service.ForumService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.naming.AuthenticationException;
import java.util.List;

/**
 * (Forum)表控制层
 *
 * @author makejava
 * @since 2020-05-15 16:51:24
 */
@RestController
@RequestMapping("forum")
public class ForumController {
    /**
     * 服务对象
     */
    @Resource
    private ForumService forumService;

    @Autowired
    private JwtConfig jwtConfig;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Forum selectOne(Integer id) {
        return this.forumService.queryById(id);
    }

    @GetMapping(value = "/list", produces = "application/json;charset=UTF-8")
    public List<Forum> list(@RequestHeader("Auth") String auth) throws AuthenticationException {
        if(this.tokenCheck(auth)){
            throw new AuthenticationException("token不可用");
        }
        return this.forumService.list();
    }

    @PostMapping(value = "/detail", produces = "application/json;charset=UTF-8")
    public List<Forum> detail(@RequestHeader("Auth") String auth,
                        @RequestBody String forumOrderId)throws AuthenticationException{
        if(this.tokenCheck(auth)) {
            throw new AuthenticationException("token不可用");
        }
        if(forumOrderId == null) {
            throw new AuthenticationException("参数为空");
        }
        return this.forumService.detail(forumOrderId);
    }

    @PostMapping(value = "/like", produces = "application/json;charset=UTF-8")
    public Forum like(@RequestHeader("Auth") String auth,
                              @RequestBody forumRequestDao forumRequestDao)throws AuthenticationException{
        if(this.tokenCheck(auth)) {
            throw new AuthenticationException("token不可用");
        }
        if(forumRequestDao == null) {
            throw new AuthenticationException("参数为空");
        }
        Forum forum = new Forum();
        forum.setForumid(Integer.parseInt(forumRequestDao.getForumId()));
        forum.setLikes(Integer.parseInt(forumRequestDao.getLikes()));
        return this.forumService.update(forum);
    }

    @PostMapping(value = "/new", produces = "application/json;charset=UTF-8")
    public Integer newforum(@RequestHeader("Auth") String auth,
                           @RequestBody Forum forum)throws AuthenticationException{
        if(this.tokenCheck(auth)) {
            throw new AuthenticationException("token不可用");
        }
        if(forum == null) {
            throw new AuthenticationException("参数为空");
        }
        return this.forumService.newforum(forum);
    }

    @PostMapping(value = "/comment", produces = "application/json;charset=UTF-8")
    public Integer comment(@RequestHeader("Auth") String auth,
                      @RequestBody Forum forum)throws AuthenticationException{
        if(this.tokenCheck(auth)) {
            throw new AuthenticationException("token不可用");
        }
        if(forum == null) {
            throw new AuthenticationException("参数为空");
        }
        return this.forumService.comment(forum);
    }

    @PostMapping(value = "/report", produces = "application/json;charset=UTF-8")
    public Forum report(@RequestHeader("Auth") String auth,
                           @RequestBody forumRequestDao forumRequestDao)throws AuthenticationException{
        if(this.tokenCheck(auth)) {
            throw new AuthenticationException("token不可用");
        }
        if(forumRequestDao == null) {
            throw new AuthenticationException("参数为空");
        }
        Forum forum=new Forum();
        forum.setForumid(Integer.parseInt(forumRequestDao.getForumId()));
        forum.setIslocked(Integer.parseInt(forumRequestDao.getIsLocked()));
        return this.forumService.update(forum);
    }

    @GetMapping(value = "/reportlist", produces = "application/json;charset=UTF-8")
    public List<Forum> reportlist(@RequestHeader("Auth") String auth) throws AuthenticationException {
        if(this.tokenCheck(auth)){
            throw new AuthenticationException("token不可用");
        }
        return this.forumService.reportlist();
    }

    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public Forum delete(@RequestHeader("Auth") String auth,
                        @RequestBody forumRequestDao forumRequestDao)throws AuthenticationException{
        if(this.tokenCheck(auth)) {
            throw new AuthenticationException("token不可用");
        }
        if(forumRequestDao == null) {
            throw new AuthenticationException("参数为空");
        }
        Forum forum=new Forum();
        forum.setForumid(Integer.parseInt(forumRequestDao.getForumId()));
        forum.setIsdeleted(Integer.parseInt(forumRequestDao.getIsDeleted()));
        return this.forumService.update(forum);
    }

    public Boolean tokenCheck(String auth){
        Claims claims = jwtConfig.getClaimByToken(auth);
        return claims == null || JwtConfig.isTokenExpired(claims.getExpiration());
    }
}