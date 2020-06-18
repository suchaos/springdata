package com.suchaos.jpa.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Type 实体类
 *
 * @author suchao
 * @date 2020/6/17
 */
@Getter
@Setter
@ToString(exclude = {"articles"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    @Column
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "article_type",
            joinColumns =
            @JoinColumn(name = "tid", referencedColumnName = "tid"),
            inverseJoinColumns =
            @JoinColumn(name = "aid", referencedColumnName = "aid")
    )
    private Set<Article> articles = new HashSet<>();
}
