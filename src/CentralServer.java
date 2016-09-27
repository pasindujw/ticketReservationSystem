import java.util.concurrent.Semaphore;

class CentralServer {
    private static int NoOfTickets = 200;
    private static float TicketPrice = 500;
    private int ticketsLeft = NoOfTickets;
    private Semaphore ticketCounter = new Semaphore(1);
    private float totalIncome = 0;

    void addReservation(int ticketAmount) throws InterruptedException {
        ticketCounter.acquire();
        if(ticketsLeft > ticketAmount){
            ticketsLeft = ticketsLeft - ticketAmount;
            totalIncome = totalIncome + ticketAmount * TicketPrice;
            System.out.println(ticketAmount + " tickets reserved | Rs."+ ticketAmount * TicketPrice + " paid.");
            System.out.println("Total Income: Rs." + totalIncome);
            System.out.println("Tickets left: " + ticketsLeft);
            System.out.println("\n");
        }
        else if (ticketsLeft < ticketAmount){
            totalIncome = totalIncome + ticketsLeft * TicketPrice;
            System.out.println("Only " + ticketsLeft+ " left and reserved them. | Rs."+ ticketsLeft * TicketPrice + " paid.");
            System.out.println("Total Income: Rs." + totalIncome );
            ticketsLeft = 0;
        }
        if (ticketsLeft == 0){
            System.out.println("\n");
            System.out.println("Sorry tickets sold out!");
            System.exit(1);
        }
        ticketCounter.release();
    }
}
