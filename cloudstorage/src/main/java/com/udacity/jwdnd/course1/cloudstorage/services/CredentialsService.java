package com.udacity.jwdnd.course1.cloudstorage.services;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialsMapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;

@Service
public class CredentialsService {
	

    @Autowired
    private CredentialsMapper credentialsMapper;

    @Autowired
    private EncryptionService encryptionService;

    private Credentials encryptPassword(Credentials credential) {
        String key = RandomStringUtils.random(16, true, true);
        credential.setKey(key);
        credential.setPassword(encryptionService.encryptValue(credential.getPassword(), key));
        return credential;
    }

    public Credentials decryptPassword(Credentials credential) {
        credential.setPassword(encryptionService.decryptValue(credential.getPassword(), credential.getKey()));
        return credential;
    }

    public List<Credentials> getAllCredentials(int userid) {
      return credentialsMapper.findByUserId(userid);
    }

    public void addCredential(Credentials credential, int userid) {
        credentialsMapper.insertCredentials(encryptPassword(credential), userid);
    }

    public void updateCredential(Credentials credential) {
        credentialsMapper.updateCredentials(encryptPassword(credential));
    }

    public void deleteCredential(String credusername) {
        credentialsMapper.deleteCredentials(credusername);
    }
}
