public class Barriera {

    private volatile boolean barrieraAbbassata = false;

    public void abbassaBarriera() {
        barrieraAbbassata = true;
    }

    public void alzaBarriera() {
        barrieraAbbassata = false;
    }

    public boolean isBarrieraAbbassata () {
        return barrieraAbbassata;
    }

}