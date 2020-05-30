package com.k0ft3.atman.domain.application.impl;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {

    private BoardRepository boardRepository;
    private BoardManagement boardManagement;
    private BoardMemberRepository boardMemberRepository;
    private UserFinder userFinder;
    private DomainEventPublisher domainEventPublisher;

    public BoardServiceImpl(BoardRepository boardRepository, BoardManagement boardManagement,
            BoardMemberRepository boardMemberRepository, UserFinder userFinder,
            DomainEventPublisher domainEventPublisher) {
        this.boardRepository = boardRepository;
        this.boardManagement = boardManagement;
        this.boardMemberRepository = boardMemberRepository;
        this.userFinder = userFinder;
        this.domainEventPublisher = domainEventPublisher;
    }

    @Override
    public List<Board> findBoardsByMembership(UserId userId) {
        return boardRepository.findBoardsByMembership(userId);
    }

    @Override
    public Board findById(BoardId boardId) {
        return boardRepository.findById(boardId);
    }

    @Override
    public List<User> findMembers(BoardId boardId) {
        return boardMemberRepository.findMembers(boardId);
    }

    @Override
    public Board createBoard(CreateBoardCommand command) {
        Board board = boardManagement.createBoard(command.getUserId(), command.getName(), command.getDescription(),
                command.getTeamId());
        domainEventPublisher.publish(new BoardCreatedEvent(board, command));
        return board;
    }

    @Override
    public User addMember(AddBoardMemberCommand command) throws UserNotFoundException {
        User user = userFinder.find(command.getUsernameOrEmailAddress());
        boardMemberRepository.add(command.getBoardId(), user.getId());
        domainEventPublisher.publish(new BoardMemberAddedEvent(command.getBoardId(), user, command));
        return user;
    }
}