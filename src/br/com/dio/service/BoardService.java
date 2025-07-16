package br.com.dio.service;

import br.com.dio.model.Board;
import br.com.dio.model.GameStatusEnum;
import br.com.dio.model.Space;
import jdk.jshell.Snippet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BoardService {

    private final static int BOARD_LIMIT = 9;

    private final Board board;


    public BoardService(final Map<String, String> gameConfig) {
        this.board = new Board(initBoard(gameConfig));
    }

    public List<List<Space>> getSpaces(){
        return board.getSpaces();
    }

    public void reset(){
        board.reset();
    }

    public boolean hasErros(){
        return board.hasErrors();
    }

    public GameStatusEnum getStatus(){
        return board.getStatus();
    }

    public boolean gameIsFiniShed(){
        return board.gameIsFinished();
    }

    private List<List<Space>> initBoard(final Map<String, String> gameConfig) {
        List<List<Space>> spaces = new ArrayList<>();

        for (int i = 0; i < BOARD_LIMIT; i++) {
            spaces.add(new ArrayList<>());
            for (int j = 0; j < BOARD_LIMIT; j++) {
                // Tenta dois formatos de chave (com e sem espaço)
                String keyWithSpace = "%s, %s".formatted(i, j);
                String keyWithoutSpace = "%s,%s".formatted(i, j);

                // Verifica qual chave existe no Map
                String positionConfig = gameConfig.get(keyWithSpace);
                if (positionConfig == null) {
                    positionConfig = gameConfig.get(keyWithoutSpace);
                }

                // Se ainda for nulo, define um valor padrão ou lança exceção
                if (positionConfig == null) {
                    throw new IllegalArgumentException(
                            "Chave de configuração não encontrada para posição: " + keyWithSpace + " ou " + keyWithoutSpace
                    );
                }

                // Divide e valida o formato
                String[] parts = positionConfig.split(",");
                if (parts.length != 2) {
                    throw new IllegalArgumentException(
                            "Formato inválido para posição [" + i + "," + j + "]. Esperado: 'numero,boolean'"
                    );
                }

                try {
                    int expected = Integer.parseInt(parts[0].trim());
                    boolean fixed = Boolean.parseBoolean(parts[1].trim());
                    spaces.get(i).add(new Space(expected, fixed));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(
                            "Valor inválido na posição [" + i + "," + j + "]. Esperado: 'numero,boolean'"
                    );
                }
            }
        }
        return spaces;
    }}
