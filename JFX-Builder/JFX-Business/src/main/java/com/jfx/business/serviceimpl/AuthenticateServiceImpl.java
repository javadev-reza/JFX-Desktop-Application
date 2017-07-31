package com.jfx.business.serviceimpl;

import com.jfx.business.service.AuthenticateService;
import com.jfx.library.util.CommonUtil;
import com.jfx.library.util.PasswordUtil;
import com.jfx.library.util.RestUtil;
import java.io.IOException;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateServiceImpl extends RestUtil implements AuthenticateService{
    
    @Override
    public Map authenticate(String userName, String password){
        try {
            authenticate("/auth/login-user", userName, password);
            if(userName.equalsIgnoreCase(getUserName())){
                if(new PasswordUtil().isPasswordEqual(password, getPassword())){
                    setResult("auth", true);
                } 
            } else{
                setResult("auth", false);
            }
            if(CommonUtil.isNotNullOrEmpty(getStatus())){
                if(getStatus()!=200){
                    setResult("message", getErrorMessage());
                } else{
                    setResult("message", getUserName());
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return getResult();
    }
    
    @Override
    public Map checkAuth(){
        if(CommonUtil.isNotNullOrEmpty(getToken())){
            setResult("auth", true);
        } else{
            setResult("auth", false);
        }
        return getResult();
    }
    
}
