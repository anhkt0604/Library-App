package Library.ui;

import Library.MainApplication;
import Library.backend.bookModel.Book;
import Library.ui.BookCard.BookCardSmallController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller cho home tab.
 */
public class HomeTabController implements Initializable {

    /** Nút tìm kiếm. Khi bấm vào sẽ chuyển sang Search tab */
    @FXML
    private Pane searchBar;

    /** Layout chứa các sách được đề xuất (reccomendation) */
    @FXML
    private HBox BookLayout;

    /** Box chào mừng khi mở app */
    @FXML
    private VBox welcomeBox;

    private MainController mainController;

    /** LIST SÁCH ĐỀ XUẤT */
    private List<Book> recommendations;

    /** Khi click vào nút tìm kiếm, chuyển sang tab tìm kiếm */
    @FXML
    void SearchButtonClicked(MouseEvent event) throws Exception {
        System.out.println("Search Button Clicked");
        mainController.setContentPane(mainController.searchTab);
        mainController.setCurrentTab(mainController.getSearchButton());

        // CLick/hover search tab button? chưa có
    }

    public MainController getMainController() {
        return mainController;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("HomeTabController initialized");
        recommendations = new ArrayList<>(getRecommendations());
        try {
            for (Book b : recommendations) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApplication.class.getResource("fxml/BookCard_small.fxml"));
                HBox bookCard = loader.load();
                BookCardSmallController controller = loader.getController();
                controller.setData(b);
                BookLayout.getChildren().add(bookCard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // TODO Lấy reccomendation từ back-end (lưu ý: chỉ lấy 4 cuốn sách)
    private List<Book> getRecommendations() {
        List<Book> ls = new ArrayList<>();

        // TODO HERE
        ls.add(new Book("", "RICH DAD & POOR DAD", "Robert T.Kiyosaki",
                1997, "Business", "978-3-16-148410-0",
                "image/img.png", 1));
        ls.add(new Book("", "THE RICHEST MAN IN BABYLON", "George Samuel Clason",
                1926, "Business", "978-3-16-148410-0",
                "image/img.png", 1));
        ls.add(new Book("", "THE 7 HABITS OF HIGHLY EFFECTIVE PEOPLE", "Stephen R.Covey",
                1989, "Business", "978-3-16-148410-0",
                "image/img.png", 1));
        ls.add(new Book("", "THINK AND GROW RICH", "Napoleon Hill",
                1937, "Business", "978-3-16-148410-0",
                "image/img.png", 1));

        // RETURN
        return ls;
    }
}
