

// Interface para estruturas de dados
interface Estrutura {
    void adicionar(int value);
    Integer remover();
    void exibir();
}

// Classe para a lista ligada
class ListaLigada implements Estrutura {
    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public ListaLigada() {
        this.head = null;
        this.tail = null;
    }

    public void adicionar(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Integer remover() {
        if (head == null) return null;
        int removedValue = head.value;
        head = head.next;
        return removedValue;
    }

    public void exibir() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// Classe para o array
class ArrayEstatica implements Estrutura {
    private int[] array;
    private int size;

    public ArrayEstatica(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
    }

    public void adicionar(int value) {
        if (size < array.length) {
            array[size++] = value;
        } else {
            System.out.println("Array cheio!");
        }
    }

    public Integer remover() {
        if (size > 0) {
            return array[--size];
        }
        return null;
    }

    public void exibir() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

// Classe que gerencia as estruturas de dados
class GerenciadorEstruturas {
    private Estrutura estrutura;

    public void setEstrutura(Estrutura estrutura) {
        this.estrutura = estrutura;
    }

    public void adicionar(int value) {
        if (estrutura != null) {
            estrutura.adicionar(value);
        } else {
            System.out.println("Nenhuma estrutura definida.");
        }
    }

    public Integer remover() {
        if (estrutura != null) {
            return estrutura.remover();
        }
        return null;
    }

    public void exibir() {
        if (estrutura != null) {
            estrutura.exibir();
        } else {
            System.out.println("Nenhuma estrutura definida.");
        }
    }
}

// Classe principal
public class EstruturaDados {
    public static void main(String[] args) {
        GerenciadorEstruturas gerenciador = new GerenciadorEstruturas();

        // Usando array
        gerenciador.setEstrutura(new ArrayEstatica(5));
        gerenciador.adicionar(10);
        gerenciador.adicionar(20);
        gerenciador.exibir(); // Saída: 10 20
        gerenciador.remover();
        gerenciador.exibir(); // Saída: 10

        // Usando lista ligada
        gerenciador.setEstrutura(new ListaLigada());
        gerenciador.adicionar(30);
        gerenciador.adicionar(40);
        gerenciador.exibir(); // Saída: 30 40
        gerenciador.remover();
        gerenciador.exibir(); // Saída: 40
    }
}

// Explique, com código, como a orientação a objetos pode melhorar a manipulação de estruturas de dados.

//Resposta --->   
/*
A orientação a objetos (OO) melhora a manipulação de estruturas de dados de várias maneiras:

1. Encapsulamento: Os dados e métodos que operam sobre eles são agrupados em classes. Por exemplo, a classe ListaLigada encapsula a lógica de manipulação da lista, permitindo que o usuário interaja apenas com métodos como adicionar, remover e exibir, sem se preocupar com a implementação interna.

2. Reutilização de Código: Classes podem ser reutilizadas em diferentes partes do programa. No seu código, tanto ArrayEstatica quanto ListaLigada implementam a interface Estrutura, permitindo que sejam usadas de forma intercambiável sem duplicação de código.

3. Polimorfismo: Permite tratar diferentes classes de forma uniforme. A classe GerenciadorEstruturas usa a interface Estrutura para adicionar, remover e exibir elementos, independentemente da implementação específica da estrutura de dados.

4. Abstração: Foca nos aspectos essenciais de uma estrutura de dados, ignorando detalhes de implementação. A interface Estrutura define um contrato que todas as estruturas devem seguir, permitindo interações consistentes.

Esses princípios tornam o código mais modular, fácil de entender, manter e expandir, facilitando a manipulação de diferentes estruturas de dados.
*/