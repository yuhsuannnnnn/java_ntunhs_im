package hw12;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class hw12 {
    public static class Window extends JFrame implements KeyListener {
        static int score = 0; // 游戏得分
        private int paddleX = 250; // 挡板初始位置
        private final int PADDLE_WIDTH = 100; // 挡板宽度
        private final int PADDLE_HEIGHT = 10; // 挡板高度
        private final int PADDLE_Y = 550; // 挡板的Y坐标
        private Ball ball; // 小球对象

        public Window() {
            this.setTitle("不让球掉下来!!"); // 窗口标题
            this.setSize(600, 600); // 窗口大小
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 关闭窗口时退出程序
            this.setLocationRelativeTo(null); // 窗口居中
            this.addKeyListener(this); // 添加键盘监听器
            ball = new Ball(this); // 创建小球对象
            this.setVisible(true); // 显示窗口
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;

            // 绘制得分
            g2d.setColor(Color.GRAY);
            g2d.setFont(new Font("Verdana", Font.BOLD, 50));
            g2d.drawString(String.valueOf(score), 500, 120);

            // 绘制挡板
            g2d.setColor(Color.PINK);
            g2d.fillRect(paddleX, PADDLE_Y, PADDLE_WIDTH, PADDLE_HEIGHT);

            // 绘制小球
            ball.paint(g2d);
        }

        // 移动小球
        public void moveBall() {
            ball.moveBall();

            int ballX = ball.getX();
            int ballY = ball.getY();
            int ballSize = Ball.getBallSize();

            // 判断小球是否与挡板碰撞
            if (ballY + ballSize >= PADDLE_Y && ballY + ballSize <= PADDLE_Y + PADDLE_HEIGHT
                    && ballX + ballSize >= paddleX && ballX <= paddleX + PADDLE_WIDTH) {
                ball.reverseYDirection(); // 反转小球的Y轴移动方向
                score++; // 增加得分
            } else if (ballY >= getHeight()) {
                // 游戏结束，重置小球位置
                ball.resetPosition();
                score = 0; // 重置得分
            }
        }

        // 移动挡板
        public void movePaddle(int direction) {
            paddleX += direction;
            if (paddleX < 0) {
                paddleX = 0;
            } else if (paddleX > getWidth() - PADDLE_WIDTH) {
                paddleX = getWidth() - PADDLE_WIDTH;
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                movePaddle(-20); // 向左移动挡板
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                movePaddle(20); // 向右移动挡板
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {}

        @Override
        public void keyTyped(KeyEvent e) {}

        public static void main(String[] args) throws InterruptedException {
            Window window = new Window();

            while (true) {
                window.moveBall(); // 移动小球
                window.repaint(); // 重绘窗口
                Thread.sleep(10); // 暂停10毫秒
            }
        }
    }

    public static class Ball extends JPanel {
        private static final int BALL_SIZE = 20; // 小球的直径
        private int x = 300; // 小球的初始X坐标
        private int y = 300; // 小球的初始Y坐标
        private int step =4; // 小球的移动步长
        private int incX = step; // 小球X轴方向的增量
        private int incY = step; // 小球Y轴方向的增量
        private Window window; // 窗口对象

        public Ball(Window w) {
            this.window = w;
        }

        public static int getBallSize() {
            return BALL_SIZE;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        // 移动小球
        public void moveBall() {
            if (x + incX > window.getWidth() - BALL_SIZE || x + incX < 0) {
                incX = -incX; // 反转X轴方向
            }
            if (y + incY < 0) {
                incY = -incY; // 反转Y轴方向
            }

            x += incX;
            y += incY;
        }

        // 反转Y轴方向
        public void reverseYDirection() {
            incY = -incY;
        }

        // 重置小球位置
        public void resetPosition() {
            x = 300;
            y = 300;
            incX = step;
            incY = step;
        }

        // 绘制小球
        public void paint(Graphics2D g) {
            g.setColor(Color.ORANGE);
            g.fillOval(x, y, BALL_SIZE, BALL_SIZE);
        }
    }
}
