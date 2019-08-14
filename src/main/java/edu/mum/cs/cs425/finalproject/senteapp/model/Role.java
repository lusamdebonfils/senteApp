package edu.mum.cs.cs425.finalproject.senteapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author okalu
 *
 */
@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false, unique=true)
    @NotEmpty
    private String name;

    @ManyToMany(mappedBy="roles")
    private List<User> users;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
