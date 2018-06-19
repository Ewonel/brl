package cz.legas.brl.dto;

import lombok.Data;

@Data
public class Player {

    String name;

    boolean alive;

    double latitude;

    double longitude;
}
