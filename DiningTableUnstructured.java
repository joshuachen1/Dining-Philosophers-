import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  @author Joshua Chen
 *  Date: Oct 14, 2018
 */
public class DiningTableUnstructured {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();

        Lock forkAB = new ReentrantLock();
        Lock forkBC = new ReentrantLock();
        Lock forkCD = new ReentrantLock();
        Lock forkDE = new ReentrantLock();
        Lock forkEA = new ReentrantLock();

        Thread philA = new Thread(new Runnable() {
            @Override
            public void run() {
                Lock leftFork = forkEA;
                Lock rightFork = forkAB;

                while (mainThread.isAlive()) {
                    try {
                        // THINK from 1 to 5 seconds
                        int thinkingTime = ThreadLocalRandom.current().nextInt(0, 5) + 1;
                        System.out.println("Philosopher A: Thinking for " + thinkingTime + " seconds");
                        Thread.sleep(thinkingTime * 1000);

                        // Keep checking to see if either fork is available until both are obtained
                        boolean needLeftFork = true;
                        boolean needRightFork = true;

                        while (needLeftFork || needRightFork) {
                            // Left fork
                            System.out.println("Philosopher A: attempt to acquire fork to left");
                            if (leftFork.tryLock()) {
                                leftFork.lock();
                                System.out.println("Philosopher A: acquired left fork");
                                needLeftFork = false;
                            }

                            // Right fork
                            System.out.println("Philosopher A: attempt to acquire fork to right");
                            if (rightFork.tryLock()) {
                                rightFork.lock();
                                System.out.println("Philosopher A: acquired right fork");
                                needRightFork = false;
                            }
                        }

                        // EAT from 1 to 10 seconds
                        int eatingTime = ThreadLocalRandom.current().nextInt(0, 10) + 1;
                        System.out.println("Philosopher A: Eating for " + eatingTime + " seconds");
                        Thread.sleep(eatingTime * 1000);

                        // Put down forks
                        leftFork.unlock();
                        rightFork.unlock();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread philB = new Thread(new Runnable() {
            @Override
            public void run() {
                Lock leftFork = forkAB;
                Lock rightFork = forkBC;

                while (mainThread.isAlive()) {
                    try {
                        // THINK from 1 to 5 seconds
                        int thinkingTime = ThreadLocalRandom.current().nextInt(0, 5) + 1;
                        System.out.println("Philosopher B: Thinking for " + thinkingTime + " seconds");
                        Thread.sleep(thinkingTime * 1000);

                        // Keep checking to see if either fork is available until both are obtained
                        boolean needLeftFork = true;
                        boolean needRightFork = true;

                        while (needLeftFork || needRightFork) {
                            // Left fork
                            System.out.println("Philosopher B: attempt to acquire fork to left");
                            if (leftFork.tryLock()) {
                                leftFork.lock();
                                System.out.println("Philosopher B: acquired left fork");
                                needLeftFork = false;
                            }

                            // Right fork
                            System.out.println("Philosopher B: attempt to acquire fork to right");
                            if (rightFork.tryLock()) {
                                rightFork.lock();
                                System.out.println("Philosopher B: acquired right fork");
                                needRightFork = false;
                            }
                        }

                        // EAT from 1 to 10 seconds
                        int eatingTime = ThreadLocalRandom.current().nextInt(0, 10) + 1;
                        System.out.println("Philosopher B: Eating for " + eatingTime + " seconds");
                        Thread.sleep(eatingTime * 1000);

                        // Put down forks
                        leftFork.unlock();
                        rightFork.unlock();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        philA.start();
        philB.start();

        // 1 minute
        int programDuration = 60 * 1000;
        mainThread.sleep(programDuration);
    }
}
