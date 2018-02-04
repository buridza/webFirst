package it.academy.entity;

import it.academy.entity.account.user.User;
import it.academy.entity.game.Game;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "purchase")
public class Purchase extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @JoinColumn(name = "game_id")
    private Game game;
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private boolean paymentStatus;
}
