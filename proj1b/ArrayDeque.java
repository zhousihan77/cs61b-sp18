/**
 * A deque list of T, using arrays
 *
 * @author zhou
 * [Do not modify this file.]
 */
public class ArrayDeque<T> implements Deque<T>{
    /**
     * 数组容量
     */
    private int size;
    /**
     * 当前的队列要素个数
     */
    private int count;
    /**
     * 队首位置
     */
    private int first;
    /**
     * 队首位置
     */
    private int rear;

    /**
     * 队首位置
     */
    private T[] que;

    /**
     * A List with first FIRST0 and rest REST0.
     */
    public ArrayDeque() {
        que = (T[]) new Object[8];
        size = 8;
        count = 0;
        first = 0;
        rear = 0;
    }

    /**
     * A List with first FIRST0 and rest REST0.
     */
    private void resize() {
        int originSize = size;
        if(count == size) {
            size *= 2;
        } else if(16 <= count && count < Math.ceil(size / 4)) {
            size /= 2;
        } else {
            return;
        }

        T[] temp = (T[]) new Object[size];
        if (first <= rear) {
            for (int i = first; i <= rear; i++) {
                temp[i - first] = que[i];
            }
        } else {
            for (int i = first; i < originSize; i++) {
                temp[i - first] = que[i];
            }
            for (int i = 0; i <= rear; i++) {
                temp[originSize - first + i] = que[i];
            }
        }
        que = temp;
        first = 0;
        rear = count - 1;
    }

    /**
     * A List with first FIRST0 and rest REST0.
     */
    @Override
    public void addFirst(T item) {
        resize();
        if(0 == count) {
            que[first] = item;
        } else {
            if (0 == first) {
                first = size - 1;
                que[first] = item;
            } else {
                que[--first] = item;
            }
        }
        count++;
    }

    /**
     * A List with first FIRST0 and rest REST0.
     */
    @Override
    public void addLast(T item) {
        resize();
        if(0 == count) {
            que[rear] = item;
        } else {
            if (size - 1 == rear) {
                rear = 0;
                que[rear] = item;
            } else {
                que[++rear] = item;
            }
        }
        count++;
    }

    /**
     * A List with first FIRST0 and rest REST0.
     */
    @Override
    public boolean isEmpty() {
        return count == 0 ? true : false;
    }

    /**
     * A List with first FIRST0 and rest REST0.
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * A List with first FIRST0 and rest REST0.
     */
    @Override
    public void printDeque() {
        if (first <= rear) {
            for (int i = first; i < rear; i++) {
                System.out.println(que[i]);
                System.out.println(" ");
            }
            System.out.println(que[rear]);
        } else {
            for (int i = first; i < size; i++) {
                System.out.println(que[i]);
                System.out.println(" ");
            }
            for (int i = 0; i < rear; i++) {
                System.out.println(que[i]);
                System.out.println(" ");
            }
            System.out.println(que[rear]);
        }
    }

    /**
     * A List with first FIRST0 and rest REST0.
     */
    @Override
    public T removeFirst() {
        if(0 == count) {
            return null;
        }
        T temp = que[first];
        if (first != rear) {
            if (size - 1 == first) {
                first = 0;
            } else {
                first++;
            }
        }
        count--;
        resize();
        return temp;
    }

    /**
     * A List with first FIRST0 and rest REST0.
     */
    @Override
    public T removeLast() {
        if(0 == count) {
            return null;
        }
        T temp = que[rear];
        if (first != rear) {
            if (0 == rear) {
                rear = size - 1;
            } else {
                rear--;
            }
        }
        count--;
        resize();
        return temp;
    }

    /**
     * A List with first FIRST0 and rest REST0.
     *
     * @param index
     */
    @Override
    public T get(int index) {
        if (count <= index) {
            return null;
        }
        if (first <= rear || index < size - first) {
            return que[first + index];
        } else {
            return que[index - (size - first)];
        }
    }
}

