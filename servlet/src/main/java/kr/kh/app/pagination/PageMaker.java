package kr.kh.app.pagination;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PageMaker {
	private int totalCount; // 전체 컨텐츠 개수 => 마지막 페이지네이션의 마지막 페이지를 계싼하기 위해
	private int startPage; //페이지네이션 시작번호
	private int endPage;  //페이지네이션 마지막번호
	private boolean prev; //이전버튼 활성화
	private boolean next; //다음버튼 활성화
	private int displayPageNum; //한페이지네이션에서 보여준 페이지의 최대 숫자 개수
	private Criteria cri;
	
	//totalCount, displayPageNum, perPageNum을 이용하여
	//endPage, startPage, prev, next를 계산하는 메서드
	public void calculate() {
		
		//현재 페이지에 대한 최대 페이지번호
		//현재페이지 : 4 , 한페이지 컨텐츠 개수가 10, 한 페이지네이션의 페이지 개수 : 10
		// (4 /10.0)의 올림 * 10 대충 현재페이지 0~10 = 10 , 11~20 = 20, 이런식임
		endPage = (int)(Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum);
		startPage = endPage - displayPageNum+1;
		
		//컨텐츠 개수를 이용하여 계산한 최대 페이지 번호
		//전체 컨텐츠 갯수 / 페이지당 보여줄 컨텐츠 갯수 ->  소숫점 올림
		int tmpEndPage = (int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
		
		//endPage와 tmpEndPage 중 작은 값을 endPage로 설정
		if(endPage > tmpEndPage) {
			endPage = tmpEndPage;
		}
		
		//첫번째 페이지네이션이면 false 아니면 true
		prev = startPage ==1 ? false : true;
		next = endPage == tmpEndPage ? false : true;
	}
	
	public PageMaker(int displayPageNum, Criteria cri, int totalCount) {
		this.displayPageNum = displayPageNum;
		this.cri=cri;
		this.totalCount=totalCount;
		calculate();
	}

}
