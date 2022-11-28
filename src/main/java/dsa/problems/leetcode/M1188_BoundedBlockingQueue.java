/*
 * Medium 1188 - Design Bounded Blocking Queue
 * https://leetcode.com/problems/design-bounded-blocking-queue/
 *
 * Implement a thread safe bounded blocking queue that has the following methods:

    BoundedBlockingQueue(int capacity) The constructor initializes the queue with a maximum capacity.
    void enqueue(int element) Adds an element to the front of the queue. If the queue is full, the calling thread is blocked until the queue is no longer full.
    int dequeue() Returns the element at the rear of the queue and removes it. If the queue is empty, the calling thread is blocked until the queue is no longer empty.
    int size() Returns the number of elements currently in the queue.

    Your implementation will be tested using multiple threads at the same time. Each thread will either be a producer thread that only makes calls to the enqueue method or a consumer thread that only makes calls to the dequeue method. The size method will be called after every test case.

    Please do not use built-in implementations of bounded blocking queue as this will not be accepted in an interview.
 */

package dsa.problems.leetcode;

public class M1188_BoundedBlockingQueue {
    private final int[] queue;
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    private final int capacity;

    public M1188_BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
    }

    public void enqueue(int element) throws InterruptedException {
        synchronized (this) {
            while (size == capacity) {
                wait();
            }
            queue[tail] = element;
            tail = (tail + 1) % capacity;
            size++;
            notifyAll();
        }
    }

    public int dequeue() throws InterruptedException {
        synchronized (this) {
            while (size == 0) {
                wait();
            }
            int element = queue[head];
            head = (head + 1) % capacity;
            size--;
            notifyAll();
            return element;
        }
    }

    public int size() {
        synchronized (this) {
            return size;
        }
    }
}

