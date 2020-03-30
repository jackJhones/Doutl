package org.buka29a.obj.pojo;

import org.buka29a.obj.model.DataContainer;

public class Metadata extends DataContainer<Metadata> {
    private String createdDate;
    private String updatedDate;

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }
}
