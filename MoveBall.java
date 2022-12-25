import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
class MoveBall extends Thread {
    Brick ball = BrickBreaker.ball;
    Random random = new Random();
    int Vx = random.nextInt(2);
    int Vy = 1;

    public MoveBall() {
        start();
    }

    public void run() {
        while (true) {
            if (ball.getX() <= 0 || ball.getX() >= 960) {
                Vx = -1 * Vx;
            }
            if (ball.getY() <= 0 || touchs()) {
                Vy = -1 * Vy;
            }
            if(ball.getY() >=590){
                System.out.println("Out");
                break;
            }


            ball.setBounds(ball.getX() + Vx, ball.getY() + Vy, ball.getWidth(), ball.getHeight());
            try {
                sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i=0; i<BrickBreaker.bricks.length; i++){
                for(int j=0; j<BrickBreaker.bricks[0].length; j++){
                        if (BrickBreaker.bricks[i][j].overlap(BrickBreaker.ball)) {
                            if(BrickBreaker.bricks[i][j].isVisible()){
                                BrickBreaker.score++;
                            }
                            BrickBreaker.bricks[i][j].setVisible(false);

                        }
                }
            }
            if(BrickBreaker.score == 32){
                System.out.println("You Win");
                break;
            }
        }
    }
    static boolean touchs(){
        int x1 = BrickBreaker.ball.getX();
        int x2 = x1+BrickBreaker.ball.getWidth();
        int y1 = BrickBreaker.ball.getY();
        int y2 = y1+BrickBreaker.ball.getHeight();
        Brick board = BrickBreaker.board;
        if(x1>=board.getX() && x1<=board.getX()+board.getWidth() && y1>=board.getY() && y1<=board.getY()+board.getHeight()){
            return true;
        }
        else if(x2>=board.getX() && x2<=board.getX()+board.getWidth() && y1>=board.getY() && y1<=board.getY()+board.getHeight()){
            return true;
        }
        else if(x1>=board.getX() && x1<=board.getX()+board.getWidth() && y2>=board.getY() && y2<=board.getY()+board.getHeight()){
            return true;
        }
        else if(x2>=board.getX() && x2<=board.getX()+board.getWidth() && y2>=board.getY() && y2<=board.getY()+board.getHeight()){
            return true;
        }
        return false;
    }
}
