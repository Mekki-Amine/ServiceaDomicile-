package org.example.homeservices.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Utilisateur implements Serializable , UserDetails {

    @Serial
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nom;

    @NotBlank
    private String prenom;

    @NotNull
    private Date dateNaissance;

    private Character sexe;
    @NotBlank

    private String adresse;

    @Email
    @NotBlank
    private String email;

    @Size(min = 8, max = 10)
    private String password;

    @NotBlank
    private String telephone;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean isEmailVerified;
    private boolean isPhoneVerified;

    private String verificationCodeEmail;
    private String verificationCodeTelephone;

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {}

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {}

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); // Vous pouvez ajouter des rôles si nécessaire
    }

    @Override
    public String getUsername() {
        return email; // L'email est utilisé comme identifiant
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true; // Vous pouvez modifier cette logique selon votre besoin
    }




}