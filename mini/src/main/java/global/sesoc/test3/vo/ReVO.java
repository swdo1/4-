package global.sesoc.test3.vo;

public class ReVO {
	
	private int rnum;
	private int bnum;
	private String id;
	private String text;
	private String inputdate;
	
	public ReVO() {
	}

	public ReVO(int rnum, int bnum, String id, String text, String inputdate) {
		super();
		this.rnum = rnum;
		this.bnum = bnum;
		this.id = id;
		this.text = text;
		this.inputdate = inputdate;
	}

	@Override
	public String toString() {
		return "ReVO [rnum=" + rnum + ", bnum=" + bnum + ", id=" + id + ", text=" + text + ", inputdate=" + inputdate
				+ "]";
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getInputdate() {
		return inputdate;
	}

	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}
	
	
	
	
	
}
