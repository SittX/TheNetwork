package com.KST.TheNetwork.model.response;

import com.KST.TheNetwork.model.dto.UserDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationResponse {
    private String token;
    private UserDTO user;
}
