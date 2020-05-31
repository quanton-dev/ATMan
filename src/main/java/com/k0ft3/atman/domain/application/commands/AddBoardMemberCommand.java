package com.k0ft3.atman.domain.application.commands;

import com.k0ft3.atman.domain.model.board.BoardId;

public class AddBoardMemberCommand extends UserCommand {

    private BoardId boardId;
    private String usernameOrEmailAddress;

    public AddBoardMemberCommand(BoardId boardId, String usernameOrEmailAddress) {
        this.boardId = boardId;
        this.usernameOrEmailAddress = usernameOrEmailAddress;
    }

    public BoardId getBoardId() {
        return boardId;
    }

    public String getUsernameOrEmailAddress() {
        return usernameOrEmailAddress;
    }
}