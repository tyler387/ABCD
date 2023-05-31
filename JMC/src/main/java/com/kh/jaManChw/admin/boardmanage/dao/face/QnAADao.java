package com.kh.jaManChw.admin.boardmanage.dao.face;

import java.util.Map;

import com.kh.jaManChw.dto.QnAA;

public interface QnAADao {

	/**
	 * 답변을 입력받아 QnA 문의의 답변으로 DB에 삽입한다
	 * 
	 * @param qnAAParam - 입력받은 답변을 가져올 DTO 객체
	 */
	public void insertQnAA(QnAA qnAAParam);

	/**
	 * 답변한 QnA 문의의 상태를 "done"으로 변경한다
	 * 
	 * @param qnAAParam - 답변한 답변의 번호를 가져올 DTO객체
	 */
	public void upadateQnAQStatus(QnAA qnAAParam);

	/**
	 * QnA문의에 대한 답변을 수정하기 위해 이전의 답변 정보를 answerno를 통해 가져온다
	 * 
	 * @param qnAAParam - answerno를 가져올 DTO객체 
	 * @return 답변 상세 정보
	 */
	public Map<String, String> selectQnAADetail(QnAA qnAAParam);

	/**
	 * 전달파라미터로 보내진 답변번호를 통해 수정할 row를 찾고 수정된 내용을 반영한다
	 * 
	 * @param qnAAParam - 답변번호, 수정된 내용을 담아올 DTO객체
	 */
	public void updateQnAA(QnAA qnAAParam);

	/**
	 * 전달 파라미터로 보내진 답변번호를 통해 답변의 상태를 delete로 변경한다
	 * 
	 * @param qnAAParam - 삭제하고자 하는 답변 번호를 가져올 DTO 객체
	 */
	public void updateQnAAStatus(QnAA qnAAParam);
	
	

}
