package Exception;

public class WrongShip extends Exception{
    private String alert1="You cannot attack this ship !!!";
    private String  alert2="You cannot add this ship in your fleet";

    public String getAlert1() {
        return alert1;
    }

    public String getAlert2() {
        return alert2;
    }
}
