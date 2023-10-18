public class PassaggioALivello {
    public static void main(String[] args) {

        Barriera barriera = new Barriera();
        barriera.start();
        SensoreBarriera sensore = new SensoreBarriera();
        sensore.start();

    }
}