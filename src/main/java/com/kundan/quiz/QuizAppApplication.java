package com.kundan.quiz;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kundan.quiz.domain.Question;
import com.kundan.quiz.repo.QuizRepo;

@SpringBootApplication
public class QuizAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizAppApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(QuizRepo questionRepository){
		return args -> {
			 questionRepository.save(new Question("What is Spring?", "Framework", "Library", "Tool", "Language", 1, "Programming", "Frameworks"));
		     questionRepository.save(new Question("What is Hibernate?", "ORM", "Database", "IDE", "Tool", 1, "Programming", "ORM"));
		     questionRepository.save(new Question("What is Maven?", "Build Tool", "Library", "Framework", "Language", 1, "Programming", "Build Tools"));
		     questionRepository.save(new Question("What is JPA?", "Specification", "Library", "Framework", "Tool", 1, "Programming", "JPA"));
		     questionRepository.save(new Question("What is Docker?", "Containerization", "Virtualization", "Cloud", "OS", 1, "DevOps", "Containers"));
		     questionRepository.save(new Question("What is Kubernetes?", "Orchestration", "Virtualization", "Cloud", "OS", 1, "DevOps", "Orchestration"));
		     questionRepository.save(new Question("What is Jenkins?", "CI/CD Tool", "Library", "Framework", "Language", 1, "DevOps", "CI/CD"));
		     questionRepository.save(new Question("What is Git?", "Version Control", "Library", "Framework", "Tool", 1, "DevOps", "Version Control"));
		     questionRepository.save(new Question("What is REST?", "Architecture", "Protocol", "Library", "Tool", 1, "Web", "API"));

		     System.out.println("10 questions have been inserted.");
		};
	}

}
