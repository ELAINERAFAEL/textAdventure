package src.model;

public class Save {

    private Integer id_save;
    private Integer Id_fase;
    private String jogador;

    public Save() {

    }

    public Integer getId_save() {
        return id_save;
    }

    public void setId_save(Integer id_save) {
        this.id_save = id_save;
    }

    public Integer getId_fase() {
        return Id_fase;
    }

    public void setId_fase(Integer id_fase) {
        Id_fase = id_fase;
    }

    public String getJogador() {
        return jogador;
    }

    public void setJogador(String jogador) {
        this.jogador = jogador;
    }

    @Override
    public String toString() {
        return "Save{" +
                "id_save=" + id_save +
                ", Id_fase=" + Id_fase +
                ", jogador=" + jogador +
                '}';
    }
}
