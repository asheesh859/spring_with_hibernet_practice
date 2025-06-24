package com.demo.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "comments_1")
public class Comments_1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    public Post_1 getPost_1() {
        return post_1;
    }

    public void setPost_1(Post_1 post_1) {
        this.post_1 = post_1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post_1 post_1;
}
