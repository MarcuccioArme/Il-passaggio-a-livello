public class Treno extends Thread {

    private final Barriera barriera;
    private final SensoreBarriera sensoreBarriera;

    public Treno(Barriera barriera, SensoreBarriera sensoreBarriera) {
        this.barriera = barriera;
        this.sensoreBarriera = sensoreBarriera;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                // La barriera si abbassa
                while (!barriera.isBarrieraAbbassata()) {
                    Thread.sleep(1000);
                }

                // Il treno passa
                Thread.sleep(3000);

                sensoreBarriera.TrenoPassato();
                System.out.println("Il Treno è passato.");

                // Attendo che la barriera si rialzi
                while (barriera.isBarrieraAbbassata()) {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread Treno è stato interrotto.");
            }
        }
    }

}

/*

Quando il treno sta per transitare, attendiamo che
la barriera si abbassi correttamente del tutto. Dopodiché
il treno può transitare tranquillamente.

Una volta che questo è passato, il sensore lo rileva.

Attendiamo prima che la barriera si sia alzata completamente
prima di andare avanti con la prossima esecuzione.

*/