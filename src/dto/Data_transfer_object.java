package dto;

public class Data_transfer_object {
	
	private String title;
	private String author;
	private int year;

	public Data_transfer_object(String title,String author,int year) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.author = author;
		this.year = year;
	}
	
	public String get_title() {
		return title;
	}
	public void set_title(String title) {
		this.title = title;
	}
	public String get_author() {
		return author;
	}
	public void set_author(String author) {
		this.author = author;
	}
	public int get_year() {
		return year;
	}
	public void set_year(int year) {
		this.year = year;
	}
	

}
