package itmo.task3;

public class Artur extends Human {
	public Artur() {
		super("Artur");
	}
	
	public void glideThroughTheAir() {
		Building building = new Building("Величественное окно на втором этаже");
		goTo(building);
	}
}
