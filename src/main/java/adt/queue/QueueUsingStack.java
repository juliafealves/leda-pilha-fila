package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

    private Stack<T> stack1;
    private Stack<T> stack2;
    private int size;
    private int count;

    /**
     * Initialize queue using stack.
     *
     * @param size
     */
    public QueueUsingStack(int size) {
        this.stack1 = new StackImpl<>(size);
        this.stack2 = new StackImpl<>(size);
        this.size = size;
        this.count = 0;
    }

    /**
     * Pop in stack2.
     * If the queue has elements, it removes the oldest of the queue and returns it;
     * otherwise, it throws an exception.
     *
     * @return
     * @throws QueueUnderflowException
     */
    @Override
    public T dequeue() throws QueueUnderflowException {
        if (this.isEmpty()) {
            throw new QueueUnderflowException();
        }

        T element = null;
        this.unStack();

        try {
            element = this.stack2.pop();
            this.count--;
        } catch (StackUnderflowException e) {
            e.printStackTrace();
        }

        return element;
    }

    /**
     * Push in stack1.
     * Inserts a new element in the queue or returns an exception if the queue
     * is full. Null elements are not allowed (the queue remains unchanged).
     *
     * @param element
     * @throws QueueOverflowException
     */
    @Override
    public void enqueue(T element) throws QueueOverflowException {
        if (this.isFull()) {
            throw new QueueOverflowException();
        }

        try {
            this.stack1.push(element);
            this.count++;
        } catch (StackOverflowException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns (without removing) the oldest element of the queue; or
     * null if the queue is empty.
     *
     * @return
     */
    @Override
    public T head() {
        T element = null;

        if (!this.isEmpty()) {
            this.unStack();
            element = this.stack2.top();
        }

        return element;
    }

    /**
     * Returns true if the queue is empty; or false, otherwise.
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * Returns true if the queue is full; or false, otherwise.
     *
     * @return
     */
    @Override
    public boolean isFull() {
        return this.count == this.size;
    }

    /**
     * Unstack the stacks.
     */
    private void unStack() {
        if (!this.isEmpty()) {
            T element;

            /*
             * If stack2 is empty, then, while stack1 is not empty,
             * push everything from stack1 to stack2.
             */
            if (stack2.isEmpty()) {
                while (!this.stack1.isEmpty()) {
                    try {
                        element = this.stack1.pop();
                        this.stack2.push(element);
                    } catch (StackUnderflowException | StackOverflowException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
