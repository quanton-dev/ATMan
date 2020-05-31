package com.k0ft3.atman.web.payload;

import com.k0ft3.atman.domain.application.commands.ChangeCardTitleCommand;
import com.k0ft3.atman.domain.model.card.CardId;

public class ChangeCardTitlePayload {

    private String title;

    public ChangeCardTitleCommand toCommand(long cardId) {
        return new ChangeCardTitleCommand(new CardId(cardId), title);
    }

    public void setTitle(String title) {
        this.title = title;
    }
}