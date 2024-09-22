package src.model;public class Cena {
    private Integer idCena;
    private String descricao;

    public Integer getIdCena() {
        return idCena;
    }

    public void setIdCena(Integer idCena) {
        this.idCena = idCena;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Cena{" +
                "idCena=" + idCena +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public void add(Cena cena) {

    }
}
