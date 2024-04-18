package com.KST.TheNetwork.controller;

import com.KST.TheNetwork.model.dto.ZoneDTO;
import com.KST.TheNetwork.service.ZoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zones")
@RequiredArgsConstructor
public class ZoneController {
    private final ZoneService zoneService;

    @GetMapping
    public ResponseEntity<List<ZoneDTO>> listAllZone() {
        return ResponseEntity.ok(this.zoneService.listAll());
    }

    @PostMapping
    public ResponseEntity<List<ZoneDTO>> createNewZone(@RequestBody List<ZoneDTO> zoneDTO) {
        return ResponseEntity.ok(zoneService.save(zoneDTO));
    }
}
