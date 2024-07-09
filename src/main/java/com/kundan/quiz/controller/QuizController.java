package com.kundan.quiz.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kundan.quiz.domain.Answer;
import com.kundan.quiz.domain.Question;
import com.kundan.quiz.domain.Score;
import com.kundan.quiz.repo.QuizRepo;

@RestController
@RequestMapping("/quiz/api")
public class QuizController {
	
	@Autowired
	private QuizRepo repo;
	
	//add the question for quiz
	@PostMapping("/addQuestion")
	public ResponseEntity<Question> add(@RequestBody Question question) {
		question = repo.save(question);
		return ResponseEntity.status(HttpStatus.CREATED).body(question);
	}
	
	@GetMapping("/fetchQuestions")
	public ResponseEntity<List<Question>> generate(@RequestParam("subject") String subject,
	                                               @RequestParam("topic") String topic) {
	    List<Integer> ids = repo.findQidBySubjectAndTopic(subject, topic).stream()
	                            .map(qn -> qn.getQid())
	                            .collect(Collectors.toList());
	    Collections.shuffle(ids);

	    // Ensure the sublist doesn't exceed the size of ids
	    List<Integer> subListIds = ids.size() > 10 ? ids.subList(0, 10) : ids;

	    List<Question> questions = repo.findByQidIn(subListIds);
	    return ResponseEntity.status(HttpStatus.OK).body(questions);
	}

	
	@PostMapping("/answers")
	public ResponseEntity<Score> evaluate(@RequestBody List<Answer> answers) {
		int rights = 0;
		for (Answer answer : answers)
		rights += (int) repo.countByQidAndAnswer(answer.getQid(), answer.getOption());
		Score score = new Score(answers.size(), rights);
		return ResponseEntity.status(HttpStatus.CREATED).body(score);
	}
	 
}
