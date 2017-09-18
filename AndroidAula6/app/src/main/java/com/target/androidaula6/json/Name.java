
package com.target.androidaula6.json;


public class Name {

    private String first;
    private String last;
    private String title;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Name() {
    }

    /**
     * 
     * @param title
     * @param last
     * @param first
     */
    public Name(String first, String last, String title) {
        super();
        this.first = first;
        this.last = last;
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
