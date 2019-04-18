public class MyLinkedList<T> implements MyList<T> {

	public Node firstNode;
	private Node lastNode;
	private int size = 0;

	public MyLinkedList() {
		size = 0;
	}

	public Node<T> getFirstNode() {
		return firstNode;
	}

	public Node<T> getLastNode() {
		return lastNode;
	}

	public void add(T value) {
		if (firstNode == null) {
			firstNode = new Node(null, null, value);
			lastNode = firstNode;
		} else {
			Node currentNode = new Node(lastNode, null, value);
			lastNode.next = currentNode;
			lastNode = currentNode;
		}
		size++;
	}

	public void add(T value, int index) {
		checkIndex(index);
		Node<T> bufferNode = getNode(index);
		Node<T> newNode = new Node<T>(bufferNode.prev, bufferNode, value);
		bufferNode.prev.next = newNode;
		bufferNode.prev = newNode;
		size++;
	}

	public T get(int index) {
		checkIndex(index);
		Node<T> requiredNode = firstNode;
		for (int i = 0; i < index; i++) {
			requiredNode = requiredNode.next;
		}
		return requiredNode.value;
	}

	public Node<T> getNode(int index) {
		checkIndex(index);
		Node<T> requiredNode = firstNode;
		for (int i = 0; i < index; i++) {
			requiredNode = requiredNode.next;
		}
		return requiredNode;
	}

	public void set(T value, int index) {
		checkIndex(index);
		Node<T> bufferNode = getNode(index);
		bufferNode.value = value;
	}

	public T remove(int index) {
		checkIndex(index);
		Node<T> bufferNode = getNode(index);
		if (index == 0) {
			firstNode = firstNode.next;
			firstNode.prev = null;
			bufferNode.next = null;
		} else {
			bufferNode.prev.next = bufferNode.next;
			bufferNode.next.prev = bufferNode.prev;
			bufferNode.prev = null;
			bufferNode.next = null;
		}
		size--;
		return bufferNode.value;
	}

	public void remove(T value) {
		Node<T> bufferNode = firstNode;
		for (int i = 0; i < size; i++) {
			if (bufferNode.value.equals(value)) {
				remove(i);
				break;
			} else {
				bufferNode = bufferNode.next;
			}
		}
	}

	public void addAll(MyList<T> list) {
		for (int i = 0; i < list.size(); i++) {
			add(list.get(i));
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public String toString() {
		Node<T> currentNode = firstNode;
		StringBuilder result = new StringBuilder(currentNode.value.toString()).append(" ");
		while (currentNode.next != null) {
			currentNode = currentNode.next;
			result.append(currentNode.value.toString()).append(" ");
		}
		return result.toString();
	}

	private class Node<T> {
		private Node prev;
		private Node next;
		private T value;

		public Node(Node prev, Node next, T value) {
			this.prev = prev;
			this.next = next;
			this.value = value;
		}
	}

	private void checkIndex(int index) {
		if (size < index || index < 0) {
			throw new ArrayIndexOutOfBoundsException("Index: " + index + " size: " + size);
		}
	}
}