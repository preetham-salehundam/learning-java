package com.company.deque;

/**
 *  implementing deque with doubly linked list
 *
 *
 * */
public class Deque<T> implements ICustomDeque<T> {

    public DequeNode head = null;
    public DequeNode tail = null;

    public Deque(DequeNode<T> head, DequeNode<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    public Deque() {
        this.head = null;
        this.tail = null;
    }
    /**
     * iterate till last element, when lastele.next is null
     * and loop breaks
     * */
    @Override
    public int size() {
        int i = 0;
        if (!isEmpty()) {
            while (head != null) {
                head = head.next;
                i++;
            }
        }
        return i;
    }

    /**
     *
     * head = null when deque is empty
     * */
    @Override
    public boolean isEmpty() {
        return head==null;
    }

    /**similar to size*/
    @Override
    public void display() {

        if(!isEmpty()){
            while(head!=null){
                head = head.next;
                System.out.print(head.value + " - ");
            }

        }

    }

    /**
     *
     *
     **/
    @Override
    public void insertFirst(DequeNode element) {



    }

    @Override
    public void insertLast(DequeNode element) {

    }

    @Override
    public void removeFirst(DequeNode element) {

    }

    @Override
    public void removeLast(DequeNode element) {

    }


}
