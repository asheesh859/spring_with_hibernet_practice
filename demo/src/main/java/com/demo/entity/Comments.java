package com.demo.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column(name="name" , nullable = false , length = 128)
    private String name;

    @Column(name = "description" , nullable= false, length = 1028)
    private String description;


    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

}
