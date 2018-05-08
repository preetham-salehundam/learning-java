package com.company.semaphores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;


/**
 * this list once filled blocks and waits until any element is removed
 * semaphores have two methods acquire and release
 * semaphores instantiated with a limit n, has 'n' permits
 * each acquire uses one permit
 * once all the permits are used
 * the thread is blocked and a semaphore needs to released for the thread to activate again
 */
public class BlockingArrayList<T> {
    private List<T> arrayList;
    private Semaphore semaphore;

    public BlockingArrayList(int permitLimit) {
        this.arrayList = Collections.synchronizedList(new ArrayList<>());
        // limit the semaphore
        this.semaphore = new Semaphore(permitLimit);

    }

    /**
     * acquires a permit and adds the element to the array list
     * if element is not added the permit is released
     *
     * @param e element to be added to the list
     * @throws InterruptedException when the permits left are zero and an element is removed there by releasing a permit.
     *                              this will interrupt the sleeping thread
     */
    public boolean add(T e) throws InterruptedException {
        Boolean added = false;
        semaphore.acquire();
        try {
            //try to add the element to arraylist if some exception occurs release the lock
            added = this.arrayList.add(e);
        } finally {
            //if not added then release lock
            if (!added) {
                semaphore.release();
            }
        }
        return added;
    }

    /**
     * remove an element from the arraylist
     * if removed succesfully, a semaphore is released
     *
     * @param e element to be inserted into array list
     * @return insertion status
     * @throws
     */
    public boolean remove(T e) {
        boolean wasRemoved = false;
        wasRemoved = this.arrayList.remove(e);
        if (wasRemoved)
            semaphore.release();
        return wasRemoved;
    }

    /**
     * remove an element at a particular index
     * @param index index at which the element needs to be removed
     * */
    public void remove(int index){
       this.arrayList.remove(index);
       semaphore.release();
    }


    public List<T> getArrayList(){
        return this.arrayList;
    }

    public Semaphore getSemaphore(){
        return this.semaphore;
    }

}
