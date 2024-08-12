import lombok.Getter;

import java.util.*;

@Getter
public  class Box implements Iterable<String>{
    private final List<String> list1;
    private final List<String> list2;
    private final List<String> list3;
    private final List<String> list4;

    public Box(){
        this.list1 = new ArrayList<>();
        this.list2 = new ArrayList<>();
        this.list3 = new ArrayList<>();
        this.list4 = new ArrayList<>();
    }
    @Override
    public Iterator<String> iterator() {
        return new IteratorBox();
    }
    public class IteratorBox implements Iterator<String>{
        private Queue<List<String>> listQueue = new LinkedList<>();
        private int index = 0;
        private int current = 1;


        public IteratorBox() {
            listQueue.add(list1);
            listQueue.add(list2);
            listQueue.add(list3);
            listQueue.add(list4);
        }

        private String getElements() {
            return switch (current) {
                case 1 -> list1.get(index++);
                case 2 -> list2.get(index++);
                case 3 -> list3.get(index++);
                case 4 -> list4.get(index++);
                default -> null;
            };
        }

        @Override
        public boolean hasNext() {
            while (current <= 4) {
                if (index < listQueue.peek().size()) {
                    return true;
                } else {
                    current++;
                    index = 0;
                }
            }
            return false;
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return getElements();
        }
    }
}
