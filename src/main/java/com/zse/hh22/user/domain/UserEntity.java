package com.zse.hh22.user.domain;

import com.zse.hh22.civicproject.domain.CivicProjectEntity;
import com.zse.hh22.user.api.UserRegisterDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Table(name = "users")
@Entity
@NoArgsConstructor
@Data
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private String surname;
    private String email;
    private String city;

    @Pattern(regexp = "[\\d]{11}")
    private String pesel;
    private String phoneNumber;
    private String password;

    @Enumerated(EnumType.ORDINAL)
    private Role role;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<CivicProjectEntity> civicProjects;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private CivicProjectEntity likedCivicProject;

    public UserEntity(UserRegisterDTO registerDTO, PasswordEncoder passwordEncoder) {
        this.name = registerDTO.name();
        this.surname = registerDTO.surname();
        this.email = registerDTO.email();
        this.city = registerDTO.city();
        this.pesel = registerDTO.pesel();
        this.phoneNumber = registerDTO.phoneNumber();
        this.password = passwordEncoder.encode(registerDTO.password());
        this.role = Role.ROLE_USER;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.pesel;
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
        return true;
    }
}
