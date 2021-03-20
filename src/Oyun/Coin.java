package Oyun;


import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class Coin {

    private double altinOrani=20;
    private int gizliAltinOrani=10;
    private int totalAltinSayisi;
    private int gizliAltin;
    private int gizliAltinlar[][];
    private int altinSayisi;
    private int[][] altinlar;



    public Coin(int max){
        altinOrani=20;
        gizliAltinOrani=10;
        totalAltinSayisi=(int)((max)*(altinOrani/100));
        gizliAltin=totalAltinSayisi/gizliAltinOrani;
        gizliAltinlar=new int[gizliAltin][3];
        altinSayisi=(int)((max)*(altinOrani/100)-(gizliAltin));
        altinlar=new int[(int)(max*(altinOrani/100))][3];

    }
    public void randomAltin(JPanel[][] panels,int row,int column) {
        Random random = new Random();

        int altinPositionX,altinPositionY;


        for(int i = 0 ; i < totalAltinSayisi;i++){

            do{
                altinPositionX=random.nextInt(row);
                altinPositionY=random.nextInt(column);
            }while(panels[altinPositionX][altinPositionY].getBackground()== Color.ORANGE);

            if(altinPositionX == 0 && altinPositionY == 0 ){
                i--;
            }
            else if(altinPositionX == 0 && altinPositionY == column-1){
                i--;
            }
            else if(altinPositionX == row-1 && altinPositionY == 0){
                i--;
            }
            else if(altinPositionX == row -1 && altinPositionY == column-1){
                i--;
            }
            else{
                if(i<8){
                    gizliAltinlar[i][0]=altinPositionX;
                    gizliAltinlar[i][1]=altinPositionY;
                    gizliAltinlar[i][2]=random.nextInt(4)*5+5;
                    panels[altinPositionX][altinPositionY].setBackground(Color.BLACK);
                }
                else{
                    altinlar[i-8][0]=altinPositionX;
                    altinlar[i-8][1]=altinPositionY;
                    JLabel labelGold=new JLabel("5");
                    int deger=random.nextInt(4)*5+5;
                    labelGold.setText((Integer.toString(deger)));
                    altinlar[i-8][2]=deger;
                    panels[altinPositionX][altinPositionY].add(labelGold);
                    panels[altinPositionX][altinPositionY].setBackground(Color.ORANGE);
                }

            }
        }
    }

    public int[][] getGizliAltinlar() {
        return gizliAltinlar;
    }

    public void setGizliAltinlar(int[][] gizliAltinlar) {
        this.gizliAltinlar = gizliAltinlar;
    }

    public int[][] altinKontrol(JPanel [][]panels, int row, int column){
        int altin=0;
        System.out.println(altinSayisi);
        int[][] altinlar1=new int[altinSayisi][3];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(panels[i][j].getBackground()==Color.ORANGE){
                    altinlar1[altin][0]=i;
                    altinlar1[altin][1]=j;
                    altin++;
                }

            }

        }

        return altinlar1;
    }
    public int[][] getAltinlar() {
        return altinlar;
    }

    public void setAltinlar(int[][] altinlar) {
        this.altinlar = altinlar;
    }

    public int getAltinSayisi() {
        return altinSayisi;
    }

    public void setAltinSayisi(int altinSayisi) {
        this.altinSayisi = altinSayisi;
    }
}
