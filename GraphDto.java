package termp0_91;

public class GraphDto {

	   private double a, b, c, d;

	   public GraphDto(double a1, double b1, double c1, double d1) {
	      a = a1;
	      b = b1;
	      c = c1;
	      d = d1;
	   }

	   public double func(double aa) {
	      double x = aa;
	      double y = a * x * x * x + b * x * x + c * x + d;
	      return y;
	   }

	}
