/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trazabilidadovina.Splash;
import javax.swing.JProgressBar;
import trazabilidadovinaPantallas.Principal;
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
    new Principal().setVisible(true);
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
