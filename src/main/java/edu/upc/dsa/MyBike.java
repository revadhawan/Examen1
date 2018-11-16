package edu.upc.dsa;

import java.util.List;

public interface MyBike {

    /**
     * number of stations
     */
    public static final int S = 10;

   //Métodos

    //Añadir usuario
   public void addUser(String idUser, String name, String surname);

   //Añadir station
   public void addStation(String idStation, String description, int max,  double lat, double lon);

   //Añadir bike en una station
   public void addBike(String idBike, String description, double kms, String idStation) throws StationFullException, StationNotFoundException;

   //Ordenar por kms las bikes de una station
   public List<Bike> bikesByStationOrderByKms(String idStation) throws StationNotFoundException;

   //Obtener primera Bike de una station
   public Bike getBike(String stationId, String userId) throws UserNotFoundException, StationNotFoundException;

   //Obtener bikes usadas por un user
   public List<Bike> bikesByUser(String userId) throws UserNotFoundException;

   //Obtener numero users
   public int numUsers();

   //Obtener numero stations
   public int numStations();

    //Obtener numero bikes en una station
    public int numBikes(String idStation) throws StationNotFoundException;

    //Clear all the data structures
    public void clear();
    
    //Añadir bike
    public void addBike(Bike bike);

    void addUser(User user);

    void addStation(Station station);
}
