package com.k0ft3.atman.domain.application.commands;

import java.util.List;

public class ChangeCardPositionsCommand extends UserCommand {

    private BoardId boardId;
    private List<CardPosition> cardPositions;

    public ChangeCardPositionsCommand(BoardId boardId, List<CardPosition> cardPositions) {
        this.boardId = boardId;
        this.cardPositions = cardPositions;
    }

    public BoardId getBoardId() {
        return boardId;
    }

    public List<CardPosition> getCardPositions() {
        return cardPositions;
    }
}