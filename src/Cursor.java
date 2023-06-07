public class Cursor {
    Pic curs;
    Cursor() {
        curs = new Pic("pics/cursor.png");
        curs.setBounds(200, 200, 20, 20);
    }
    void move( int x, int y){
        int tx = curs.getX() + x;//(x - curs.getX())/(10);
        int ty = curs.getY() + y;//(y - curs.getY())/(10);
        curs.setLocation(tx,ty);

        //timer+=10;
        //max speed 20;
        //min speed 1;
    }
}