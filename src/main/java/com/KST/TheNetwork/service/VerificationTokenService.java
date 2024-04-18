package com.KST.TheNetwork.service;

import com.KST.TheNetwork.model.User;
import com.KST.TheNetwork.model.VerificationToken;
import com.KST.TheNetwork.repository.VerificationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VerificationTokenService {
    private VerificationTokenRepository verificationTokenRepository;

    public VerificationToken save(VerificationToken token) {
        if (token == null) throw new RuntimeException("Token cannot be empty");

        return this.verificationTokenRepository.save(token);
    }

    public User findByToken(String token) {
        if (token == null) throw new RuntimeException("Id cannot be 0");

        return this.verificationTokenRepository.findByToken(token).getUser();
    }
}
