package com.kh.jaManChw.dto;

public class FriendList {

	private int friendListno;
	private int userno;
	private int friendUserno;
	private String friendBlock;
	
	public FriendList() {}

	public FriendList(int friendListno, int userno, int friendUserno, String friendBlock) {
		super();
		this.friendListno = friendListno;
		this.userno = userno;
		this.friendUserno = friendUserno;
		this.friendBlock = friendBlock;
	}

	@Override
	public String toString() {
		return "FriendList [friendListno=" + friendListno + ", userno=" + userno + ", friendUserno=" + friendUserno
				+ ", friendBlock=" + friendBlock + "]";
	}

	public int getFriendListno() {
		return friendListno;
	}

	public void setFriendListno(int friendListno) {
		this.friendListno = friendListno;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public int getFriendUserno() {
		return friendUserno;
	}

	public void setFriendUserno(int friendUserno) {
		this.friendUserno = friendUserno;
	}

	public String getFriendBlock() {
		return friendBlock;
	}

	public void setFriendBlock(String friendBlock) {
		this.friendBlock = friendBlock;
	}
	
}
