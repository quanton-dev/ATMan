package com.k0ft3.atman.web.payload;

import com.k0ft3.atman.domain.application.commands.ChangeCardDescriptionCommand;
import com.k0ft3.atman.domain.model.card.CardId;

public class ChangeCardDescriptionPayload {

    private String description;

    public ChangeCardDescriptionCommand toCommand(long cardId) {
        return new ChangeCardDescriptionCommand(new CardId(cardId), description);
    }

    public void setDescription(String description) {
        this.description = description;
    }
}