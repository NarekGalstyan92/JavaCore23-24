package classwork.chapter8;

class ColorBox extends Box {
    int color; // color of the box

    ColorBox(double w, double h, double d, int c) {
        super(w, d, h);
        color = c;
    }
}
