package com.ql.BlogApplication.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Table(name = "roles")
@Getter
@Setter

public class Role {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @Column(nullable = false,unique = true)
     String role_name;

     @ManyToMany(mappedBy = "roles")
     Set<User> users;

}

