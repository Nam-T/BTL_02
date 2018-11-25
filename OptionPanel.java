package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OptionPanel extends JPanel implements MouseListener {
    private GUIManager guiManager;
    private JLabel lbBack;
    public OptionPanel(GUIManager guiManager){
        this.guiManager = guiManager;
        setLayout(null);
        addComp();
    }

    public void addComp(){
        int x = GUIManager.W_FRAME / 2 - 182 / 2;
        int y = 420;

        lbBack = setLabel(x,y,"Images/button_back.png");
        add(lbBack);
        lbBack.addMouseListener(this);
    }

    private JLabel setLabel(int x,int y,String url){
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
        Image image = new ImageIcon("image_game/Option_image.png").getImage();
        g2d.drawImage(image, - 24, 0, GUIManager.W_FRAME + 24, GUIManager.H_FRAME, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource().equals(lbBack)){
            if(BoomPanel.HIT_PAUSE == false)
                guiManager.showMenu();
            //else
            //guiManager.showSubMenu();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e){
        if(e.getSource().equals(lbBack)){
            lbBack.setIcon(new ImageIcon("Images/button_back2.png"));
        }
    }

    @Override
    public void mouseExited(MouseEvent e){
        if(e.getSource().equals(lbBack)){
            lbBack.setIcon(new ImageIcon("Images/button_back.png"));
        }
    }
}
