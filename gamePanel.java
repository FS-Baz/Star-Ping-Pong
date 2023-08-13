import java.awt.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class gamePanel extends JPanel implements ActionListener {
    
    final int WIDTH = 800;
    final int HEIGHT =400;
    final int UNITS_SIZE =1;
    final int PLAYER_UNIT =(WIDTH*HEIGHT)-UNITS_SIZE;
    ImageIcon Star ;
    boolean keyPressed = false;
    Timer timer;
    int xVelocity = 3;
    int yVelocity = 2;
    int x=0;
    int y =0;
    float moveVelocity=(float)0.1;
    float[] x1 ={20,20,20,20,20};
    float[] y1 ={50,60,70,80,90};
    float[] x2 ={750,750,750,750,750};
    float[] y2 ={50,60,70,80,90};
    int bodyParts=5;
    char direction ='N';
    
    gamePanel(){
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.pink);
        this.addKeyListener(new MyKeyAdapter());
        Star =  new ImageIcon("Star.png");
        timer = new Timer(10,this);
        timer.start();
        
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g ;
        g2D.drawImage(Star.getImage(), x, y, null);
        for (int i =0;i<bodyParts;i++){
            g2D.setColor(Color.blue);
            g2D.drawRect((int)x1[i],(int) y1[i], 10, 20);
            g2D.fillRect((int)x1[i],(int) y1[i], 10, 20);
            g2D.setColor(Color.red);
            g2D.drawRect((int)x2[i],(int) y2[i], 10, 20);
            g2D.fillRect((int)x2[i],(int) y2[i], 10, 20);
            }
    


        }



        public void move(){
        switch (direction) {
            case 'U':
                for (int i = bodyParts-1; i >= 0; i--) 
                y1[i]=y1[i]-moveVelocity;
                
                if (moveVelocity <10)
                moveVelocity=moveVelocity+(float)0.1;
                break;
            case 'D':
                for (int i = bodyParts-1; i >= 0; i--) 
                y1[i]=y1[i]+moveVelocity;
                
                if (moveVelocity <10)
                moveVelocity=moveVelocity+(float)0.1;
                break;
            case 'N':
                for (int i = bodyParts-1; i >= 0; i--) 
                y1[i]=y1[i];
                
                break;
            default:
                
                break;
        }




        }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (x>=WIDTH-Star.getIconWidth()||x<0){
            xVelocity=xVelocity*-1;
            repaint();
        }
        if (y>=HEIGHT-Star.getIconHeight() || y<0){
            yVelocity=yVelocity*-1;
            repaint();
        }
        x=x+xVelocity;
        y=y+yVelocity;
        move();
        repaint();
    }   
        
    public class MyKeyAdapter extends KeyAdapter{
        @Override
		public void keyPressed(KeyEvent e) {
            
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    direction = 'U';
                    System.out.println("you pressed up");
                  
                    break;
                
                case KeyEvent.VK_DOWN:
                    direction ='D';
                    System.out.println("you pressed down");
                
                    break;
                

                default:
                     
                    break;
            }
          
            
        }

    }
}