package Library;

import Customer.BookTable;
import Customer.Filter;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class SearchBookPage extends BorderPane {
    Button nameButton = new Button("Name");
    Button authorButton = new Button("Writer");
    Button idButton = new Button("Type");
    TextField textField = new TextField();
    Button searchButton = new Button("Search");
    TableView<Filter> table = new TableView<Filter>();
    ChoiceBox<String> types = new ChoiceBox<>();
    RemoveSpace remove = new RemoveSpace();
    String typeStrings[] = {"Novel", "History", "Philosophy"};

    SearchBookPage() {
        this.getStylesheets().add(this.getClass().getResource("/CSS-Design/design.css").toExternalForm());
        nameButton.getStyleClass().add("SearchBookButton");
        authorButton.getStyleClass().add("SearchBookButton");
        idButton.getStyleClass().add("SearchBookButton");
        searchButton.getStyleClass().add("SearchBookButton");
        textField.getStyleClass().add("SearchTextBox");
        types.getStyleClass().add("SearchPageChoiceBox");
        types.setItems(FXCollections.observableArrayList(typeStrings));
        types.setValue(typeStrings[0]);
        GridPane mainPane = new GridPane();
        HBox topMenu = new HBox();
        HBox Nodes = new HBox();
        VBox tableBox = new VBox();

        topMenu.setPadding(new Insets(10, 10, 10, 10));
        Nodes.setSpacing(5);


        mainPane.setAlignment(Pos.TOP_CENTER);
        topMenu.setAlignment(Pos.CENTER);
        topMenu.getChildren().addAll(nameButton, authorButton, idButton);
        Nodes.setAlignment(Pos.CENTER);
        tableBox.setAlignment(Pos.CENTER);
        mainPane.setPadding(new Insets(10, 20, 10, 10));
        mainPane.setVgap(20);


        nameButton.setOnAction(e -> {
            mainPane.getChildren().removeAll(Nodes, tableBox);
            if (Nodes.getChildren().contains(types)) {
                Nodes.getChildren().removeAll(types, searchButton);
            } else {
                Nodes.getChildren().removeAll(textField, searchButton);
            }
            Nodes.getChildren().removeAll(textField, searchButton);
            Nodes.getChildren().addAll(textField, searchButton);
            mainPane.add(Nodes, 0, 0);

            textField.setText("");
            textField.setPromptText("Name of the Book");
            searchButton.setOnAction(f -> {
                tableBox.getChildren().remove(table);
                mainPane.getChildren().removeAll(tableBox);

                new TypesOfSearch(nameButton.getText(), String.valueOf(remove.removeSpace(textField.getText())));
                if (!BookFactory.check) {

                } else {
                    this.table = new BookTable().table;
                    tableBox.getChildren().add(table);
                    mainPane.add(tableBox, 0, 1);
                    textField.setText("");
                }


            });

        });

        authorButton.setOnAction(e -> {

            mainPane.getChildren().removeAll(Nodes, tableBox);
            if (Nodes.getChildren().contains(types)) {
                Nodes.getChildren().removeAll(types, searchButton);
            } else {
                Nodes.getChildren().removeAll(textField, searchButton);
            }
            Nodes.getChildren().addAll(textField, searchButton);
            mainPane.add(Nodes, 0, 0);

            textField.setText("");
            textField.setPromptText("Name of the Author");
            searchButton.setOnAction(f -> {
                tableBox.getChildren().remove(table);
                mainPane.getChildren().removeAll(tableBox);
                new TypesOfSearch(authorButton.getText(), String.valueOf(remove.removeSpace(textField.getText())));
                if (!BookFactory.check) {
                    this.table = null;
                } else {

                    this.table = new BookTable().table;
                    tableBox.getChildren().add(table);
                    mainPane.add(tableBox, 0, 2);
                    textField.setText("");
                }

            });

        });
        idButton.setOnAction(e -> {

            mainPane.getChildren().removeAll(Nodes, tableBox);
            if (Nodes.getChildren().contains(types)) {
                Nodes.getChildren().removeAll(types, searchButton);
            } else {
                Nodes.getChildren().removeAll(textField, searchButton);
            }
            Nodes.getChildren().addAll(types, searchButton);
            mainPane.add(Nodes, 0, 0);
            textField.setPromptText("Type of the Book");
            searchButton.setOnAction(f -> {
                tableBox.getChildren().remove(table);
                mainPane.getChildren().removeAll(tableBox);
                new TypesOfSearch(idButton.getText(), types.getValue());
                if (!BookFactory.check) {
                    this.table = null;
                } else {
                    this.table = new BookTable().table;
                    tableBox.getChildren().add(table);
                    mainPane.add(tableBox, 0, 2);
                    textField.setText("");
                }
            });

        });

        this.getChildren().remove(mainPane);
        this.setCenter(mainPane);
        this.setTop(topMenu);

    }

}
