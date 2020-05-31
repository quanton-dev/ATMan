package com.k0ft3.atman.web.payload;

import java.util.List;

import com.k0ft3.atman.domain.application.commands.ChangeCardListPositionsCommand;
import com.k0ft3.atman.domain.model.board.BoardId;
import com.k0ft3.atman.domain.model.cardlist.CardListPosition;

public class ChangeCardListPositionsPayload {

    private long boardId;
    private List<CardListPosition> cardListPositions;

    public ChangeCardListPositionsCommand toCommand() {
        return new ChangeCardListPositionsCommand(new BoardId(boardId), cardListPositions);
    }

    public void setBoardId(long boardId) {
        this.boardId = boardId;
    }

    public void setCardListPositions(List<CardListPosition> cardListPositions) {
        this.cardListPositions = cardListPositions;
    }
}