package com.example.realm;

import com.example.bean.Owner;
import com.example.service.OwnerService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/8/19.
 */
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private OwnerService ownerService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String phone = token.getUsername();
        Owner owner = ownerService.getOwnerByPhone(phone);
        return new SimpleAuthenticationInfo(owner, owner.getPassword(), this.getClass().getName());
    }
}
