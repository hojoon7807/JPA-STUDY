package example.mapping.domain;

import javax.persistence.Entity;

@Entity
public class Book extends Item2{
    private String author;
    private String isbn;
}
