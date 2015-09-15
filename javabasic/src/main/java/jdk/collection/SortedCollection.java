package jdk.collection;

import java.util.Collection;
import java.util.Comparator;

public interface SortedCollection<E> extends Collection<E> {

	public Comparator<E> getComparator();
	public void setComparator(Comparator<E> comp);
}
