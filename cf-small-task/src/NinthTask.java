//implement your own doubly linked list structure
public class NinthTask {
    // Node is an object that holds data and points to the next and previous nodes in the doubly linked list!
    public static class Node {
        String data;
        //pointer next
        Node next;
        //pointer previous
        Node prev;

        public Node(String data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node start;
    private Node end;

    public boolean add(String data) {
        Node newNode = new Node(data);
        //if the list is Empty
        if (start == null) {
            start = end = newNode;
            return true;
        }
        //last.next (null) be the new Node
        //1 <-> 2 <-> 3  (new4)
        end.next = newNode;
        //new Node prev be the end
        //1 <-> 2 <-> 3 <- (new4)
        newNode.prev = end;
        //new node be the last element
        //1 <-> 2 <-> 3 <-> (new4)
        end = newNode;
        return true;
    }

    public String get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int halfSize = size() / 2;
        Node actual = start;

        if (index < halfSize) {
            for (int i = 0; i < index; i++) {
                actual = actual.next;
            }
        } else {
            actual = end;
            for (int i = size() - 1; i > index; i--) {
                actual = actual.prev;
            }
        }
        return actual.data;
    }

    public boolean contains(String data) {
        Node actual = start;
        while (actual != null) {
            if (actual.data.equals(data)) {
                return true;
            }
            actual = actual.next;
        }
        return false;
    }

    public boolean remove(String data) {
        if (start == null) {
            return false;
        }
        Node actual = start;
        while (actual != null) {
            if (actual.data.equals(data)) {
                //if the first element
                if (actual == start) {
                    start = actual.next;
                    //the prev pointer points to the element what we want to delete.
                    if (start != null) {
                        //set is null
                        start.prev = null;
                    }
                    //if the last
                } else if (actual == end) {
                    end.prev = actual;
                    end.next = null;
                } else {
//[  1  ] <-> [  2 ] <-> [   3  ] <-> [  4 ] <-> [  5 ]
//[first] <-> [prev] <-> [actual] <-> [next] <-> [last] <-> [null]

// The previous element (2)'s next pointer now points to the element after the one being deleted (4).
                    actual.prev.next = actual.next;
//The next element (4)'s previous pointer now points to the element after the one being deleted (2).
                    actual.next.prev = actual.prev;
                }
                return true;
            }
            actual = actual.next;
        }
        return false;
    }

    public int size() {
        int counter = 0;
        Node actual = start;
        while (actual != null) {
            actual = actual.next;
            counter++;
        }
        return counter;
    }

    public boolean clear() {
        if (start == null) {
            return false;
        }
        //we set the start and end to null, so the list becomes empty
        start = null;
        end = null;
        return true;
    }

    public boolean isEmpty() {
        return start == null && end == null;
    }
}
