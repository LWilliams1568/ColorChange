package LashonWilliams.project2;
import java.util.*;

public class ColorModel implements ColorModelInterface {
    ArrayList redObservers = new ArrayList();
    ArrayList blueObservers = new ArrayList();
    ArrayList greenObservers = new ArrayList();
    ViewInterface viewInterface;
    ColorObserver observer;
    int red= 10;
    int blue= 10;
    int green= 10;
    
    public void setRed(int red) {
        if(red >=0 && red <= 255){
            this.red = red;
            notifyRedObservers();
        }    
        
        else{
            System.out.println("out of range");
        }
	
    }
  
    public int getRed() {
	return red;
    }
    
    public void setBlue(int blue) {
        if(blue >=0 && blue <= 255){
            this.blue = blue;
            notifyBlueObservers();
        }
        
        else{
            System.out.println("out of range");
        }
    }
  
    public int getBlue() {
	return blue;
    }
    
    public void setGreen(int green) {
        if(green >=0 && green <= 255){
            this.green = green;
            notifyGreenObservers();
        }
        else{
            System.out.println("out of range");
        }
    }
  
    public int getGreen() {
	return green;
    }
  
    void RedEvent() {
	notifyRedObservers();
    }
    
    void GreenEvent() {
	notifyGreenObservers();
    }
  
  
    void BlueEvent() {
	notifyBlueObservers();
    }
  
    public void registerObserver(ColorObserver o) {
	redObservers.add(o);
        blueObservers.add(o);
        greenObservers.add(o);
    }
   
    public void notifyRedObservers() {
	for(int i = 0; i < redObservers.size(); i++) {
            ColorObserver observer = (ColorObserver)redObservers.get(i);
            observer.updateRed();
	}
    }
  
    
    public void notifyBlueObservers() {
	for(int i = 0; i < blueObservers.size(); i++) {
            ColorObserver observer = (ColorObserver)blueObservers.get(i);
            observer.updateBlue();
        }
    }
    
    public void notifyGreenObservers() {
	for(int i = 0; i < greenObservers.size(); i++) {
            ColorObserver observer = (ColorObserver)greenObservers.get(i);
            observer.updateGreen();
        }
    }


    public void removeObserver(ColorObserver o) {
	int i = redObservers.indexOf(o);
            if (i >= 0) {
		redObservers.remove(i);
                blueObservers.remove(i);
                greenObservers.remove(i);
            }
    }        
}
