package com.suchaos.jpa.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Article 实体类
 *
 * @author suchao
 * @date 2020/6/17
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aid;

    @Column(name = "author")
    private String author;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "title")
    private String title;

    @OneToOne(mappedBy = "article", cascade = CascadeType.ALL)
    private ArticleData articleData;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Comment> comments = new HashSet<>();

    @ManyToMany(mappedBy = "articles", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Type> types = new HashSet<>();
}
