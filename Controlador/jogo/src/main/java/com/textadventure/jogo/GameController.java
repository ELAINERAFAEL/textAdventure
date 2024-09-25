package com.textadventure.jogo;

import com.textadventure.jogo.back.model.Save;
import com.textadventure.jogo.back.repository.FaseDAO;
import com.textadventure.jogo.back.repository.SaveDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



@RestController
public class GameController {

    private String nomeJogador;
    private Integer faseid;

    @GetMapping("/comando")
    public String processarComando(@RequestParam String comando) throws SQLException {
        // Lógica para processar o comando
        if(!(comando.length()<4)){
            String idenComando = comando.substring(0, 4);
            String regex = "\\[(.*?)\\]";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(comando);
            String resultado ="Nenhum conteúdo encontrado.";

            if (matcher.find()) {
                resultado = matcher.group(1); // Captura o conteúdo dentro dos colchetes

            }

            if ("SELE".equalsIgnoreCase(idenComando)) {
                FaseDAO buscarFase = new FaseDAO();
                List<String> novaFase = buscarFase.proximaFase(resultado);

                if (!(buscarFase.idFase(resultado) == null)) {
                    this.faseid = buscarFase.idFase(resultado);
                }

                return String.join("<br>", novaFase);
            } else if ("JOGA".equalsIgnoreCase(idenComando)) {
                if ("Nenhum conteúdo encontrado.".equalsIgnoreCase(resultado)){
                    return "Erro, nome não informado!";
                } else {
                    this.nomeJogador = resultado;
                    return "Nome do Jogador definido para "+ resultado+"<br>"+"Escolha uma opção da fase atual para continuar!";
                }

            } else if ("SAVE".equalsIgnoreCase(idenComando)) {
                if(!(this.nomeJogador == null)) {
                    SaveDAO salvar = new SaveDAO();
                    String retorno = salvar.salvarJogo(this.faseid, this.nomeJogador);
                    return retorno + "<br>"+"Escolha uma opção da fase atual para continuar!";
                } else {
                    return "Defina o nome do Jogador antes de Salvar";
                }

            } else if ("LOAD".equalsIgnoreCase(idenComando)) {
                SaveDAO carregarsave = new SaveDAO();
                Save ultimosave = carregarsave.consultarSave(resultado);

                FaseDAO fase = new FaseDAO();


                if(ultimosave.getId_save() == null){
                    return "Jogador informado não possui Saves!";
                } else {
                    List<String> novaFase = fase.carregarFase(ultimosave.getId_fase());
                    this.faseid = ultimosave.getId_fase();
                    this.nomeJogador = resultado;

                    return String.join("<br>", novaFase);
                }


            } else if ("RESE".equalsIgnoreCase(idenComando)) {

                FaseDAO fase = new FaseDAO();

                List<String> novaFase = fase.carregarFase(1);

                this.faseid = 1;
                this.nomeJogador = null;

                return String.join("<br>", novaFase);
            } else if ("HELP".equalsIgnoreCase(idenComando)) {
                return "Possíveis comandos:" +
                        "<br>SELECT[OPÇAO]: seleciona a opção desejada." +
                        "<br>JOGADOR[NOME DO JOGADOR]: define o nome de quem está jogando, obrigatório para salvar o jogo." +
                        "<br>SAVE: salva o jogo com o nome do jogador anteriormente definido e a fase atual em que o jogo se encontra" +
                        "<br>RESET: reinicia o jogo resetando o nível e o nome do jogador (não apaga os saves relizados." +
                        "<br>HELP: permiti consultar os comandos possíveis em qualquer etapa do jogo." +
                        "<br>INICIAR: inicia o jogo do zero." +
                        "<br>Para contuniar a jogar selecione uma das opções da última fase apresentada ou o comando que desejar efetuar!";
            } else if ("INIC".equalsIgnoreCase(idenComando)) {
                FaseDAO fase = new FaseDAO();

                List<String> novaFase = fase.carregarFase(1);

                this.faseid = 1;
                this.nomeJogador = null;

                return String.join("<br>", novaFase);
            } else {
                return "Comando desconhecido.";
            }
        } else {
            return "Comando desconhecido.";
        }
    }
}

