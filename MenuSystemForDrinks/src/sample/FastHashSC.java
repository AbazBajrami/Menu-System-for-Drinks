package sample;

public class FastHashSC<E> {
    public LinkedList<E>[] hashTable;

    @SuppressWarnings("unchecked")
    public FastHashSC(int size) {
        hashTable = new LinkedList[size];
        for (int i = 0; i < hashTable.length; i++)
            hashTable[i] = new LinkedList<>();
    }


    public LinkedList<E> getLinkedList(int index) {
        return hashTable[index];
    }


    public int hashFunction(String input) {  //this hashes the input if its a String(eg, drink/ingredient name
        return input.length() % hashTable.length;
    }

    public int hashFunction(int input) {  //this hashes the input if its an int (eg ABVInfo)
        return input % hashTable.length;
    }

    public void add(E item, String tobeHashed) {
        int num1 = hashFunction(tobeHashed);

        hashTable[num1].add(item);  //adds the item to the location num1 in the hash table hashTable

    }

    public void add(E item, int tobeHashed) {
        int num3 = hashFunction(tobeHashed);

        hashTable[num3].add(item);
    }

}
