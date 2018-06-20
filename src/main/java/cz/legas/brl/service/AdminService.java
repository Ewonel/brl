package cz.legas.brl.service;

import cz.legas.brl.dto.Player;
import cz.legas.brl.repository.PlayerRepository;
import lombok.val;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    private PlayerRepository playerRepository;

    public AdminService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers(){
        List<Player> players = new ArrayList<>();
        val allPlayers = playerRepository.findAllPlayers();
        for (cz.legas.brl.entity.Player p: allPlayers
             ) {
            Player player = new Player();
            BeanUtils.copyProperties(p, player, "id");
            players.add(player);
        }
        return players;
    }

    public void deleteAllPlayers() {
        playerRepository.deleteAll();
    }
}
