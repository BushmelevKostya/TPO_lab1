package itmo.task3;

import java.util.ArrayList;
import java.util.List;

public class Crowd {
	private List<Human> humans;
	
	public Crowd() {
		this.humans = new ArrayList<>();
	}
	
	public List<Human> getHumans() {
		return humans;
	}
	
	public void addHuman(Human human) {
		humans.add(human);
	}
	
	public void cheer() {
		for (Human human : humans) {
			human.beHappy();
		}
	}
}
