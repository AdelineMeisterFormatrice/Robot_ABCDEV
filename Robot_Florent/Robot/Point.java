package Robot;
/**
 * Cette classe permet de définir un point qui servira pour la position des robot.
 */
public class Point {

	int abcisse,ordonnee;
	
	public Point(int _abcisse,int _ordonnee)
	{
		abcisse = _abcisse;
		ordonnee = _ordonnee;
	}
	

	public int getAbcisse()
	{
		return this.abcisse;
	}
	public int getOrdonnee()
	{
		return this.ordonnee;
	}
	public void setAbcisse(int _abcisse)
	{
		this.abcisse = _abcisse;
	}
	public void setOrdonnee(int _ordonnee)
	{
		this.ordonnee = _ordonnee;
	}


}
