package org.launchcode.cheesemvc.models;

import java.util.ArrayList;

/**
 * Created by LaunchCode
 */

// CheeseData is where data is stored and methods to get, add and remove Cheese. These methods
// are used by the controller for access
public class CheeseData {

    // create an instance or object of Class Cheese so that the methods and fields (getters and setters)
    // of Cheese class can be used - also, each element of cheeses will be a Cheese object
    // with name, description, and cheeseId
    static ArrayList<Cheese> cheeses = new ArrayList<>();

    // create a method getAll() RETURNING an ArrayList cheeses of Cheese objects
    // that the controller needs to access the arrayList object elements
    // eg CheeseData.getAll()
    public static ArrayList<Cheese> getAll() {
        return cheeses;
    }

    // add - create a method add(object) RETURNING void since we just add newCheese and
    // don't need to return anything
    public static void add(Cheese newCheese) {
        cheeses.add(newCheese);
    }

    // remove - create a method remove via Id: Return Cheese object after getting Cheese element via Id
    // id is most useful to us to be used by the controller usually
    public static void remove(int id) {
        // get the ArrayList element (object) and assign it to cheeseToRemove reference variable
        Cheese cheeseToRemove = getById(id);
        // use built-in .remove method to remove cheeseToRemove object from cheeses
        cheeses.remove(cheeseToRemove);
    }

    // getById - return Cheese object after finding object via Id
    public static Cheese getById(int id) {

        // declare a Cheese local variable the Cheese. Return null if Id not found
        Cheese theCheese = null;

        for (Cheese candidateCheese : cheeses) {
            // getter Cheese.getCheeseId() is used to to compare the parameter with the
            // id from the Cheese object
            if (candidateCheese.getCheeseId() == id) {
                theCheese = candidateCheese;
            }
        }

        return theCheese;
    }

}