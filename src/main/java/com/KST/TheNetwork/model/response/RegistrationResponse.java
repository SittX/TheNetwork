package com.KST.TheNetwork.model.response;

import com.KST.TheNetwork.model.dto.UserDTO;

public record RegistrationResponse(String token, UserDTO user){};