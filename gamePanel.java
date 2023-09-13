import java.awt.*;
import javax.swing.*;

import java.awt.event.*;


public class gamePanel extends JPanel implements ActionListener {
    
    final int WIDTH = 800;
    final int HEIGHT =400;
    final int UNITS_SIZE =1;
    final int PLAYER_UNIT =(WIDTH*HEIGHT)-UNITS_SIZE;
    JPanel panel = new JPanel();
    JLabel score = new JLabel();
    ImageIcon ball = new ImageIcon("Star.png");
    Action upAction;
    Action downAction;
    Action player2Action;
    boolean keyPressed = false;
    Timer timer;
    Timer player2;
    int xVelocity = -3;
    int yVelocity = 2;
    int x=400;
    int y =200;
    int red_score;
    int blue_score;
    int moveVelocity=7;
    int[] x1 ={20,20,20,20,20};
    int[] y1 ={50,60,70,80,90};
    int[] x2 ={750,750,750,750,750};
    int[] y2 ={50,60,70,80,90};
    int bodyParts=5;    
    gamePanel(){
        
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(new Color(152,210,94));
        upAction = new UpAction();
        downAction = new DownAction();
        this.getInputMap().put(KeyStroke.getKeyStroke("UP"),"upAction");
        this.getActionMap().put("upAction",upAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("DOWN"),"downAction");
        this.getActionMap().put("downAction",downAction);
        score.setBounds(200, 100, 50, 15);
        score.setBackground(Color.DARK_GRAY);
        this.add(score);
        timer = new Timer(10,this);
        timer.start();
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.setColor(Color.white);
        g2D.setStroke(new BasicStroke(5));
        g2D.drawLine(WIDTH/2, 0, WIDTH/2, HEIGHT);


        g2D.drawImage(ball.getImage(), x, y, this);
        g2D.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
        g2D.setColor(Color.BLUE);
        g2D.drawString(blue_score+"", 375, 20);
        g2D.setColor(Color.red);
        g2D.drawString(red_score+"", 415, 20);
        
        
        for (int i =0;i<bodyParts;i++){
            // g2D.setColor(Color.GREEN);
            // g2D.drawLine(x1[0]+10,y1[0]-5,x1[4]+10,y1[4]+25);
            // g2D.drawLine(x2[0],y2[0]-5,x2[4],y2[4]+25);
            g2D.setColor(Color.blue);
            g2D.drawRect((int)x1[i],(int) y1[i], 10, 20);
            g2D.fillRect((int)x1[i],(int) y1[i], 10, 20);
            g2D.setColor(Color.red);
            g2D.drawRect((int)x2[i],(int) y2[i], 10, 20);
            g2D.fillRect((int)x2[i],(int) y2[i], 10, 20);

            }
        }

    void Palyer2Move() {
        // System.out.println("Hi i'm player 2");    
        if (y2[0]>y-75){
        for (int i = bodyParts-1; i >= 0; i--){ 
            y2[i]=y2[i]-2;
            repaint();}
        }
        
        if (y2[4]<y+75){
        for (int i = bodyParts-1; i >= 0; i--) {
            y2[i]=y2[i]+2;
            repaint();}
        }
    }
        
// x2[0],y2[0]-5,x2[4],y2[4]+25
    void paddle(){
        if (x>=WIDTH-ball.getIconWidth()||x<0 || x==34&&y>=y1[0]-50&&y<=y1[0]+50){
        xVelocity=xVelocity*-1;
        }

         if (x>=WIDTH-ball.getIconWidth()||x>800 || x>=702&y>=y2[0]-50&y<=y2[0]+50){
        xVelocity=xVelocity*-1;
        }
        repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {


        if (y>=HEIGHT-ball.getIconHeight() || y<0){
            yVelocity=yVelocity*-1;   
        }

        x=x+xVelocity;
        y=y+yVelocity;
        checkColiision();
        Palyer2Move();
        paddle();
        repaint();
    }
        
    void checkColiision(){
        if (x<=-1){
            red_score++;
            // System.out.println("Goal for red !" + y1[0]);
            y=200;
            x=400;
        }
        
        if (x>=750){
            blue_score++;
            // System.out.println("Goal for blue ! ");
            y=200;
            x=400;
        }
    }


public class UpAction extends AbstractAction{

    @Override
    public void actionPerformed(ActionEvent e) {
        if (y1[0] >=6){
        for (int i = bodyParts-1; i >= 0; i--){ 
                y1[i]=y1[i]-moveVelocity;
                repaint();}
        // System.out.println("going up! " + y1[0]);
        }

    }
}

public class DownAction extends AbstractAction{

    @Override
    public void actionPerformed(ActionEvent e) {
       if (y1[4] <=372)
        for (int i = bodyParts-1; i >= 0; i--) {
                y1[i]=y1[i]+moveVelocity;
                repaint();}
        // System.out.println("going Down! "+ y1[4]);  
                 
        
    }
}

}