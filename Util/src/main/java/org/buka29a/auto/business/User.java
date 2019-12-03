package org.buka29a.auto.business;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.buka29a.auto.model.DataContainer;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class User extends DataContainer<User> {

    private Integer id;
    private String firstName;
    private String lastName;
    private Boolean active;
}
