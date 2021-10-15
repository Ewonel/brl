package cz.legas.brl.controller;

import cz.legas.brl.service.PlayerService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/player", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/initialize")
    public Long initializePlayer(@RequestParam @NotNull String name, @RequestParam @Schema(example = "50.4628411") Double latitude, @RequestParam @Schema(example = "15.5833150") Double longitude) {
        return playerService.initializePlayer(name, latitude, longitude);
    }

    @PutMapping("/update")
    public void updatePlayer(@RequestParam @NotNull Long id, @RequestParam @Schema(example = "50.4628411") Double latitude, @RequestParam @Schema(example = "15.5833150") Double longitude) {
        playerService.updatePlayer(id, latitude, longitude);
    }

    @PutMapping("/updateByName")
    public void updatePlayerByName(@RequestParam @NotNull String name, @RequestParam @Schema(example = "50.4628411") Double latitude, @RequestParam @Schema(example = "15.5833150") Double longitude) {
        playerService.updatePlayerByName(name, latitude, longitude);
    }

    @GetMapping("/kill")
    public void killPlayer(@RequestParam @NotNull Long id) {
        playerService.killPlayer(id);
    }

    @PostMapping("/locationCheck")
    public String locationCheck(@RequestParam @NotNull Long id) {
        //TODO check in DB there will be location of center of white actual circle
        return "dead";
    }
}
