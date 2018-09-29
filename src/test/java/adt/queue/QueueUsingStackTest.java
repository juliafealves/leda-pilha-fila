package adt.queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueueUsingStackTest {

    private Queue<Integer> queue;

    @Before
    public void setUp() {
        this.queue = new QueueUsingStack<>(7);
    }

    @Test
    public void testIsEmpty() {
        Assert.assertTrue(this.queue.isEmpty());
    }

    @Test
    public void testIsNotFull() {
        Assert.assertFalse(this.queue.isFull());
    }

    @Test
    public void testEnqueue() throws QueueOverflowException {
        this.queue.enqueue(2);
        this.queue.enqueue(3);
        this.queue.enqueue(7);

        Assert.assertEquals(2, this.queue.head(), 0);
    }

    @Test(expected = QueueOverflowException.class)
    public void testEnqueueFull() throws QueueOverflowException {
        this.queue.enqueue(1);
        this.queue.enqueue(2);
        this.queue.enqueue(3);
        this.queue.enqueue(4);
        this.queue.enqueue(5);
        this.queue.enqueue(6);
        this.queue.enqueue(7);
        this.queue.enqueue(0);
    }

    @Test
    public void testEnqueueDequeue() throws QueueOverflowException, QueueUnderflowException {
        Queue<Integer> queue = new QueueUsingStack<>(3);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(7);
        Assert.assertTrue(queue.isFull());
        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals(2, queue.head(), 0);

        queue.dequeue();
        Assert.assertEquals(3, queue.head(), 0);

        queue.dequeue();
        Assert.assertEquals(7, queue.head(), 0);
        queue.dequeue();

        Assert.assertTrue(queue.isEmpty());
        Assert.assertFalse(queue.isFull());
    }

    @Test
    public void testDequeue() throws QueueOverflowException, QueueUnderflowException {
        this.queue.enqueue(2);
        this.queue.enqueue(3);
        this.queue.enqueue(7);
        this.queue.dequeue();
        Assert.assertEquals(3, this.queue.head(), 0);
    }

    @Test(expected = QueueUnderflowException.class)
    public void testDequeueEmpty() throws QueueUnderflowException {
        this.queue.dequeue();
    }

    @Test
    public void testHead() throws QueueOverflowException {
        this.queue.enqueue(2);
        Assert.assertEquals(2, this.queue.head(), 0);
    }

    @Test
    public void testHeadEmpty() {
        Assert.assertNull(this.queue.head());
    }
}
