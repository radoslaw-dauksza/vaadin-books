package com.kodilla.books;

import com.kodilla.books.domain.Book;
import com.kodilla.books.domain.BookService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;


public class BookForm extends FormLayout {
    private TextField title = new TextField("Title");
    private TextField author = new TextField("Author");
    private TextField publicationYear = new TextField("Publication year");
    private ComboBox<BookType> type = new ComboBox<>("Book type");
    private Button save = new Button("save");
    private Button delete = new Button("delete");
    private Binder<Book> binder = new Binder<>(Book.class);
    private BookService bookService = BookService.getInstance();
    private MainView mainView;

    BookForm(MainView mainView) {
        type.setItems(BookType.values());
        HorizontalLayout buttons = new HorizontalLayout(save, delete);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(title, author, publicationYear, type, buttons);
        binder.bindInstanceFields(this);
        save.addClickListener(event -> save());
        delete.addClickListener(event -> delete());
        this.mainView = mainView;
    }

    private void save() {
        Book book = binder.getBean();
        bookService.save(book);
        mainView.refresh();
        setBook(null);
    }

    private void delete() {
        Book book = binder.getBean();
        bookService.delete(book);
        mainView.refresh();
        setBook(null);
    }

    void setBook(Book book) {
        binder.setBean(book);
        if (book == null) {
            setVisible(false);
        } else {
            setVisible(true);
            title.focus();
        }
    }
}
