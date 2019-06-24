package springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
	}
	
	// define init method
	@PostConstruct
	public void StartupStuff() {
		System.out.println("TennisCoach is Starting - postcontruct method");
	}
	
	// define destroy method
	@PreDestroy
	public void CleanupStuff() {
		System.out.println("Tennis Coach is being destroyed - predestroy method");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
