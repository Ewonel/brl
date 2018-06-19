package cz.legas.brl.controller;

import cz.legas.brl.dto.Player;
import cz.legas.brl.service.AdminService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/admin", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AdminController {

    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/getAllPlayers")
    public List<Player> getAllPlayers(){
        return adminService.getAllPlayers();
    }

    @DeleteMapping("/deleteAllPlayers")
    public void deleteAllPlayers(){
        adminService.deleteAllPlayers();
    }
}
