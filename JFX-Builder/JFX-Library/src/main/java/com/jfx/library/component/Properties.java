package com.jfx.library.component;

import javafx.geometry.NodeOrientation;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.scene.AccessibleRole;
import javafx.scene.CacheHint;
import javafx.scene.Cursor;
import javafx.scene.DepthTest;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.TitledPane;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.AnchorPane;
import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Reza
 */
public class Properties {
    
    public static void setPropertiesTitledPane(TitledPane titledPane){
        //Properties text
        titledPane.setFont(Font.font("System" ,12));
        titledPane.setTextFill(Paint.valueOf("Black"));
        titledPane.setTextAlignment(TextAlignment.LEFT);
        titledPane.setTextOverrun(OverrunStyle.ELLIPSIS);
        titledPane.setLineSpacing(0);
        
        //Properties spesific
        titledPane.setExpanded(true);
        titledPane.setAnimated(true);
        titledPane.setCollapsible(true);
        
        //Properties graphic
        titledPane.setGraphicTextGap(4);
        titledPane.setContentDisplay(ContentDisplay.LEFT);
        
        //Properties node
        titledPane.setAlignment(Pos.CENTER_LEFT);
        titledPane.setNodeOrientation(NodeOrientation.INHERIT);
        titledPane.setFocusTraversable(true);
        titledPane.setCacheShape(true);
        titledPane.setScaleShape(true);
        titledPane.setCursor(Cursor.DEFAULT);
        
        //Properties extras
        titledPane.setBlendMode(BlendMode.SRC_OVER);
        titledPane.setCacheHint(CacheHint.DEFAULT);
        titledPane.setDepthTest(DepthTest.INHERIT);
        titledPane.intersects(96, 96, 96, 96);
        titledPane.setMouseTransparent(false);
        titledPane.setPickOnBounds(true);
        
        //Properties accessibility
        titledPane.setAccessibleRole(AccessibleRole.TITLED_PANE);
        
        //Layout size
        titledPane.setMinWidth(USE_COMPUTED_SIZE);
        titledPane.setMinHeight(USE_COMPUTED_SIZE);
        titledPane.setPrefWidth(USE_COMPUTED_SIZE);
        titledPane.setPrefHeight(USE_COMPUTED_SIZE);
        titledPane.setMaxWidth(USE_COMPUTED_SIZE);
        titledPane.setMaxHeight(USE_COMPUTED_SIZE);
        
        //Layout position
        titledPane.setLayoutX(0);
        titledPane.setLayoutY(0);
        
        //Layout transform
        titledPane.setRotationAxis(Point3D.ZERO);
        titledPane.setScaleX(1);
        titledPane.setScaleY(1);
        titledPane.setScaleZ(1);
        titledPane.setTranslateX(0);
        titledPane.setTranslateY(0);
        titledPane.setTranslateZ(0);
        
        //Layout bounds
        titledPane.layoutBoundsProperty();
        titledPane.boundsInLocalProperty();
        titledPane.boundsInParentProperty();
        
        //Layout extras
        titledPane.setSnapToPixel(true);
    }
    
    public static void setPropertiesAnchorPane(AnchorPane anchorPane){
        //Properties node
        anchorPane.setOpacity(1);
        anchorPane.setNodeOrientation(NodeOrientation.INHERIT);
        anchorPane.setVisible(true);
        anchorPane.setFocusTraversable(false);
        anchorPane.setCacheShape(true);
        anchorPane.setCenterShape(true);
        anchorPane.setScaleShape(true);
        anchorPane.setCursor(Cursor.DEFAULT);
        
        //Properties extras
        anchorPane.setBlendMode(BlendMode.SRC_OVER);
        anchorPane.setCacheHint(CacheHint.DEFAULT);
        anchorPane.setDepthTest(DepthTest.INHERIT);
        anchorPane.intersects(96, 96, 96, 96);
        anchorPane.setMouseTransparent(false);
        anchorPane.setPickOnBounds(true);
        
        //Properties accessibility
        anchorPane.setAccessibleRole(AccessibleRole.PARENT);
        
        //Layout size
        anchorPane.setMinWidth(USE_COMPUTED_SIZE);
        anchorPane.setMinHeight(USE_COMPUTED_SIZE);
        anchorPane.setPrefWidth(USE_COMPUTED_SIZE);
        anchorPane.setPrefHeight(USE_COMPUTED_SIZE);
        anchorPane.setMaxWidth(USE_COMPUTED_SIZE);
        anchorPane.setMaxHeight(USE_COMPUTED_SIZE);
        
        //Layout position
        anchorPane.setLayoutX(0);
        anchorPane.setLayoutY(0);
        
        //Layout transform
        anchorPane.setRotationAxis(Point3D.ZERO);
        anchorPane.setScaleX(1);
        anchorPane.setScaleY(1);
        anchorPane.setScaleZ(1);
        anchorPane.setTranslateX(0);
        anchorPane.setTranslateY(0);
        anchorPane.setTranslateZ(0);
        
        //Layout bounds
        anchorPane.layoutBoundsProperty();
        anchorPane.boundsInLocalProperty();
        anchorPane.boundsInParentProperty();
        
        //Layout extras
        anchorPane.setSnapToPixel(true);
    }
    
    public static void setPropertiesStackPane(StackPane stackPane){
        //Properties node
        stackPane.setAlignment(Pos.CENTER);
        stackPane.setOpacity(1);
        stackPane.setNodeOrientation(NodeOrientation.INHERIT);
        stackPane.setVisible(true);
        stackPane.setFocusTraversable(false);
        stackPane.setCacheShape(true);
        stackPane.setCenterShape(true);
        stackPane.setScaleShape(true);
        stackPane.setCursor(Cursor.DEFAULT);
        
        //Properties extras
        stackPane.setBlendMode(BlendMode.SRC_OVER);
        stackPane.setCacheHint(CacheHint.DEFAULT);
        stackPane.setDepthTest(DepthTest.INHERIT);
        stackPane.intersects(96, 96, 96, 96);
        stackPane.setMouseTransparent(false);
        stackPane.setPickOnBounds(true);
        
        //Properties accessibility
        stackPane.setAccessibleRole(AccessibleRole.PARENT);
        
        //Layout size
        stackPane.setMinWidth(USE_COMPUTED_SIZE);
        stackPane.setMinHeight(USE_COMPUTED_SIZE);
        stackPane.setPrefWidth(USE_COMPUTED_SIZE);
        stackPane.setPrefHeight(USE_COMPUTED_SIZE);
        stackPane.setMaxWidth(USE_COMPUTED_SIZE);
        stackPane.setMaxHeight(USE_COMPUTED_SIZE);
        
        //Layout position
        stackPane.setLayoutX(0);
        stackPane.setLayoutY(0);
        
        //Layout transform
        stackPane.setRotationAxis(Point3D.ZERO);
        stackPane.setScaleX(1);
        stackPane.setScaleY(1);
        stackPane.setScaleZ(1);
        stackPane.setTranslateX(0);
        stackPane.setTranslateY(0);
        stackPane.setTranslateZ(0);
        
        //Layout bounds
        stackPane.layoutBoundsProperty();
        stackPane.boundsInLocalProperty();
        stackPane.boundsInParentProperty();
        
        //Layout extras
        stackPane.setSnapToPixel(true);
    }
}
