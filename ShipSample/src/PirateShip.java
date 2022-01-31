import Exception.*;

public class PirateShip extends Ship {

    public PirateShip(String shipName, int maxNumberOfSailors, Sailor sailor) {
        super(shipName, maxNumberOfSailors, sailor);
    }

    public String typeOfTheShip() {
        return "Pirate ships";
    }

    public void attackOfTheShip(Ship ship) throws WrongShip {
        if (getCurrentNumberOfSailors() > ship.getCurrentNumberOfSailors()) {
            if (quallityOfTheShip() > ship.quallityOfTheShip()) {
                if ((ship.getCaptain().getSailorGrade() > sailors[getWorstSailor()].getSailorGrade()) && (getCurrentNumberOfSailors() < getMaxNumberOfSailors()))
                    addSailor(ship.removeCaptain());
            } else removeAllSailors();
        } else throw new WrongShip();
    }
}
