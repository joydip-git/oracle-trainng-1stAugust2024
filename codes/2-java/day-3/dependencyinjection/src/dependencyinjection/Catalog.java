package dependencyinjection;

import java.util.Date;

//Association class
public class Catalog {
	public int EntryId;
	public int BookId;
	public int UserId;
	public Date IssueDate;
	public Date ReturnDate;
	public double FineAmount;
	
	public Book BookInfo;
	public User UserInfo;	
}
