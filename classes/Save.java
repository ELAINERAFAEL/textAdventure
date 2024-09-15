package classes;

public class Save {

    private Integer id_save;
    private Integer Id_fase;
    private Integer jogador;

    public Save(Integer id_save, Integer id_fase, Integer jogador) {
        this.id_save = id_save;
        Id_fase = id_fase;
        this.jogador = jogador;
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

    public Integer getJogador() {
        return jogador;
    }

    public void setJogador(Integer jogador) {
        this.jogador = jogador;
    }
}
