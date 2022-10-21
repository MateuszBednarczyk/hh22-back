package com.zse.hh22.wallet.domain;

import com.zse.hh22.user.domain.UserEntity;
import com.zse.hh22.wallet.domain.document.DriverLicenceEntity;
import com.zse.hh22.wallet.domain.document.IdentityCardEntity;
import com.zse.hh22.wallet.domain.document.PassportEntity;
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
    private IdentityCardEntity identityCard;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private PassportEntity passport;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private DriverLicenceEntity driverLicence;

    public static boolean isWalletCreated(UserEntity userEntity) {
        return userEntity.getWallet() != null;
    }

}
