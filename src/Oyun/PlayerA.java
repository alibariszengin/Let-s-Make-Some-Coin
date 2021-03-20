package Oyun;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class PlayerA extends Player {
    int[]hedef;
    JLabel resim = new JLabel(new ImageIcon("C:\\Users\\Pikachu\\IdeaProjects\\Oyuncu\\src\\Oyun\\hunter5.png"));




    public PlayerA(int altin,int hamleMaliyet,int hedefMaliyet){
        super(altin,hamleMaliyet,hedefMaliyet,0,0);



        System.out.println("Degerleriniz-A");

    }

    public int[] getHedef() {
        return hedef;
    }

    public void setHedef(int[] hedef) {
        this.hedef = hedef;
    }

    void hedefeGit(JPanel panels[][], int altinSayisi, int altinlar[][], int gizliAltinlar[][], Coin coin,int row,int column){




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

        //System.out.println(getX()+" "+getY());
    }

    @Override
    int[] hedefBelirle(Coin coin,JPanel[][] panels) {
        double dist = 0;
        int [] yakinKoor=new int[3];
        double yakin;
        int altinMiktari=coin.getAltinlar()[0][2];
        yakin=Math.abs(coin.getAltinlar()[0][0] -getX()) +Math.abs(coin.getAltinlar()[0][1] -getY());


        for(int i = 0; i<coin.getAltinSayisi(); i++){
            dist=Math.abs(coin.getAltinlar()[i][0] -getX()) +Math.abs(coin.getAltinlar()[i][1] -getY());
            altinMiktari=coin.getAltinlar()[i][2];
            if(coin.getAltinlar()[i][0]==0 &&coin.getAltinlar()[i][1]==0){
                System.out.println("0-0 Hatasi");
            }
            else if(yakin>=dist){
                yakin=dist;
                yakinKoor[0]=coin.getAltinlar()[i][0];
                yakinKoor[1]=coin.getAltinlar()[i][1];
                yakinKoor[2]=altinMiktari;
            }
        }
        return yakinKoor;
    }


}
