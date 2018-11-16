package edu.upc.dsa;

import org.apache.log4j.Logger;

import java.util.*;

public class MyBikeImpl implements MyBike {

    //LLamamos a las propiedades log4j del archivo
    final static Logger log = Logger.getLogger(MyBikeImpl.class.getName());

    //Singleton
    //Inicializamos producto
    private static MyBike instance;

    //Metodo que retorna ejemplo tipo instance
    //Si instance ea nulo genera instancia
    public static MyBike getInstance() {
        if (instance == null) {
            //Generamos una instancia
            instance = new MyBikeImpl();
        }
        return instance;
    }
    //Constructor privado
    private MyBikeImpl() {
        stations = new ArrayList<>();
        stationBikes = new LinkedList<>();
        users = new HashMap<>();
        userBikes = new LinkedList<>();
    }

    //Inicializar listas private o protected
    private ArrayList<Station> stations;
    private LinkedList<Bike> stationBikes;
    private LinkedList<Bike> userBikes;
    private HashMap<String, User> users;


    //Añadir usuario
    public void addUser(User user){
        log.info("Add user:" +user);
        this.addUser(new User(user));
    }

    //Añadir station
    public void addStation(Station station){
        log.info("Add station:" +station);
        this.addStation(new Station(station));
    }


    //Añadir bike en una station
    public void addBike(String idBike, String description, double kms, String idStation) throws StationFullException, StationNotFoundException{
        log.info("Bike añadida:" +idBike +description +kms +idStation);
        for (int i=0; i<stations.size(); i++){
            if (idStation.equals(this.stations.get(i).getidStation())){
                this.addBike(new Bike(idBike, description, kms, idStation));
            }
        }
    }

    //Ordenar por kms las bikes de una station
    public List<Bike> bikesByStationOrderByKms(String idStation) throws StationNotFoundException{
        log.info("Bikes by Station ordered by kms" + this.stationBikes);
        List<Bike> ret = new LinkedList<>();
        ret.addAll(this.stationBikes);

        Collections.sort(ret, new Comparator<Bike>() {
            @Override
            public int compare(Bike o1, Bike o2) {
                return (int)(o1.getkms()-o2.getkms());
            }
        });
        log.info("Bikes by Station ordered by kms" + ret);
        return ret;
    }

    @Override
    public Bike getBike(String stationId, String userId) throws UserNotFoundException, StationNotFoundException {
        return null;
    }

    //Obtener bikes usadas por un user
    public LinkedList<Bike> bikesByUser(String idUser) throws UserNotFoundException{
        LinkedList<Bike> bikes;

        User user = this.users.get(idUser);
        log.info("User: " +user);
        if (idUser!=null){
            bikes = user.getuserBikes();
        }

        else {
            throw  new UserNotFoundException();
        }

        log.info("User bikes:" +bikes);
        return bikes;
    }

    //Obtener numero users
    public int numUsers(){
        log.info("Number of users:" + this.users.size());
        return this.users.size();
    }

    //Obtener numero stations
    public int numStations(){
        log.info("Number of stations:" + this.stations.size());
        return this.stations.size();
    }

    //Obtener numero bikes en una station
    public int numBikes(String idStation) throws StationNotFoundException{

        int numBikes = 0;
        log.info("Station: " +idStation);
        for (int i=0; i<stations.size(); i++){
            if (idStation.equals(this.stations.get(i).getidStation())){

                if (numBikes < stationBikes.size())
                    numBikes= numBikes+1;

                else
                    i++;

                log.info("User bikes:" +numBikes);
                return numBikes;
            }
            else throw new StationNotFoundException();
        }
        return numBikes;
    }

    public void addBike (String idBike){

    }

    //Clear all the data structures
    public void clear(){

    }

    @Override
    public void addBike(Bike bike) {

    }


    @Override
    public void addUser(String idUser, String name, String surname) {

    }

    @Override
    public void addStation(String idStation, String description, int max, double lat, double lon) {

    }

}
