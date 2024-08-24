public class techacademy1 {
    public static void main(String[] args) {
                Integer idade = new Integer(19);
                Boolean estaNaFaculdade = new Boolean(true);

                System.out.println("idade " +idade);
                System.out.println("entrou na faculdade? " +estaNaFaculdade);
    }
}

public class Projeto {
    String titulo;
    String descricao;
    int itens;
    int cenas;

    public Projeto() {
    }

    public Projeto(String titulo, String descricao, int itens, int cenas) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.itens = itens;
        this.cenas = cenas;
    }