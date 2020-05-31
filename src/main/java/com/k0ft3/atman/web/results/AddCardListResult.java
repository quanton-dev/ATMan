package com.k0ft3.atman.web.results;

import com.k0ft3.atman.domain.model.cardlist.CardList;

import org.springframework.http.ResponseEntity;

public class AddCardListResult {

    public static ResponseEntity<ApiResult> build(CardList cardList) {
        ApiResult apiResult = ApiResult.blank().add("id", cardList.getId().value()).add("name", cardList.getName());
        return Result.ok(apiResult);
    }
}