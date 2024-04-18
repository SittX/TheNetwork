package com.KST.TheNetwork.controller;

import com.KST.TheNetwork.model.User;
import com.KST.TheNetwork.model.request.LoginRequest;
import com.KST.TheNetwork.model.request.RegistrationRequest;
import com.KST.TheNetwork.model.response.RegistrationResponse;
import com.KST.TheNetwork.service.AuthService;
import com.KST.TheNetwork.service.UserService;
import com.KST.TheNetwork.service.VerificationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final VerificationTokenService verificationTokenService;
    private final UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<RegistrationResponse> signUp(@RequestBody RegistrationRequest registrationRequest) {
        return ResponseEntity.ok(authService.signUp(registrationRequest));
    }

    @GetMapping("/verify/{token}")
    public ResponseEntity<String> accountVerification(@PathVariable("token") String token) {
        User user = verificationTokenService.findByToken(token);
        user.setEnable(true);
        userService.save(user);

        return ResponseEntity.ok("Account have been verified. You can return to the Login page.");
    }

    @GetMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        Authentication authentication = authService.login(request);
        return "Login";
    }
}
