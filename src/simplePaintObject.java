import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.geometry.*;
import javafx.scene.shape.*;
import org.w3c.dom.css.Rect;

import java.awt.event.MouseEvent;


public class simplePaintObject extends Application {

    private double penWidth;

abstract class AbstractTool extends StackPane{

    private double penWidth;
}
abstract class ShapeTool extends AbstractTool{
    abstract public void draw (GraphicsContext g,Color color, Point2D start,Point2D end);

}

class PointTool extends ShapeTool{
    private double penWidth;

    public PointTool(double penWidth){
        this.penWidth = penWidth;
        Rectangle rectangle = new Rectangle(60,60,Color.LIGHTCORAL);
        rectangle.setStroke(Color.WHITE);
        this.getChildren().add(rectangle);

        Ellipse toolimage = new Ellipse(penWidth,penWidth);
        toolimage.setStroke(Color.LEMONCHIFFON);
        toolimage.setFill(Color.LEMONCHIFFON);

        this.getChildren().add(toolimage);
    }


    @Override
    public void draw(GraphicsContext g, Color color, Point2D start, Point2D end) {

    }
}




    @Override
    public void start(Stage primaryStage) throws Exception {

        FlowPane canvas=new FlowPane();
        Pane parrent = new Pane(canvas);


        
        Scene scene = new Scene(parrent);
        primaryStage.setScene(scene);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch();
    }

    private Parent makeRootPane(){
        HBox root = new HBox();
        root.getChildren().add(makeCanvas());
        //root.getchildern.add(toolPane);
       // root.getchildern.add()

        return root;
    }
    private Node makeCanvas() {
        Canvas canvas = new Canvas(600, 400);
        return canvas;
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


}



