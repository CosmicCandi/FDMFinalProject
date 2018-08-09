package com.fdmgroup.icms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.icms.models.Comment;

public interface CommentJpaRepository extends JpaRepository<Comment, Long> {

	Comment findOneByCommentId(int commentId);
}
