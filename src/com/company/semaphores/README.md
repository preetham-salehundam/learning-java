## BLOCKING ARRAY LIST using Semaphores


 * This list once filled, blocks and waits until any element is removed
 * semaphores have two methods acquire and release
 * semaphores instantiated with a limit n, has 'n' permits
 * each acquire uses one permit
 * once all the permits are used up
 * the thread is blocked and a semaphore needs to released for the thread to activate again
 * so on every add operation we call semaphore.acquire() to acquire a permit.
    * once the permits are exhausted, the thread calling the add method goes to wait.
 * on each remove operation, we release the acquired permit by calling semaphore.release()
    * on release of a permit, the blocked thread calling add method is interrupted and gets blocked again once the permits are used up.
    
 ## Applications:
 - Can be used as buffer to convert parallel data to serial.
 - Can sequentialize a parallel process.
 
 

