import Exception.*;

public class Main {
    public static void main(String[] args) {

        Sailor s1 = new Sailor("Goran", 15);
        Sailor s2 = new Sailor("Janko", 5);
        Sailor s3 = new Sailor("Milan", 25);
        Sailor s4 = new Sailor("Nikola", 35);
        Sailor s5 = new Sailor("Petar", 88);
        Sailor s6 = new Sailor("Ilija", 42);
        Sailor s7 = new Sailor("Pedja", 45);
        Sailor s8 = new Sailor("Marko", 86);
        Sailor s9 = new Sailor("Dragan", 99);
        Sailor s10 = new Sailor("Zoran", 17);
        Sailor s11 = new Sailor("Lazar", 89);

        Ship ship1 = new PirateShip("Crna Udovica", 15, s1);
        Ship ship2 = new KingShip("Elisabhet", 7, s9);

        ship1.addSailor(s11);
        ship1.addSailor(s6);
        ship1.addSailor(s7);
        ship1.addSailor(s10);
        ship2.addSailor(s5);
        ship2.addSailor(s8);
        Fleet fleet1 = new Fleet("US Navy");

        try {
            fleet1.addShip(ship1);

            System.out.println(ship2);
        } catch (WrongShip wrongShip) {
            System.out.println(wrongShip.getAlert2());
        }
        try {
            ship2.attackOfTheShip(ship1);
        } catch (WrongShip wrongShip) {
            System.out.println(wrongShip.getAlert1());
        }
        System.out.println(ship2);
    }
}
