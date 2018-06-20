package cz.legas.brl.service;

import org.springframework.stereotype.Service;

@Service
public class GPSCalculator {

    public void calculateGPS() {

        double random1 = Math.random();
        double random2 = Math.random();
        double randomXPoint = random2 * Math.cos(Math.PI * random1 / random2);
        double randomYPoint = random2 * Math.sin(Math.PI * random1 / random2);
    }
}
