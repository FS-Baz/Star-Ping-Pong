import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class gamePanel extends JPanel implements ActionListener {
    
    final int WIDTH = 800;
    final int HEIGHT =400;
    final int UNITS_SIZE =1;
    final int PLAYER_UNIT =(WIDTH*HEIGHT)-UNITS_SIZE;
    JPanel image = new JPanel();
    ImageIcon Star ;
    Action upAction;
    Action downAction;
    boolean keyPressed = false;
    Timer timer;
    int xVelocity = 3;
    int yVelocity = 2;
    int x=0;
    int y =0;
    int moveVelocity=6;
    int[] x1 ={20,20,20,20,20};
    int[] y1 ={50,60,70,80,90};
    int[] x2 ={750,750,750,750,750};
    int[] y2 ={50,60,70,80,90};
    int bodyParts=5;
    char direction ='N';
    
    gamePanel(){
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.pink);
        upAction = new UpAction();
        downAction = new DownAction();
        this.getInputMap().put(KeyStroke.getKeyStroke("UP"),"upAction");
        this.getActionMap().put("upAction",upAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("DOWN"),"downAction");
        this.getActionMap().put("downAction",downAction);
        Star =  new ImageIcon("Star.png");        
        timer = new Timer(10,this);
        timer.start();
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g ;
        g2D.drawImage(Star.getImage(), x, y, null);
        
        
        for (int i =0;i<bodyParts;i++){
            g2D.setColor(Color.GREEN);
            g2D.drawLine(x1[0]+10,y1[0],x1[4]+10,y1[4]+25);
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
                moveVelocity=moveVelocity+1;
                break;
            case 'D':
                for (int i = bodyParts-1; i >= 0; i--) 
                y1[i]=y1[i]+moveVelocity;
                
                if (moveVelocity <10)
                moveVelocity=moveVelocity+1;
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
        if (x>=WIDTH-Star.getIconWidth()||x<0 || (x<=32&y>=y1[0]&&y<=y1[0]+20)){
            xVelocity=xVelocity*-1;
            
        }
        if (y>=HEIGHT-Star.getIconHeight() || y<0){
            yVelocity=yVelocity*-1;
           
        }
        x=x+xVelocity;
        y=y+yVelocity;
        move();
        checkColiision();
        repaint();
    }   
        
    void checkColiision(){
        if (x<=-1)
            System.out.println("Goal for red !" + y1[0]);
        if (x==750)
            System.out.println("Goal for blue ! ");

    }


public class UpAction extends AbstractAction{

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = bodyParts-1; i >= 0; i--){ 
                y1[i]=y1[i]-moveVelocity;
                repaint();}
        System.out.println("going up!");
        System.out.println(y);
    }
}

public class DownAction extends AbstractAction{

    @Override
    public void actionPerformed(ActionEvent e) {
       for (int i = bodyParts-1; i >= 0; i--) {
                y1[i]=y1[i]+moveVelocity;
                repaint();}
        System.out.println("going Down!");  
        System.out.println(y+ "   " + y1[1]);         
        
    }
    
}














}