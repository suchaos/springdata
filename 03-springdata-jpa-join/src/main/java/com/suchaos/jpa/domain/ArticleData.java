package com.suchaos.jpa.domain;

import lombok.*;

import javax.persistence.*;

/**
 * ArticleData
 *
 * @author suchao
 * @date 2020/6/18
 */
@Getter
@Setter
@ToString(exclude = {"article"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "article_data")
public class ArticleData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "content")
    private String content;

    @OneToOne
    @JoinColumn(name = "article_id", referencedColumnName = "aid", unique = true)
    private Article article;
}
