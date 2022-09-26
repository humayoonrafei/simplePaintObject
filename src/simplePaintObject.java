import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;





    abstract class AbstractTool extends StackPane {
        public AbstractTool(Color color) {
            Rectangle rectangle = new Rectangle(60, 60);
            rectangle.setFill(color);
            rectangle.setStroke(Color.WHITE);
            this.getChildren().add(rectangle);
        }


    }

    class ColorTool extends AbstractTool {
        public ColorTool(Color color) {
            super(color); // calling super inorder to intialize the constructor of parrent making rectangles for color Tools
        }
    }

    class ActionTool extends AbstractTool{
        public ActionTool(Color color){
            super(color);
        }
        public ActionTool(String text){
            super(Color.LIGHTCORAL);
            Label cmdName = new Label(text);
            cmdName.setTextFill(Color.LEMONCHIFFON);
            cmdName.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
            this.getChildren().add(cmdName);

        }

    }


    abstract class ShapeTool extends AbstractTool {
        public ShapeTool(Color color) {
            super(color);    // calling parrent class constructor to make the rectangles for shapeTools
        }

        abstract public void draw(GraphicsContext g, Color color, Point2D start, Point2D end);

    }

    class PointTool extends ShapeTool {
        private double penWidth;

        public PointTool(double penWidth) {
            super(Color.LIGHTCORAL);
            this.penWidth = penWidth;

            Ellipse toolimage = new Ellipse(penWidth, penWidth);
            toolimage.setStroke(Color.LEMONCHIFFON);
            toolimage.setFill(Color.LEMONCHIFFON);

            this.getChildren().add(toolimage);
        }


        @Override
        public void draw(GraphicsContext g, Color color, Point2D start, Point2D end) {

        }
    }


public class simplePaintObject extends Application {

    public static void main(String[] args) {
        launch();
    }





            private Parent makeRootPane() {
                HBox root = new HBox();
                root.getChildren().add(makeCanvas());
                root.getChildren().add(makeToolPane());
                root.getChildren().add(makeColorPane());

                return root;
            }

            private final Color[] palette = {
                    Color.BLACK, Color.RED, Color.GREEN, Color.BLUE,
                    Color.CYAN, Color.MAGENTA, Color.YELLOW
            };

            GraphicsContext g;

            private Node makeCanvas() {
                Canvas canvas = new Canvas(600, 400);
                g = canvas.getGraphicsContext2D();
                clearCanvas();
                canvas.setOnMousePressed(e -> mousePressed());
                canvas.setOnMouseDragged(e -> mouseDragged());
                canvas.setOnMouseReleased(e -> mouseReleased());
                return canvas;
            }

            private void mousePressed() {

            }

            private void mouseDragged() {

            }

            private void mouseReleased() {

            }

            private void clearCanvas() {

            }

            private Node makeColorPane() {
                VBox ColorPane = new VBox();
                for (int i = 0; i < 7; i++) {
                    ColorTool ct = new ColorTool(palette[i]);
                    ColorPane.getChildren().add(ct);
                    ct.setOnMousePressed(e -> mousePressed());
                    ct.setOnMouseDragged(e -> mouseDragged());
                    ct.setOnMouseReleased(e -> mouseReleased());
                }
                return ColorPane;
            }

            private Node makeToolPane() {
                VBox toolPane = new VBox();
                toolPane.getChildren().add(new PointTool(2));
                toolPane.getChildren().add(new PointTool(4));
                toolPane.getChildren().add(new PointTool(6));
                toolPane.getChildren().add(new PointTool(8));
                return toolPane;

            }

        @Override
        public void start(Stage primaryStage) throws Exception {
          /* REFACTORED
        Scene scene = new Scene(makeRootPane());
        primaryStage.setScene(scene);
        */

            primaryStage.setScene(new Scene(makeRootPane()));
            primaryStage.setTitle("Vertical Slice Paint");
            primaryStage.show();

        }
        }


    /*
    private void mousePressed(MouseEvent e){
    if (dragging == true);
        {
            return;
        }
    double x = e.getX();
    double y = e.getY();
    initX = x ;
    initY = y;

    dragging = true ;
    }

    private void mouseDragged(MouseEvent e) {

    if ( dragging == true )
    }

    */






