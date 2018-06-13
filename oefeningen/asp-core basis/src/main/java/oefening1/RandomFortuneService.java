package oefening1;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] data = { 
			"Random data is hier",
			"maar hier is ook random data",
			"nog meer random data haha?"
	};

	private Random myRandom = new Random();
		
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(data.length);
		
		String theFortune = data[index];
		
		return theFortune;
	}

}


