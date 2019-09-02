package org.launchcode.cheesemvc.models;

import java.util.ArrayList;

public class CheeseData {

    static ArrayList<Cheese> cheeses = new ArrayList<>();

    //getAll method
    public static ArrayList<Cheese> getAll() {
        return cheeses;
    }

    //add method
    public static void add(Cheese newCheese) {
        cheeses.add(newCheese);
    }

    //remove method
    public static void remove(int id){
        Cheese cheeseToRemove = getById(id);
        cheeses.remove(cheeseToRemove);
    }

    //getById
    public static Cheese getById(int id) {
       Cheese theCheese = null;

       for (Cheese candidateCheese : cheeses) {
           if (candidateCheese.getCheeseId() == id) {
               theCheese = candidateCheese;
           }
       }

       return theCheese;
    }

}
