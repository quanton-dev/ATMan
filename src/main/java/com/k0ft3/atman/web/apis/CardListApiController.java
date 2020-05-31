package com.k0ft3.atman.web.apis;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

import com.k0ft3.atman.domain.application.CardListService;
import com.k0ft3.atman.domain.application.commands.AddCardListCommand;
import com.k0ft3.atman.domain.application.commands.ChangeCardListPositionsCommand;
import com.k0ft3.atman.domain.model.cardlist.CardList;
import com.k0ft3.atman.web.payload.AddCardListPayload;
import com.k0ft3.atman.web.payload.ChangeCardListPositionsPayload;
import com.k0ft3.atman.web.results.AddCardListResult;
import com.k0ft3.atman.web.results.ApiResult;
import com.k0ft3.atman.web.results.Result;

@Controller
public class CardListApiController extends AbstractBaseController {

    private CardListService cardListService;

    public CardListApiController(CardListService cardListService) {
        this.cardListService = cardListService;
    }

    @PostMapping("/api/card-lists")
    public ResponseEntity<ApiResult> addCardList(@RequestBody AddCardListPayload payload, HttpServletRequest request) {
        AddCardListCommand command = payload.toCommand();
        addTriggeredBy(command, request);

        CardList cardList = cardListService.addCardList(command);
        return AddCardListResult.build(cardList);
    }

    @PostMapping("/api/card-lists/positions")
    public ResponseEntity<ApiResult> changeCardListPositions(@RequestBody ChangeCardListPositionsPayload payload,
            HttpServletRequest request) {
        ChangeCardListPositionsCommand command = payload.toCommand();
        addTriggeredBy(command, request);

        cardListService.changePositions(command);
        return Result.ok();
    }
}