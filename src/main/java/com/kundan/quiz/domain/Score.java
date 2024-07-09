package com.kundan.quiz.domain;

public class Score {
	private int total;
    private int right;
	
    public Score(int total, int right){
    	this.total = total;
    	this.right = right;
    }
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getRight() {
		return right;
	}
	public void setRight(int right) {
		this.right = right;
	}
    
}
