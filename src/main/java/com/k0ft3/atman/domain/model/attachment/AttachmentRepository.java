package com.k0ft3.atman.domain.model.attachment;

import java.util.List;

import com.k0ft3.atman.domain.model.card.CardId;

public interface AttachmentRepository {

    /**
     * Find card attachments
     *
     * @param cardId the id of the card
     * @return a list of attachment, empty list if none found
     */
    List<Attachment> findAttachments(CardId cardId);

    /**
     * Save attachment
     *
     * @param attachment the attachment to save
     */
    void save(Attachment attachment);
}