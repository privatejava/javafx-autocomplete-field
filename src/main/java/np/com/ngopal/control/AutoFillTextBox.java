/* 
 * The MIT License
 *
 * Copyright 2016 Narayan G. Maharjan .
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package np.com.ngopal.control;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * This class is main Control class which extends from Control <br>
 * and also implements basic functions of the AutoFillTextBoxFactory<br>
 *
 * You can easily utilize the AutoFillTextBox in your application<br>
 *
 * e.g <br>
 * <pre>
 *      //..codes
 *      AutoFillTextBox autobox = new AutoFillTextBox("helo","prefix","dog","city");
 *      autobox.setLimit(7);
 *      //..add autobox to your scene then the output must be like this:
 * </pre> Output:
 * <br>
 * <img src="http://blog.ngopal.com.np/wp-content/uploads/2011/07/screen.png" align="center"/>
 * <br>
 * <p>
 *
 *
 * @author Narayan G. Maharjan
 * @see <a href="http://www.blog.ngopal.com.np"> Blog </a>
 * <p>
 */
public class AutoFillTextBox<T> extends Control implements
        AutoFillTextBoxFactory<T> {

    //==========
    //ATTRIBUTES
    //==========
    private TextField textbox;

    private ListView<T> listview;

    private ObservableList<T> data = FXCollections.observableArrayList();

    private boolean filterMode;

    private int limit;

    /**
     * Constructor
     */
    /* public AutoFillTextBox() {
     * init();
     * }
     */
    public AutoFillTextBox(ObservableList<T> data) {
        this.data = data;
        init();
    }

    public AutoFillTextBox() {
        init();
    }

    /* =================================
     * Initialize the AutoFillTextBox *
     * ================================ */
    private void init() {
        getStyleClass().setAll("autofill-text");
        textbox = new TextField();
        listview = new ListView<T>();
        limit = 5;
        filterMode = false;

        setSkin(new AutoFillTextBoxSkin<T>(this));
        listen();
    }

    public void requestFocus() {
        super.requestFocus();
        textbox.requestFocus();
    }

    public T getItem() {
        return listview.getSelectionModel().getSelectedItem();
    }

    public String getText() {
        return textbox.getText();
    }

    public void addData(T data) {
        this.data.add(data);

    }

    /* --------------------
     * OVERRIDEN METHODS *
     * -------------------- */
    @Override
    public void setData(ObservableList<T> data) {
        this.data = data;
    }

    @Override
    public ObservableList<T> getData() {
        return data;
    }

    @Override
    public ListView<T> getListview() {
        return listview;
    }

    @Override
    public TextField getTextbox() {
        return textbox;
    }

    @Override
    public void setListLimit(int limit) {

        this.limit = limit;

    }

    @Override
    public int getListLimit() {
        return limit;
    }

    @Override
    public void setFilterMode(boolean filter) {
        filterMode = filter;
    }

    @Override
    public boolean getFilterMode() {
        return filterMode;
    }

    @Override
    public void setMinSize(double d, double d1) {
        super.setMinSize(d, d1);
        textbox.setMinSize(d, d1);
    }

    @Override
    public void setPrefSize(double d, double d1) {
        super.setPrefSize(d, d1);
        textbox.setPrefSize(d, d1);
    }

    @Override
    public void resize(double d, double d1) {
        super.resize(d, d1);
        textbox.resize(d, d1);
    }

    @Override
    public void setMaxSize(double d, double d1) {
        super.setMaxSize(d, d1);
        textbox.setMaxSize(d, d1);

    }

    private void listen() {
        this.prefHeightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                textbox.setPrefHeight(t1.doubleValue());
            }

        });
        this.prefWidthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                textbox.setPrefWidth(t1.doubleValue());
            }

        });
        this.minHeightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                textbox.setMinHeight(t1.doubleValue());
            }

        });
        this.maxHeightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                textbox.setMaxHeight(t1.doubleValue());
            }

        });
        this.minWidthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                textbox.setMinWidth(t1.doubleValue());
            }

        });
        this.maxWidthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                textbox.setMaxWidth(t1.doubleValue());
            }

        });
    }

    @Override
    protected double computeMaxHeight(double width) {
        return Math.max(22.0d, textbox.getHeight());
    }

}
