package lekang.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class Person extends BaseEnity{
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
}
