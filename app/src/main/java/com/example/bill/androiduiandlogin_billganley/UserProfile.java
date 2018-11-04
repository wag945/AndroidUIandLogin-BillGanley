package com.example.bill.androiduiandlogin_billganley;

public class UserProfile {
    private long ID;
    private String firstname;
    private String surname;
    private String username;
    private String birthday;
    private String mobilePhone;
    private String email;
    private String password;

    public UserProfile(){}

    public UserProfile(String firstname, String surname){
        this.firstname = firstname;
        this.surname = surname;
    }

    public UserProfile (String firstname,
                        String surname,
                        String username,
                        String birthday,
                        String mobilePhone,
                        String email,
                        String password){
        this.firstname = firstname;
        this.surname = surname;
        this.username = username;
        this.birthday = birthday;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.password = password;
    }


    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMobilePhone(){return mobilePhone;}
    public void setMobilePhone(String mobilePhone) {this.mobilePhone = mobilePhone;}

    public String getEmail(){return this.email;}
    public void setEmail(String email){this.email = email;}

    public String getPassword(){return this.password;}
    public void setPassword(String password){this.password = password;}
    @Override
    public String toString() {
        return this.firstname + " " + this.surname;
    }
}
