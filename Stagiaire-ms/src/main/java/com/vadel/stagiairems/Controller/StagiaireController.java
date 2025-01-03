package com.vadel.stagiairems.Controller;

import com.vadel.stagiairems.Entity.Stagiaire;
import com.vadel.stagiairems.Services.StagiaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api/stagiaire")
@RequiredArgsConstructor
public class StagiaireController {

    private final StagiaireService stagiaireService;

    @GetMapping("/{id}/exists")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Boolean> existsStagiaireById(@PathVariable Long id) {
        boolean exists = stagiaireService.existsById(id);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/{id}/with-project")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Map<String, Object> getStagiaireWithProject(@PathVariable Long id) {
        return stagiaireService.getStagiaireWithProject(id);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<Stagiaire> getAllStagiaires() {
        return stagiaireService.getAllStagiaires();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Stagiaire> getStagiaire(@PathVariable Long id) {
        Stagiaire stagiaire = stagiaireService.getStagiaireById(id);
        return ResponseEntity.ok(stagiaire);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Stagiaire createStagiaire(@RequestBody Stagiaire stagiaire) {
        return stagiaireService.saveStagiaire(stagiaire);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public void deleteStagiaire(@PathVariable Long id) {
        stagiaireService.deleteStagiaire(id);
    }
}
