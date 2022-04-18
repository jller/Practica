package javaapplication2;
import java.util.Scanner;
import java.io.*;

class clase_B{
    private String nombre, num_tef, dni; int edad;
    
    public int scan(){
        Scanner data = new Scanner(System.in);
        return data.nextInt();
    }    
    public String gets(){
        Scanner data = new Scanner(System.in);
        return data.nextLine();
    }
    public void leer(){
        System.out.println("Ingrese su DNI: "); dni=gets();
        System.out.println("Ingrese su nombre: "); nombre=gets();
        System.out.println("Ingrese su edad: "); edad=scan();
        System.out.println("Ingrese su telefono: "); num_tef=gets();
    }
    public void mostrar(){
        System.out.println(dni+" | "+nombre+" | "+edad+" | "+num_tef);
    }
    public void registrar(){
        try{
            File file = new File("test.txt");
            FileOutputStream o = new FileOutputStream(file, true);
            String str=dni+" | "+nombre+" | "+edad+" | "+num_tef+"\n";
            byte[] a=str.getBytes();
            o.write(a);
            o.close();
	}catch (IOException e){
            System.out.println(e);
        }       
    } 
}
class clase_D extends clase_B{
}
public class JavaApplication2 {
    public static void ver(){
        File file = new File("test.txt");
        int n = -1;
        byte[] b = new byte[1000];
        try {
            FileInputStream f = new FileInputStream(file);
            while ((n = f.read(b,0,50))!=-1) {
                String str = new String(b,0,n,"utf-8");
                System.out.println(str);
            }
            f.close();
        } catch (IOException e) {
            System.out.println("El archivo no existe");
        }
    }
    public static void start() {
        clase_D[] dp=new clase_D[99];
        for(int i=0;; i++){
            dp[i]=new clase_D();
            dp[i].leer();
            dp[i].mostrar();
            dp[i].registrar();
            System.out.println("\nSalir?(s/n): "); String r=dp[i].gets();
            if(r.equals("s")) break;
        }
        ver();
    }
    public static void main(String[] args){
        start();
    }
}
