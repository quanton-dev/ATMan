package com.k0ft3.atman.domain.model.activity;

import com.k0ft3.atman.domain.common.event.DomainEvent;
import com.k0ft3.atman.domain.model.attachment.events.CardAttachmentAddedEvent;
import com.k0ft3.atman.domain.model.board.events.BoardCreatedEvent;
import com.k0ft3.atman.domain.model.board.events.BoardMemberAddedEvent;
import com.k0ft3.atman.domain.model.card.events.CardAddedEvent;
import com.k0ft3.atman.domain.model.card.events.CardDescriptionChangedEvent;
import com.k0ft3.atman.domain.model.card.events.CardTitleChangedEvent;
import com.k0ft3.atman.domain.model.cardlist.events.CardListAddedEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DomainEventToActivityConverter {

    private static final Logger log = LoggerFactory.getLogger(DomainEventToActivityConverter.class);

    /**
     * Convert a domain event to the corresponding activity
     *
     * @param event a domain event
     * @return a corresponding activity, or null when no activity tracked by that
     *         domain event
     */
    public Activity toActivity(DomainEvent event) {
        if (event instanceof BoardCreatedEvent) {
            return BoardActivities.from((BoardCreatedEvent) event);
        } else if (event instanceof BoardMemberAddedEvent) {
            return BoardActivities.from((BoardMemberAddedEvent) event);
        } else if (event instanceof CardAttachmentAddedEvent) {
            return CardActivities.from((CardAttachmentAddedEvent) event);
        } else if (event instanceof CardAddedEvent) {
            return CardActivities.from((CardAddedEvent) event);
        } else if (event instanceof CardDescriptionChangedEvent) {
            return CardActivities.from((CardDescriptionChangedEvent) event);
        } else if (event instanceof CardTitleChangedEvent) {
            return CardActivities.from((CardTitleChangedEvent) event);
        } else if (event instanceof CardListAddedEvent) {
            return CardListActivities.from((CardListAddedEvent) event);
        }

        log.debug("No activity converted from " + event);
        return null;
    }
}