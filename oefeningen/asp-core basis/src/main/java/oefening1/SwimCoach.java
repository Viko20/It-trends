package oefening1;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;

	public SwimCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Zwem 1000 meter.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}




