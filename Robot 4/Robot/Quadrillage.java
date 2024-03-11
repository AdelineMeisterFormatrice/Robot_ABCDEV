package Robot;
/**
 * 
 */
public class Quadrillage {

	private int abcisseMax;
	private int abcisseMin;
	private int ordonneeMax;
	private int ordonneeMin;
	
	public Quadrillage(int _abcisseMax,int _abcisseMin,int _ordonneeMax, int _ordonneeMin)
	{
		abcisseMax = _abcisseMax;
		abcisseMin = _abcisseMin;
		ordonneeMax = _ordonneeMax;
		ordonneeMin = _ordonneeMin;
	}
	
	public int getOrdonneeMax()
	{
		return this.ordonneeMax;
	}
	public int getOrdonneeMin()
	{
		return this.ordonneeMin;
	}
	public int getAbcisseMax()
	{
		return this.abcisseMax;
	}
	public int getAbcisseMin()
	{
		return this.abcisseMin;
	}
}
