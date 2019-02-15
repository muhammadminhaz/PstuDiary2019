package com.minhaz.muhammad.pstudiary2019;

public class Child {

    private String name;
    private String occupation;
    private String dept;
    private String mobile;
    private String mail;

    public Child(String name,String occupation, String mobile, String mail )
    {
        //super();
        this.occupation=occupation;
        this.name=name;
        this.mobile=mobile;
        this.mail=mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getDept() {
        return this.dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
