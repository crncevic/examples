/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import constants.Constants;
import domain.Destination;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Petar
 */
public class Service {

    List<Destination> destinations;

    public Service() {
        destinations = new ArrayList<>();
        initDestinations();
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    private void initDestinations() {
        destinations.add(new Destination(1, "Beograd", 1, true));
        destinations.add(new Destination(2, "Budimpesta", 3, true));
        destinations.add(new Destination(3, "Bec", 5, true));

        destinations.add(new Destination(4, "Atina", 1, false));
        destinations.add(new Destination(5, "Monako", 3, false));
        destinations.add(new Destination(6, "Malta", 5, false));

    }

    public List<Destination> getDestinationsFor(String transportionMean) {
        List<Destination> destinationsFor = new ArrayList();

        for (Destination d : destinations) {
            if (transportionMean.equals(Constants.VEHICLE) && d.isLandTransportion()) {
                destinationsFor.add(d);
            } else if (transportionMean.equals(Constants.SHIP) && !d.isLandTransportion()) {
                destinationsFor.add(d);
            }
        }

        return destinationsFor;
    }
}
