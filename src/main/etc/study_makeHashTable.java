package etc;

import java.util.LinkedList;

public class study_makeHashTable {

    private LinkedList<Node>[] table;

    /**
     * Node
     */
    class Node {

        String key;
        String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + " / " + value;
        }
    }

    public study_makeHashTable(int size) {
        table = new LinkedList[size];
    }

    public study_makeHashTable() {
        table = new LinkedList[10];
    }

    public long getHashCode(String key) {
        long hashCode = 0;
        /*for(char c : key.toCharArray()){
            hashCode += (long) c;
        }*/
        //또는
        return key.hashCode();
    }

    public int getIndex (long hashCode){
        return (int) (hashCode % table.length);
    }

    public Node searchNode(int index, String key){
        LinkedList<Node> indexList = table[index];
        for(Node n : indexList){
            if(n.key.equals(key)){
                return n;
            }
        }
        return null;
    }

    public void put(String key, String value){
        long hashCode = getHashCode(key);
        int index = getIndex(hashCode);

        if(table[index] == null){
            table[index] = new LinkedList<>();
            table[index].add(new Node(key, value));
        }else{
            Node node = searchNode(index, key);
            if(node == null){
                table[index].add(new Node(key, value));
            }else{
                node.value = value;
            }
        }
    }

    public String get(String key){
        long hashCode = getHashCode(key);
        int index = getIndex(hashCode);
        Node node = searchNode(index, key);
        if ( node == null){
            return null;
        }else{
            return node.value;
        }
    }

    public LinkedList[] getArray(){
        return table;
    }

}
