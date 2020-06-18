package com.suchaos.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Article 实体类
 *
 * @author suchao
 * @date 2020/6/17
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne
    private Integer aid;

    @Column(name = "author")
    private String author;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "title")
    private String title;
}
