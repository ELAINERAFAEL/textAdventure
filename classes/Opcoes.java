package classes;

public class Opcoes {

    private Integer id_opcoes;
    private Integer id_fase;
    private String opcao;
    private Integer destino;

    public Opcoes(Integer id_opcoes, Integer id_fase, String opcao, Integer destino) {
        this.id_opcoes = id_opcoes;
        this.id_fase = id_fase;
        this.opcao = opcao;
        this.destino = destino;
    }

    public Integer getId_opcoes() {
        return id_opcoes;
    }

    public void setId_opcoes(Integer id_opcoes) {
        this.id_opcoes = id_opcoes;
    }

    public Integer getId_fase() {
        return id_fase;
    }

    public void setId_fase(Integer id_fase) {
        this.id_fase = id_fase;
    }

    public String getOpcao() {
        return opcao;
    }

    public void setOpcao(String opcao) {
        this.opcao = opcao;
    }

    public Integer getDestino() {
        return destino;
    }

    public void setDestino(Integer destino) {
        this.destino = destino;
    }
}