package sample;

public class LinkedList<E> {

    //INSTANCES
    public Node<E> head;
    private int size;

    //CONSTRUCTOR
    public LinkedList() {
        size = 0; //default size is 0
        head = null; //default is always null
    }

    //IS EMPTY
    public boolean isEmpty() {
        if (head == null)
            return true; //if the head is null, then there are no links, therfore it is empty
        else
            return false;
    }

    //ADD NODE
    public void add(E link) {
        Node<E> node = new Node<>(link); //creates new node
        size++; //size is increased by one

        if (isEmpty()) {
            head = node; //if the list is empty, then the new node is the head
        } else {
            node.next = head; //if list is not empty, then new node is added to the top
            head = node;
        }
    }

    //REMOVE FIRST NODE
    public void deleteFirst() {
        if (isEmpty()) {
            return; //returns nothing if the list is empty
        } else {
            size--; //as you delete one node, the size also decreases by one
            head = head.next; //whatever the next node is, that becomes the head
        }
    }

    //LIST SIZE
    public int listSize() {
        return size; //returns length of the linked list
    }

    //IN RANGE
    private boolean inRange(int index) {
        if (isEmpty() || index >= listSize() || index < 0) {
            return false;
            /*
            return false if the list is empty, or if the number put in is bigger than how many nodes here are in the list,
            or if the number is less than 0
            */
        } else {
            return true; //else the node number put in is a valid number
        }
    }

    //GET NODE
    public Node<E> getNode(int index) //index is number the user wants
    {
        if (!inRange(index)) {
            return null; //if the node number is invalid, return null
        }

        Node returningNode = head; //returning node is the node the user will get

        for (int i = 0; i < index; i++) {
            returningNode = returningNode.next; //goes through loop to find the right node
        }

        return returningNode; //return desired node
    }

    //REMOVE NODE
    public void delete(int index) //index is the number of the node the user wants to delete
    {
        if (!inRange(index)) {
            return; //if the number that was put in is not valid, return nothing
        } else if (index == 0) {
            deleteFirst(); //else, change the number to 0, then delete the first node in the list.
            return;
        }

        getNode(index - 1).next = getNode(index + 1); //the node after index becomes the next node for the node before the index
        size--; //reduce size of the list by one
    }

    //DELETE ALL NODES
    public void deleteAll(int index) {
        head = null; //if there is no head then
        size = 0; //size of the list turns t 0
    }

    //TO STRING
    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }
}

class Node<E> {
    //INSTANCES
    private E data;
    public Node<E> next;

    //CONSTRUCTOR
    public Node(E data) {
        this.data = data;
    }

    //GETTER
    public E getData() {
        return data; //return data stored in the node
    }

    //TO STRING
    @Override
    public String toString() {
        return data.toString() + "\n";
    }
}