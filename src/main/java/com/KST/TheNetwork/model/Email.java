package com.KST.TheNetwork.model;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Email {
    private String subject;
    private String to;
    private String body;
}
