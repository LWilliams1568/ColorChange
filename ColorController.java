package LashonWilliams.project2;
  
public class ColorController implements ControllerInterface {
    ColorModelInterface model;
    ColorView view;
    ViewInterface viewInterface;
   
    public ColorController(ColorModelInterface model) {
        this.model = model;
        view = new ColorView(this, model);
        view.createView();
    }    
        
    public void increaseRed() {
        int red = model.getRed();
        
        if(red >= 0 && red <= 255){
            model.setRed(red + 10);
        }  
        else{
            System.out.println("Out of range");
        }
    }
    
    public void decreaseRed() {
        int red = model.getRed();
        
        if(red >= 0 && red <= 255){
            model.setRed(red - 10);
        }
        else{
            System.out.println("Out of range");
        }
    }
  
    public void setRed(int red) {
        if(red >= 0 && red <=255)
            model.setRed(red);
            
        else
            System.out.println("out of range");
    }
        
    public void increaseBlue() {
        int blue = model.getBlue();
        
        if(blue >= 0 && blue <= 255){
            model.setBlue(blue + 10);
        }
        else{
            System.out.println("Out of range");
        }
    }
    
    public void decreaseBlue() {
        int blue = model.getBlue();
        
        if(blue >= 0 && blue <= 255){
            model.setBlue(blue - 10);
        }
        else{
            System.out.println("Out of range");
        }
    }
  
    public void setBlue(int blue) {
        model.setBlue(blue);
    }
        
    public void increaseGreen() {
        int green = model.getGreen();
        
        if(green >= 0 && green <= 255){
            model.setGreen(green + 10);
        }
        
        else{
            System.out.println("Out of range");
        }
    }
    
    public void decreaseGreen() {
        int green = model.getGreen();
        
        if(green >= 0 && green <= 255){
            model.setGreen(green - 10);
        }
        else{
            System.out.println("Out of range");
        }
    }    
  
    public void setGreen(int green) {
        model.setGreen(green);
    }
        
    public int getGreen(){
        return model.getGreen();       
    }
       
    public int getRed(){
        return model.getRed();
    }
       
    public int getBlue(){
        return model.getBlue();
   }
}
