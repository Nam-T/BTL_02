package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import FrameWork.HighScore;

public class HighScorePanel extends JPanel implements MouseListener {
    private ArrayList<HighScore> highScores;
    private GUIManager guiManager;
    private JLabel lb_back;
    public HighScorePanel(GUIManager guiManager) {
        this.guiManager = guiManager;
        setLayout(null);
        addComp();
        initHighScore("FileTxt/HighScore.dat");
    }

    private void addComp() {
        int x = GUIManager.W_FRAME / 2 - 182 / 2;
        int y = 520;
        lb_back = setLabel(x, y, "Images/button_back.png");
        lb_back.addMouseListener(this);
        add(lb_back);
    }

    private JLabel setLabel(int x, int y, String url) {
        JLabel jLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(url);
        jLabel.setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());
        jLabel.setIcon(imageIcon);
        jLabel.setLocation(x, y);
        return jLabel;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        //Draw background;
        Image image = new ImageIcon("Images/Final_Highscore.jpg").getImage();
        g2d.drawImage(image, 0, - 35 , GUIManager.W_FRAME, GUIManager.H_FRAME + 35, null);

        //Draw HighScore
        int y = 120;
        int x = 280;
        for(int i = 0; i < highScores.size(); i++){
            g2d.setColor(Color.PINK);
            g2d.setFont(new Font("Arial", Font.BOLD, 18));
            g2d.drawString(Integer.toString(i + 1), x , y);
            g2d.drawString(highScores.get(i).getName(), x + 50, y);
            g2d.drawString(Integer.toString(highScores.get(i).getScore()), x + 300, y);
            y += 50;
            //System.out.println(highScores.get(i).getName());
        }
    }

    public void initHighScore(String highScorePath){
        highScores = new ArrayList<>();
        try{
            String line = "";
            /*FileReader fileReader = new FileReader(highScorePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null){
                String name;
                int score;
                String[] arr = line.split("/");
                name = arr[0];
                score = Integer.parseInt(arr[1]);
                //score = 1;
                HighScore highScore = new HighScore(name, score);
                highScores.add(highScore);
            }*/
            Scanner read = new Scanner(new FileInputStream(highScorePath),"UTF-8");
            while (read.hasNextLine()){
                line = read.nextLine();
                if(!line.contains("#")){
                String name;
                int score;
                String[] arr = line.split(":");
                name = arr[0];
                score = Integer.parseInt(arr[1]);
                //score = 1;
                HighScore highScore = new HighScore(name, score);
                //System.out.println(name+score);
                highScores.add(highScore);}
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource().equals(lb_back)){
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
    public void mouseEntered(MouseEvent e) {
        if(e.getSource().equals(lb_back)){
            lb_back.setIcon(new ImageIcon("Images/button_back2.png"));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource().equals(lb_back)){
            lb_back.setIcon(new ImageIcon("Images/button_back.png"));
        }
    }
}
