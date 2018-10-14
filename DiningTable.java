import java.util.concurrent.ThreadLocalRandom;

public class DiningTable {
    public static void main(String[] args) throws InterruptedException {

        Thread mainThread = Thread.currentThread();

        Fork forkAB = new Fork();
        Fork forkBC = new Fork();
        Fork forkCD = new Fork();
        Fork forkDE = new Fork();
        Fork forkEA = new Fork();

        Thread philA = new Thread(new Runnable() {
            @Override
            public void run() {
                Fork leftFork = forkEA;
                Fork rightFork = forkAB;

                while (mainThread.isAlive()) {
                    try {
                        // THINK from 1 to 5 seconds
                        int thinkingTime = (ThreadLocalRandom.current().nextInt(0, 5) + 1) * 1000;
                        System.out.println("Philosopher A: Thinking for " + (thinkingTime / 1000) + " seconds");
                        Thread.sleep(thinkingTime);

                        // Left fork
                        System.out.println("Philosopher A: attempt to acquire fork to left");
                        leftFork.pickUpFork();
                        System.out.println("Philosopher A: acquired left fork");

                        // Right fork
                        System.out.println("Philosopher A: attempt to acquire fork to right");
                        rightFork.pickUpFork();
                        System.out.println("Philosopher A: acquired right fork");

                        // EAT from 1 to 10 seconds
                        int eatingTime = (ThreadLocalRandom.current().nextInt(0, 10) + 1) * 1000;
                        System.out.println("Philosopher A: Eating for " + (eatingTime / 1000) + " seconds");
                        Thread.sleep(eatingTime);

                        // Put down forks
                        leftFork.putDownFork();
                        rightFork.putDownFork();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread philB = new Thread(new Runnable() {
            @Override
            public void run() {
                Fork leftFork = forkAB;
                Fork rightFork = forkBC;
                while (mainThread.isAlive()) {
                    try {
                        // THINK from 1 to 5 seconds
                        int thinkingTime = (ThreadLocalRandom.current().nextInt(0, 5) + 1) * 1000;
                        System.out.println("Philosopher B: Thinking for " + (thinkingTime / 1000) + " seconds");
                        Thread.sleep(thinkingTime);

                        // Left fork
                        System.out.println("Philosopher B: attempt to acquire fork to left");
                        leftFork.pickUpFork();
                        System.out.println("Philosopher B: acquired left fork");

                        // Right fork
                        System.out.println("Philosopher B: attempt to acquire fork to right");
                        rightFork.pickUpFork();
                        System.out.println("Philosopher B: acquired right fork");

                        // EAT from 1 to 10 seconds
                        int eatingTime = (ThreadLocalRandom.current().nextInt(0, 10) + 1) * 1000;
                        System.out.println("Philosopher B: Eating for " + (eatingTime / 1000) + " seconds");
                        Thread.sleep(eatingTime);

                        // Put down forks
                        leftFork.putDownFork();
                        rightFork.putDownFork();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread philC = new Thread(new Runnable() {
            @Override
            public void run() {
                Fork leftFork = forkBC;
                Fork rightFork = forkCD;
                while (mainThread.isAlive()) {
                    try {
                        // THINK from 1 to 5 seconds
                        int thinkingTime = (ThreadLocalRandom.current().nextInt(0, 5) + 1) * 1000;
                        System.out.println("Philosopher C: Thinking for " + (thinkingTime / 1000) + " seconds");
                        Thread.sleep(thinkingTime);

                        // Left fork
                        System.out.println("Philosopher C: attempt to acquire fork to left");
                        leftFork.pickUpFork();
                        System.out.println("Philosopher C: acquired left fork");

                        // Right fork
                        System.out.println("Philosopher C: attempt to acquire fork to right");
                        rightFork.pickUpFork();
                        System.out.println("Philosopher C: acquired right fork");

                        // EAT from 1 to 10 seconds
                        int eatingTime = (ThreadLocalRandom.current().nextInt(0, 10) + 1) * 1000;
                        System.out.println("Philosopher C: Eating for " + (eatingTime / 1000) + " seconds");
                        Thread.sleep(eatingTime);

                        // Put down forks
                        leftFork.putDownFork();
                        rightFork.putDownFork();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread philD = new Thread(new Runnable() {
            @Override
            public void run() {
                Fork leftFork = forkCD;
                Fork rightFork = forkDE;
                while (mainThread.isAlive()) {
                    try {
                        // THINK from 1 to 5 seconds
                        int thinkingTime = (ThreadLocalRandom.current().nextInt(0, 5) + 1) * 1000;
                        System.out.println("Philosopher D: Thinking for " + (thinkingTime / 1000) + " seconds");
                        Thread.sleep(thinkingTime);

                        // Left fork
                        System.out.println("Philosopher D: attempt to acquire fork to left");
                        leftFork.pickUpFork();
                        System.out.println("Philosopher D: acquired left fork");

                        // Right fork
                        System.out.println("Philosopher D: attempt to acquire fork to right");
                        rightFork.pickUpFork();
                        System.out.println("Philosopher D: acquired right fork");

                        // EAT from 1 to 10 seconds
                        int eatingTime = (ThreadLocalRandom.current().nextInt(0, 10) + 1) * 1000;
                        System.out.println("Philosopher D: Eating for " + (eatingTime / 1000) + " seconds");
                        Thread.sleep(eatingTime);

                        // Put down forks
                        leftFork.putDownFork();
                        rightFork.putDownFork();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread philE = new Thread(new Runnable() {
            @Override
            public void run() {
                Fork leftFork = forkDE;
                Fork rightFork = forkEA;
                while (mainThread.isAlive()) {
                    try {
                        // THINK from 1 to 5 seconds
                        int thinkingTime = (ThreadLocalRandom.current().nextInt(0, 5) + 1) * 1000;
                        System.out.println("Philosopher E: Thinking for " + (thinkingTime / 1000) + " seconds");
                        Thread.sleep(thinkingTime);

                        // Left fork
                        System.out.println("Philosopher E: attempt to acquire fork to left");
                        leftFork.pickUpFork();
                        System.out.println("Philosopher E: acquired left fork");

                        // Right fork
                        System.out.println("Philosopher E: attempt to acquire fork to right");
                        rightFork.pickUpFork();
                        System.out.println("Philosopher E: acquired right fork");

                        // EAT from 1 to 10 seconds
                        int eatingTime = (ThreadLocalRandom.current().nextInt(0, 10) + 1) * 1000;
                        System.out.println("Philosopher E: Eating for " + (eatingTime / 1000) + " seconds");
                        Thread.sleep(eatingTime);

                        // Put down forks
                        leftFork.putDownFork();
                        rightFork.putDownFork();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        philA.start();
        philB.start();
        philC.start();
        philD.start();
        philE.start();

        // 1 minute
        int programDuration = 60 * 1000;
        mainThread.sleep(programDuration);

    }
}
