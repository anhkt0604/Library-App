package Library.ui.BookInfoView;

import Library.backend.bookModel.Book;
import Library.ui.User.UserMainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * Controller cho cửa sổ hiển thị thông tin sách chi tiết
 */
public class BookInfoViewController {

    @FXML
    private Label author;

    @FXML
    private AnchorPane container;

    @FXML
    private Button closeButton;

    @FXML
    private ImageView cover;

    @FXML
    private Label title;

    @FXML
    private Label isbn;

    @FXML
    private Label category;

    @FXML
    private Label publishyear;

    @FXML
    private Button ActionButton;

    private BookInfoView bookInfoView;

    @FXML
    void close(ActionEvent event) {
        bookInfoView.close();
    }

    @FXML
    void Action(ActionEvent event) {

    }

    public BookInfoView getBookInfoView() {
        return bookInfoView;
    }

    public void setBookInfoView(BookInfoView bookInfoView) {
        this.bookInfoView = bookInfoView;
    }

    public void setData(Book book) {
// 1. LẤY ẢNH BÌA SÁCH
        try {
            // TODO KIỂM TRA ĐỊA CHỈ ẢNH BỊ LỖI?
            Image image = new Image(book.getCoverCode());
            cover.setImage(image);

        } catch (Exception e) {
            System.out.println("Error loading image from " + book.getCoverCode());
            cover.setImage(new Image("D:/My Code/lib2024-1117/src/main/resources/Library/image/default-cover.png"));

            // demo với link ảnh trên web
//            cover.setImage (new Image("https://marketplace.canva.com/EAFaQMYuZbo/1/0/1003w/canva-brown-rusty-mystery-novel-book-cover-hG1QhA7BiBU.jpg"));
        }

        // 2. LẤY THONG TIN SÁCH
        title.setText(book.getTitle());
        author.setText(book.getAuthor());
        isbn.setText(book.getIsbn());
        category.setText(book.getCategory());
        publishyear.setText(String.valueOf(book.getPublishYear()));

        if (getBookInfoView().getMainController() instanceof UserMainController) {
            ActionButton.setText("Mượn sách");
        } else {
            ActionButton.setText("Chỉnh sửa");
        }

    }

}
