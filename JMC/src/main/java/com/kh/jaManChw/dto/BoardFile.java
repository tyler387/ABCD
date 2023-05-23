package com.kh.jaManChw.dto;

public class BoardFile {

	private int boardFileno;
	private int boardno;
	private String originName;
	private String storedName;
	private double filesize;
	
	public BoardFile() {}

	public BoardFile(int boardFileno, int boardno, String originName, String storedName, double filesize) {
		super();
		this.boardFileno = boardFileno;
		this.boardno = boardno;
		this.originName = originName;
		this.storedName = storedName;
		this.filesize = filesize;
	}

	@Override
	public String toString() {
		return "BoardFile [boardFileno=" + boardFileno + ", boardno=" + boardno + ", originName=" + originName
				+ ", storedName=" + storedName + ", filesize=" + filesize + "]";
	}

	public int getBoardFileno() {
		return boardFileno;
	}

	public void setBoardFileno(int boardFileno) {
		this.boardFileno = boardFileno;
	}

	public int getBoardno() {
		return boardno;
	}

	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getStoredName() {
		return storedName;
	}

	public void setStoredName(String storedName) {
		this.storedName = storedName;
	}

	public double getFilesize() {
		return filesize;
	}

	public void setFilesize(double filesize) {
		this.filesize = filesize;
	}
	
	
}
