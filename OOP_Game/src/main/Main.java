package main;

import javax.swing.SwingUtilities;
import resources.Loader;

public class Main {
    public static void main(String[] argv){
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run(){
                Loader.load();
                Engine.init();
                Engine.start();
            }
        
    });
}
}

