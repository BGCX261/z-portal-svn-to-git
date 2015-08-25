package iglabs.zportal.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class Sequences {
    private Sequences() {
    }
    
    public static <E> ArrayList<E> toList(Iterable<? extends E> iterable) {
        ArrayList<E> result = new ArrayList<E>();
        
        Iterator<? extends E> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            E elem = iterator.next();
            result.add(elem);
        }
        
        return result;
    }
    
    @SuppressWarnings("unchecked")
    public static <E> E[] toArray(Class<E> klass, Iterable<? extends E> iterable) {
        ArrayList<E> list = toList(iterable);
        return list.toArray((E[])Array.newInstance(klass, list.size()));
    }
    
    public static <E> void addAll(Collection<? super E> toCollection,
            Iterable<? extends E> iterable) {
     
        if (iterable == null) { return; }
        
        Iterator<? extends E> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            E elem = iterator.next();
            toCollection.add(elem);
        }
    }
    
    public static <E> void addAll(
            Collection<? super E> toCollection, E[] array) {
        
        if (array == null) { return; }
        
        for (int i = 0; i < array.length; ++i) {
            toCollection.add(array[i]);
        }
    }
    
    
    private static class ReadOnlyIterator<E>
        implements Iterator<E> {
        
        public ReadOnlyIterator(Iterator<E> iterator) {
            this.iterator = iterator;
        }
        
        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public E next() {
            return iterator.next();
        }
        
        @Override
        public void remove() {
            throw new RuntimeException("Not supported");
        }
        
        private final Iterator<E> iterator;
    }
    
    public static <E> Iterable<E> readOnlyIterable(
            final Iterable<E> iterable) {
        
        return new Iterable<E>() {
            @Override
            public Iterator<E> iterator() {
                return new ReadOnlyIterator<E>(iterable.iterator());
            }
        };
    }
}
