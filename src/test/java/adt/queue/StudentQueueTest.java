package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentQueueTest {

    public Queue<Integer> queue1;
    public Queue<Integer> queue2;
    public Queue<Integer> queue3;

    private Queue<Integer> queue;

    @Before
    public void setUp() throws QueueOverflowException {
        getImplementations();
        queue = new QueueImpl<>(7);

        // Fila com 3 elementos não cheia.
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);

        // Fila com 2 elementos de tamanho 2. Fila cheia.
        queue2.enqueue(1);
        queue2.enqueue(2);

    }

    private void getImplementations() {
        // TODO O aluno deve ajustar aqui para instanciar sua implementação
        queue1 = new QueueImpl<>(4);
        queue2 = new QueueImpl<>(2);
        queue3 = new QueueImpl<>(3);
    }

    // MÉTODOS DE TESTE
    @Test
    public void testHead() {
        assertEquals(new Integer(1), queue1.head());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(queue1.isEmpty());
        assertTrue(queue3.isEmpty());
    }

    @Test
    public void testIsFull() {
        assertFalse(queue1.isFull());
    }

    @Test
    public void testEnqueue() {
        try {
            queue1.enqueue(new Integer(5));
        } catch (QueueOverflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test(expected = QueueOverflowException.class)
    public void testEnqueueComErro() throws QueueOverflowException {
        queue1.enqueue(new Integer(5)); // vai depender do tamanho que a fila
        // foi iniciada!!!
    }

    @Test
    public void testDequeue() {
        try {
            assertEquals(new Integer(1), queue1.dequeue());
        } catch (QueueUnderflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test(expected = QueueUnderflowException.class)
    public void testDequeueComErro() throws QueueUnderflowException {
        assertEquals(new Integer(1), queue1.dequeue()); // vai depender do
        // tamanho que a fial
        // foi iniciada!!!
    }

    @Test
    public void testQueueIsEmpty() {
        Assert.assertTrue(this.queue.isEmpty());
    }

    @Test
    public void testQueueIsNotEmpty() throws QueueOverflowException {
        this.queue.enqueue(2);
        Assert.assertFalse(this.queue.isEmpty());
    }

    @Test
    public void testQueueIsFull() throws QueueOverflowException {
        Queue<Integer> queue = new QueueImpl<>(2);
        queue.enqueue(2);
        queue.enqueue(3);
        Assert.assertTrue(queue.isFull());
    }

    @Test
    public void testQueueIsNotFull() {
        Assert.assertFalse(this.queue.isFull());
    }

    @Test
    public void testQueueHeadIsEmpty() {
        Assert.assertNull(this.queue.head());
    }

    @Test
    public void testQueueHead() throws QueueOverflowException {
        this.queue.enqueue(3);
        this.queue.enqueue(2);
        this.queue.enqueue(1);
        Assert.assertEquals(3, this.queue.head(), 0);
    }

    @Test
    public void testQueueEnqueue() throws QueueOverflowException {
        this.queue.enqueue(1);
        this.queue.enqueue(2);
        this.queue.enqueue(3);
        Assert.assertEquals(1, this.queue.head(), 0);
    }

    @Test(expected = QueueOverflowException.class)
    public void testQueueEnqueueFull() throws QueueOverflowException {
        this.queue.enqueue(1);
        this.queue.enqueue(2);
        this.queue.enqueue(3);
        this.queue.enqueue(4);
        this.queue.enqueue(5);
        this.queue.enqueue(6);
        this.queue.enqueue(7);
        this.queue.enqueue(8);
    }

    @Test
    public void testQueueDequeueHead() throws QueueOverflowException, QueueUnderflowException {
        this.queue.enqueue(1);
        this.queue.enqueue(2);
        this.queue.dequeue();
        this.queue.dequeue();
        this.queue.enqueue(3);
        Assert.assertEquals(3, this.queue.head(), 0);
    }

    @Test
    public void testQueueDequeue() throws QueueOverflowException, QueueUnderflowException {
        this.queue.enqueue(1);
        this.queue.enqueue(2);
        this.queue.dequeue();
        this.queue.enqueue(3);
        Assert.assertEquals(2, this.queue.head(), 0);
    }

    @Test(expected = QueueUnderflowException.class)
    public void testQueueDequeueEmpty() throws QueueUnderflowException {
        this.queue.dequeue();
    }
}