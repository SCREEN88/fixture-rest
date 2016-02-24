package ru.hh.fixture;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDateTime;

@XmlRootElement
public class UserData implements Serializable {
    private String login;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDateTime creationTime;
    private String email;
    private int resumeViewLimit;
    private int userId;
    private long hhid;
    private int siteId;
    private int areaId;
    private AuthSystem authSystem;

    public UserData(String login, String password, String firstName, String middleName, String lastName, LocalDateTime creationTime, String email, int userId, long hhid) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.creationTime = creationTime;
        this.email = email;
        this.userId = userId;
        this.hhid = hhid;
        this.authSystem = AuthSystem.HH;
    }

    public UserData() {
        String sUnique = "sdfsdfvsdfbs";
        this.login = "u" + sUnique.toLowerCase() + "@example.com";
        this.firstName = "Fn" + sUnique.toLowerCase();
        this.middleName = "Mn" + sUnique.toLowerCase();
        this.lastName = "Ln" + sUnique.toLowerCase();
        this.password = "password";
        this.creationTime = LocalDateTime.now();
        this.email = this.login;
        this.resumeViewLimit = 500;
        this.siteId = 1;
        this.areaId = 113;
        this.authSystem = AuthSystem.HH;
    }

    public UserData(int userId, long hhid, UserData user) {
        this.login = user.login;
        this.password = user.password;
        this.firstName = user.firstName;
        this.middleName = user.middleName;
        this.lastName = user.lastName;
        this.creationTime = user.creationTime;
        this.email = user.email;
        this.resumeViewLimit = user.resumeViewLimit;
        this.siteId = user.siteId;
        this.areaId = user.areaId;
        this.hhid = hhid;
        this.userId = userId;
    }

    public UserData(String login, String password) {
        this();
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFullName() {
        return this.getLastName() + " " + this.getFirstName() + " " + this.getMiddleName();
    }

    public String getFamilyAndName() {
        return this.getLastName() + " " + this.getFirstName();
    }

    public LocalDateTime getCreationTime() {
        return this.creationTime;
    }

    public String getEmail() {
        return this.email;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getResumeViewLimit() {
        return this.resumeViewLimit;
    }

    public void setResumeViewLimit(int resumeViewLimit) {
        this.resumeViewLimit = resumeViewLimit;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getHhid() {
        return this.hhid;
    }

    public void setHhid(long hhid) {
        this.hhid = hhid;
    }

    public int getSiteId() {
        return this.siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public int getAreaId() {
        return this.areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public AuthSystem getAuthSystem() {
        return this.authSystem;
    }

    public void setAuthSystem(AuthSystem authSystem) {
        this.authSystem = authSystem;
    }
}