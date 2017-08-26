package com.spring.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User extends AbstractPersistable<Long> {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    private String name;

    private String email;
    private String password;
    private String gender;

    @OneToMany(mappedBy = "user")
    List<Article> articles = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }
}
