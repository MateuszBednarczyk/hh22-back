package com.zse.hh22.user.domain;

import com.zse.hh22.civicproject.domain.CivicProjectEntity;
import com.zse.hh22.user.api.UserRegisterDTO;
import com.zse.hh22.wallet.domain.WalletEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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

    @NotBlank(message = "Name cannot be blank")
    private String firstName;

    @Nullable
    private String secondName;

    @NotBlank(message = "Surname cannot be blank")
    private String surname;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "City cannot be blank")
    private String city;

    @Pattern(regexp = "[\\d]{11}")
    private String pesel;

    @NotBlank(message = "Phone number cannot be blank")
    private String phoneNumber;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    @Enumerated(EnumType.ORDINAL)
    private Role role;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<CivicProjectEntity> civicProjects;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private CivicProjectEntity likedCivicProject;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private WalletEntity wallet;

    public UserEntity(UserRegisterDTO registerDTO, PasswordEncoder passwordEncoder) {
        this.firstName = registerDTO.firstName();
        this.secondName = registerDTO.secondName();
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
