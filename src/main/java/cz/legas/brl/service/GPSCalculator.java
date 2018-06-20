package cz.legas.brl.service;

import io.vavr.collection.List;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GPSCalculator {

    public void calculateGPS() {

        double random1 = Math.random();
        double random2 = Math.random();
        double randomXPoint = random2 * Math.cos(Math.PI * random1 / random2);
        double randomYPoint = random2 * Math.sin(Math.PI * random1 / random2);
    }

    public static List<Double> getLocation(double longitude, double latitude, int radius) {//radius in meters
        Random random = new Random();

        // Convert radius from meters to degrees
        double radiusInDegrees = radius / 111000f;

        double u = random.nextDouble();
        double v = random.nextDouble();
        double w = radiusInDegrees * Math.sqrt(u);
        double t = 2 * Math.PI * v;
        double x = w * Math.cos(t);
        double y = w * Math.sin(t);

        // Adjust the x-coordinate for the shrinking of the east-west distances
        double newX = x / Math.cos(Math.toRadians(latitude));

        Double foundLongitude = newX + longitude;
        Double foundLatitude = y + latitude;
        return List.of(foundLongitude, foundLatitude);
    }

    public static double distance2points(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344; //to km from mile
        dist = dist * 1000; //to m from km

        return (dist);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts decimal degrees to radians             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts radians to decimal degrees             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}
