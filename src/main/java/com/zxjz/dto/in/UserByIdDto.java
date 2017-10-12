package com.zxjz.dto.in;

public class UserByIdDto {
    private String user_id;
    private String password;
    private String newPwd;

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserByIdDto{" +
                "user_id='" + user_id + '\'' +
                ", password='" + password + '\'' +
                ", newPwd='" + newPwd + '\'' +
                '}';
    }
}
