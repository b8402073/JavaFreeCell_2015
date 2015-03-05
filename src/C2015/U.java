/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C2015;

import java.util.Vector;


/**
 * The Class U is designed to record the "World Obects" that created 
 * when we run WorldExt.makeChild();
 * We record these Objects to save some times
 * @author easterday
 */
public class U<T extends World>  {
    public static Vector[][][] Data=new Vector[22][22][5];
    public static boolean ready=false;
    public U() {
        if (!ready) {
            for (int i=0; i<22; i++) {
                for (int j=0; j<=i; j++) {
                    for (int k=0; k<5; k++) {
                        Data[i][j][k]=new Vector<T>();
                    }
                }
            }
        }
        ready=true;
    }
    private static <T extends World> boolean SubExist(Vector<T>  V ,T that) {
       if (V.size()>0) {
           for(T tmp : V) {
               if (tmp.ValueEquals(that)) {
                   return true;
               }
           }
       }
       return false;
    }
    public static int WorldNum() {
        int ret=0;
        for (int i=0; i<22; i++) {
            for (int j=0; j<22; j++) {
                for (int k=0; k<5; k++) {
                    ret += Data[i][j][k].size();
                }
            }
        }
        return ret;
    }
    public static int WorldMax() {
        int ret=0;
        for (int i=0; i<22; i++) {
            for (int j=0; j<22; j++) {
                for (int k=0; k<5; k++) {
                    int that=Data[i][j][k].size();
                    if (that>ret) {
                        ret=that;
                    }
                }
            }
        }
        return ret;
    }
    public static void clear() {
        for (int i=0; i<22; i++) {
            for (int j=0; j<22; j++) {
                for (int k=0; k<5; k++) {
                    Data[i][j][k].clear();
                }
            }
        }
    }
    public static <T extends World> boolean  Add(T inn) {
        int A=inn.P.MaxOf_NowMaxPos();
        int B=inn.P.SecondOf_NowMaxPos();
        int C=inn.P.GetBuffer().size();
        if (SubExist(Data[A][B][C],inn))
            return false;
        else {
            Data[A][B][C].add(inn);
            return true;
        }
    }
    public static <T extends World> boolean Exist(T inn) {
        int A=inn.P.MaxOf_NowMaxPos();
        int B=inn.P.SecondOf_NowMaxPos();
        int C=inn.P.GetBuffer().size(); 
        return SubExist(Data[A][B][C],inn);
    }
    public static <T extends World> boolean Remove(T inn) {
        int A=inn.P.MaxOf_NowMaxPos();
        int B=inn.P.SecondOf_NowMaxPos();
        int C=inn.P.GetBuffer().size();        
        for( T elem : (Vector<T>) Data[A][B][C]) {
            if (inn.ValueEquals(elem)) {
                Data[A][B][C].remove(elem);
                return true;
            }
        }
        return false;
    }
    public static <T extends World> T  EE(T inn) {   //'輸入一個局,如果成功找到已經儲存過的局，把那個局傳回來，如果找不到傳回Null
        int A=inn.P.MaxOf_NowMaxPos();
        int B=inn.P.SecondOf_NowMaxPos();
        int C=inn.P.GetBuffer().size();  
        for( T elem : (Vector<T>) Data[A][B][C]) {
            if (inn.ValueEquals(elem)) {
                return elem;
            }
        }
        return null;
    }
    public static <T extends World> int Locate(T inn) {
        int A=inn.P.MaxOf_NowMaxPos();
        int B=inn.P.SecondOf_NowMaxPos();
        int C=inn.P.GetBuffer().size();        
        Vector<T> V=Data[A][B][C];
        int D=V.size();
        for (int i=0; i<D; i++) {
            if (inn.ValueEquals(V.get(i))) {
                return i;
            }
        }
        return -1;
    }
    public static <T> Vector<T> GetList(int i,int j,int k) {
        return Data[i][j][k];
    }
    public static void Destroy() {
        for (int i=0; i<22; i++) {
            for (int j=0; j<22; j++) {
                for (int k=0; k<5; k++) {
                    Data[i][j][k].clear();
                    Data[i][j][k]=null;
                }
            }
        }
        Data=null;
        ready=false;
        System.gc();
    }
    
            
    
}
