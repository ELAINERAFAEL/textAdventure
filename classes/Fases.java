package classes;

public class Fases {

    private Integer id_fase;
    private Integer id_historia;
    private  Integer numero;
    private  String descricao;

    public Fases(Integer id_fase, Integer id_historia, Integer numero, String descricao) {
        this.id_fase = id_fase;
        this.id_historia = id_historia;
        this.numero = numero;
        this.descricao = descricao;
    }

    public Integer getId_fase() {
        return id_fase;
    }

    public void setId_fase(Integer id_fase) {
        this.id_fase = id_fase;
    }

    public Integer getId_historia() {
        return id_historia;
    }

    public void setId_historia(Integer id_historia) {
        this.id_historia = id_historia;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
