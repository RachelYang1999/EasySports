package com.elec5619.easysports.utility;

import com.elec5619.easysports.domain.Playground;
import com.elec5619.easysports.service.PlaygroundService;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.GeocodingResult;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapAPI {

    public static boolean validate(String address) throws InterruptedException, ApiException, IOException {
        String apiKey = "AIzaSyBIBX15KcmTfTcFaCUxU53PC9JZj9VA_Jw";
        Map<String, Double> map = new HashMap<>();
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();
        GeocodingResult[] results =  GeocodingApi.geocode(context,
                address).await();
        if(results.length == 0) return false;
        return true;
    }

    public static List<Playground> calDistance(String[] origins, List<Playground> playgroundList, PlaygroundService playgroundService, double maxDistance) throws InterruptedException, ApiException, IOException {
        if(playgroundList.size() == 0) return playgroundList;

        String apiKey = "AIzaSyBIBX15KcmTfTcFaCUxU53PC9JZj9VA_Jw";
        List<Playground> results = new ArrayList<>();

        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();
        List<String> destinations = new ArrayList<>();
        for(Playground playground: playgroundList) {
            destinations.add(playground.getAddress());
        }


        DistanceMatrix matrix = DistanceMatrixApi.getDistanceMatrix(context, origins, destinations.toArray(new String[0])).await();

        int count = 0;
        for(String destination : destinations) {
            Playground p = playgroundService.findOneByProperty("address", destination);
            long distance = matrix.rows[0].elements[count].distance.inMeters/1000;
            System.out.println("address-distance" + destination + "    " + distance);

            p.setDistance(distance);

            if( distance <= maxDistance) {
                results.add(p);
            }
            count ++;
        }
        return results;
    }

    public static List<Playground> calDistanceHelper(String[] origins, List<Playground> playgroundList, PlaygroundService playgroundService) throws InterruptedException, ApiException, IOException {
        if(playgroundList.size() == 0) return playgroundList;
        String apiKey = "AIzaSyBIBX15KcmTfTcFaCUxU53PC9JZj9VA_Jw";
        List<Playground> results = new ArrayList<>();

        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();
        List<String> destinations = new ArrayList<>();
        for(Playground playground: playgroundList) {
            destinations.add(playground.getAddress());
        }


        DistanceMatrix matrix = DistanceMatrixApi.getDistanceMatrix(context, origins, destinations.toArray(new String[0])).await();

        int count = 0;
        for(String destination : destinations) {
            Playground p = playgroundService.findOneByProperty("address", destination);
            long distance = 0;
            if(matrix.rows != null) {
                distance  = matrix.rows[0].elements[count].distance.inMeters/1000;
            }
            System.out.println("address-distance" + destination + "    " + distance);

            p.setDistance(distance);
            results.add(p);
            count ++;
        }

        return results;
    }

}
