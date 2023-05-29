package com.petmily.backend.community.flea.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FleaBoardRepository extends JpaRepository<FleaBoard, Long> {

	// 게시글 전체 조회
	@Query(
			nativeQuery=true,
			value="SELECT fb.boardNum, fb.boardId, fb.boardSubject, fb.boardCost, fb.boardCount, fb.imgThumbnail, m.memberNickname "
					+ "FROM fleaboard fb "
					+ "JOIN member m ON fb.memberNum = m.memberNum")
	List<FleaBoardList> getFleaBoards();
	
	// 게시글 조회
	@Query(
			nativeQuery=true,
			value="SELECT fb.*, m.memberNickName, m.memberImg "
			+ "FROM fleaboard fb "
			+ "JOIN member m ON fb.memberNum = m.memberNum WHERE fb.boardNum = :boardNum")
	FleaBoardDetail findFleaBoardDetail(@Param("boardNum") Long boardNum);
	
	// 조회수 증가
	@Modifying
    @Query(
    		nativeQuery=true,
    		value="UPDATE FleaBoard fb SET fb.boardCount = fb.boardCount + 1 WHERE fb.boardNum = :boardNum")
    void updateBoardCount(Long boardNum);
}