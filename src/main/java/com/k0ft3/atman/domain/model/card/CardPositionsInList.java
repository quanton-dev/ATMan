package com.k0ft3.atman.domain.model.card;

import java.util.List;

import com.k0ft3.atman.domain.model.cardlist.CardListId;

public class CardPositionsInList {

    private long cardListId;
    private List<CardPosition> cardPositions;

    public CardListId getCardListId() {
        return new CardListId(cardListId);
    }

    public void setCardListId(long cardListId) {
        this.cardListId = cardListId;
    }

    public List<CardPosition> getCardPositions() {
        return cardPositions;
    }

    public void setCardPositions(List<CardPosition> cardPositions) {
        this.cardPositions = cardPositions;
    }
}