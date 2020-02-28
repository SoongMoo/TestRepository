package Model.DTO;

public class StartEndPageDTO {
	Long startPage;
	Long endPage;
	public StartEndPageDTO(Long startPage, Long endPage) {
		this.startPage = startPage;
		this.endPage = endPage;
	}
	public Long getStartPage() {
		return startPage;
	}
	public Long getEndPage() {
		return endPage;
	}	
}
