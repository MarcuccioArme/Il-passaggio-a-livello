import java.io.IOException;

public class ArrestaProgramma extends Thread {

    private final SensoreBarriera sensoreBarriera;
    private final Treno treno;

    public ArrestaProgramma(SensoreBarriera sensoreBarriera, Treno treno) {
        this.sensoreBarriera = sensoreBarriera;
        this.treno = treno;
    }

    @Override
    public void run() {
        try {
            System.out.println("Premi Invio per arrestare il programma...");
            System.in.read();

            // Interrompi i thread treno e sensoreBarriera
            sensoreBarriera.interrupt();
            treno.interrupt();

            System.out.println("Programma arrestato.");
            System.exit(0); // Chiudi il programma
        } catch (IOException e) {
            System.out.println("Errore durante l'arresto del programma.");
        }
    }

}
