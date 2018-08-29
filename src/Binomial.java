
public class Binomial {

	private int expon;
	private int x;
	private int y;
	private String response;
	private int[] factorial = new int[expon + 1];
	private int[] sum1 = new int[expon + 1];
	private double[] coefX = new double[expon + 1];
	private double[] coefY = new double[expon + 1];
	private int[] powX = new int[expon + 1];
	private int[] powY = new int[expon + 1];
	private String[] myString1 = new String[expon + 1];
	private String myString;

	public Binomial(int x, int y, int expon) {
		this.x = x;
		this.y = y;
		this.expon = expon;
	}

	public static double calcCoefX(double x, double i) {
		double result = Math.pow(x, i);
		return result;
	}

	public static double calcCoefy(double y, double i) {
		double result = Math.pow(y, i);
		return result;
	}

	public static int calcComb(int expon, int i) {
		int result = calcFact(expon) / (calcFact(expon - i) * calcFact(i));
		return result;
	}

	public static int calcFact(int expon) {
		int result = 1;
		for (int i = expon; i > 0; i--)
			result = result * i;
		return result;

	}

	public String toString() {
		for (int i = 0; i <= expon; i++)
			factorial[i] = calcComb(expon, i);

		for (int i = 0; i <= expon; i++)
			coefX[i] = calcCoefX(x, i);

		int index = 0;
		for (int i = expon; i >= 0; i--)
			coefY[index] = calcCoefy(y, i);
		index++;

		for (int i = 0; i <= expon; i++)
			sum1[i] = ((int) coefX[i] * (int) coefY[i]) * factorial[i];

		int counter;
		for (counter = 0; counter <= expon; counter++)
			powX[counter] = counter;

		int c = 0;
		int j;
		for (j = expon; j >= 0; j--)
			powY[c] = j;
		c++;
		int l;
		for (l = 0; l <= expon; l++)
			if (powX[l] == 0)
				myString1[l] = "( " + (int) sum1[l] + "y^" + powY[l] + " ) + ";
			else if (powX[l] == 1 && powY[l] == 1)
				myString1[l] = "( " + (int) sum1[l] + "x" + "y" + " ) + ";
			else if (powX[l] == 1)
				myString1[l] = "( " + (int) sum1[l] + "x" + "y^" + powY[l] + " ) + ";
			else if (powY[l] == 0)
				myString1[l] = "( " + (int) sum1[l] + "x^" + powX[l] + " )";
			else if (powY[l] == 1)
				myString1[l] = "( " + (int) sum1[l] + "x^" + powX[l] + "y" + " ) + ";
			else
				myString1[l] = "( " + (int) sum1[l] + "x^" + powX[l] + "y^" + powY[l] + " ) + ";

		myString = "( " + (int) x + "x + " + (int) y + "Y )^" + expon + " = " + myString1[l];

		return myString;
	}
}
