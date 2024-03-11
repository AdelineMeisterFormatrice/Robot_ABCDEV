package Robot;



public class App {

	public static void main(String[] args) {
		Robot bot = new Robot("R2D2",false,false,false);
		
		boolean on = bot.allumerRobot();
		
		bot.deplacer(Robot.Deplacement.AVANT);

	}

}
