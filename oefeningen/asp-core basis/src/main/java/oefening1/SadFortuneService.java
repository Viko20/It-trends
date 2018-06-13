package oefening1;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Vandaag heb je geen chance";
	}

}
