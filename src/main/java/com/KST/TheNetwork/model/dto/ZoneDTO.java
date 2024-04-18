package com.KST.TheNetwork.model.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ZoneDTO {
    private Long zoneId;
    private String title;
    private Timestamp createdOn;
    private Timestamp updatedOn;
}
