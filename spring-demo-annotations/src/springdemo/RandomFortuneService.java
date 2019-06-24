package springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	private Random myRandom = new Random();
	
	// Array of Fortunes
	private String[] data = {
			"Beware of the wolf in sheep's clothing",
			"Dilligence is the mother of good luck",
			"The Journey is the reward"
	};
	
	@Override
	public String getFortune() {
		// Pick a random fortune from the Fortune Array
		int index = myRandom.nextInt(data.length);

		return data[index];
	}

}
