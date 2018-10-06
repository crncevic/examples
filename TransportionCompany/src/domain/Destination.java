/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Petar
 */
public class Destination {

    private int destinationId;
    private String name;
    private double gasUnits;
    private boolean landTransportion;

    public Destination() {
    }

    public Destination(int destinationId, String name, double gasUnits, boolean landTransportion) {
        this.destinationId = destinationId;
        this.name = name;
        this.gasUnits = gasUnits;
        this.landTransportion = landTransportion;
    }

   

    public double getGasUnits() {
        return gasUnits;
    }

    public void setGasUnits(double gasUnits) {
        this.gasUnits = gasUnits;
    }

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLandTransportion() {
        return landTransportion;
    }

    public void setLandTransportion(boolean landTransportion) {
        this.landTransportion = landTransportion;
    }
    
    

}
