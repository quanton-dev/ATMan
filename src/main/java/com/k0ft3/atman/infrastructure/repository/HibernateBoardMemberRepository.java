package com.k0ft3.atman.infrastructure.repository;

import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import com.k0ft3.atman.domain.model.board.BoardId;
import com.k0ft3.atman.domain.model.board.BoardMember;
import com.k0ft3.atman.domain.model.board.BoardMemberRepository;
import com.k0ft3.atman.domain.model.user.User;
import com.k0ft3.atman.domain.model.user.UserId;

import java.util.List;

@Repository
public class HibernateBoardMemberRepository extends HibernateSupport<BoardMember> implements BoardMemberRepository {

    HibernateBoardMemberRepository(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<User> findMembers(BoardId boardId) {
        String sql = " SELECT u.* FROM user u " + " LEFT JOIN board_member bm ON u.id = bm.user_id "
                + " WHERE bm.board_id = :boardId ";
        NativeQuery<User> query = getSession().createNativeQuery(sql, User.class);
        query.setParameter("boardId", boardId.value());
        return query.list();
    }

    @Override
    public void add(BoardId boardId, UserId userId) {
        String sql = "INSERT IGNORE INTO board_member (board_id, user_id) VALUE (:boardId, :userId)";
        NativeQuery query = getSession().createNativeQuery(sql);
        query.setParameter("boardId", boardId.value());
        query.setParameter("userId", userId.value());
        query.executeUpdate();
    }
}