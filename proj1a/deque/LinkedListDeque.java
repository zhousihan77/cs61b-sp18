/**
 * A naked recursive list of integers, similar to what we saw in lecture 3, but
 * with a large number of additional methods.
 *
 * @author P. N. Hilfinger, with some modifications by Josh Hug and melaniecebula
 *         [Do not modify this file.]
 */
public class LinkedListDeque<T> {
    private int size;
    ListNode senHead;
    ListNode senRear;

    private class ListNode {
        public T item;
        public ListNode next;
        public ListNode last;

        public ListNode(T value, ListNode l, ListNode n) {
            item = value;
            next = n;
            last = l;
        }
    }

    public LinkedListDeque() {
        senHead = new ListNode(null, null, null);
        senRear = new ListNode(null, null, null);
        senHead.next = senRear;
        senRear.last = senHead;
        size = 0;
    }

    public LinkedListDeque(T item) {
        senHead = new ListNode(null, null, null);
        senRear = new ListNode(null, null, null);
        ListNode first = new ListNode(item, senHead, senRear);
        senHead.next = first;
        senRear.last = first;
    }

    public void addFirst(T item) {
        ListNode p = new ListNode(item, senHead, senHead.next);
        p.next.last = p;
        senHead.next = p;
        size++;
    }

    public void addLast(T item) {
        ListNode p = new ListNode(item, senRear.last, senRear);
        senRear.last.next = p;
        p.next = senRear;
        size++;
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        ListNode p = senHead;
        if (p == senRear) {
            return;
        }
        if (p.next != senRear.last) {
            System.out.println(p.next + " ");
            p = p.next;
        }
        System.out.println(p.next);
    }

    public T removeFirst() {
        if (senRear.last == senHead) {
            return null;
        }
        ListNode first = senHead.next;
        senHead.next = first.next;
        first.next.last = senHead;
        size--;
        return first.item;
    }

    public T removeLast() {
        if (senRear.last == senHead) {
            return null;
        }
        ListNode rear = senRear.last;
        rear.last.next = senRear;
        senRear.last = rear.last;
        size--;
        return rear.item;
    }

    public T get(int index) {
        if (size < index) {
            return null;
        }
        ListNode p = senHead.next;
        int count = 0;
        while (count < index) {
            p = p.next;
            count++;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        return recur(index, senHead.next);
    }

    private T recur(int index, ListNode start) {
        if (0 == index) {
            return start.item;
        }
         return recur(index, start.next);
    }
}