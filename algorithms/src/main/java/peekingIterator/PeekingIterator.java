package peekingIterator;

import java.util.Iterator;

/**
 * 迭代器
 * @author haixiangchen
 */
public class PeekingIterator implements Iterator<Integer> {

    private Integer current;
    private Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        current = null;
    }

    public Integer peek() {
        if (current != null) {
            return current;
        }

        current = iterator.next();
        return current;
    }

    @Override
    public Integer next() {
        if (current != null) {
            int res = current;
            current = null;
            return res;
        }

        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return current != null || iterator.hasNext();
    }
}
