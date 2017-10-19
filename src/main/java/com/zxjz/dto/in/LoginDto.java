package com.zxjz.dto.in;

public class LoginDto {
    private String employees_num;
    private String login_password;

    public String getEmployees_num() {
        return employees_num;
    }

    public void setEmployees_num(String employees_num) {
        this.employees_num = employees_num;
    }

    public String getLogin_password() {
        return login_password;
    }

    public void setLogin_password(String login_password) {
        this.login_password = login_password;
    }

    @Override
    public String toString() {
        return "LoginDto{" +
                "employees_num='" + employees_num + '\'' +
                ", login_password='" + login_password + '\'' +
                '}';
    }
}
