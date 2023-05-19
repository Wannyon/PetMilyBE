package com.petmily.backend.community.missing.board;

import java.time.LocalDateTime;

public interface MissingBoardList {
	Long getBoardNum();
	String getBoardId();
	String getBoardSubject();
	Integer getBoardCount();
	LocalDateTime BoardDate();
	boolean getBoardStatus();
	String getImgThumbnail();
	String getMemberNickName();
}
