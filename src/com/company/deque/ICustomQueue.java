package com.company.deque;

public interface ICustomQueue<T> {

    public int size();

    public boolean isEmpty();

    public DequeNode<T> enqueue();

    public DequeNode<T> dequeue();

}
