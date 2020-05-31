package com.k0ft3.atman.web.payload;

import com.k0ft3.atman.domain.application.commands.AddCardCommand;
import com.k0ft3.atman.domain.model.board.BoardId;
import com.k0ft3.atman.domain.model.cardlist.CardListId;

public class AddCardPayload {

    private long boardId;
    private long cardListId;
    private String title;
    private int position;

    public AddCardCommand toCommand() {
        return new AddCardCommand(new CardListId(cardListId), title, position);
    }

    public BoardId getBoardId() {
        return new BoardId(boardId);
    }

    public void setBoardId(long boardId) {
        this.boardId = boardId;
    }

    public void setCardListId(long cardListId) {
        this.cardListId = cardListId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}