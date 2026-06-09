package com.kh.miniproject;

import java.util.ArrayList;
import java.util.List;

public class BookController {
	
	private List<Book> bookList = new ArrayList<>();
	private List<RentRecord> pastRecord = new ArrayList<>();
	private List<RentRecord> currentRecord = new ArrayList<>();
	final static int DEFAUL_DAY = 7; 
	
	//도서 등록
	public int addBook(String title, String author) {
		for(Book b2 : bookList) {
			if(title.equals(b2.getTitle()) && author.equals(b2.getAuthor())) {
				System.out.println("이미 등록되어있는 책입니다.");
				return 0;
			}
		}
		bookList.add(new Book(title, author));
		System.out.println("등록했습니다.");
		return 1;
	}
	
	//도서 삭제
	public int removeBook(int bookID) {
		for(RentRecord r : currentRecord) {
			if(bookID == r.getBookID()) {
				System.out.println("아직 대출중인 책을 삭제할 수 없습니다.");
				return 0;
			}
		}
		
		for(Book b : bookList) {
			if(bookID == b.getId()) {
				bookList.remove(b);
				System.out.println("책" +b+ "를 삭제했습니다.");
				return 1;
			}
		}
		
		System.out.println("도서번호를 잘못 입력하셨습니다.");
		return 0;
	}
	
	// 전체 도서 리스트
	public List<Book> allBook(){
		return bookList;
	}
	
	// 제목에 특정키워드 들어가는 도서리스트
	public List<Book> searchBook(String str) {
		List<Book> searched = new ArrayList<>();
		for(Book b : bookList) {
			if(b.getTitle().contains(str)) {
				searched.add(b);
			}
		}
		
		if(searched.isEmpty()) {
			return null;
		}
			
		return searched;
	}
	
	//도서 대출
	public int rentBook(int bookID, int managementID, int today) {
		for(Book b : bookList) {
			if(bookID == b.getId()) {
				
				for(RentRecord r : currentRecord) {
					if(bookID == r.getBookID()) {
						System.out.println("이미 대출중인 도서입니다");
						return 0;
					}
				}
				
				currentRecord.add(new RentRecord(bookID, managementID, today, today+DEFAUL_DAY));
				System.out.println("대출에 성공했습니다");
				return today+DEFAUL_DAY;
			}
		}
		
		System.out.println("도서번호를 잘못 입력하셨습니다.");
		return 0;
	}
	
	//도서 반납
	public RentRecord returnBook(int bookID, int today) {
		for(int i=0; i<currentRecord.size(); i++) {
			if(bookID == currentRecord.get(i).getBookID()) {
				currentRecord.get(i).setReturnDate(today);
				pastRecord.add(currentRecord.get(i));
				RentRecord r = currentRecord.get(i); 
				
				currentRecord.remove(i);
				System.out.println("반납되었습니다.");
				return r;
			}
		}
		
		System.out.println("대출중인 도서가 아닙니다");
		return null;
	}
	
	// 특정 사용자 대출기록 리스트
	public List<RentRecord> personRentRecord(int managementID){
		List<RentRecord> pr = new ArrayList<>();
		for(RentRecord r : currentRecord) {
			if(r.getmanagementID() == managementID) {
				pr.add(r);
			}
		}
		
		for(RentRecord r : pastRecord) {
			if(r.getmanagementID() == managementID) {
				pr.add(r);
			}
		}
		
		return pr;
	}
	
	// 특정 도서 대출기록 리스트
	public List<RentRecord> bookRentRecord(int bookID){
		List<RentRecord> br = new ArrayList<>();
		for(RentRecord r : currentRecord) {
			if(r.getBookID() == bookID) {
				br.add(r);
			}
		}
		
		for(RentRecord r : pastRecord) {
			if(r.getBookID() == bookID) {
				br.add(r);
			}
		}
		
		return br;
		
	}
	
	// 대출 기한 연장
	public int delay(int bookID, int day) {
		for(RentRecord r : currentRecord) {
			if(r.getBookID() == bookID) {
				r.setDueDate(r.getDueDate()+day);
				System.out.println("반납 예정일을 " +day+"일 만큼 연장했습니다.");
				return 1;
			}
		}
		
		System.out.println("도서번호를 잘못 입력하셨습니다.");
		return 0;
	}
	
	// 대출중인 도서 리스트
	public List<RentRecord> getCurrentRecord(){
		return currentRecord;
	}
	
	// 대출기록 과거 리스트
	public List<RentRecord> getpastRecord() {
		return pastRecord;
	}
	
}
