public class PassaggioALivello {
    public static void main(String[] args) {

        SensoreBarriera sensore = new SensoreBarriera();
        Treno treno = new Treno(sensore);
        Barriera barriera = new Barriera(sensore);

        ArrestaProgramma arrestaProgramma = new ArrestaProgramma();

        treno.start();
        barriera.start();
        arrestaProgramma.start();

    }
}