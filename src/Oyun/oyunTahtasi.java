package Oyun;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class oyunTahtasi extends JFrame {

    private int row=20;
    private int column=20;

    private int max = row*column;

    private JPanel[][] panels = new JPanel[row][column];

    private Color renk1 = Color.getColor("Red",100);
    private Color renk2 = Color.getColor("Blue",1000);
    private Color temp;
    private JPanel kareler = new JPanel();
    private JLabel labels = new JLabel("");
    private JFrame framePuan = new JFrame("Puan");
    private int azalan=0;
    private JFrame frame = new JFrame("Altin Oyun");
    private int[][]player1Hedef;
    private int[][]player2Hedef;
    private int[][]player3Hedef;
    public oyunTahtasi () {
        super("Deneme");

        Coin coin=new Coin(max);

        PlayerA player1=new PlayerA(200,5,5);
        PlayerB player2=new PlayerB(200,5,10,column-1);
        PlayerC player3=new PlayerC(200,5,10,row-1,column-1);
        PlayerD player4=new PlayerD(200,5,10,row-1);

        JLabel resim = new JLabel(new ImageIcon("C:\\Users\\Pikachu\\IdeaProjects\\Oyuncu\\src\\Oyun\\hunter5.png"));

        //JLabel icon = new JLabel(Oyun/hunter1.png);

        framePuan.setLayout(new GridLayout(1, 4));

        JPanel oyuncular1 = new JPanel();

        JLabel  oyuncularLabel1= new JLabel(" ");
        JPanel[] oyuncuPanel=new JPanel[4];

        framePuan.add(oyuncular1.add(oyuncularLabel1));
        for(int i =0; i<4;i++){
            JLabel  oyuncularLabel= new JLabel();
            JPanel oyuncular = new JPanel();
            oyuncularLabel.setText("Player "+(i+1));
            oyuncular.add(oyuncularLabel);
            oyuncular.setBorder(BorderFactory.createLineBorder(Color.black));
            oyuncuPanel[i]=oyuncular;

            framePuan.add(oyuncuPanel[i]);
        }

        tahtaBastir();
        coin.randomAltin(panels,row,column);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(500,500);
        frame.setVisible(true);
        framePuan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePuan.setLocationRelativeTo(null);
        framePuan.setSize(200,300);
        framePuan.setVisible(false);


        player1.setHedef(player1.hedefBelirle(coin,panels));
        player1.setAltin(player1.getAltin()-player1.getHedefMaliyet());

        player2.setHedef(player2.hedefBelirle(coin,panels));
        player2.setAltin(player2.getAltin()-player2.getHedefMaliyet());

        player3.setHedef(player3.hedefBelirle(coin,panels));
        player3.setAltin(player3.getAltin()-player3.getHedefMaliyet());

        player4.setPlayer1(player1);
        player4.setPlayer2(player2);
        player4.setPlayer3(player3);


        player4.setHedef(player4.hedefBelirle(coin,panels));
        player4.setAltin(player4.getAltin()-player4.getHedefMaliyet());
        while(coin.getAltinSayisi()!=0){
            if(player1.getAltin()!=0){
                int[][] altinlar2=coin.altinKontrol(panels,row,column);
                player1.hedefeGit(panels,coin.getAltinSayisi(),altinlar2,coin.getGizliAltinlar(),coin,row,column);
            }
            if(player2.getAltin()!=0){
                int[][]altinlar3=coin.altinKontrol(panels,row,column);
                player2.hedefeGit(panels,coin.getAltinSayisi(),altinlar3,coin.getGizliAltinlar(),coin,row,column);
            }
            if(player3.getAltin()!=0){

                int[][]altinlar4=coin.altinKontrol(panels,row,column);
                player3.hedefeGit(panels,coin.getAltinSayisi(),altinlar4,coin.getGizliAltinlar(),coin,row,column);
            }
            if(player4.getAltin()!=0){

                int[][]altinlar5=coin.altinKontrol(panels,row,column);
                player4.hedefeGit(panels,coin.getAltinSayisi(),altinlar5,coin.getGizliAltinlar(),coin,row,column,player1,player2,player3);
            }


        }

    }
    public void tahtaBastir(){

        frame.setLayout(new GridLayout(row, column));

        for(int i = 0;i < row;i++){
            for(int j=0;j<column;j++){
                JPanel kareler1 = new JPanel();
                JLabel labels1 = new JLabel();

                kareler1.add(labels1);
                kareler1.setBorder(BorderFactory.createLineBorder(Color.black));

                panels[i][j] = kareler1;

                if((i % 20) == 0){
                    temp = renk1;
                    renk1 = renk2;
                    renk2 = temp;
                }
                if(i % 2 == 0){
                    panels[i][j].setBackground(renk1);
                }
                else{
                    panels[i][j].setBackground(renk2);
                }

                if(i==0 && j== 0 || i == 0 && j==column-1){
                    JLabel resim = new JLabel(new ImageIcon("C:\\Users\\Pikachu\\IdeaProjects\\Oyuncu\\src\\Oyun\\hunter5.png"));

                    panels[i][j].add(resim);
                    panels[i][j].remove(labels1);
                }
                else if(i==row-1 && j== column-1 || i == row-1 && j==0){
                    JLabel resim = new JLabel(new ImageIcon("C:\\Users\\Pikachu\\IdeaProjects\\Oyuncu\\src\\Oyun\\hunter5.png"));
                    panels[i][j].remove(labels1);
                    panels[i][j].add(resim);

                }

                frame.add(panels[i][j]);

            }

        }

    }


}
