//implement your own linked list structure

// Node is an object that holds data and points to the next Node in the linked list!
public class EighthTask {
    public static class Node {
        //data
        String data;
        //pointer to the next node
        Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    //first element of the list
    private Node start;

    public boolean add(String data) {
        Node newNode = new Node(data);
        if (start == null) {
            start = newNode;
            return true;
        }

        Node current = start;
        //go to end of the list
        while (current.next != null) {
            current = current.next;
        }
        //append the new Node at the end
        current.next = newNode;
        return true;
    }

    public String get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        //first element (node)
        Node actual = start;
        for (int i = 0; i < index; i++) {
            //(actual++)
            actual = actual.next;
        }
        return actual.data;
    }

    public boolean contains(String data) {
        Node current = start;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            //(current++)
            current = current.next;
        }
        return false;
    }

    public boolean remove(String data) {
        if (start == null) {
            return false;
        }
//we need to handle the first element separately cause when we removing it we replace it with the second element.
        Node first = start;
        if (first.data.equals(data)) {
            start = start.next;
            return true;
        }

        Node previous = first;
        Node current = start.next;

//We start at the second element and if we find the searched element we replaced it with the previous element's next pointer
//to the next element thereby skipping the element to be removed form the list.
        while (current != null) {
            //foe example: we want to delete '2'
            //      1   ->  2    ->  3                ->    4 -> ......
            //  previous |current |current.next
            // set : previous.next = current.next
            //       1    -----      3
            //          (prev.next)
            //prev     | -------> |current.next
            if (current.data.equals(data)) {
                previous.next = current.next;
                return true;
            }
            //(prev++)
            previous = current;
            //(current++)
            current = current.next;
        }
        return false;
    }

    public int size() {
        int counter = 0;
        Node current = start;
        while (current != null) {
            current = current.next;
            counter++;
        }
        return counter;
    }

    public boolean clear() {
        if (start == null) {
            return false;
        }
        //example: 1 -> 2 -> 3 -> 4 -> null
        //if we set start to null the list becomes empty.
        start = null;
        return true;
    }

    public boolean isEmpty() {
        return start == null;
    }
}
