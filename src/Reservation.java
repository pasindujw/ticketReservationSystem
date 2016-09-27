
/**
 * Created by pasindu on 9/27/16.
 */
class Reservation extends Thread {
    private int ticketAmount;
    private CentralServer centralServer;

    @Override
    public void run(){
        try {
            centralServer.addReservation(ticketAmount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public Reservation(int ticketAmount, CentralServer centralServer){
        this.ticketAmount = ticketAmount;
        this.centralServer = centralServer;
    }

}
