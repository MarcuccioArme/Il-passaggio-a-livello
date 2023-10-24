public class PassaggioALivello {
    public static void main(String[] args) {

        Barriera barriera = new Barriera();
        SensoreBarriera sensoreBarriera = new SensoreBarriera(barriera);
        Treno treno = new Treno(barriera, sensoreBarriera);

        ArrestaProgramma arrestaProgramma = new ArrestaProgramma();

        sensoreBarriera.start();
        treno.start();
        arrestaProgramma.start();

    }
}