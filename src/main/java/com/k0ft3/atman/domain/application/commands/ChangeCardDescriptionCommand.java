package com.k0ft3.atman.domain.application.commands;

import com.k0ft3.atman.domain.model.card.CardId;

public class ChangeCardDescriptionCommand extends UserCommand {

    private CardId cardId;
    private String description;

    public ChangeCardDescriptionCommand(CardId cardId, String description) {
        this.cardId = cardId;
        this.description = description;
    }

    public CardId getCardId() {
        return cardId;
    }

    public String getDescription() {
        return description;
    }
}