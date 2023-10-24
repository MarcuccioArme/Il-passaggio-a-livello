public class SensoreBarriera extends Thread {

    private final Barriera barriera;

    private volatile boolean trenoInTransito = false;

    public SensoreBarriera(Barriera barriera) {
        this.barriera = barriera;
    }

    public void TrenoInTransito() {
        trenoInTransito = true;
    }

    public void TrenoPassato() {
        trenoInTransito = false;
    }

    public boolean isTrenoInTransito () {
        return trenoInTransito;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Il treno passa in un momento casuale
                Thread.sleep((long) (Math.random() * 5000));

                // Rileva il treno in arrivo e abbassa la barriera
                System.out.println("\nIl Treno è in arrivo.");
                TrenoInTransito();

                barriera.abbassaBarriera();
                System.out.println("Barriera abbassata e semaforo rosso acceso.");

                // Attende che il treno passi
                while (isTrenoInTransito()) {
                    Thread.sleep(1000);
                }

                // Rialza la barriera
                barriera.alzaBarriera();
                System.out.println("Barriera rialzata e semaforo verde acceso.");
            }
        } catch (InterruptedException e) {
            System.out.println("Thread Treno è stato interrotto.");
        }
    }

}

/*

Il treno passa in un momento casuale dal passaggio a livello.

Quando questo è in arrivo, il sensore lo rileva e fa abbassare la barriera.

Attendiamo affinché il sensore non ci segnali che il treno
è transitato completamente.

Quando questo è passato, il sensore fa alzare correttamente la barriera.

*/