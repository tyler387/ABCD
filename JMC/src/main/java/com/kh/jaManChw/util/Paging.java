package com.kh.jaManChw.util;

public class Paging {

	private int curPage; 
	private int totalCount;
	private int totalPage;
	private int listCount;
	
	private int pageCount;
	
	private int startPage;
	private int endPage;
	private int startno;
	private int endno;
	
	
	public Paging() {}

	public Paging(int curPage, int totalCount) {
		setCurPage(curPage);
		setTotalCount(totalCount);
		makePaging();
	}

	public Paging(int curPage, int totalCount, int listCount, int pageCount) {
		setCurPage(curPage);
		setTotalCount(totalCount);
		setListCount(listCount);
		setPageCount(pageCount);
		makePaging();
	}

	private void makePaging() {
		
		if(totalCount == 0) return;
		if(curPage <= 0) curPage = 1;
		if(listCount == 0) listCount = 10;
		if(pageCount == 0 ) pageCount = 10;
		
		totalPage = totalCount / listCount;
		if(totalCount%listCount != 0 ) totalPage ++;
		
		if(curPage >= totalPage) curPage = totalPage;
		
		startPage = ((curPage -1)/pageCount)*pageCount + 1;
		endPage = startPage + pageCount -1;
		
		if(endPage > totalPage) endPage = totalPage;
		
		startno = (curPage-1)*listCount + 1;
		endno = curPage*listCount;
	}
	
	@Override
	public String toString() {
		return "Paging [curPage=" + curPage + ", totalCount=" + totalCount + ", totalPage=" + totalPage + ", listCount="
				+ listCount + ", pageCount=" + pageCount + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", startno=" + startno + ", endno=" + endno +"]";
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartno() {
		return startno;
	}

	public void setStartno(int startno) {
		this.startno = startno;
	}

	public int getEndno() {
		return endno;
	}

	public void setEndno(int endno) {
		this.endno = endno;
	}
	

	
}
