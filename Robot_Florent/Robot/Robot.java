package Robot;
enum Bouton{
	ALLUMER,ETEINDRE,AVANCER,TOURNEADROITE,TOURNEAGAUCHE,ARRETER
}
enum Direction{
	GAUCHE,DROITE,HAUT,BAS
}

public class Robot {

	private boolean estAllume;
	private boolean seDeplace;
	private Point position;
	private Direction direction;
	private Quadrillage quadrillage;
	private int vitesse;

	/**
	 * Constructeur sans paramètres
	 */
	public Robot()
	{
		estAllume = false;
		seDeplace = false;
		position = new Point(0,0);
		direction = Direction.HAUT;
		vitesse = 0;
		quadrillage = new Quadrillage(5,-5,5,-5);
	}
	/** Constructeur avec paramètres
	 * 
	 * @param _estAllume
	 * @param _estEnMarche
	 * @param _position
	 * @param _direction
	 * @param _vitesse
	 * @param _quadrillage
	 */
	public Robot(boolean _estAllume,boolean _estEnMarche,Point _position,Direction _direction,int _vitesse,Quadrillage _quadrillage)
	{
		estAllume = _estAllume;
		seDeplace = _estEnMarche;

		position = _position;
		direction = _direction;
		vitesse = _vitesse;
		quadrillage = _quadrillage;
	}
	/**
	 * Cette méthode allume le robot (en appuyant sur le bouton "allumer"==> ALLUMER dans action()).
	 * @return
	 */
	private boolean allumer()
	{
		if (estAllume == false){
			estAllume =true;
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * Cette méthode eteint le robot (en appuyant sur le bouton "éteindre" ==> ETEINDRE dans action()).
	 * @return
	 */
	private boolean eteindre()
	{
		if (estAllume == true){
			vitesse = 0;
			seDeplace = false;
			estAllume = false;
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * Cette méthode diminue la vitesse du robot s'il est en marche jusqu'a avoir une vitesse de 0 (a chaque appuie sur le bouton "arrêter"==> ARRETER dans action()) 
	 * ou l'arrête si la vitesse est nulle.
	 * Elle gère la vitesse de recule comme la vitesse d'avancée.
	 */
	private boolean arreter()
	{
		if (estAllume && seDeplace){
			if (vitesse <=2 && vitesse != 0){
				vitesse -= 1;
				if (vitesse ==0){
					seDeplace = false;
				}
				return true;
			}
			else if (vitesse ==0){
				seDeplace = false;
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	/**
	 * Cette méthode fait avancer le robot s'il est allumé et lui fait prendre de la vitesse (à chaque appuie sur le bouton "avancer"==> AVANCER dans action()).
	 * S'il bute au bornes du quadrillage, il s'arrête.
	 * @return
	 */
	private boolean avancer()
	{	
		if(this.vitesse <=1){
			this.vitesse += 1;
		}
		if (estAllume)
		{
				if(!this.estPositionValide(this.position)){
					this.vitesse = 0;
					this.seDeplace = false;
					return false;
				}else
				{
					
					this.seDeplace = true;
					if(direction == this.direction.HAUT) {
							if(this.estPositionValide(new Point(0,this.position.ordonnee+vitesse))){
								this.position.ordonnee += vitesse;
								return true;
							}else {
								return false;
							}
					}else if(direction == this.direction.DROITE) {
						if(this.estPositionValide(new Point(0,this.position.abcisse+vitesse))){
							this.position.abcisse += vitesse;
							return true;
						}else {
							return false;
						}
					}else if(direction == this.direction.BAS) {
						if(this.estPositionValide(new Point(0,this.position.ordonnee-vitesse))){
							this.position.ordonnee -= vitesse;
							return true;
						}else {
							return false;
						}
					}else if (direction == this.direction.GAUCHE){
						if(this.estPositionValide(new Point(0,this.position.abcisse+vitesse))){
							this.position.abcisse -= vitesse;
							return true;
						}else {
							return false;
						}
					}
					return true;
				}

		}else{
			return false;
		}
	}
	/**
	 * Cette fonction fait tourner le robot a droite (à chaque appuie sur le bouton "tourner à droite  ==> TOURNEADROITE dans action()). 
	 * IL faudrait définir une vitesse max a laquelle le robot peut tourner, sans quoi il risque d'avoir trop d'inertie dans son virage et tomber.
	 * @return
	 */
	private boolean tourneADroite()
	{
		if (estAllume)
		{
			if(direction == this.direction.HAUT ){
					this.direction = this.direction.DROITE;
					return true;
			}
			else if(direction == this.direction.DROITE){
					this.direction = this.direction.BAS;
					return true;
			}
			else if (direction == this.direction.BAS){
					this.direction = this.direction.GAUCHE;
					return true;
			}
			else if (direction == this.direction.GAUCHE){
					this.direction = this.direction.HAUT;
					return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	/**
	 * Cette fonction fait tourner à gauche le robot (à chaque appuie sur le bouton "tourner à gauche" ==> TOURNEAGAUCHE dans action()).
	 * IL faudrait définir une vitesse max a laquelle le robot peut tourner, sans quoi il risque d'avoir trop d'inertie dans son virage et tomber.
	 * @return
	 */
	private boolean tourneAGauche()
	{
		if (estAllume)
		{
			if(direction == this.direction.HAUT ){
					direction = this.direction.GAUCHE;
					return true;
			}
			else if(direction == this.direction.GAUCHE){
					direction = this.direction.BAS;
					return true;
			}
			else if (direction == this.direction.BAS){
					direction = this.direction.DROITE;
					return true;
			}
			else if (direction == this.direction.DROITE){
					direction = this.direction.HAUT;
					return true;
			}
			else{
					return false;
			}
		}
		else{
			return false;
		}
	}
	/**
	 * Retourne true si la position du robot est valide, false sinon
	 * @param _positionTest
	 * @return
	 */
	private boolean estPositionValide(Point _positionTest) {
		if (_positionTest.getAbcisse() <= quadrillage.getAbcisseMax()
				&& _positionTest.getOrdonnee() <= quadrillage.getOrdonneeMax()
				&& _positionTest.getAbcisse() >= quadrillage.getAbcisseMin()
				&& _positionTest.getOrdonnee() >= quadrillage.getOrdonneeMin()) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Cette fonction exécute une action dépendante de la valeur de l'énumération à laquelle se réferera l'appuie sur un bouton de la télécommande
	 * @param appuiBouton
	 * @return
	 */
	public boolean action(Bouton appuiBouton)
	{
		switch(appuiBouton){
		case ALLUMER:
			this.allumer();
			return true;
		case ETEINDRE:
			this.eteindre();
			return true;
		case AVANCER:
			this.avancer();
			return true;
		case TOURNEADROITE:
			this.tourneADroite();
			return true;
		case TOURNEAGAUCHE:
			this.tourneAGauche();
			return true;
		case ARRETER:
			this.arreter();
			return true;
		default:
			return false;
		}
	}
}
