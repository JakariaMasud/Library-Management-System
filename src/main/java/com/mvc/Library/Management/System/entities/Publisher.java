package com.mvc.Library.Management.System.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String name;
    @ManyToMany(mappedBy = "publishers",cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();
}
