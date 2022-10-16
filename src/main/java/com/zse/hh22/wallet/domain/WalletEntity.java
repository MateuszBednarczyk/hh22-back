package com.zse.hh22.wallet.domain;

import com.zse.hh22.user.domain.UserEntity;
import com.zse.hh22.wallet.api.CreateIdentityCardDTO;
import com.zse.hh22.wallet.domain.document.Document;
import com.zse.hh22.wallet.domain.document.IdentityCard;
import com.zse.hh22.wallet.exception.WalletDoesNotExistOrDocumentOfRquestedTypeIsAlreadyCreated;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.security.Principal;
import java.util.List;

import static com.zse.hh22.wallet.domain.document.Document.isDocumentOfGivenTypeCreated;
import static com.zse.hh22.wallet.domain.document.Document.isWalletCreated;

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

    private void addDocument(Document document) {
        this.documents.add(document);
    }

    public void createNewDocument(Document document) {
        if (isDocumentOfGivenTypeCreated(this, IdentityCard.class)) {
            addDocument(document);
        } else {
            throw new WalletDoesNotExistOrDocumentOfRquestedTypeIsAlreadyCreated();
        }
    }
}
