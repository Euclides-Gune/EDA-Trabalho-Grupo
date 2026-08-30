public class Fila {

    public static class No {
        public int elemento;
        public No prox;

        public No(int e, No n) {
            this.elemento = e;
            this.prox = n;
        }
    }

    private No frente;
    private No fim;
    private int tamanho;

    public Fila() {
        this.frente = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public Fila(Fila fila) {
        this.frente = fila.frente;
        this.fim = fila.fim;
        this.tamanho = fila.tamanho;
    }

    public boolean vazio() {
        return this.tamanho == 0;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public void enqueue(int e) {
        No n = new No(e, null);
        if(this.vazio()) {
            frente = n;
        } else {
            fim.prox = n;
        }
        fim = n;
        this.tamanho++;
    }

    public int dequeue() {
        if(this.vazio()) throw  new RuntimeException("Fila vazia");
        int e = frente.elemento;
        frente = frente.prox;
        this.tamanho--;
        return e;
    }

    public int front() {
        if(this.vazio()) throw new RuntimeException("Vaziooo...");
        return frente.elemento;
    }

    public void iterar() {
        if(this.vazio()) return;

        No primeiro = frente;

        while (primeiro != null) { 
            IO.print(primeiro.elemento + " ");
            primeiro = primeiro.prox;
        }
        IO.println();

    }

    public int iterarEContar() {
        this.iterar();
        return this.tamanho;
    }

    public boolean buscar(int x) {
        try {
            No primeiro = frente;
            while(primeiro != null) {
                if(primeiro.elemento == x) return true;
                primeiro = primeiro.prox;
            }
        } catch(NullPointerException ex) {
            IO.println("Fim fa fila");
        }
        return false;
    }

    public void contarParImpar() {
        if(this.vazio()) throw new RuntimeException("Vazio");
        int even = 0;
        int odd = 0;
        No primeiro = frente;
        while (primeiro != null) { 
            if(primeiro.elemento % 2 == 0) even++;
            else odd++;
            primeiro = primeiro.prox;
        }
        IO.println("Pares = "+even);
        IO.println("Ímpares = "+odd);
    }

    public int soma() {
        int soma = 0;
        No primeiro = frente;
        while (primeiro != null) { 
            soma += primeiro.elemento;
            primeiro = primeiro.prox;
        }
        return soma;
    }

    public int maior() {
        if(this.vazio()) throw new RuntimeException("Fila vazia...");
        No primeiro = frente;
        int maior = primeiro.elemento;
        while (primeiro != null) { 
            if(primeiro.elemento > maior) maior = primeiro.elemento;
            primeiro = primeiro.prox;
        }
        return maior;
    }

    public int menor() {
        if(this.vazio()) throw new RuntimeException("Fila vazia...");
        No primeiro = frente;
        int menor = primeiro.elemento;
        while (primeiro != null) { 
            if(primeiro.elemento < menor) menor = primeiro.elemento;
            primeiro = primeiro.prox;
        }
        return menor;
    }

    public void removerMultiplosDeK(int k) {
        if(this.vazio()) throw new RuntimeException("Fila vazia...");
        No primeiro = frente;
        while(!this.vazio()) {
            this.dequeue();
        }
        while (primeiro != null) { 
            if(k % primeiro.elemento != 0) {
                this.enqueue(primeiro.elemento);
            }
            primeiro = primeiro.prox;
        }
    }

    public void adicionarFila(Fila adicional) {
        while(!adicional.vazio()) {
            this.enqueue(adicional.front());
            adicional.dequeue();
        }
    }

    public Fila filaInversa() {
        Fila fila = new Fila();

        int[] lista = new int[this.tamanho];
        int index = 0;

        No primeiro = frente;
        while(primeiro != null) {
            lista[index++] = primeiro.elemento;
            primeiro = primeiro.prox;
        }

        for(int i = lista.length-1; i >= 0; i--) {
            fila.enqueue(lista[i]);
        }

        return fila;
    }

}
