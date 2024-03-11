package Robot;

public class Test {

	public static void main(String[] args) {
		
		Robot robot1 = new Robot();
		
		//On appuie sur les boutons

		robot1.action(Bouton.ALLUMER);//On allume
		robot1.action(Bouton.AVANCER);
		robot1.action(Bouton.TOURNEADROITE);//Test tourner à droite
		robot1.action(Bouton.AVANCER); //On regarde si le déplacement à changé d'axe après avoir avancé
		robot1.action(Bouton.TOURNEAGAUCHE);//Test tourner à gauche
		robot1.action(Bouton.AVANCER);
		robot1.action(Bouton.AVANCER);
		robot1.action(Bouton.ARRETER);//On diminue la vitesse
		robot1.action(Bouton.ARRETER);// On arrête le robot
		robot1.action(Bouton.AVANCER);//On test la butée
		robot1.action(Bouton.ETEINDRE);//ON éteint
		

	}

}
