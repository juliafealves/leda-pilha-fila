package adt.stack;

public class StackImpl<T> implements Stack<T> {

    private T[] array;
    private int top;

    @SuppressWarnings("unchecked")
    public StackImpl(int size) {
        array = (T[]) new Object[size];
        top = -1;
    }

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

    @Override
    public boolean isFull() {
        return top == (array.length - 1);
    }

    @Override
    public void push(T element) throws StackOverflowException {
        if (this.isFull()) {
            throw new StackOverflowException();
        }

        this.array[++this.top] = element;
    }

    @Override
    public T pop() throws StackUnderflowException {
        if (this.isEmpty()) {
            throw new StackUnderflowException();
        }

        return this.array[this.top++];
    }
}
