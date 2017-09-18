
package com.target.androidaula6.json;

import java.util.List;

public class DataSet {

    private List<User> users = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DataSet() {
    }

    /**
     * 
     * @param users
     */
    public DataSet(List<User> users) {
        super();
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
