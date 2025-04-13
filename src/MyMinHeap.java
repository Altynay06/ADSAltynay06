import java.util.ArrayList;

public class MyMinHeap {
    private ArrayList<Integer> heap = new ArrayList<>();

    public void add(int val) {
        heap.add(val);
        int i = heap.size() - 1;
        while (i > 0 && heap.get(i) < heap.get((i - 1) / 2)) {
            int temp = heap.get(i);
            heap.set(i, heap.get((i - 1) / 2));
            heap.set((i - 1) / 2, temp);
            i = (i - 1) / 2;
        }
    }

    public int removeMin() {
        if (heap.isEmpty()) throw new IllegalStateException();
        int min = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapify(0);
        }
        return min;
    }

    private void heapify(int i) {
        int left = 2*i + 1, right = 2*i + 2, smallest = i;
        if (left < heap.size() && heap.get(left) < heap.get(smallest)) smallest = left;
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) smallest = right;
        if (smallest != i) {
            int temp = heap.get(i);
            heap.set(i, heap.get(smallest));
            heap.set(smallest, temp);
            heapify(smallest);
        }
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}