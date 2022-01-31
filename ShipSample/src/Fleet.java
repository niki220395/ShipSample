import java.util.LinkedList;

import Exception.*;

public class Fleet {
    private String fleetName;
    private LinkedList<Ship> ships;

    public Fleet(String fleetName) {
        this.fleetName = fleetName;
        ships = new LinkedList<Ship>();
    }

    public void addShip(Ship ship) throws WrongShip {
        if (ships.size() == 0) ships.add(ship);
        else if (ships.get(0).typeOfTheShip().equals(ship.typeOfTheShip())) ships.add(ship);
        else throw new WrongShip();
    }

    public Ship getShip(int index) throws WrongIndex {
        return ships.get(index);
    }

    public double quallityOfTheFleet() {
        double quallity = 0;
        for (int i = 0; i < ships.size(); i++) {
            quallity += ships.get(i).quallityOfTheShip();
        }
        return ships.size() == 0 ? quallity / ships.size() : 0;
    }

    @Override
    public String toString() {
        return "Fleet (" + ships.get(0).typeOfTheShip() + ")" + " Name:" + fleetName + " Quallity:" + quallityOfTheFleet();
    }
}
