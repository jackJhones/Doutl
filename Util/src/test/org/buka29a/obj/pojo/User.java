package org.buka29a.obj.pojo;

import org.buka29a.obj.model.DataContainer;

public class User extends DataContainer<User> {
    private Integer id;
    private String firstName;
    private String lastName;
    private Boolean active;
    private Metadata metadata;

    public User() {
    }

    public User(Integer id, String firstName, String lastName, Boolean active, Metadata metadata) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
        this.metadata = metadata;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }
}
