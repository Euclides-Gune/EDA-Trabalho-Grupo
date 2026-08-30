
public class FilaEst {

    private int capacidade;
    private int[] elementos;
    private int frente;
    private int fim;
    private int tamanho;

    public FilaEst(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new int[capacidade];
        this.frente = 0;
        this.fim = -1;
    }

    public boolean cheia() {
        return this.tamanho == capacidade;
    }

    public boolean vazia() {
        return this.tamanho == 0;
    }

    public int front() {
        if(this.vazia()) {
            throw new RuntimeException("Fila vazia");
        }
        return this.elementos[frente];
    }

    public void enqueue(int x) {
        if (this.cheia()) {
            throw new RuntimeException("Fila cheia");
        }
        fim = (fim + 1) % capacidade;
        this.elementos[fim] = x;
        this.tamanho++;
    }

    private void ordenar() {
        if(this.tamanho > 1) {
            int e = elementos[fim];
            for(int i = this.tamanho-1; i > 0; i--) {
                if(elementos[i] < elementos[i-1]) {
                    int aux = elementos[i];
                    elementos[i] = elementos[i-1];
                    elementos[i-1] = aux;
                }
            }
        }
    }

    public int dequeue() {
        if(this.vazia()) {
            throw new RuntimeException("Fila vazia");
        }
        int value = elementos[frente];
        frente = (frente + 1) % capacidade;
        return value;
    }

    public int elementoEm(int index) {
        if(index >= this.tamanho || this.vazia()) 
            throw  new RuntimeException("Índice inválido para a fila de tamanho "+this.tamanho);    
        return this.elementos[index];
    }

    public int buscarElemento(int element) {
        for(int i = 0; i < this.tamanho; i++) {
            if(this.elementos[i] == element) return i;
        }
        throw new RuntimeException("Elemento não existe na fila!");
    }

    public void contarParImpar() {
        int par = 0;
        int impar = 0;

        for(int i = 0; i < this.tamanho; i++) {
            if(this.elementos[i] % 2 == 0) {
                par++;
            } else {
                impar++;
            }
        }

        IO.println("Pares: "+par);
        IO.println("Ímpares: "+impar);
    }

    public void reverter() {
        for(int i = this.tamanho - 1; i >= 0; i--) {
            IO.print(this.elementos[i] + " ");
        }
        IO.println();
    }

    public void maior() {
        if(this.vazia()) throw new RuntimeException("Fila vazia");
        int maior = this.elementos[frente];
        int pos = 0;
        for(int i = 0; i < this.tamanho; i++) {
            if(this.elementos[i] > maior) {
                maior = this.elementos[i];
                pos = i;
            }
        }

        IO.println("O maior elemento é "+maior+" na posição "+pos);
    }

    public void menor() {
        if(this.vazia()) throw new RuntimeException("Fila vazia");
        int menor = this.elementos[frente];
        int pos = 0;
        for(int i = 0; i < this.tamanho; i++) {
            if(this.elementos[i] < menor) {
                menor = this.elementos[i];
                pos = i;
            }
        }

        IO.println("O menor elemento é "+menor+" na posição "+pos);
    }

    public void somaEMedia() {
        if(this.vazia()) throw new RuntimeException("Fila vazia");
        int sum = 0;
        double avg = 0;
        for(int i = 0; i < this.tamanho; i++) {
            sum += this.elementos[i];
        }
        avg = sum/this.tamanho;
        IO.println("Soma = "+sum);
        IO.println("Média = "+avg);
    }

    public void rotacaoAEsquerda() {
        if(this.vazia()) throw new RuntimeException("A fila está vazia!");
        int wasFirstNowLast = this.elementos[frente];
        for(int i = 0; i < this.tamanho-1; i++) {
            this.elementos[i] = this.elementos[i+1];
        }
        this.elementos[this.tamanho-1] = wasFirstNowLast;
    }

    public void print() {
        for(int i = 0; i < this.tamanho; i++) {
            IO.print(this.elementos[i] + " ");
        }
        IO.println();
    }

    public FilaEst intercalar(int[] a, int[] b) {
        if(a.length != b.length) throw new RuntimeException("Vetores de tamanhos diferentes");
        
        FilaEst c = new FilaEst(2*a.length);

        for(int i = 0; i < a.length; i++) {
            c.enqueue(a[i]);
            c.enqueue(b[i]);
        }

        return c;

    }

    public FilaEst excluirX(int x) {
        FilaEst c = new FilaEst(this.tamanho);
        for(int i = 0; i < this.tamanho; i++) {
            if(this.elementoEm(i) != x) {
                c.enqueue(this.elementoEm(i));
            }
        }
        return c;
    }

    public FilaEst sort() {
        FilaEst f = new FilaEst(this.tamanho);
        for(int i = 0; i < this.tamanho; i++) {
            f.enqueue(this.elementoEm(i));
            f.ordenar();
        }
        return f;
    }

}