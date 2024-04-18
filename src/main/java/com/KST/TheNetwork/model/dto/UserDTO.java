package com.KST.TheNetwork.model.dto;

import com.KST.TheNetwork.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long userId;
    private String username;
    private String email;
    private Role role;
    private Timestamp createdOn;
    private Timestamp updateOn;
}
