package com.k0ft3.atman.domain.application.commands;

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