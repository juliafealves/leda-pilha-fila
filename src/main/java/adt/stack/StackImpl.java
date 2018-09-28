package adt.stack;

/**
 * The interface of a generic stack. The queue is able to store any kind of data.
 */
public class StackImpl<T> implements Stack<T> {

    private T[] array;
    private int top;

    /**
     * Initialize a stack.
     * @param size
     */
    @SuppressWarnings("unchecked")
    public StackImpl(int size) {
        array = (T[]) new Object[size];
        top = -1;
    }

    /**
     * If the stack has elements, it removes the top of the stack and returns
     * it; otherwise, it returns an exception.
     *
     * @return
     * @throws StackUnderflowException
     */
    @Override
    public T top() {
        T element = null;

        if (!this.isEmpty()) {
            element = this.array[top];
        }

        return element;
    }

    /**
     * Returns true if the stack is empty or false, otherwise.
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Returns true if the stack is full or false, otherwise.
     *
     * @return
     */
    @Override
    public boolean isFull() {
        return top == (array.length - 1);
    }

    /**
     * Inserts a new element in the stack or returns an exception if the stack
     * is full. Null elements are not allowed (the stack remains unchanged).
     *
     * @param element
     * @throws StackOverflowException
     */
    @Override
    public void push(T element) throws StackOverflowException {
        if (this.isFull()) {
            throw new StackOverflowException();
        }

        this.array[++this.top] = element;
    }

    /**
     * If the stack has elements, it removes the top of the stack and returns
     * it; otherwise, it returns an exception.
     *
     * @return
     * @throws StackUnderflowException
     */
    @Override
    public T pop() throws StackUnderflowException {
        if (this.isEmpty()) {
            throw new StackUnderflowException();
        }

        return this.array[this.top--];
    }
}
