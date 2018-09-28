package adt.queue;

/**
 * The interface of a generic queue. The queue is able to store any kind of data.
 */
public class QueueImpl<T> implements Queue<T> {

    private T[] array;
    private int tail;

    /**
     * Initialize the queue.
     * @param size
     */
    @SuppressWarnings("unchecked")
    public QueueImpl(int size) {
        array = (T[]) new Object[size];
        tail = -1;
    }

    /**
     * If the queue has elements, it removes the oldest of the queue and returns
     * it; otherwise, it throws an exception.
     *
     * @return
     * @throws QueueUnderflowException
     */
    @Override
    public T dequeue() throws QueueUnderflowException {
        if (this.isEmpty()) {
            throw new QueueUnderflowException();
        }

        T element = this.head();
        this.shiftLeft();
        this.tail--;

        return element;
    }

    /**
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

        this.array[++this.tail] = element;
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
            element = this.array[0];
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
        return this.tail == -1;
    }

    /**
     * Returns true if the queue is full; or false, otherwise.
     *
     * @return
     */
    @Override
    public boolean isFull() {
        return this.tail == (this.array.length - 1);
    }

    /**
     * Execute shift of all elements in one position to left.
     */
    private void shiftLeft() {
        if(this.tail >= 0){
            for (int i = 0; i < tail; i++) {
                this.array[i] = this.array[i + 1];
            }
        }
    }
}
