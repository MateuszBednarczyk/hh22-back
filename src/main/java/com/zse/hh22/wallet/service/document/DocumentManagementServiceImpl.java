package com.zse.hh22.wallet.service.document;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class DocumentManagementServiceImpl implements DocumentManagementService {
    @Override
    public void verifyDocument(String pesel, String documentType) {
        // TODO Auto-generated method stub

    }
}
