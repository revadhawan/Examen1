package edu.upc.dsa;

import java.util.LinkedList;

public class User {

    //Atributos
    String name;
    String surname;
    private String idUser;

    LinkedList<Bike> userBikes;

    //Constructor JSON
    public User(){

    }

    //Constructor lista y usuarios
    public User(String name, String surname, String idUser){
        this.name = name;
        this.surname = surname;
        this.idUser = idUser;
        this.userBikes = new LinkedList<>();
    }

    public User(User user) {
    }

    //GET/SET userBikes
    public void setuserBikes(LinkedList<Bike> userBikes) {
        this.userBikes = userBikes;
    }

    public LinkedList<Bike> getuserBikes() {
        return userBikes;
    }


    //GET/SET name
    public void setname(String name) {
        this.name = name;
    }
    public String getname() {
        return name;
    }


    //GET/SET surname
    public void setsurname(String surname) {
        this.name = name;
    }
    public String getsurname() {
        return surname;
    }

    //GET/SET idUser
    public String getidUser() {
        return idUser;
    }

    public void setidUser(String idUser) {
        this.idUser = idUser;
    }

    //Add bike for a user
    public void addBike(Bike bike){
        this.userBikes.add(bike);
    }


}
