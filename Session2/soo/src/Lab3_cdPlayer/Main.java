/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdplayer;

/**
 *
 * @author WONSEOB
 */
public class Main {

    public static void main(String[] args) {
 
        CDplayer.getInstance().addCD(new CD("CD01 :It's my Life", "Bon Jovi"));
        CDplayer.getInstance().addCD(new CD("CD02 :Dancing Queen", "ABBA"));
        System.out.println(CDplayer.getInstance().getCD(0).getTitle());
         System.out.println(CDplayer.getInstance().getCD(1).getTitle());
    }

}
