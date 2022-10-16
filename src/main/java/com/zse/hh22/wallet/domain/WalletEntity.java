package com.zse.hh22.wallet.domain;

import com.zse.hh22.wallet.domain.document.Document;
import com.zse.hh22.wallet.domain.document.IdentityCard;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "wallets")
@Data
@Entity
@NoArgsConstructor
public class WalletEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Document> documents;

}
