package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class NextRoundPanel extends JPanel implements MouseListener{
    private GUIManager guiManager;
    private JLabel lbNextRound;
    public NextRoundPanel(GUIManager guiManager){
        this.guiManager = guiManager;
        setLayout(null);
        addComp();
    }

    public void addComp(){
        int x = GUIManager.W_FRAME / 2 - 182 / 2;
        int y = 400;

        lbNextRound = setLabel(x,y,"Images/next.png");
        add(lbNextRound);
        lbNextRound.addMouseListener(this);
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
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Image image = new ImageIcon("Images/3_Star.png").getImage();
        g2d.drawImage(image, - 24, 0, GUIManager.W_FRAME + 24, GUIManager.H_FRAME, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource().equals(lbNextRound)){
            guiManager.getBoomPanel().setIS_PAUSE(false);
            guiManager.showNewGame();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e){}

    @Override
    public void mouseExited(MouseEvent e){}
}
