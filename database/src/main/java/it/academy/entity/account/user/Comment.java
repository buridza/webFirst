package it.academy.entity.account.user;

import it.academy.entity.BaseEntity;
import it.academy.entity.game.Game;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "comments")
public class Comment extends BaseEntity {
    @Column(name = "rating", nullable = false)
    private int rating;
    @Column(name = "message")
    private String message;
    @ManyToOne
    @JoinColumn(name = "name")
    private Game game;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
