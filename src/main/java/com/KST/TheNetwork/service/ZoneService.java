package com.KST.TheNetwork.service;


import com.KST.TheNetwork.model.Zone;
import com.KST.TheNetwork.model.dto.ZoneDTO;
import com.KST.TheNetwork.repository.ZoneRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ZoneService {
    private final ZoneRepository zoneRepository;

    @Transactional
    public List<ZoneDTO> save(List<ZoneDTO> zoneDTO) {
        List<Zone> zones = zoneDTO.stream().map(this::mapToObject).toList();
        zoneRepository.saveAllAndFlush(zones);
        log.info("New Zone data saved to the database.");
        return zones.stream().map(this::mapToDTO).toList();
    }

    public List<ZoneDTO> listAll() {
        return zoneRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private ZoneDTO mapToDTO(Zone zone) {
        return ZoneDTO.builder()
                .zoneId(zone.getZoneId())
                .title(zone.getTitle())
                .createdOn(zone.getCreatedOn())
                .updatedOn(zone.getUpdatedOn())
                .build();
    }

    private Zone mapToObject(ZoneDTO zoneDTO) {
        return Zone.builder()
                .zoneId(zoneDTO.getZoneId())
                .title(zoneDTO.getTitle())
                .createdOn(zoneDTO.getCreatedOn())
                .updatedOn(zoneDTO.getUpdatedOn())
                .build();
    }
}
