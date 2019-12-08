package com.example.remindmeapp;

/**
 * The type Pml.
 */
class Pml {

    /*
    Create two strings to call from toDo.json
     */

    private String title;
    private String tdl;


    /*
    Generate Constructors
     */

    /**
     * Instantiates a new Pml.
     *
     * @param title the title
     * @param tdl   the tdl
     */
    public Pml(String title, String tdl) {
        this.title = title;
        this.tdl = tdl;

    }

    /**
     * Instantiates a new Pml.
     */
    public Pml() {
    }
    /*

    Generate Getters and Setters
    */

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets tdl.
     *
     * @return the tdl
     */
    public String getTdl() {
        return tdl;
    }

    /**
     * Sets tdl.
     *
     * @param tdl the tdl
     */
    public void setTdl(String tdl) {
        this.tdl = tdl;
    }
}
