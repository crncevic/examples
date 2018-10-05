/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import domain.Car;
import domain.Truck;
import factory.CarCreator;
import factory.Creator;
import factory.TruckCreator;

/**
 *
 * @author Petar
 */
public class Main {
    
  public static void main(String [] args){
      Creator creator = new TruckCreator();
      creator.create();
      
      System.out.println("Ukupan broj kola je "+Truck.numberOfTrucks);
  }
}
