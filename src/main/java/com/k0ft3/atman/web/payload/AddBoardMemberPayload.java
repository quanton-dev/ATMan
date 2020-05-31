package com.k0ft3.atman.web.payload;

import com.k0ft3.atman.domain.application.commands.AddBoardMemberCommand;
import com.k0ft3.atman.domain.model.board.BoardId;

public class AddBoardMemberPayload {

    private String usernameOrEmailAddress;

    public AddBoardMemberCommand toCommand(BoardId boardId) {
        return new AddBoardMemberCommand(boardId, usernameOrEmailAddress);
    }

    public void setUsernameOrEmailAddress(String usernameOrEmailAddress) {
        this.usernameOrEmailAddress = usernameOrEmailAddress;
    }
}