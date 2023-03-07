package com.mvc.Library.Management.System.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String isbn;
    private String name;
    private String description;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Author> authors = new HashSet<>();
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Category> categories = new HashSet<>();
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Publisher> publishers = new HashSet<>();
}
