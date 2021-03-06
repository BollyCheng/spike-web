package com.bolly.spike.shiro.realm;

import com.bolly.spike.model.entity.ups.Application;
import com.bolly.spike.model.entity.ups.Module;
import com.bolly.spike.model.entity.ups.User;
import com.bolly.spike.model.util.ModelConvertUtil;
import com.bolly.spike.model.vo.ComboTreeVo;
import com.bolly.spike.service.ups.ApplicationService;
import com.bolly.spike.service.ups.ModuleService;
import com.bolly.spike.service.ups.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Author   : Bolly
 * CreateAt : 2018/05/05 09:30:55
 */
public class SpikeRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpikeRealm.class);

    @Resource
    private UserService userService;
    @Resource
    private ApplicationService applicationService;
    @Resource
    private ModuleService moduleService;

    /**
     * 授权
     *
     * @param principals 登录成功的用户凭证
     * @return 返回授权信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        LOGGER.info("Start authorization for login user. username={}", username);

        // ============================== 1.权限管理 ==============================
        List<String> permissionList = new ArrayList<>();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionList);

        return info;
    }

    /**
     * 认证
     *
     * @param token 登录的token
     * @return 返回认证信息
     * @throws AuthenticationException 认证失败
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        LOGGER.info("Validate user login information. username = {}", username);

        // ============================== 1.登录认证 ==============================
        if (StringUtils.isEmpty(username)) {
            throw new AccountException("Login account is empty.");
        }

        User user = userService.loadUserForLogin(username);
        if (user == null) {
            throw new UnknownAccountException("Not found account [" + username + "]");
        }

        String password = new String((char[]) token.getCredentials());
        if (!StringUtils.equals(password, user.getPassword())) {
            throw new IncorrectCredentialsException("Password is error. username=" + username);
        }
        LOGGER.info("Validate user information success. username={}", username);

        // ============================== 2.Session管理 ==============================
        Session session = SecurityUtils.getSubject().getSession();
        // 登录用户
        User loginUser = userService.loadByUsername(username);
        session.setAttribute("loginUser", loginUser);
        // 用户应用
        List<Application> applications = applicationService.list();
        session.setAttribute("userApplications", applications);
        // 用户的模块
        List<Module> modules = moduleService.list();
        List<ComboTreeVo> moduleTree = ModelConvertUtil.convert(modules, Module.class, "id", "name");
        session.setAttribute("userModules", moduleTree);

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, this.getName());
        return info;
    }

}
