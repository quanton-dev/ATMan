package com.k0ft3.atman.domain.application;

import java.util.List;

import com.k0ft3.atman.domain.application.commands.AddCardAttachmentCommand;
import com.k0ft3.atman.domain.application.commands.AddCardCommand;
import com.k0ft3.atman.domain.application.commands.AddCardCommentCommand;
import com.k0ft3.atman.domain.application.commands.ChangeCardDescriptionCommand;
import com.k0ft3.atman.domain.application.commands.ChangeCardPositionsCommand;
import com.k0ft3.atman.domain.application.commands.ChangeCardTitleCommand;
import com.k0ft3.atman.domain.model.activity.Activity;
import com.k0ft3.atman.domain.model.attachment.Attachment;
import com.k0ft3.atman.domain.model.board.BoardId;
import com.k0ft3.atman.domain.model.card.Card;
import com.k0ft3.atman.domain.model.card.CardId;

public interface CardService {

    /**
     * Find all the cards of a board
     *
     * @param boardId the id of the board
     * @return a list of card instances or an empty list if none found
     */
    List<Card> findByBoardId(BoardId boardId);

    /**
     * Find card by its id
     *
     * @param cardId the id of the card
     * @return a card instance or null if not found
     */
    Card findById(CardId cardId);

    /**
     * Get the activities related to a card
     *
     * @param cardId the id of the card
     * @return a list of card activities
     */
    List<Activity> findCardActivities(CardId cardId);

    /**
     * Get card attachments
     *
     * @param cardId the id of the card
     * @return a list of card attachments
     */
    List<Attachment> getAttachments(CardId cardId);

    /**
     * Add card
     *
     * @param command the command instance
     * @return the newly added card
     */
    Card addCard(AddCardCommand command);

    /**
     * Change card positions
     *
     * @param command the command instance
     */
    void changePositions(ChangeCardPositionsCommand command);

    /**
     * Change card's title
     *
     * @param command the command instance
     */
    void changeCardTitle(ChangeCardTitleCommand command);

    /**
     * Change card's description
     *
     * @param command the command instance
     */
    void changeCardDescription(ChangeCardDescriptionCommand command);

    /**
     * Add card comment
     *
     * @param command the command instance
     * @return an instance of Activity
     */
    Activity addComment(AddCardCommentCommand command);

    /**
     * Add attachment to a card
     *
     * @param command the command instance
     * @return created attachment
     */
    Attachment addAttachment(AddCardAttachmentCommand command);

}