package easyrent.search.pojo;
import java.util.List;

public class SearchResult {

	private List<Home> homeList;
	
	private long recordCount;

	private long pageCount;

	private long curPage;
	
	public List<Home> gethomeList() {
		return homeList;
	}
	public void setHomeList(List<Home> homeList) {
		this.homeList = homeList;
	}
	public long getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}
	public long getPageCount() {
		return pageCount;
	}
	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}
	public long getCurPage() {
		return curPage;
	}
	public void setCurPage(long curPage) {
		this.curPage = curPage;
	}
	
}
