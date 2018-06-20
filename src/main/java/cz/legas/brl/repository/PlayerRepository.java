package cz.legas.brl.repository;

import cz.legas.brl.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Transactional
    @Query("select p from Player p")
    List<Player> findAllPlayers();

    @Transactional
    @Query("select p from Player p where p.alive = true")
    List<Player> findAllAlivePlayers();

    @Modifying
    @Query("update Player p set p.latitude=:latitude, p.longitude=:longitude where p.id = :id")
    int update(@Param("id") Long id, @Param("latitude") Double latitude, @Param("longitude") Double longitude);

    @Modifying
    @Query("update Player p set p.alive=false where p.id = :id")
    int kill(@Param("id") Long id);
}
