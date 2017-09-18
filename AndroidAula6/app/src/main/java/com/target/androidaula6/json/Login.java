
package com.target.androidaula6.json;


public class Login {

    private String md5;
    private String password;
    private String salt;
    private String sha1;
    private String sha256;
    private String username;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Login() {
    }

    /**
     * 
     * @param username
     * @param sha256
     * @param md5
     * @param sha1
     * @param password
     * @param salt
     */
    public Login(String md5, String password, String salt, String sha1, String sha256, String username) {
        super();
        this.md5 = md5;
        this.password = password;
        this.salt = salt;
        this.sha1 = sha1;
        this.sha256 = sha256;
        this.username = username;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    public String getSha256() {
        return sha256;
    }

    public void setSha256(String sha256) {
        this.sha256 = sha256;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
