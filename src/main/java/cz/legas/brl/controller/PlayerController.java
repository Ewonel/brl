package cz.legas.brl.controller;

import cz.legas.brl.service.PlayerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/player", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/initialize")
    public Long initializePlayer (@RequestParam @NotNull String name, @RequestParam Double latitude, @RequestParam Double longitude){
        return playerService.initializePlayer(name, latitude, longitude);
    }

    @PutMapping("/actualize")
    public void actualizePlayer (@RequestParam @NotNull Long id, @RequestParam Double latitude, @RequestParam Double longitude){
        playerService.actualizePlayer(id, latitude, longitude);
    }

    @GetMapping("/kill")
    public void killPlayer (@RequestParam @NotNull Long id){
        playerService.killPlayer(id);
    }
}
