import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.util.*;
import javafx.animation.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class SpinningCircles extends Application
{
            @Override
            public void start(Stage stage) throws Exception {
            stage.setTitle("Spinning circles");
            Duration d1 = Duration.seconds(1);
            Duration d2 = Duration.seconds(1);

            int smallCircleX = 200;
            int smallCircleY = 200;
            int smallCircleR = 60;

            Circle circS = new Circle(smallCircleX,smallCircleY,smallCircleR, Color.WHITE);
            circS.setStroke(Color.RED);
            circS.setStrokeWidth(4);

            int bigCircleX = 200;
            int bigCircleY = 200;
            int bigCircleR = 120;
            Circle circB = new Circle(bigCircleX,bigCircleY,bigCircleR, Color.YELLOW);
            circB.setStroke(Color.GREEN);
            circB.setStrokeWidth(9);

            int c1X = 320;
            int c1Y = 200;
            int c1R = 20;
            Circle c1 = new Circle(c1X, c1Y, c1R, Color.RED);
            c1.setStroke(Color.GREEN);
            c1.setStrokeWidth(5);

            int c2X = 260;
            int c2Y = 200;
            int c2R = 10;
            Circle c2 = new Circle(c2X, c2Y, c2R, Color.GREEN);
            c2.setStroke(Color.RED);
            c2.setStrokeWidth(2);

            PathTransition t1 = new PathTransition();
            t1.setNode(c1);
            t1.setDuration(d1);
            t1.setPath(circB);
            t1.setCycleCount(PathTransition.INDEFINITE);
            t1.setInterpolator(Interpolator.LINEAR);
            t1.play();

            PathTransition t2 = new PathTransition();
            t2.setNode(c2);
            t2.setDuration(d2);
            t2.setPath(circS);
            t2.setCycleCount(PathTransition.INDEFINITE);
            t2.setInterpolator(Interpolator.LINEAR);
            t2.play();

            Pane pane = new Pane(circB, circS, c1, c2);
            pane.setPrefSize(400, 400);

            Slider slider = new Slider(0, 1, 0.5);
            slider.setShowTickMarks(true);
            slider.setShowTickLabels(true);
            slider.setMajorTickUnit(0.25);

            t1.rateProperty().bind(slider.valueProperty());
            t2.rateProperty().bind(slider.valueProperty().subtract(1));


            stage.setScene(new Scene(new VBox(pane, slider)));
            stage.show();
        }


        public static void main(String[] args)
        {
            launch(args);
        }
}