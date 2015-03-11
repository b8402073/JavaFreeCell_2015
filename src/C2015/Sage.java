/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C2015;

import java.util.Collections;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author easterday
 */
public class Sage {
    public final int MaxHeight=150;
    public final int High_Height=125;
    public final int Selection=100;
    public WorldExt root;    
    public static WorldExt Result;
    public int Total_Work=0;
    public int Cur_Pos=0;
    public boolean work_complete=false;  
    public Vector<WorldExt> Stone;
    public Sage(WorldExt inn) {
        root=inn;
        root.History.clear();
    }
    //Run1是應用在單執行緒的解題;步驟依序是
    // WorldExt.Instance.Clear() ==> MakeStone ==> RightFS
    public boolean Run1(boolean prt_debug) {
        WorldExt.InstanceU.clear();
        MakeStone(root);
        if (work_complete)
            return true;
        int sz= Stone.size();
        for (int i=0; i<sz; i++) {
            Cur_Pos=i;
            if (prt_debug) {
                String str=""+Cur_Pos+"/"+ sz+"\t\t\t"+ new Date().toString();
                System.out.println(str);
            }
            Vector<WorldExt> LS= new Vector<WorldExt>();
            LS.add(Stone.get(i));
            if (RightFS(LS))
                return true;
        }
        work_complete=true;        
        return false;
    }
    
    //Run2是應用在GUI的解題,所以有一些Sleep的指令幫助GUI更新;
    //請先執行 WorldExt.Uni.Clear(), MakeStone
    //然後才跑Run2
    public boolean Run2(boolean prt_debug) {
         return false;  //暫時不作
    }
    public void MakeStone(WorldExt inn) {
        Vector<WorldExt> C1= inn.makeChild(0,High_Height,null);               
        Vector<WorldExt> C2= new Vector<WorldExt>();
        for (WorldExt elem: C1) {
            if (elem.isComplete()) {
                Result=elem;
                work_complete=true;
                return;
            }else if (elem.isDead()) {
                continue;
            }else {
                C2.addAll(elem.makeChild(0, High_Height,null));
            }                
        }
        Stone=new Vector<WorldExt>();
        for (WorldExt elem: C2) {
            if (elem.isComplete()) {
                Result=elem;
                work_complete=true;
                return;
            }else if (elem.isDead()) {
                continue;
            }else {
                Stone.addAll(elem.makeChild(0, High_Height,null));
            }
        }
        Collections.sort(Stone,WorldExt.CM);
    }
    public boolean RightFS(Vector<WorldExt> inn) {
        for (int x=0;x<=MaxHeight; x++) {
            if (inn!=null && inn.size()>0) {
                if (inn.get(0).isComplete()) {
                    Result=inn.get(0);
                    work_complete=true;
                    return true;
                }else if (work_complete) {
                    return true;
                }
                Vector<WorldExt> Nex_Layer=new Vector<WorldExt>();
                for (int k=0; k< Math.min(Selection, inn.size()); k++) {
                    inn.get(k).makeChild(x, High_Height,null);
                    Nex_Layer.addAll(inn.get(k).Child);                     
                }
                Collections.sort(Nex_Layer,WorldExt.CM);
                if (Nex_Layer.size()>0) {
                    inn=Nex_Layer;
                }else
                    return false;
            }else
                return false;
        }
        return false;
    }
}

