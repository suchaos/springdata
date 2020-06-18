package com.suchaos.jpa.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Comment 实体类
 *
 * @author suchao
 * @date 2020/6/17
 */
@Getter
@Setter
//@ToString(exclude = {"article"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;

    @Column
    private String comment;

    @ManyToOne
    @JoinColumn(name = "aid", referencedColumnName = "aid")
    private Article article;

    @Override
    public String toString() {
        return "Comment{" +
                "cid=" + cid +
                ", comment='" + comment + '\'' +
                ", article.aid=" + article.getAid() +
                ", article.title=" + article.getTitle() +
                '}';
    }
}
