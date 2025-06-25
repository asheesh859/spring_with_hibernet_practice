    package com.demo.entity;

    import jakarta.persistence.*;

    import java.util.ArrayList;
    import java.util.List;

    @Entity
    @Table(name = "Post_1")
    public class Post_1 {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;


        @OneToMany(mappedBy = "post_1", cascade = CascadeType.ALL)
        private List<Comments_1> comments_1 = new ArrayList<>();

    //    @OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    //    @JoinColumn(name = "post_id")
    //    private List<Comments_1> comments_1 = new ArrayList<>();


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<Comments_1> getComments_1() {
            return comments_1;
        }

        public void setComments_1(List<Comments_1> comments_1) {
            this.comments_1 = comments_1;
        }
    }
