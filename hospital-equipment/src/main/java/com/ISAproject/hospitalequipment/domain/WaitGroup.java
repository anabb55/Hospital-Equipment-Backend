package com.ISAproject.hospitalequipment.domain;

public class WaitGroup {

    public WaitGroup(int jobs) {
        this.jobs = jobs;
    }

    private int jobs = 0;

    public synchronized void add(int i) {
        jobs += i;
    }

    public synchronized void done() {
        if (--jobs == 0) {
            notifyAll();
        }
    }

    public synchronized void await() throws InterruptedException {
        while (jobs > 0) {
            wait();
        }
    }

}
