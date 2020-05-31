package com.k0ft3.atman.domain.model.card.events;

import com.k0ft3.atman.domain.common.event.DomainEvent;
import com.k0ft3.atman.domain.common.event.TriggeredBy;
import com.k0ft3.atman.domain.model.board.BoardId;
import com.k0ft3.atman.domain.model.card.CardId;

public abstract class CardDomainEvent extends DomainEvent {

    private static final long serialVersionUID = 8301463735426628027L;

    private CardId cardId;
    private String cardTitle;
    private BoardId boardId;

    public CardDomainEvent(CardId cardId, String cardTitle, BoardId boardId, TriggeredBy triggeredBy) {
        super(triggeredBy);
        this.cardId = cardId;
        this.cardTitle = cardTitle;
        this.boardId = boardId;
    }

    public CardId getCardId() {
        return cardId;
    }

    public String getCardTitle() {
        return cardTitle;
    }

    public BoardId getBoardId() {
        return boardId;
    }
}