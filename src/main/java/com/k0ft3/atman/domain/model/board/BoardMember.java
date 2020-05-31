package com.k0ft3.atman.domain.model.board;

import javax.persistence.*;

import com.k0ft3.atman.domain.common.model.AbstractBaseEntity;
import com.k0ft3.atman.domain.model.user.UserId;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "board_member")
public class BoardMember extends AbstractBaseEntity {

    private static final long serialVersionUID = 1101935717986500672L;

    @EmbeddedId
    private BoardMemberId id;

    public static BoardMember create(BoardId boardId, UserId userId) {
        BoardMember boardMember = new BoardMember();
        boardMember.id = new BoardMemberId(boardId, userId);
        return boardMember;
    }

    public BoardId getBoardId() {
        return id.getBoardId();
    }

    public UserId getUserId() {
        return id.getUserId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof BoardMember))
            return false;
        BoardMember that = (BoardMember) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "BoardMember{" + "id=" + id + '}';
    }

    @Embeddable
    public static class BoardMemberId implements Serializable {

        private static final long serialVersionUID = -5739169913659318896L;

        @Column(name = "board_id")
        private long boardId;

        @Column(name = "user_id")
        private long userId;

        public BoardMemberId() {
        }

        private BoardMemberId(BoardId boardId, UserId userId) {
            this.boardId = boardId.value();
            this.userId = userId.value();
        }

        public BoardId getBoardId() {
            return new BoardId(boardId);
        }

        public UserId getUserId() {
            return new UserId(userId);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof BoardMemberId))
                return false;
            BoardMemberId that = (BoardMemberId) o;
            return boardId == that.boardId && userId == that.userId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(boardId, userId);
        }

        @Override
        public String toString() {
            return "BoardMemberId{" + "boardId=" + boardId + ", userId=" + userId + '}';
        }
    }
}