package com.k0ft3.atman.domain.model.activity;

public class CardListActivities {

    public static Activity from(CardListAddedEvent event) {
        String detail = ActivityDetail.blank().add("cardListId", event.getCardListId().value())
                .add("cardListName", event.getCardListName()).toJson();
        return Activity.from(event.getUserId(), event.getBoardId(), ActivityType.ADD_BOARD, detail,
                event.getIpAddress());
    }
}