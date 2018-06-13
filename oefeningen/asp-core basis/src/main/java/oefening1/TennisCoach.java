package oefening1;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	public TennisCoach() {
		System.out.println("TennisCoach: in default const");
	}

	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("TennisCoach: in doMyStartupStuff()");
	}

	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("TennisCoach: in doMyCleanupStuff()");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Oefen uw backhand vclley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
