package com.jfx.library.component;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.jfx.library.superclass.BaseTemp;
import com.jfx.library.util.CommonUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 *
 * @author Reza
 */
public abstract class JFXComponent extends BaseTemp{
    

    /**
     * @param TABLE  : new TableView();
     * @param HEADER : String HEADER[] = {"NO", "HEADER NAME 1", "HEADER NAME 2"};
     * @param DATA   : List<_Object> DATA = new ArrayList<>();
     * @param WIDTH  : Integer WIDTH[] = {50, 100, 100};
     */
    public void setDinamicTableView(TableView TABLE, String[] HEADER, Object[][] DATA, Integer[] WIDTH){
        try{
            TableView<ObservableList<String>> tableView = TABLE;

            ObservableList<String> header = FXCollections.observableArrayList();
            header.addAll(Arrays.asList(HEADER));
            for (int i = 0; i < header.size(); i++) {
                final int finalIdx = i;
                TableColumn<ObservableList<String>, String> column = new TableColumn<>(header.get(i));
                column.setMinWidth(WIDTH[finalIdx]);
                column.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().get(finalIdx)));
                tableView.getColumns().add(column);
            }

            ObservableList<ObservableList> data = FXCollections.observableArrayList();
            for(Object[] parent : DATA){
                ObservableList<Object> row = FXCollections.observableArrayList();
                row.addAll(Arrays.asList(parent));
                data.add(row);   
            }  
            TABLE.setItems(data);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * @param COMBOBOX : new ComboBox();
     * @param ITEMS    : new ArrayList<>();
     */
    public void setItemsComboBox(ComboBox COMBOBOX, List<Items> ITEMS){
        try{
            COMBOBOX.setConverter(new StringConverter<Items>() {
                @Override
                public String toString(Items object) {
                    return object.getName();
                }
                @Override
                public Items fromString(String string) {
                    return null;
                }
            });

            ObservableList<Items> items = 
                    FXCollections.observableArrayList();
            for(Items model : ITEMS){
                items.add(model);
            }
            COMBOBOX.setItems(items);
            getIdComboBox(COMBOBOX);
            getItemComboBox(COMBOBOX);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
     protected Integer resultInt;
    /**
     * @param COMBOBOX : new ComboBox();
     * @return         : new Integer();
     */
    public Integer getIdComboBox(ComboBox COMBOBOX){
        COMBOBOX.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Items>() {
            @Override
            public void changed(ObservableValue<? extends Items> observable, Items oldValue, Items newValue) {
                resultInt = observable.getValue().getId();
            }
        });
        return resultInt;
    }
    
    protected String resultString;
    /**
     * @param COMBOBOX : new ComboBox();
     * @return         : new String();
     */
    public String getItemComboBox(ComboBox COMBOBOX){
        COMBOBOX.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Items>() {
            @Override
            public void changed(ObservableValue<? extends Items> observable, Items oldValue, Items newValue) {
                resultString = observable.getValue().getName();
            }
        });
        return resultString;
    }

    /**
     * @param HAMBURGER : new JFXHamburger();
     * @param DRAWER    : new JFXDrawer();
     */
    public void setSideBarMenu(JFXHamburger HAMBURGER, JFXDrawer DRAWER) {
        try {
            AnchorPane anchorPane = (AnchorPane) new FXMLLoader().load(getClass().getResource("/com/jfx/fxml/SideBarMenu.fxml"));
            AnchorPane backAnchorPane = (AnchorPane) anchorPane.getChildren().get(1);
            Accordion accordion = (Accordion) backAnchorPane.getChildren().get(0);
            accordion.getPanes().addAll(setListTitledPane());
            DRAWER.setSidePane(anchorPane);

            HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(HAMBURGER);
            transition.setRate(-1.0);
            HAMBURGER.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                transition.setRate(transition.getRate() * -1.0);
                transition.play();
                if (DRAWER.isShown()) {
                    DRAWER.close();
                } else {
                    DRAWER.open();
                }
            }
            );
            DRAWER.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                transition.setRate(-1.0);
                transition.play();
                if (DRAWER.isShown()) {
                    DRAWER.close();
                }
            }
            );
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public List<TitledPane> setListTitledPane(){
        List<TitledPane> titledPaneList = new ArrayList<>();
        try{
//            InputStream in = getClass().getResourceAsStream("/sidemenu/"+(String) RestUtil.getKelompokUser().get("kelompokUser")+".json");
//            BufferedReader br = new BufferedReader(new InputStreamReader(in));
//            for(Map<String, Object> data : JsonUtil.JsonFileToListMap(br)){
//                TitledPane titledPane = new TitledPane((String) data.get("name"), setStackPane(setTreeView((List<Map<String, Object>>) data.get("children"))));
//                PropertiesComponent.setPropertiesTitledPane(titledPane);
//                titledPaneList.add(titledPane);
//            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return titledPaneList;
    }
    
    /**
     * @param value
     * @return 
     */
    public AnchorPane setAnchorPane(Node value){
        AnchorPane anchor = new AnchorPane();
        Properties.setPropertiesAnchorPane(anchor);
        anchor.getChildren().add(value);
        return anchor;  
    }
    
    /**
     * @param value
     * @return 
     */
    public StackPane setStackPane(Node value){
        StackPane stack = new StackPane();
        Properties.setPropertiesStackPane(stack);
        stack.getChildren().add(value);
        return stack;
    }
    
    /**
     * @param value
     * @return 
     */
    public TreeView<?> setTreeViewSideBar(List<Map<String, Object>> value){
        TreeItem<String> rootItem = new TreeItem<>();
        rootItem.getChildren().addAll(setTreeItemSideBar(value));
        TreeView<String> treeView = new TreeView<>(rootItem);
        treeView.setShowRoot(false);
        return treeView;
    }

    /**
     * @param value
     * @return 
     */
    public List<TreeItem<String>> setTreeItemSideBar(List<Map<String, Object>> value){
        List<TreeItem<String>> rootItem = new ArrayList<>();
        for(Map<String, Object> parent : value){
            TreeItem<String> parentItem = new TreeItem<>((String)parent.get("name"));
            List<Map<String, Object>> childrens = (List<Map<String, Object>>) parent.get("children");
            if(CommonUtil.isNotNullOrEmpty(childrens)){
                parentItem.setExpanded(true);
                parentItem.getChildren().addAll(setTreeItemSideBar(childrens));
            }
            rootItem.add(parentItem);
        }
        return rootItem;
    } 
    
    /**
     * @param LISTVIEW
     * @param VALUES
     */
    public void setListView(ListView<Items> LISTVIEW, List<Map<String, Object>> VALUES){
        ObservableList<Items> items = FXCollections.observableArrayList();
        for(Map<String, Object> value : VALUES){
            Items item = new Items((Integer)value.get("id"), (String)value.get("name"));
            items.add(item);
        }
        LISTVIEW.setCellFactory(param -> new ListCell<Items>() {
            @Override
            protected void updateItem(Items item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null || item.getName() == null) {
                    setText(null);
                } else {
                    setText(item.getName());
                }
            }
        });
        LISTVIEW.setItems(items);
        LISTVIEW.setCellFactory(new Callback<ListView<Items>, ListCell<Items>>() {
            @Override
            public ListCell<Items> call(ListView<Items> param) {
                return null;
            }
        });
    }
  
    /**
     * @param ROOT
     * @param CHILD
     */
    public void setToContainer(ScrollPane ROOT, AnchorPane CHILD){
        ROOT.setContent(CHILD);
    }

}
