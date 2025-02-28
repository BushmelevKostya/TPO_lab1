package itmo.task3;

public class Orator extends Human {
	public Orator(String name) {
		super(name);
	}
	
	public void makeSpeech(Crowd crowd) {
		if (position.getName().isEmpty() || !position.getName().equals("Помост")) {
			System.out.println("Оратора никто не услышал");
		} else {
			System.out.println(name + " обращается к толпе.");
			crowd.cheer();
		}
	}
	public void goToPlatform() {
		Building building = new Building("Помост");
		goTo(building);
	}
}
