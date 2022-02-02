package com.iti.dbapp.db;

import java.util.Date;

public class Contact {
    private int id;
    private String name, nName, address, hPhone, wPhone, cPhone, eMail, webSite, prof;
    private Date bDate;

    public Contact() {

    }

    public Contact(int id, String name, String nName, String address, String hPhone, String wPhone, String cPhone, String eMail, String webSite, String prof, Date bDate) {
        this.id = id;
        this.name = name;
        this.nName = nName;
        this.address = address;
        this.hPhone = hPhone;
        this.wPhone = wPhone;
        this.cPhone = cPhone;
        this.eMail = eMail;
        this.webSite = webSite;
        this.prof = prof;
        this.bDate = bDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getnName() {
        return nName;
    }

    public void setnName(String nName) {
        this.nName = nName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String gethPhone() {
        return hPhone;
    }

    public void sethPhone(String hPhone) {
        this.hPhone = hPhone;
    }

    public String getwPhone() {
        return wPhone;
    }

    public void setwPhone(String wPhone) {
        this.wPhone = wPhone;
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public Date getbDate() {
        return bDate;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }
}
