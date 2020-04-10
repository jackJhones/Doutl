package org.buka29a.obj.pojo;

import org.buka29a.obj.format.DataField;
import org.buka29a.obj.format.DataTable;
import org.buka29a.obj.model.DataContainer;
import org.buka29a.obj.type.DataType;

import java.util.List;

@DataTable(name = "test.user")
public class User extends DataContainer<User> {
    @DataField(name = "id", type = DataType.INT)
    private Integer id;
    @DataField(name = "first_name", type = DataType.VARCHAR)
    private String firstName;
    @DataField(name = "last_name", type = DataType.VARCHAR)
    private String lastName;
    private Address[] addressList;
    @DataField(name = "active", type = DataType.BOOLEAN)
    private Boolean active;
    @DataField(name = "groups", type = DataType.VARCHAR)
    private List<UserGroup> groupList;
    private Metadata metadata;

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

    public List<UserGroup> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<UserGroup> groupList) {
        this.groupList = groupList;
    }

    public Address[] getAddressList() {
        return addressList;
    }

    public void setAddressList(Address[] addressList) {
        this.addressList = addressList;
    }
}
