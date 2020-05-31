package com.k0ft3.atman.web.results;

import com.k0ft3.atman.domain.model.card.Card;

import org.springframework.http.ResponseEntity;

public class AddCardResult {

    public static ResponseEntity<ApiResult> build(Card card) {
        ApiResult apiResult = ApiResult.blank().add("id", card.getId().value()).add("title", card.getTitle())
                .add("position", card.getPosition());
        return Result.ok(apiResult);
    }
}