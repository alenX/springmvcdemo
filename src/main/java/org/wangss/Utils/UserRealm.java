package org.wangss.Utils;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.wangss.Mapper.SysUserMapper;
import org.wangss.Model.SysAuth;
import org.wangss.Model.SysRole;
import org.wangss.Model.SysUser;
import org.wangss.Model.SysUserExample;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangss on 17-7-16.
 */
public class UserRealm extends AuthorizingRealm {
    // 用户对应的角色信息与权限信息都保存在数据库中，通过UserService获取数据
    @Autowired
    private SysUserMapper userService;

    /**
     * 提供用户信息返回权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 根据用户名查询当前用户拥有的角色
        Set<SysRole> roles = userService.findRoles(username);
        Set<String> roleNames = new HashSet<String>();
        for (SysRole role : roles) {
            roleNames.add(role.getRolename());
        }
        // 将角色名称提供给info
        authorizationInfo.setRoles(roleNames);
        // 根据用户名查询当前用户权限
        Set<SysAuth> permissions = userService.findPermissions(username);
        Set<String> permissionNames = new HashSet<String>();
        for (SysAuth permission : permissions) {
            permissionNames.add(permission.getAuthname());
        }
        // 将权限名称提供给info
        authorizationInfo.setStringPermissions(permissionNames);

        return authorizationInfo;
    }

    /**
     * 提供账户信息返回认证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        SysUserExample example = new SysUserExample();
        example.createCriteria().andUsernameEqualTo(username);
        SysUser user = userService.selectByExample(example).get(0);
        if (user == null) {
            // 用户名不存在抛出异常
            throw new UnknownAccountException();
        }
        /*if (user.getLocked() == 0) {
            // 用户被管理员锁定抛出异常
            throw new LockedAccountException();
        }*/
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(),
                user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
        return authenticationInfo;
    }
}