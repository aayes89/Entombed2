package control;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;
import myentombed.model.Matriz;
import myentombed.model.Person;

/**
 *
 * @author AyA
 */
public class Logica {

    private Graphics gr;
    private JPanel panel;
    private Matriz m;
    private Person p;
    private boolean seguir;
    private Timer timer;
    private int width;
    private int height;
    private int xsize;
    private int ysize;
    private int scrollDown;

    public Logica(JPanel jp) {
        panel = jp;
        gr = panel.getGraphics();
        m = new Matriz();
        p = new Person();
        seguir = true;
        width = panel.getWidth();
        height = panel.getHeight();
        xsize = (width / 20) ;
        ysize = (height / 20)+10;
        scrollDown = height - ysize;
    }

    public void StartGame() {
        timer = new Timer("paint screen");
        pintarPantalla();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //pintarPixels();
                pintarScroll();
            }
        }, 0, 125);
    }

    private void pintarPantalla() {
        gr.setColor(Color.BLACK);
        gr.fillRect(0, 0, width, height);
    }

    private void pintarScroll() {
        if (scrollDown <= 0) {
            scrollDown = height - ysize;
        }
        char[] pixels = m.crearPatron().toCharArray();
        gr.setColor(Color.WHITE);
        int xaxis = 0;
        for (int i = 0; i < pixels.length; i++) {
            if (pixels[i] == '0') {
                gr.setColor(Color.WHITE);
                gr.fillRect(xaxis, scrollDown, xsize, ysize);
                xaxis += xsize;
            } else {
                gr.setColor(Color.BLACK);
                gr.fillRect(xaxis, scrollDown, xsize, ysize);
                xaxis += xsize;
            }
        }
        scrollDown = scrollDown - ysize;
    }

    private void pintarPixels() {
        char[] pixels = m.crearPatron().toCharArray();

        for (int x = 0; x < pixels.length; x += xsize) {
            if (pixels[x] == '0') {
                gr.setColor(Color.WHITE);
                gr.fillRect(x, scrollDown, xsize, ysize);
            } else {
                gr.setColor(Color.BLACK);
                gr.fillRect(x, scrollDown, xsize, ysize);
            }
        }
        scrollDown -= scrollDown;
    }

}
