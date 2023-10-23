public class Treno extends Thread {

    private final SensoreBarriera sensoreBarriera;

    public Treno(SensoreBarriera sensoreBarriera) {
        this.sensoreBarriera = sensoreBarriera;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep((int) (Math.random()) * 8000);
                System.out.println("Il treno sta arrivando.");
                sensoreBarriera.abbassaBarriera();
                Thread.sleep(3000);
                sensoreBarriera.alzaBarriera();
                System.out.println("Il treno è passato.");
            }
        } catch (InterruptedException e) {
            System.out.println("Thread Treno è stato interrotto.");
        }
    }

}