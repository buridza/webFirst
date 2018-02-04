package it.academy.entity.account.admin;


import it.academy.entity.account.Account;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@ToString
@Entity
@DiscriminatorValue("admin")
public class Admin extends Account {
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
}

