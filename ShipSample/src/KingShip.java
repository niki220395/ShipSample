import java.util.Arrays;

import Exception.*;

public class KingShip extends Ship {
    public KingShip(String shipName, int maxNumberOfSailors, Sailor sailor) {
        super(shipName, maxNumberOfSailors, sailor);
    }

    public String typeOfTheShip() {
        return "King ships";
    }

    public void attackOfTheShip(Ship ship) throws WrongShip {
        Sailor temporarySailor = null;
        if (ship instanceof PirateShip) {
            if (quallityOfTheShip() > ship.quallityOfTheShip()) {
                for (int i = 0; getCurrentNumberOfSailors() < getMaxNumberOfSailors(); i++) {
                    if (sailors[getWorstSailor()].getSailorGrade() < ship.getCaptain().getSailorGrade()) {
                        addSailor(ship.removeCaptain());
                    }
                }
            } else removeAllSailors();
        } else throw new WrongShip();

    }
}