package ra.model.entity;

import java.util.Date;

public class User {
    private int userId;
    private String userName;
    private String passwords;
    private String confirmPasswords;
    private String fullName;
    private Date birthdate;
    private String address;
    private String email;
    private String phone;
    private String image;
    private boolean permission;
    private boolean userStatus;

    public User() {
    }

    public User(int userId, String userName, String passwords, String confirmPasswords, String fullName, Date birthdate, String address, String email, String phone, String image, boolean permission, boolean userStatus) {
        this.userId = userId;
        this.userName = userName;
        this.passwords = passwords;
        this.confirmPasswords = confirmPasswords;
        this.fullName = fullName;
        this.birthdate = birthdate;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.image = image;
        this.permission = permission;
        this.userStatus = userStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public String getConfirmPasswords() {
        return confirmPasswords;
    }

    public void setConfirmPasswords(String confirmPasswords) {
        this.confirmPasswords = confirmPasswords;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }
}
