package com.kh.jaManChw.dto;

public class BoardOption {

	private int boardOptionno;
	private String boardTitle;

	public BoardOption() {}

	public BoardOption(int boardOptionno, String boardTitle) {
		super();
		this.boardOptionno = boardOptionno;
		this.boardTitle = boardTitle;
	}

	@Override
	public String toString() {
		return "BoardOption [boardOptionno=" + boardOptionno + ", boardTitle=" + boardTitle + "]";
	}

	public int getBoardOptionno() {
		return boardOptionno;
	}

	public void setBoardOptionno(int boardOptionno) {
		this.boardOptionno = boardOptionno;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

}
