package com.k0ft3.atman.domain.application.commands;

public class AddCardListCommand extends UserCommand {

    private String name;
    private BoardId boardId;
    private int position;

    public AddCardListCommand(BoardId boardId, String name, int position) {
        this.boardId = boardId;
        this.name = name;
        this.position = position;
    }

    public BoardId getBoardId() {
        return boardId;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}