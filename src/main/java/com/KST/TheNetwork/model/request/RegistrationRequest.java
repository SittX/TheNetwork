package com.KST.TheNetwork.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationRequest {
    private String username;
    private String password;
    private String email;
}
