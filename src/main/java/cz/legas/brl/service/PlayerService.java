package cz.legas.brl.service;

import cz.legas.brl.Repository.PlayerRepository;
import cz.legas.brl.entity.Player;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    public Long initializePlayer(String name, Double latitude, Double longitude) {
        Player player = Player.builder()
                .alive(true)
                .latitude(latitude)
                .longitude(longitude)
                .name(name)
                .build();
        final Player savedPlayer = playerRepository.save(player);
        return savedPlayer.getId();
    }

    @Transactional
    public void actualizePlayer(Long id, Double latitude, Double longitude) {
        playerRepository.actualize(id, latitude, longitude);
    }

    @Transactional
    public void killPlayer (Long id){
        playerRepository.kill(id);
    }
}
