package com.jfx.business.service;

import java.util.Map;

public interface AuthenticateService {
    public Map authenticate(String userName, String password);
    public Map checkAuth();
}
