package com.k0ft3.atman.web.payload;

import java.util.List;

import com.k0ft3.atman.domain.application.commands.ChangeCardPositionsCommand;
import com.k0ft3.atman.domain.model.board.BoardId;
import com.k0ft3.atman.domain.model.card.CardPosition;

public class ChangeCardPositionsPayload {

    private long boardId;
    private List<CardPosition> cardPositions;

    public ChangeCardPositionsCommand toCommand() {
        return new ChangeCardPositionsCommand(new BoardId(boardId), cardPositions);
    }

    public void setBoardId(long boardId) {
        this.boardId = boardId;
    }

    public void setCardPositions(List<CardPosition> cardPositions) {
        this.cardPositions = cardPositions;
    }
}