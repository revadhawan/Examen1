package edu.upc.dsa;

import java.util.LinkedList;

public class Station {

    //Atributos
    private String idStation;
    String description;
    int max = 10;
    double lat;
    double lon;

    LinkedList<Bike> stationBikes;


    //Constructor JSON
    public Station(){
    }

    //Constructor
    public Station(String description, String idStation, int max, double lat, double lon){
        this.description = description;
        this.idStation = idStation;
        this.max = max;
        this.lat = lat;
        this.lon = lon;
        this.stationBikes = new LinkedList<>();
    }

    public Station(Station station) {
    }

    //SET/GET stationBikes list
    public void setstationBikes(LinkedList<Bike> stationBikes) {
        this.stationBikes = stationBikes;
    }

    public LinkedList<Bike> getstationBikes() {
        return stationBikes;
    }


    //GET/SET description
    public void setdescription(String description) {
        this.description = description;
    }
    public String getdescription() {
        return description;
    }


    //GET/SET idStation
    public void setidStation(String idStation) {
        this.idStation = idStation;
    }

    public String getidStation() {
        return idStation;
    }



    //GET/SET max
    public void setmax(int max) {
        this.max = max;
    }

    public int getmax() {
        return max;
    }


    //GET/SET lat
   public void setlat(int lat) {
        this.lat = lat;
    }

    public double getlat() {
        return lat;
    }

    //GET/SET lon
    public void setlon(int lon) {
        this.lon = lon;
    }

    public double getlon() {
        return lon;
    }

    //Add bike for a station
    public void addBike(Bike bike){
        this.stationBikes.add(bike);
    }



}
