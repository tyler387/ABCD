package com.kh.jaManChw.dto;

public class BoardLike {

	private int likeno;
	private int boardno;
	private int userno;
	
	public BoardLike() {}

	public BoardLike(int likeno, int boardno, int userno) {
		super();
		this.likeno = likeno;
		this.boardno = boardno;
		this.userno = userno;
	}

	@Override
	public String toString() {
		return "BoardLike [likeno=" + likeno + ", boardno=" + boardno + ", userno=" + userno + "]";
	}

	public int getLikeno() {
		return likeno;
	}

	public void setLikeno(int likeno) {
		this.likeno = likeno;
	}

	public int getBoardno() {
		return boardno;
	}

	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}
	
}
