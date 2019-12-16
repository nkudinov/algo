package c5;

import java.util.Arrays;

public class q8 {

    static class Screen1{
        int width;
        int height;
        byte[] pixels;


        public Screen1(int width, int height) {
            this.pixels = new byte[(int)Math.ceil(width*height/8.0)];
            this.width  = width;
            this.height = height;
        }

         void print(int r, int c){
            int i = width/8*(r-1) + (c-1)/8;
            int j = (c-1)%8;
            try {
                System.out.print(getBit( pixels[i], j));
            } catch (Exception e){
                System.out.println(" r="+r+" c="+c+" i=="+i);
            }
        }

        private void setBit(int r, int c, int x){
            int i = width/8*(r-1) + (c-1)/8;
            int j = (c-1)%8;
            int mask = (x<<(7-j));
            pixels[i] = (byte)( (pixels[i]&(~mask)) | mask);
        }

        private int getBit(byte value, int index){
            if (index >=8)
                throw new RuntimeException("index can not be than 7");
            return (value >>(7-index))&1;
        }

        public void drawLine(int x1, int x2, int y){
           for (int i = x1; i<= x2; i++)
               setBit( y, i,1);
        }

        public void draw(){
          for(int r = 1 ; r <= height; r++){
              System.out.println();
              for(int c = 1; c <= width; c++){
                  print(r,c);
              }
          }
        }

    }
    static class Screen2{
        int width;
        int height;
        byte[] pixels;


        public Screen2(int width, int height) {
            this.pixels = new byte[(int)Math.ceil(width*height/8.0)];
            this.width  = width;
            this.height = height;

        }

        void print(int r, int c){
            int i = width/8*(r-1) + (c-1)/8;
            int j = (c-1)%8;
            System.out.print(getBit( pixels[i], j));

        }



        private int getBit(byte value, int index){
            if (index >=8)
                throw new RuntimeException("index can not be than 7");
            return (value >>(7-index))&1;
        }

        public void drawLine( int x1, int x2, int y){

           int startOffset  = (x1-1)%8;
           int firstFullByte = (x1-1)/8;
           if (startOffset!=0){
               firstFullByte++;
           }

           int endOffset = (x2-1)%8;
           int lastFullByte = (x2-1)/8;
           if (endOffset!=7){
               lastFullByte--;
           }

           for(int b = firstFullByte; b <= lastFullByte;b++){
               pixels[(width / 8) * (y-1) + b] = (byte) 0xFF;
           }

           byte startMask = (byte)( 0xFF >> (startOffset));
           byte endMask   = (byte)~(0xFF >> (endOffset +1));
           if ((x1-1)/8==(x2-1)/8){
               byte mask = (byte) (startMask & endMask);
               pixels[(width / 8) * (y-1) + ((x1-1) / 8)] |= mask;
           } else {
               if (startOffset!=0){
                   int byteNumber = (width / 8) * (y-1) + firstFullByte - 1;
                   pixels[byteNumber] |= startMask;
               }
               if (endOffset!=7){
                   int byteNumber = (width / 8) * (y-1) + lastFullByte + 1;
                   pixels[byteNumber] |= endMask;
               }
           }

        }

        public void draw(){
            for(int r = 1 ; r <= height; r++){
                System.out.println();
                for(int c = 1; c <= width; c++){
                    print(r,c);
                }
            }
        }

    }

    public static void main(String[] args) {
        Screen1 screen1 = new Screen1(16,3);
        screen1.drawLine(1,15,2);
        screen1.draw();
        System.out.println("");
        Screen2 screen2 = new Screen2(16,3);
        screen2.drawLine(1,15,2);
        screen2.draw();
     }
}
