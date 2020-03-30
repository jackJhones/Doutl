package org.buka29a.obj;

import org.buka29a.obj.pojo.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class DataContainerTests {

    @Test
    public void objectToMapIgnoreNullFieldsTest() {
        Map<String, Object> userData = new HashMap<>();
        userData.put("id", 100);
        userData.put("firstName", "Alex");
        userData.put("lastName", "Hoffman");
        userData.put("active", true);

        User actual = new User().initialize(userData);

        Assert.assertEquals(userData, actual.toMap(true));
    }

    @Test
    public void objectToMapWithNullFieldsTest() {
        Map<String, Object> userData = new HashMap<>();
        userData.put("id", 100);
        userData.put("firstName", "Alex");
        userData.put("lastName", "Hoffman");
        userData.put("active", true);

        User actual = new User().initialize(userData);

        Assert.assertEquals(new HashSet<>(Arrays.asList("id", "firstName", "lastName", "active", "metadata")),
                actual.toMap(false).keySet());
    }

    @Test
    public void initializedFieldsTest() {
        Map<String, Object> userData = new HashMap<>();
        userData.put("id", 100);
        userData.put("first_Name", "Alex");
        userData.put("last_Name", "Hoffman");
        userData.put("active", true);

        User actual = new User().initialize(userData);

        Assert.assertEquals(Arrays.asList("id", "firstName", "lastName", "active"), actual.initializedFields());
    }

    @Test
    public void notInitializedFieldsTest() {
        Map<String, Object> userData = new HashMap<>();
        userData.put("id", 100);
        userData.put("firstName", "Alex");
        userData.put("lastName", "Hoffman");
        userData.put("active", true);

        User actual = new User().initialize(userData);

        Assert.assertEquals(Collections.singletonList("metadata"), actual.notInitializedFields());
    }

    @Test
    public void convertFieldsTypeTest() {
        Map<String, Object> userData = new HashMap<>();
        userData.put("id", "101");
        userData.put("firstName", 1000L);
        userData.put("active", "false");

        User actual = new User().initialize(userData);

        Assert.assertEquals(new Integer(101), actual.getId());
        Assert.assertEquals("1000", actual.getFirstName());
        Assert.assertEquals(new Boolean(false), actual.getActive());
    }

    @Test(expected = ClassCastException.class)
    public void typeCastExceptionTest() {
        Map<String, Object> userData = new HashMap<>();
        userData.put("id", 102);
        userData.put("metadata", "1");

        User actual = new User().initialize(userData);
    }

    @Test
    public void convertSubTypeTest() {
        Map<String, Object> userData = new HashMap<>();
        userData.put("id", "99");
        userData.put("metadata.createdDate", "10-10-2001");
        userData.put("metadata.updatedDate", "10-10-2002");

        User actual = new User().initialize(userData);

        Assert.assertEquals(new Integer(99), actual.getId());
        Assert.assertEquals("10-10-2001", actual.getMetadata().getCreatedDate());
        Assert.assertEquals("10-10-2002", actual.getMetadata().getUpdatedDate());
    }
}
