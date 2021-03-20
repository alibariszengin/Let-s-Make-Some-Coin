package Oyun;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public abstract class Player {
    private int altin=200;
    private int hamleMaliyet = 0;
    private int hedefMaliyet=0;
    private int hamleSayisi=3;



    private int x;
    private int y;


    File file = new File("player.txt");

    public Player(int altin, int hamleMaliyet, int hedefMaliyet, int x, int y){
        this.altin=altin;
        this.hamleMaliyet=hamleMaliyet;
        this.hedefMaliyet=hedefMaliyet;
        this.hamleSayisi=3;
        this.x=x;
        this.y=y;


    }
    public int getHamleSayisi() {
        return hamleSayisi;
    }

    public void setHamleSayisi(int hamleSayisi) {
        this.hamleSayisi = hamleSayisi;
    }
    void removeComp(JPanel[][] panels, int i, int j ){
        Component[] componentList =panels[i][j].getComponents();
        for(Component c : componentList){

            if(c instanceof JLabel){

                panels[i][j].remove(c);
            }
        }
        panels[i][j].revalidate();
        panels[i][j].repaint();
    }
    public boolean gizliAltin(int x,int y,int[][]gizliAltinlar,JPanel[][] panels){

        for(int i=0;i<gizliAltinlar.length;i++){
            if(gizliAltinlar[i][0]== x && gizliAltinlar[i][1]==y){
                JLabel labelGold=new JLabel();
                labelGold.setText((Integer.toString(gizliAltinlar[i][2])));

                return true;
            }
        }
        return false;
    }

    void hedefeIlerleX(JPanel [][]panels,int [] hedef,JLabel resim,int[][] gizliAltinlar,Coin coin){
        int yonI=0;

        if(getX()>hedef[0]){
            yonI=-1;
        }
        else if(hedef[0]>getX()){
            yonI=1;
        }
        else{
            yonI=0;
        }
        try
        {
            Thread.sleep(700);

        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        removeComp(panels,getX()+(yonI),getY());


        removeComp(panels,getX(),getY());
        panels[getX()][getY()].revalidate();

        panels[getX()][getY()].repaint();
        try
        {

            Thread.sleep(700);


        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        setX(getX()+yonI);



        if(gizliAltin(getX(),getY(),gizliAltinlar,panels)){
            panels[getX()][getY()].setBackground(Color.ORANGE);
            coin.setAltinSayisi(coin.getAltinSayisi()+1);

        }

        panels[getX()][getY()].add(resim);

        panels[getX()][getY()].revalidate();

        panels[getX()][getY()].repaint();

        setAltin(getAltin()-getHamleMaliyet());


    }
    void hedefeIlerleY(JPanel [][]panels,int [] hedef,JLabel resim,int gizliAltinlar[][],Coin coin){
        int yonJ=0;
        if(getY()>hedef[1]){
            yonJ=-1;
        }
        else if(hedef[1]>getY()){
            yonJ=1;
        }
        else{
            yonJ=0;
        }

        try
        {

            Thread.sleep(700);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        removeComp(panels,getX(),getY()+(yonJ));

        removeComp(panels,getX(),getY());

        panels[getX()][getY()].revalidate();

        panels[getX()][getY()].repaint();
        try
        {

            Thread.sleep(700);

        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        setY(getY()+yonJ);



        if(gizliAltin(getX(),getY(),gizliAltinlar,panels)){
            panels[getX()][getY()].setBackground(Color.ORANGE);
            coin.setAltinSayisi(coin.getAltinSayisi()+1);

        }

        panels[getX()][getY()].add(resim);

        panels[getX()][getY()].revalidate();

        panels[getX()][getY()].repaint();

        setAltin(getAltin()-getHamleMaliyet());



    }





    abstract int[] hedefBelirle(Coin coin,JPanel[][] panels);

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getHamleMaliyet() {
        return hamleMaliyet;
    }

    public void setHamleMaliyet(int hamleMaliyet) {
        this.hamleMaliyet = hamleMaliyet;
    }

    public int getHedefMaliyet() {
        return hedefMaliyet;
    }

    public void setHedefMaliyet(int hedefMaliyet) {
        this.hedefMaliyet = hedefMaliyet;
    }

    public int getAltin() {
        return altin;
    }

    public void setAltin(int altin) {
        this.altin = altin;
    }

    public void setX(int x) {
        this.x = x;
    }
}
