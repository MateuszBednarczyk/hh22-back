package com.zse.hh22.wallet.domain;

import com.zse.hh22.wallet.domain.identitycard.IdentityCard;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "wallets")
@Data
@Entity
@NoArgsConstructor
public class WalletEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private IdentityCard identityCard;

}
