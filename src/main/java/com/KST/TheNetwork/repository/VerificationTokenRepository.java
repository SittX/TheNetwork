package com.KST.TheNetwork.repository;

import com.KST.TheNetwork.model.User;
import com.KST.TheNetwork.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Long> {
    public VerificationToken findByToken(String token);
}
