package com.k0ft3.atman.web.payload;

import com.k0ft3.atman.domain.application.commands.AddCardCommentCommand;
import com.k0ft3.atman.domain.model.card.CardId;

public class AddCardCommentPayload {

    private String comment;

    public AddCardCommentCommand toCommand(CardId cardId) {
        return new AddCardCommentCommand(cardId, comment);
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}