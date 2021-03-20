package Oyun;

import javax.swing.*;
import java.awt.*;

import static java.lang.Integer.parseInt;

public class PlayerC extends Player{
    int[]hedef;
    JLabel resim = new JLabel(new ImageIcon("C:\\Users\\Pikachu\\IdeaProjects\\Oyuncu\\src\\Oyun\\hunter5.png"));
    int ulasAltin=1;
    public PlayerC(int altin,int hamleMaliyet,int hedefMaliyet,int x,int y){
        super(altin,hamleMaliyet,hedefMaliyet,x,y);

        System.out.println("Degerleriniz-B");

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


    }

    @Override
    int[] hedefBelirle(Coin coin,JPanel[][]panels) {
        double dist = 0;
        int [] yakinKoor=new int[3];
        double yakin;

        int altin=0;
        if(ulasAltin!=0){
            yakin=Math.abs(coin.getGizliAltinlar()[0][0] -getX()) +Math.abs(coin.getGizliAltinlar()[0][1] -getY());
            altin=coin.getGizliAltinlar()[0][2];
            for(int j=0; j < ulasAltin ;j++  ){
                for(int i = 0; i<coin.getGizliAltinlar().length; i++){
                    dist=Math.abs(coin.getGizliAltinlar()[i][0] -getX()) +Math.abs(coin.getGizliAltinlar()[i][1] -getY());
                    altin=coin.getGizliAltinlar()[i][2];
                    if(coin.getGizliAltinlar()[i][0]==0 &&coin.getGizliAltinlar()[i][1]==0){
                        System.out.println("0-0 Hatasi");
                    }
                    else if(yakin>=dist){
                        yakin=dist;
                        yakinKoor[0]=coin.getGizliAltinlar()[i][0];
                        yakinKoor[1]=coin.getGizliAltinlar()[i][1];
                        yakinKoor[2]=altin;
                    }
                }
                while(getX()==yakinKoor[0] && getY()==yakinKoor[1]){
                    if(getX()!=hedef[0]){
                        hedefeIlerleX(panels,hedef,resim,coin.getGizliAltinlar(),coin);
                    }
                    else if(getY()!=hedef[1]){
                        hedefeIlerleY(panels,hedef,resim,coin.getGizliAltinlar(),coin);
                    }
                }
                if(getX()!=19 && getY()!=19){
                    panels[getX()][getY()].setBackground(Color.ORANGE);
                    coin.setAltinSayisi(coin.getAltinSayisi()+1);
                    ulasAltin=ulasAltin-1;
                }

            }
        }
        else{
            altin=coin.getAltinlar()[0][2];
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
