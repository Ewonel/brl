package cz.legas.brl.service;

import cz.legas.brl.dto.Player;
import cz.legas.brl.repository.PlayerRepository;
import lombok.val;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static cz.legas.brl.service.GPSCalculator.getLocation;

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

    public List<Player> getAllAlivePlayers() {
        List<Player> players = new ArrayList<>();
        val allPlayers = playerRepository.findAllAlivePlayers();
        for (cz.legas.brl.entity.Player p: allPlayers
                ) {
            Player player = new Player();
            BeanUtils.copyProperties(p, player, "id");
            players.add(player);
        }
        return players;
    }

    public List<Double> setupGame(double longitude, double latitude, int radius) {
        playerRepository.deleteAll();
        List locations = getLocation(longitude, latitude, radius).asJava();
        //only test
//        return io.vavr.collection.List.of(distance2points(50.72042,15.168182, 50.674897365510965, 15.158748383516151)).asJava();
        return locations;
    }
}
