package cz.legas.brl.service;

import cz.legas.brl.entity.Player;
import cz.legas.brl.repository.PlayerRepository;
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
    public void updatePlayer(Long id, Double latitude, Double longitude) {
        playerRepository.update(id, latitude, longitude);
    }

    @Transactional
    public void updatePlayerByName(String name, Double latitude, Double longitude) {
        playerRepository.updateByName(name, latitude, longitude);
    }

    @Transactional
    public void killPlayer (Long id){
        playerRepository.kill(id);
    }


}
