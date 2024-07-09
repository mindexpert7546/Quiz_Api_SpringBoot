package com.kundan.quiz.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kundan.quiz.domain.Question;

public interface QuizRepo extends  JpaRepository<Question, Integer>{
	List<Question> findByQidIn(List<Integer> qids);
	List<QuestionNumber> findQidBySubjectAndTopic(String subject, String topic);
	long countByQidAndAnswer(int qid, int option);
}
