package it.academy.entity.account.user;

import it.academy.entity.account.Account;
import it.academy.entity.account.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor

public class User extends Account {
    @Column(name = "date", nullable = false)
    private LocalDate dateOfBirthday;
    @Column(name = "language", nullable = false)
    @Enumerated(EnumType.STRING)
    private Language language;
    @ManyToOne
    @JoinColumn(name = "friend_id")
    private Friends friends;

    public User(Address address, String name, String login, String password, String email, LocalDate dateOfBirthday, Language language) {
        super(address, name, login, password, email);
        this.dateOfBirthday = dateOfBirthday;
        this.language = language;
    }

}
