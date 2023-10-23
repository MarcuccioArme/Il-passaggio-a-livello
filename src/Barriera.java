public class Barriera extends Thread {

    private final SensoreBarriera sensoreBarriera;

    public Barriera(SensoreBarriera sensoreBarriera) {
        this.sensoreBarriera = sensoreBarriera;
    }

    @Override
    public void run() {
        try {
            while (true) {
                while (sensoreBarriera.isBarrieraAbbassata()) {
                    Thread.sleep(1000);
                }
                System.out.println("Barriera abbassata.");
                Thread.sleep(3000);
                sensoreBarriera.alzaBarriera();
                System.out.println("Barriera alzata.");
            }
        } catch (InterruptedException e) {
            System.out.println("Thread Barriera è stato interrotto.");
        }
    }

}
