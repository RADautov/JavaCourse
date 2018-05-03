package ru.ivmiit.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "m_user")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "user_role", nullable = false, length = 10)
    private String role;

    @Column(name = "login", unique = true, nullable = false, length = 30)
    private String login;

    @Column(name = "hash_password", nullable = false)
    private String hashPassword;
}


