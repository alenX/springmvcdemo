package org.wangss.Controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wangss.Mapper.SysUserMapper;
import org.wangss.Model.SysUser;
import org.wangss.Model.SysUserExample;


/**登录Controller
 * Created by wangss on 17-7-16.
 */
@RequestMapping("login")
@Controller
public class LoginController {

    @Autowired
    private SysUserMapper sysUserMapper;


    @RequestMapping("login")
    public String login(@RequestParam String username,@RequestParam String password){

        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        SysUserExample example = new SysUserExample();
        example.createCriteria().andUsernameEqualTo(username);
        SysUser user = sysUserMapper.selectByExample(example).get(0);
        subject.getSession().setAttribute("user",user);
        return  "succ";
    }
}
