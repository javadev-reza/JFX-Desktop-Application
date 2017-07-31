package com.jfx.library.util;

import com.jfx.library.constant.Constants;
import com.jfx.library.dbhelper.SqLiteHelper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriBuilderException;

/**
 *
 * @author Reza
 */
public class RestUtil extends RestUtilModel{
    
    
    /**
     * @param URL
     * @return 
     */
    public String contextPath(String URL){
        String extented = Constants.CONTEXT_PATH.SERVER+URL;
        return extented;
    }
    
    /**
     * @param URL
     * @param USERNAME
     * @param PASSWORD
     */
    public void authenticate(String URL, String USERNAME, String PASSWORD) {
        authResponse(contextPath(URL), USERNAME, PASSWORD);
        if(CommonUtil.isNotNullOrEmpty(getToken())){
            SqLiteHelper sqlite = new SqLiteHelper();
            if(sqlite.checkExistingToken()!=0){
                sqlite.updateToken(getToken());
                sqlite.logging(getUserName(), DateUtil.now().toString());
            } else{
                sqlite.saveToken(getToken());
                sqlite.logging(getUserName(), DateUtil.now().toString());
            }
        }
    }

    /**
     * @param URL
     * @param USERNAME
     * @param PASSWORD
     * @return 
     */
    public Map authRequest(String URL, String USERNAME, String PASSWORD) {
        Map<String, Object> result = new HashMap<>();
        try {
            DefaultClientConfig config = new DefaultClientConfig();
            Client client = Client.create((ClientConfig)config);
            WebResource service = client.resource(UriBuilder.fromUri((String)URL).build(new Object[0]));
            Map<String, Object> body = new HashMap<>();
            body.put("userName", USERNAME);
            body.put("password", PASSWORD);
            ClientResponse response = (ClientResponse)service.type("application/json").post(ClientResponse.class, (Object)JsonUtil.MapToJson(body));
            setStatus(response.getStatus());
            result = JsonUtil.JsonToMap((String)response.getEntity(String.class));
        }
        catch (IllegalArgumentException | UriBuilderException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * @param URL
     * @param USERNAME
     * @param PASSWORD 
     */
    public void authResponse(String URL, String USERNAME, String PASSWORD) {
        Map<String, Object> response = authRequest(URL, USERNAME, PASSWORD);
        if (CommonUtil.isNotNullOrEmpty(response)) {
            Map<String, Object> data = (Map)response.get("data");
            Map<String, Object> messages = (Map)response.get("messages");
            
            if (CommonUtil.isNotNullOrEmpty(data)) {
                if(CommonUtil.isNotNullOrEmpty(data.get("userName"))){
                    setUserName((String) data.get("userName"));
                } 
                if(CommonUtil.isNotNullOrEmpty(data.get("password"))){
                    setPassword((String) data.get("password"));
                }
                if(CommonUtil.isNotNullOrEmpty(messages.get("X-AUTH-TOKEN"))){
                    setToken((String)messages.get("X-AUTH-TOKEN"));
                }
            } else{
                if(CommonUtil.isNotNullOrEmpty(messages.get("ERROR_MESSAGE"))){
                    setErrorMessage((String)messages.get("ERROR_MESSAGE"));
                }
            }
        }
    }
    
    //--------------------------------------------------------------------------

}