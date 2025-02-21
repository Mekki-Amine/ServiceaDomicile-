package org.example.homeservices.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@RequiredArgsConstructor

public class Utilisateur implements Serializable , UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nom;

    @NotBlank
    private String prenom;

    @NotNull
    private Date dateNaissance;

    @NotBlank
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

    @CreationTimestamp
    private LocalDateTime creationDate;

    @UpdateTimestamp
    private LocalDateTime modificationDate;


    private boolean isEmailVerified;
    private boolean isPhoneVerified;

    private String verificationCodeEmail;
    private String verificationCodeTelephone;

    @Embedded
    private Location location;

    @NotBlank
    private String specialite;

    private boolean disponible;

    @OneToMany(mappedBy = "utilisateur")
    private List<Reservation> reservations ;

    @ManyToOne
    private Servicees serviceees;


    @OneToMany(mappedBy = "utilisateur")
    private List<Paiement> paiements;


    @Embeddable
    public class Location {
        private Double latitude;
        private Double longitude;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }



    public String getNom() {
        return nom;
    }

    public String getPassword() {
        return password;
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