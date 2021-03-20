package Oyun;

import Oyun.Coin;

import javax.swing.*;
import java.awt.*;

public class PlayerD extends Player {


    int[]hedef;
    int[][] digerHedefler;
    PlayerA player1;
    PlayerB player2;
    PlayerC player3;
    JLabel resim = new JLabel(new ImageIcon("C:\\Users\\Pikachu\\IdeaProjects\\Oyuncu\\src\\Oyun\\hunter5.png"));
    public PlayerD(int altin,int hamleMaliyet,int hedefMaliyet,int x){
        super(altin,hamleMaliyet,hedefMaliyet,x,0);

        System.out.println("Degerleriniz-D");

    }

    public int[] getHedef() {
        return hedef;
    }

    public int[][] getDigerHedefler() {
        return digerHedefler;
    }

    public void setDigerHedefler(int[][] digerHedefler) {
        this.digerHedefler = digerHedefler;
    }

    public void setHedef(int[] hedef) {
        this.hedef = hedef;
    }

    public PlayerA getPlayer1() {
        return player1;
    }

    public void setPlayer1(PlayerA player1) {
        this.player1 = player1;
    }

    public PlayerB getPlayer2() {
        return player2;
    }

    public void setPlayer2(PlayerB player2) {
        this.player2 = player2;
    }

    public PlayerC getPlayer3() {
        return player3;
    }

    public void setPlayer3(PlayerC player3) {
        this.player3 = player3;
    }

    void hedefeGit(JPanel panels[][], int altinSayisi, int altinlar[][], int gizliAltinlar[][], Coin coin, int row, int column, PlayerA player1
                    , PlayerB player2, PlayerC player3){
        this.player1=player1;
        this.player2=player2;
        this.player3=player3;

        int hedefAltin=hedef[2];


        System.out.println(hedef[0]+" " +hedef[1]);
        for(int i=0;i<getHamleSayisi();i++){
            if(getX()!=hedef[0]){
                hedefeIlerleX(panels,hedef,resim,gizliAltinlar,coin);
            }
            else if(getY()!=hedef[1]){
                hedefeIlerleY(panels,hedef,resim,gizliAltinlar,coin);
            }
            if(getX()==hedef[0] && getY()==hedef[1]){
                panels[hedef[0]][hedef[1]].setBackground(Color.BLUE);

                panels[hedef[0]][hedef[1]].revalidate();

                panels[hedef[0]][hedef[1]].repaint();

                setAltin(getAltin()+hedefAltin);

                coin.setAltinSayisi(coin.getAltinSayisi()-1);
                coin.setAltinlar(coin.altinKontrol(panels,row,column));

                this.hedef=this.hedefBelirle(coin,panels);

                setAltin(getAltin()-getHedefMaliyet());
                hedefAltin=hedef[2];
            }

        }


    }
    @Override
    int[] hedefBelirle(Coin coin,JPanel[][]panels) {
        double dist = 0;
        int [] yakinKoor=new int[3];
        double yakin;
        int fark1=0;
        int fark2=0;
        int altin=coin.getAltinlar()[0][2];
        yakin=(Math.abs((coin.getAltinlar()[0][0]) -getX()) +Math.abs((coin.getAltinlar()[0][1]) -getY()))*5;

        yakin=Math.abs(yakin-(coin.getAltinlar())[0][2]);

        for(int i = 0; i<coin.getAltinSayisi(); i++){

            dist=(Math.abs(coin.getAltinlar()[i][0] -getX()) +Math.abs(coin.getAltinlar()[i][1] -getY()))*5;
            altin=coin.getAltinlar()[i][2];
            dist=Math.abs(dist-coin.getAltinlar()[i][2]);

            if(coin.getAltinlar()[i][0]==0 && coin.getAltinlar()[i][1]==0){
                System.out.println("0-0 Hatasi");
            }
            else if(yakin>=dist){
                if(player1.getHedef()[0]==coin.getAltinlar()[i][0] && player1.getHedef()[1]==coin.getAltinlar()[i][1]){
                    fark1 = (Math.abs(coin.getAltinlar()[i][0] -player1.getX()) +Math.abs(coin.getAltinlar()[i][1] -player1.getY()));
                    fark2=(Math.abs(coin.getAltinlar()[i][0] -getX()) +Math.abs(coin.getAltinlar()[i][1] -getY()));
                    if(fark1>fark2){
                        yakin=dist;
                        yakinKoor[0]=coin.getAltinlar()[i][0];
                        yakinKoor[1]=coin.getAltinlar()[i][1];
                        yakinKoor[2]=altin;
                    }
                }
                else if(player2.getHedef()[0]==coin.getAltinlar()[i][0] && player2.getHedef()[1]==coin.getAltinlar()[i][1]){
                    fark1 = (Math.abs(coin.getAltinlar()[i][0] -player2.getX()) +Math.abs(coin.getAltinlar()[i][1] -player2.getY()));
                    fark2=(Math.abs(coin.getAltinlar()[i][0] -getX()) +Math.abs(coin.getAltinlar()[i][1] -getY()));
                    if(fark1>fark2){
                        yakin=dist;
                        yakinKoor[0]=coin.getAltinlar()[i][0];
                        yakinKoor[1]=coin.getAltinlar()[i][1];
                        yakinKoor[2]=altin;
                    }
                }
                else if(player3.getHedef()[0]==coin.getAltinlar()[i][0] && player3.getHedef()[1]==coin.getAltinlar()[i][1]){
                    fark1 = (Math.abs(coin.getAltinlar()[i][0] -player3.getX()) +Math.abs(coin.getAltinlar()[i][1] -player3.getY()));
                    fark2=(Math.abs(coin.getAltinlar()[i][0] -getX()) +Math.abs(coin.getAltinlar()[i][1] -getY()));
                    if(fark1>fark2){
                        yakin=dist;
                        yakinKoor[0]=coin.getAltinlar()[i][0];
                        yakinKoor[1]=coin.getAltinlar()[i][1];
                        yakinKoor[2]=altin;
                    }
                }
                else{
                    yakin=dist;
                    yakinKoor[0]=coin.getAltinlar()[i][0];
                    yakinKoor[1]=coin.getAltinlar()[i][1];
                    yakinKoor[2]=altin;
                }

            }
        }
        return yakinKoor;
    }

}

