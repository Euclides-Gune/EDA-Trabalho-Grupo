public class Main {

    public static void inserirEPercorrer(Fila fila) {
        for(int i = 0; i < 10; i++) {
            fila.enqueue(i+1);
        }
        fila.iterar();
    }

    public static void main(String[] args) {
        // Fila estática
        IO.println("\n============== Fila estática ==============\n");
        FilaEst queue = new FilaEst(10);
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(5);
        queue.enqueue(60);
        queue.enqueue(8);
        queue.enqueue(2);
        queue.enqueue(20);
        queue.enqueue(4);
        queue.enqueue(6);
        queue.print();
        FilaEst s = queue.sort();
        s.print();

        // Fila dinâmica
        IO.println("\n============== Fila dinâmica ==============\n");
        Fila fila = new Fila();
        Fila outra = new Fila();
        outra.enqueue(11);
        outra.enqueue(12);
        inserirEPercorrer(fila);
        fila.removerMultiplosDeK(9);
        fila.iterar();
        IO.println(fila.iterarEContar());
        IO.println(fila.buscar(7));
        IO.println(fila.soma());
        IO.println(fila.maior());
        IO.println(fila.menor());
        fila.adicionarFila(outra);
        fila.iterar();
        Fila f = fila.filaInversa();
        f.iterar();
        IO.println(f.vazio());

        // Desafio Fila dinâmica
        IO.println("\n============== Desafio Fila dinâmica ==============\n");
        Fila d = new Fila();
        d.enqueue(10);
        d.enqueue(15);
        d.enqueue(20);
        d.enqueue(25);
        d.enqueue(30);

        d.enqueue(40);
        d.iterar();
        d.dequeue();
        d.iterar();
        IO.println(d.front());
        d.contarParImpar();
        IO.println(d.soma());
        IO.println(d.maior());
    }
}
