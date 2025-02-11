package itmo.task3;

import java.util.List;

public class Building {
	private String name;
	private List<Human> humans;
	
	public Building(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Human> getHumans() {
		return humans;
	}
	
	public void setHumans(List<Human> humans) {
		this.humans = humans;
	}
	
	@Override
	public String toString() {
		return "Здесь возведено: " + name;
	}
}
