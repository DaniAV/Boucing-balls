import java.awt.Color;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private BouncingBall[] balls;
    private Color[] colores;
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        BouncingBall balls[]= new BouncingBall[0];
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numeroDeBolas)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        balls = new BouncingBall[numeroDeBolas]; //Se crea un array para meter tantas bolas
        //como el nº q se indica por parametro

        Random diametro = new Random();
        Random colores = new Random();
        Random xposition = new Random();
        Random yposition = new Random();

        Random r = new Random();
        Random g = new Random();
        Random v = new Random();
        

        for(int i = 0; i<numeroDeBolas; i++)
        {
            Color colo = new Color(r.nextInt(255), g.nextInt(255), v.nextInt(255));
            balls[i] = new BouncingBall(xposition.nextInt(60), yposition.nextInt(60), (diametro.nextInt(30)+5), colo, ground, myCanvas);
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(int x = 0; x<balls.length; x++)
            {

                balls[x].move();
                if(balls[balls.length - 1].getXPosition() >= 550) {
                    finished = true;
                }
            }
        }

    }
}
