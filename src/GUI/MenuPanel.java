package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuPanel extends JPanel implements MouseListener{
    private GUIManager guiManager;
    private JLabel lbPlay;
    private JLabel lbOption;
    private JLabel lbHighScore;
    private JLabel lbExit;
    public MenuPanel(GUIManager guiManager) {
        this.guiManager = guiManager;
        setLayout(null);
        addComp();
    }

    private void addComp() {
        int x = GUIManager.W_FRAME / 2 - 182 / 2;
        int y = 200;

        //image/MenuGame/Play2.png
        lbPlay = setLabel(x, y, "Images/button_play.png");
        //lbPlay = setLabel(x, y, "image_game/MenuGame/Play2.png");
        add(lbPlay);
        lbPlay.addMouseListener(this);
        y += 70;

        lbOption = setLabel(x, y, "Images/button_help.png");
        add(lbOption);
        lbOption.addMouseListener(this);
        y += 70;

        lbHighScore = setLabel(x, y, "Images/button_high-score.png");
        add(lbHighScore);
        lbHighScore.addMouseListener(this);
        y += 70;

        lbExit = setLabel(x, y, "Images/button_exit.png");
        add(lbExit);
        lbExit.addMouseListener(this);
    }

    private JLabel setLabel(int x, int y, String url){
        JLabel jLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(url);
        jLabel.setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());
        jLabel.setLocation(x, y);
        jLabel.setIcon(imageIcon);
        return jLabel;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Image image = new ImageIcon("Images/back_ground_menu.png").getImage();
        g2d.drawImage(image, - 24, 0, GUIManager.W_FRAME + 24, GUIManager.H_FRAME, null);
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource().equals(lbPlay)){
            guiManager.getBoomPanel().setIS_PAUSE(false);
            guiManager.showNewGame();
        }
        else if(e.getSource().equals(lbOption)){
            guiManager.showOption();
        }
        else if(e.getSource().equals(lbHighScore)){
            guiManager.showHighScore();
        }
        else if(e.getSource().equals(lbExit)){
            guiManager.exit();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource().equals(lbPlay)){
            lbPlay.setIcon(new ImageIcon("Images/button_play2.png"));
        }
        else if(e.getSource().equals(lbOption)){
            lbOption.setIcon(new ImageIcon("Images/button_help2.png"));
        }
        else if(e.getSource().equals(lbHighScore)){
            lbHighScore.setIcon(new ImageIcon("Images/button_high-score2.png"));
        }
        else if(e.getSource().equals(lbExit)){
            lbExit.setIcon(new ImageIcon("Images/button_exit2.png"));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource().equals(lbPlay)){
            lbPlay.setIcon(new ImageIcon("Images/button_play.png"));
            //lbPlay.setIcon(new ImageIcon("image/MenuGame/Play2.png"));
        }
        else if(e.getSource().equals(lbOption)){
            lbOption.setIcon(new ImageIcon("Images/button_help.png"));
        }
        else if(e.getSource().equals(lbHighScore)){
            lbHighScore.setIcon(new ImageIcon("Images/button_high-score.png"));
        }
        else if(e.getSource().equals(lbExit)){
            lbExit.setIcon(new ImageIcon("Images/button_exit.png"));
        }
    }
}