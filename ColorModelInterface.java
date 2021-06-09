package LashonWilliams.project2;

public interface ColorModelInterface {

    void setRed(int red);
    
    void setBlue(int blue);
    
    void setGreen(int green);
    
    int getBlue();
    
    int getGreen();
    
    int getRed();
    
    void registerObserver(ColorObserver og);
    
    void removeObserver(ColorObserver ro);
    
}
    
  
    

