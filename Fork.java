public class Fork {
    private boolean pickedUp;

    public Fork () {
        pickedUp = false;
    }

    public void pickUpFork() throws InterruptedException {
        synchronized (this) {
            if (pickedUp) {
                // Wait until notified that fork is available
                wait();
            }
            pickedUp = true;
        }
    }

    public void putDownFork() throws InterruptedException {
        synchronized (this) {
            pickedUp = false;
            // Notify all threads waiting on fork
            notifyAll();
        }
    }
}
