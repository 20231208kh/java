package kr.kh.account.pagination;

import lombok.Data;

//현재 페이지 정보를 관리하는 클래스
@Data
public class Criteria {
	
	private int page;
	private int perPageNum;
	private String Search;
	
	public Criteria() {
		page = 1;
		perPageNum = 10;
		
	}
	
	public Criteria(int page, int perPageNum) {
		this.page =page;
		this.perPageNum = perPageNum;
	}
	
	public int getPageStart() {
		return (page-1) * perPageNum;
	}
}
