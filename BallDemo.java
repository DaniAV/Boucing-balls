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
        
        Color col[]= new Color[3];
        col[0] = Color.RED;
        col[1] = Color.BLUE;
        col[2] = Color.GREEN;
        for(int i = 0; i<numeroDeBolas; i++)
        {
            balls[i] = new BouncingBall(xposition.nextInt(60), yposition.nextInt(60), diametro.nextInt(30), col[colores.nextInt(2)], ground, myCanvas);
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            for(int x = 0; x<balls.length; x++)
            {
                myCanvas.wait(50);           // small delay
                balls[x].move();
                if(balls[balls.length - 1].getXPosition() >= 550) {
                    finished = true;
                }
            }
        }

    }
}
