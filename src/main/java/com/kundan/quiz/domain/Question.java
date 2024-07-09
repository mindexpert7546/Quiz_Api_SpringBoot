package com.kundan.quiz.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qid;
	private String description;
	private String optionOne;
	private String optionTwo;
	private String optionThree;
	private String optionFour;
	private int answer;
	private String subject;
	private String topic;
	
	public Question() {}
	 
	public Question(String description, String optionOne, String optionTwo, String optionThree, String optionFour, int answer, String subject, String topic) {
	        this.description = description;
	        this.optionOne = optionOne;
	        this.optionTwo = optionTwo;
	        this.optionThree = optionThree;
	        this.optionFour = optionFour;
	        this.answer = answer;
	        this.subject = subject;
	        this.topic = topic;
	   }
	    
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOptionONe() {
		return optionOne;
	}
	public void setOptionONe(String optionONe) {
		this.optionOne = optionONe;
	}
	public String getOptionTwo() {
		return optionTwo;
	}
	public void setOptionTwo(String optionTwo) {
		this.optionTwo = optionTwo;
	}
	public String getOptionThree() {
		return optionThree;
	}
	public void setOptionThree(String optionThree) {
		this.optionThree = optionThree;
	}
	public String getOptionFour() {
		return optionFour;
	}
	public void setOptionFour(String optionFour) {
		this.optionFour = optionFour;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
}
