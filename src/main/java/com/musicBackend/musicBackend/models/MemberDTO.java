package com.musicBackend.musicBackend.models;

import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode
public class MemberDTO {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String password;
    private String matchingPassword;

    @NotNull
    private String email;

}
