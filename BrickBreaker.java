import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class BrickBreaker{
    static JFrame frame = new JFrame();
    static Brick bricks[][];
    static Brick board;
    static Brick ball;
    static int score = 0;
    public static void main(String[] args) {
        bricks=new Brick[4][8];
        frame.setLayout(null);
        frame.setSize(1000, 650);
        addBricks();
        board = new Brick(425, 580, 150, 20);
        board.setBackground(Color.WHITE);

        ball = new Brick(425, 500, 20, 20);
        ball.setBackground(Color.WHITE);


        frame.add(board);
        frame.add(ball);
        new MoveBall();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                new MoveBoard(e.getKeyCode());
            }
        });


        frame.getContentPane().setBackground(Color.BLACK);

        frame.setVisible(true);


    }
    static void addBricks(){
        for(int i=0; i<bricks.length; i++) {
            for(int j=0; j<bricks[0].length; j++){
                bricks[i][j] = new Brick(j*120 + 20, 25*i + 20, 100, 20);
                frame.add(bricks[i][j]);
            }
        }
    }
}
