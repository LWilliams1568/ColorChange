package LashonWilliams.project2;

public class Main {
      public static void main (String[] args) {
        ColorModelInterface model = new ColorModel();
	ControllerInterface controller = new ColorController(model);
    }
    
}
