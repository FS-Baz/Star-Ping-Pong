import javax.swing.*;


public class gameFrame extends JFrame{
    
    gamePanel panel ;
    gameFrame(){
        panel = new gamePanel();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Star ball");   
        this.add(panel); 
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


    public static void main(String[] args) {
        new gameFrame();
        }
} 
    

