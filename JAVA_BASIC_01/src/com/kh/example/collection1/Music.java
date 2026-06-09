package com.kh.example.collection1;

import java.util.Objects;

public class Music {

	private String title;
	private String singer;
	
	public Music() {
	}

	public Music(String title, String singer) {
		super();
		this.title = title;
		this.singer = singer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	@Override
	public String toString() {
		return this.title +", "+ this.singer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(singer, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Music other = (Music) obj;
		return title.equals(other.title) && singer.equals(other.singer);
	}
	
	public int compareTo(Music obj) {
		if (this.equals(obj))
			return 0;
		if (title.compareTo(obj.title) != 0)
			return title.compareTo(obj.title);
		return singer.compareTo(obj.singer);
	}
	/*
	 * 기준 값과 비교대상이 동일한 값일 경우 0
		기준 값이 비교대상 보다 작은 경우 -1
		기준 값이 비교대상 보다 큰 경우 1
	 */
	
	
}
