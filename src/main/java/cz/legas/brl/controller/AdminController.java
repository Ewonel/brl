package cz.legas.brl.controller;

import cz.legas.brl.dto.Player;
import cz.legas.brl.service.AdminService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/admin", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return adminService.getAllPlayers();
    }

    @GetMapping("/players/alive")
    public List<Player> getAllAlivePlayers() {
        return adminService.getAllAlivePlayers();
    }

    @PostMapping("/setupGame")
    public List<Double> setupGame(@RequestParam double longitude, @RequestParam double latitude, @RequestParam int radius) {
        return adminService.setupGame(longitude, latitude, radius);
    }

    @DeleteMapping("/players")
    public void deleteAllPlayers() {
        adminService.deleteAllPlayers();
    }
}
