package com.jfx.library.superclass;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Reza
 */
public class BaseTemp {
    
    private Map<String, Object> result = new HashMap<>();
    private Map<String, String> message = new HashMap<>();
    private Map<String, Object> container = new HashMap<>();;

    /**
     * @return the result
     */
    public Map<String, Object> getResult() {
        return result;
    }

    /**
     * @param key
     * @param result the result to set
     */
    public void setResult(String key, Object result) {
        this.getResult().put(key, result);
    }

    /**
     * @return the message
     */
    public Map<String, String> getMessage() {
        return message;
    }

    /**
     * @param key
     * @param result
     */
    public void setMessage(String key, String result) {
        this.getMessage().put(key, result);
    }

    /**
     * @return the container
     */
    public Map<String, Object> getContainer() {
        return container;
    }

    /**
     * @param container the container to set
     */
    public void setContainer(Map<String, Object> container) {
        this.container.clear();
        this.container = container;
    }

}