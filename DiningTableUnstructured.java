import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
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
                Lock leftFork = forkAB;
                Lock rightFork = forkBC;

                while (mainThread.isAlive()) {
                    try {
                        // THINK from 1 to 5 seconds
                        int thinkingTime = ThreadLocalRandom.current().nextInt(0, 5) + 1;
                        System.out.println("Philosopher A: Thinking for " + thinkingTime + " seconds");
                        Thread.sleep(thinkingTime * 1000);

                        System.out.println("Philosopher A: attempt to acquire fork to left");
                        leftFork.lock();
                        try {
                            System.out.println("Philosopher A: acquired left fork");
                            System.out.println("Philosopher A: attempt to acquire fork to right");
                            rightFork.lock();
                            try {
                                System.out.println("Philosopher A: acquired right fork");

                                // EAT from 1 to 10 seconds
                                int eatingTime = ThreadLocalRandom.current().nextInt(0, 10) + 1;
                                System.out.println("Philosopher A: Eating for " + eatingTime + " seconds");
                                Thread.sleep(eatingTime * 1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } finally {
                                rightFork.unlock();
                            }
                        } finally {
                            leftFork.unlock();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread philB = new Thread(new Runnable() {
            @Override
            public void run() {
                Lock leftFork = forkBC;
                Lock rightFork = forkCD;

                while (mainThread.isAlive()) {
                    try {
                        // THINK from 1 to 5 seconds
                        int thinkingTime = ThreadLocalRandom.current().nextInt(0, 5) + 1;
                        System.out.println("Philosopher B: Thinking for " + thinkingTime + " seconds");
                        Thread.sleep(thinkingTime * 1000);

                        System.out.println("Philosopher B: attempt to acquire fork to left");
                        leftFork.lock();
                        try {
                            System.out.println("Philosopher B: acquired left fork");
                            System.out.println("Philosopher B: attempt to acquire fork to right");
                            rightFork.lock();
                            try {
                                System.out.println("Philosopher B: acquired right fork");

                                // EAT from 1 to 10 seconds
                                int eatingTime = ThreadLocalRandom.current().nextInt(0, 10) + 1;
                                System.out.println("Philosopher B: Eating for " + eatingTime + " seconds");
                                Thread.sleep(eatingTime * 1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } finally {
                                rightFork.unlock();
                            }
                        } finally {
                            leftFork.unlock();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread philC = new Thread(new Runnable() {
            @Override
            public void run() {
                Lock leftFork = forkBC;
                Lock rightFork = forkCD;

                while (mainThread.isAlive()) {
                    try {
                        // THINK from 1 to 5 seconds
                        int thinkingTime = ThreadLocalRandom.current().nextInt(0, 5) + 1;
                        System.out.println("Philosopher C: Thinking for " + thinkingTime + " seconds");
                        Thread.sleep(thinkingTime * 1000);

                        System.out.println("Philosopher C: attempt to acquire fork to left");
                        leftFork.lock();
                        try {
                            System.out.println("Philosopher C: acquired left fork");
                            System.out.println("Philosopher C: attempt to acquire fork to right");
                            rightFork.lock();
                            try {
                                System.out.println("Philosopher C: acquired right fork");

                                // EAT from 1 to 10 seconds
                                int eatingTime = ThreadLocalRandom.current().nextInt(0, 10) + 1;
                                System.out.println("Philosopher C: Eating for " + eatingTime + " seconds");
                                Thread.sleep(eatingTime * 1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } finally {
                                rightFork.unlock();
                            }
                        } finally {
                            leftFork.unlock();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread philD = new Thread(new Runnable() {
            @Override
            public void run() {
                Lock leftFork = forkCD;
                Lock rightFork = forkDE;

                while (mainThread.isAlive()) {
                    try {
                        // THINK from 1 to 5 seconds
                        int thinkingTime = ThreadLocalRandom.current().nextInt(0, 5) + 1;
                        System.out.println("Philosopher D: Thinking for " + thinkingTime + " seconds");
                        Thread.sleep(thinkingTime * 1000);

                        System.out.println("Philosopher D: attempt to acquire fork to left");
                        leftFork.lock();
                        try {
                            System.out.println("Philosopher D: acquired left fork");
                            System.out.println("Philosopher D: attempt to acquire fork to right");
                            rightFork.lock();
                            try {
                                System.out.println("Philosopher D: acquired right fork");

                                // EAT from 1 to 10 seconds
                                int eatingTime = ThreadLocalRandom.current().nextInt(0, 10) + 1;
                                System.out.println("Philosopher D: Eating for " + eatingTime + " seconds");
                                Thread.sleep(eatingTime * 1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } finally {
                                rightFork.unlock();
                            }
                        } finally {
                            leftFork.unlock();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread philE = new Thread(new Runnable() {
            @Override
            public void run() {
                Lock leftFork = forkDE;
                Lock rightFork = forkEA;

                while (mainThread.isAlive()) {
                    try {
                        // THINK from 1 to 5 seconds
                        int thinkingTime = ThreadLocalRandom.current().nextInt(0, 5) + 1;
                        System.out.println("Philosopher E: Thinking for " + thinkingTime + " seconds");
                        Thread.sleep(thinkingTime * 1000);

                        System.out.println("Philosopher E: attempt to acquire fork to left");
                        leftFork.lock();
                        try {
                            System.out.println("Philosopher E: acquired left fork");
                            System.out.println("Philosopher E: attempt to acquire fork to right");
                            rightFork.lock();
                            try {
                                System.out.println("Philosopher E: acquired right fork");

                                // EAT from 1 to 10 seconds
                                int eatingTime = ThreadLocalRandom.current().nextInt(0, 10) + 1;
                                System.out.println("Philosopher E: Eating for " + eatingTime + " seconds");
                                Thread.sleep(eatingTime * 1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } finally {
                                rightFork.unlock();
                            }
                        } finally {
                            leftFork.unlock();
                        }
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
