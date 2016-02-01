/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cdplayer;

import java.util.ArrayList;

/**
 *
 * @author WONSEOB
 */
public class CDplayer {
    
    private static CDplayer ourInstance = new CDplayer();

    private ArrayList<CD> CDs;

    public static CDplayer getInstance() {
        return ourInstance;
    }

    private CDplayer() {
        this.CDs = new ArrayList<>();
    }

    public ArrayList<CD> getCDs() {
        return this.CDs;
    }

    public CD getCD(int pos) {
        return this.CDs.get(pos);
    }

    public int CDCount() {
        return this.CDs.size();
    }

    public void addCD(CD cd) {
        if (!CDs.contains(cd)) {
            this.CDs.add(cd);
        }
    }

}
