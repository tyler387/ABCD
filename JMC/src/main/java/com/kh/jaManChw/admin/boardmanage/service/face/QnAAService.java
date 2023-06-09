package com.kh.jaManChw.admin.boardmanage.service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.kh.jaManChw.dto.QnAA;

public interface QnAAService {

	/**
	 * 세션의 userno를 qnAAParam에 넣어 반환한다
	 * 
	 * @param session - userno를 가져올 세션 객체
	 * @param qnAAParam - userno를 받을 DTO 객체
	 * @return userno를 set한 qnAAParam DTO 객체
	 */
	public QnAA getCompleteParam(HttpSession session, QnAA qnAAParam);

	/**
	 * 답변을 입력받아 QnA 문의의 답변으로 DB에 삽입한다
	 * 
	 * @param qnAAParam - 입력받은 답변을 가져올 DTO객체
	 */
	public void writeQnAA(QnAA qnAAParam);

	/**
	 * 전달 파라미터로 보내진 문의 번호, 답변번호를 통해 문의, 답변의 상세정보를 반환한다
	 * 
	 * @param qnAAParam - 문의 번호와 답변번호를 가져올 DTO객체
	 * @return 문의, 답변의 상세정보
	 */
	public Map<String, Map<String, String>> showQnAADetail(QnAA qnAAParam);

	/**
	 * 전달파라미터로 보내진 답변번호를 통해 수정할 row를 찾고 수정된 내용을 반영한다
	 * 
	 * @param qnAAParam - 답변번호, 수정된 내용을 담아올 DTO객체
	 */
	public void reviseQnAA(QnAA qnAAParam);

	/**
	 * 전달 파라미터로 보내진 답변번호를 통해 답변의 상태를 delete로 변경하고
	 * 해당문의의 처리상태를 미처리로 변경한다
	 * 
	 * @param qnAAParam - 삭제하고자 하는 답변 번호와 문의 번호를 가져올 DTO 객체
	 */
	public void eraseQnAAStatus(QnAA qnAAParam);




}