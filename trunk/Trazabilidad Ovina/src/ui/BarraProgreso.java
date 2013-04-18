/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;
import javax.swing.JProgressBar;
import ui.Marco;
import javax.swing.JFrame;
/**
 *
 * @author edgardo.rodriguez
 */
public class BarraProgreso extends Thread{


     JProgressBar progreso;
     JFrame ini;

    public BarraProgreso(JProgressBar progreso1,Inicio i)
    {
        super();
        this.progreso=progreso1;
        this.ini= i;
    }

    public void run()
{
    for(int i=1;i<=100;i++)
    {
        progreso.setValue(i);
        pausa(100);
    }
    new Marco().setVisible(true);
    ini.dispose();
}

    public void pausa(int mlSeg)
{
    try
    {
        // pausa para el splash
        Thread.sleep(mlSeg);
    }catch(Exception e){}
}


    

}
