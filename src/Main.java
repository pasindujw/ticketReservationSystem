import java.util.Random;

public class Main {
    private static CentralServer centralServer = new CentralServer();
    private static Random r = new Random();

    public static void main(String[] args) throws InterruptedException {
        while(true){
            int zeroSkipper = r.nextInt(4);
            if(zeroSkipper ==0)
                continue;
            new Reservation(zeroSkipper, centralServer).start();
            Thread.sleep(r.nextInt(2000));
        }
    }
}
