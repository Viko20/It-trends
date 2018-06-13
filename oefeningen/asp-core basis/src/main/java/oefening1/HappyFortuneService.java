package oefening1;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Vandaag is een gelukkige dag!";
	}

}
