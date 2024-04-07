package com.KST.TheNetwork.service;

import com.KST.TheNetwork.model.*;
import com.KST.TheNetwork.model.request.LoginRequest;
import com.KST.TheNetwork.model.request.RegistrationRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final VerificationTokenService verificationTokenService;
    private final MailService mailService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Value("${app.email.mail_verification_url}")
    private String MAIL_VERIFY_URL;

    @Transactional
    public String signUp(RegistrationRequest registrationRequest){
        User user = User.builder()
                .username(registrationRequest.getUsername())
                .password(passwordEncoder.encode(registrationRequest.getPassword()))
                .email(registrationRequest.getEmail())
                .role(Role.USER)
                .enable(false)
                .build();

        this.userService.save(user);
        VerificationToken token = setUserVerificationToken(user);

        Email verificationEmail = new Email();
        verificationEmail.setSubject("Account verification for the new account SignUp.");
        verificationEmail.setTo(user.getEmail());
//        verificationEmail.setBody("http://localhost:8080/api/auth/verify/" + token.getToken());
        verificationEmail.setBody(this.MAIL_VERIFY_URL + token.getToken());
        mailService.sendEmail(verificationEmail);

        return jwtService.generateToken(user);
    }

    private VerificationToken setUserVerificationToken(User user){
        UUID uuid = UUID.randomUUID();
        VerificationToken token = new VerificationToken();
        token.setUser(user);
        token.setToken(uuid.toString());
        token.setExpiryDate(Date.valueOf(LocalDate.now().plusDays(2)));
        return this.verificationTokenService.save(token);
    }

    public Authentication login(LoginRequest loginRequest){
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword());
        return authenticationManager.authenticate(authToken);
    }
}
