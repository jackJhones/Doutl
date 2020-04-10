package org.buka29a.obj.pojo;

import org.buka29a.obj.format.DataField;
import org.buka29a.obj.format.DataTable;
import org.buka29a.obj.model.DataContainer;
import org.buka29a.obj.type.DataType;

@DataTable(name = "test.user_auxiliary")
public class Metadata extends DataContainer<Metadata> {
    @DataField(name = "created_date", type = DataType.TIMESTAMP)
    private String createdDate;
    @DataField(name = "updated_date", type = DataType.TIMESTAMP)
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
