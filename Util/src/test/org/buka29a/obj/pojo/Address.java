package org.buka29a.obj.pojo;

import org.buka29a.obj.format.DataField;
import org.buka29a.obj.format.DataTable;
import org.buka29a.obj.type.DataType;

@DataTable(name = "test.address")
public class Address {
    @DataField(name = "country", type = DataType.VARCHAR)
    private String country;
    @DataField(name = "state", type = DataType.VARCHAR)
    private String state;
    @DataField(name = "city", type = DataType.VARCHAR)
    private String city;
    @DataField(name = "zip", type = DataType.VARCHAR)
    private String zip;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
