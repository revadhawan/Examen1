package edu.upc.dsa;

public class Bike {

    //Atributos
    private String idStation;
    private String idBike;
    String description;
    double kms;
  

    //Constructor JSON
    public Bike(){
    }

    //Constructor
    public Bike (String idBike, String description, double kms, String idStation){
        this.description = description;
        this.idStation = idStation;
        this.idBike = idBike;
        this.kms = kms;
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

    //GET/SET idBike
    public void setidBike(String idStation) {
        this.idBike = idBike;
    }

    public String getidBike() {
        return idBike;
    }


    //GET/SET kms
    public void setkms(int kms) {
        this.kms = kms;
    }

    public double getkms() {
        return kms;
    }

    

}

