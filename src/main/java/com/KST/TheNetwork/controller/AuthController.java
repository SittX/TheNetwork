package com.KST.TheNetwork.controller;

import com.KST.TheNetwork.model.request.LoginRequest;
import com.KST.TheNetwork.model.request.RegistrationRequest;
import com.KST.TheNetwork.model.User;
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
    public ResponseEntity<String> signUp(@RequestBody RegistrationRequest registrationRequest){
        return ResponseEntity.ok(authService.signUp(registrationRequest));
    }

    @GetMapping("/verify/{token}")
    public String accountVerification(@PathVariable("token") String token){
        System.out.println(token);
        User user = verificationTokenService.findByToken(token);
        user.setEnable(true);
        System.out.println(user.getUsername());

        userService.save(user);
        return "Account : " + user.getUsername() + " Status : " + user.isEnable();
    }

    @GetMapping("/login")
    public String login(@RequestBody LoginRequest request){
        Authentication authentication = authService.login(request);
       return "Login";
    }
}
