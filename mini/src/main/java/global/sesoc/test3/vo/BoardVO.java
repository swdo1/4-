package global.sesoc.test3.vo;

public class BoardVO {

	private int bnum;
	private String id;
	private String title;
	private String content;
	private int hits;
	private String inputdate;
	private String originalfile;
	private String savedfile;
	
	public BoardVO() {
	}

	public BoardVO(int bnum, String id, String title, String content, int hits, String inputdate, String originalfile,
			String savedfile) {
		super();
		this.bnum = bnum;
		this.id = id;
		this.title = title;
		this.content = content;
		this.hits = hits;
		this.inputdate = inputdate;
		this.originalfile = originalfile;
		this.savedfile = savedfile;
	}

	@Override
	public String toString() {
		return "BoardVO [bnum=" + bnum + ", id=" + id + ", title=" + title + ", content=" + content + ", hits=" + hits
				+ ", inputdate=" + inputdate + ", originalfile=" + originalfile + ", savedfile=" + savedfile + "]";
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public String getInputdate() {
		return inputdate;
	}

	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}

	public String getOriginalfile() {
		return originalfile;
	}

	public void setOriginalfile(String originalfile) {
		this.originalfile = originalfile;
	}

	public String getSavedfile() {
		return savedfile;
	}

	public void setSavedfile(String savedfile) {
		this.savedfile = savedfile;
	}
	
	
	
	
	
	
}

