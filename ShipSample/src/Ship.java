import Exception.*;

public abstract class Ship {
    private String shipName;
    public Sailor[] sailors;
    private int currentNumberOfSailors;
    private int captainIndex;

    public Ship(String shipName, int maxNumberOfSailors, Sailor sailor) {
        this.shipName = shipName;
        sailors = new Sailor[maxNumberOfSailors];
        sailors[currentNumberOfSailors++] = sailor;
    }

    public Sailor getCaptain() {
        return (currentNumberOfSailors == 0) ? sailors[captainIndex] : null;
    }

    public int getWorstSailor() {
        int worstSailor = 0;
        if (currentNumberOfSailors == 0) return -1;
        for (int i = 1; i < currentNumberOfSailors; i++) {
            if (sailors[i].getSailorGrade() < sailors[worstSailor].getSailorGrade()) {
                worstSailor = i;
            }
        }
        return worstSailor;
    }

    public Sailor removeCaptain() {
        if (currentNumberOfSailors == 0) return null;
        Sailor currentCaptain = sailors[captainIndex];
        for (int i = captainIndex; i < currentNumberOfSailors - 1; i++) {
            sailors[i] = sailors[i + 1];
        }
        currentNumberOfSailors--;
        for (int i = 0; i < currentNumberOfSailors; i++) {
            if (sailors[i].getSailorGrade() > sailors[captainIndex].getSailorGrade()) captainIndex = i;
        }
        return currentCaptain;
    }

    //Method which add sailor on the ship/
    public void addSailor(Sailor sailor) {
        if (currentNumberOfSailors == sailors.length) return;
        if (currentNumberOfSailors == 0 || (sailor.getSailorGrade() > sailors[captainIndex].getSailorGrade()))
            captainIndex = currentNumberOfSailors;
        sailors[currentNumberOfSailors++] = sailor;
    }

    public Sailor getSailor(int index) throws WrongIndex {
        if (index < 0) throw new WrongIndex();
        else
            return currentNumberOfSailors > 0 ? sailors[index] : null;
    }

    public int getCurrentNumberOfSailors() {
        return currentNumberOfSailors;
    }

    public int getMaxNumberOfSailors() {
        return sailors.length;
    }


    public void removeAllSailors() {
        for (int i = 0; i < currentNumberOfSailors; i++) {
            sailors[i] = null;
        }
        currentNumberOfSailors = 0;
    }

    //Method which calculates the quality of the ship based on the each grade of the sailor on the ship
    public double quallityOfTheShip() {
        double sum = 0;
        for (int i = 0; i < currentNumberOfSailors; i++) {
            sum += sailors[i].getSailorGrade();
        }
        return sum / currentNumberOfSailors;
    }

    public abstract String typeOfTheShip();

    public abstract void attackOfTheShip(Ship ship) throws WrongShip;

    @Override
    public String toString() {
        String s = "";
        if (currentNumberOfSailors > 0) {
            for (int i = 0; i < currentNumberOfSailors; i++) {
                s += sailors[i].toString() + "\n";
            }
            return typeOfTheShip() + ":" + shipName + " Ship Quallity:" + quallityOfTheShip() + "\n" + "Members of the ship:\n" + s;
        } else
            return "Ship is empty !";
    }
}
