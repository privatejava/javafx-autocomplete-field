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

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author Narayan G. Maharjan
 * @see <a href="http://www.blog.ngopal.com.np"> Blog </a>
 */
public interface AutoFillTextBoxFactory<T> {
    
    /**
     * Keeps the array of String which contains the 
     * words to be matched on typing.
     * @param data 
     */
    void setData(ObservableList<T> data);
    
     /**
     * Give the data containing possible fast matching words
     * @return <a href="http://download.oracle.com/javafx/2.0/api/javafx/collections/ObservableList.html"> ObservableList </a>          
     */
    ObservableList<T> getData();
    
    /**
     * the main listview of the AutoFillTextBox
     * @return <a href="http://download.oracle.com/javafx/2.0/api/javafx/scene/control/ListView.html"> ListView </a>          
     */
    ListView<T> getListview();
    
     /**
     * the textbox of the AutoFillTextBox
     * @return <a href="http://download.oracle.com/javafx/2.0/api/javafx/scene/control/ListView.html"> TextView </a>          
     */
    TextField getTextbox();
    
    /**
     * This defines how many max listcell to be visibled in listview when
     * matched words are occured on typing.
     * @param limit 
     */
    void setListLimit(int limit);
    
    /**
     * this gives the limit of listcell to be visibled in listview
     * @return int
     */
    int getListLimit();
    
    /**
     * This sets the AutoFilterMode which can show as filter type
     * rather than searched type if value is true.
     * @param filter 
     */
    void setFilterMode(boolean filter);
        
    /**
     * 
     * @return boolean value of Filtermode
     */
    boolean getFilterMode();
}
