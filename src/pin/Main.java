/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pin;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;

/**
 *
 * @author mcgann
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        oldMain(args);
    }

    public static void oldMain(String[] args) throws Exception {
        int width = 128;
        int height = 32;
        int screen = 1024;

//        File file = new File("/home/mcgann/Downloads/xx/tzone9_2.rom");
//        File file = new File("/home/mcgann/Downloads/xx/ADDAM_L7.ROM");
//        long length = file.length();
//        System.out.println("Size: " + length);

        ArrayList<Byte> data = new ArrayList<Byte>();

        InputStream fis = new BufferedInputStream(Main.class.getResourceAsStream("/ADDAM_L7.ROM"));
        int in = 0;
        while ( (in = fis.read()) >= 0 ) {
            data.add((byte)(in & 1));
            data.add((byte)((in & 2) >> 1));
            data.add((byte)((in & 4) >> 2));
            data.add((byte)((in & 8) >> 3));
            data.add((byte)((in & 16) >> 4));
            data.add((byte)((in & 32) >> 5));
            data.add((byte)((in & 64) >> 6));
            data.add((byte)((in & 128) >> 7));

//            data.add((byte)p4(in));
//            data.add((byte)p3(in));
//            data.add((byte)p2(in));
//            data.add((byte)p1(in));
        }
//        System.out.println("Read: " + read);

        int pos = 0;

        if ( args.length == 1 ) {
            pos = Integer.parseInt(args[0], 16);
        }

        ImageFrame iframe = new ImageFrame(data);
        iframe.setPosition(pos);
  
        new DisplayFrame(iframe).setVisible(true);


//        for ( ; pos < length - screen; pos++ ) {
//            int cpos = pos;
//            int wpos = 0;
//            int hpos = 0;
//            System.out.printf("\nPOS: %x\n\n", pos);
//            int by = 0;
//            cpos = pos;
////            while ( hpos < height ) {
////                int x = b[cpos];
////                printDot(p1(x));
////                printDot(p2(x));
////                printDot(p3(x));
////                printDot(p4(x));
////                wpos += 4;
//////                if ( wpos >= width ) {
////                    wpos = 0;
////                    System.out.println();
//////                    cpos += 32;
////                    hpos++;
////                }
////                cpos++;
////                by++;
////            }
////            System.out.println("\nFLIP\n");
//            for ( cpos = pos; cpos < pos + screen; cpos++ ) {
//                int x = b[cpos];
//                printDot(p3(x));
//                printDot(p4(x));
//                printDot(p1(x));
//                printDot(p2(x));
//
//                wpos += 4;
//                if ( wpos >= width ) {
//                    wpos = 0;
//                    System.out.println();
//                }
//                by++;
//            }
//            System.out.println("By: " + by);
//            Thread.currentThread().sleep(50);
//        }
    }

    public static int p1(int b) {
        return b & 0x03;
    }

    public static int p2(int b) {
        return (b & 0x0c) >> 2;
    }

    public static int p3(int b) {
        return (b & 0x30) >> 4;
    }
    
    public static int p4(int b) { 
        return (b & 0xc0) >> 6;
    }

    public static void printDot(int b) {
        if ( b == 0 ) {
            System.out.print(" ");
        } else if ( b == 1 ) {
            System.out.print("-");
        } else if ( b == 2 ) {
            System.out.print("=");
        } else if ( b == 3 ) {
            System.out.print("#");
        } else {
            System.out.print("?");
        }
    }
}
