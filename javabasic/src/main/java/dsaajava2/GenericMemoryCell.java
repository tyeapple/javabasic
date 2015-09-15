package dsaajava2;

public class GenericMemoryCell<T> {

	public T read() {
		return storedValue;
	}
	public void write(T x) {
		storedValue = x;
	}
	private T storedValue;
}
