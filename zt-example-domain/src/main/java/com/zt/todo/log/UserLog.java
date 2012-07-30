package com.zt.todo.log;

/**
 * Created with IntelliJ IDEA.
 * User: zhangtan
 * Date: 12-7-29
 * Time: 上午11:50
 * To change this template use File | Settings | File Templates.
 */
public class UserLog {

    private String operater;//操作人
    private String message;//操作记录

    public UserLog(String operater, String message) {
        this.operater = operater;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOperater() {
        return operater;
    }

    public void setOperater(String operater) {
        this.operater = operater;
    }
}
