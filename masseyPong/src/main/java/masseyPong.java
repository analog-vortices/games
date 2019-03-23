import processing.core.PApplet;

public class masseyPong extends PApplet{
    public static void main(String[] args) {PApplet.main(masseyPong.class.getCanonicalName());}

    public void setup() {
        background(0);
        frameRate=30;
    }

    public void settings() {
        size(800,600);
    }


    public void draw() {
//        keyPressed();
        background(0);
        player1(y1);
        player2(y2);
        ball(ballx, bally);
        collisionVert();
        collisionHor();
        ballMovement();
        textSize(100);
        text(score1, 200, 100);
        text(score2, 550, 100);

    }
    int y1 = 300,
    y2 = 300,
    ballx = 380,
    bally = 380,
            ballSpeedx = 5,
            ballSpeedy = 5;
    int score1 = 0;
    int score2 = 0;



    public void player1(int y) {
        fill(255);
        rect(0,y,20,100);
    }
    public void player2(int y) {
        fill(255);
        rect(780,y,20,100);
    }
    public void ball(int x, int y) {
        fill(255);
        rect(x,y,20,20);
    }

    public void keyPressed() {
        if (key == CODED) {
            if (keyCode == UP) {
                y2 -= 25;
                if (y2 < 0) {
                    y2 = 0;
                }
            }
            if (keyCode == DOWN) {
                y2+=25;
                if (y2 > 500) {
                    y2 = 500;
                }
            }

        } else {
            if (keyCode == 'w' || keyCode == 'W') {
                y1 -= 25;
                if (y1 < 0) {
                    y1 = 0;
                }
            }
            if (keyCode == 's' || keyCode == 'S') {
                y1 +=25;
                if (y1 > 500) {
                    y1 = 500;
                }
            }
        }
    }
    public boolean collisionVert() {
        boolean col = false;
        if (bally <= 0 || bally >= 580) {
            col = true;
        }
//        if ((bally+20 == ))
            return col;
    }
    public boolean collisionHor() {
        boolean col = false;
        if (ballx >= 780) {
            col = true;
            if (ballSpeedx > 0) {
                score1 += 1;
            }
        }
        if (ballx <= 0) {
            col = true;
            if (ballSpeedx < 0) {
                score2 += 1;
            }
        }
        if (ballx >= 760 && bally > y2 && bally < (y2+100) && ballSpeedx > 0) {
            col = true;
        }
        if (ballx <= 20 && bally > y1 && bally < (y1+100) && ballSpeedx < 0) {
            col = true;
        }
        return col;
    }

    public void ballMovement() {
        ballx += ballSpeedx;
        bally += ballSpeedy;
        if (collisionVert()) {
            ballSpeedy *= -1;
        }
        if (collisionHor()) {
            ballSpeedx *= -1;
        }
    }

}
