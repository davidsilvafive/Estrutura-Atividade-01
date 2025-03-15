class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Método para adicionar um elemento no final da lista
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Método para remover um elemento
    public void remove(int data) {
        Node current = head;

        while (current != null) {
            if (current.data == data) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next; // Atualiza a cabeça se o nó a ser removido for o primeiro
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev; // Atualiza a cauda se o nó a ser removido for o último
                }

                return; // Elemento removido, sai do método
            }
            current = current.next;
        }
    }

    // Método para exibir elementos na ordem direta
    public void displayForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Método para exibir elementos na ordem inversa
    public void displayBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        
        // Adicionando elementos
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        
        // Exibindo elementos na ordem direta
        System.out.println("Elementos na ordem direta:");
        list.displayForward();
        
        // Exibindo elementos na ordem inversa
        System.out.println("Elementos na ordem inversa:");
        list.displayBackward();
        
        // Removendo um elemento
        list.remove(3);
        
        // Exibindo elementos após remoção
        System.out.println("Elementos após remoção do 3:");
        list.displayForward();
    }
}