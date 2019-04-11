// IBookManager.aidl
package com.samluys.devdemo;

// Declare any non-default types here with import statements
import com.samluys.devdemo.Book;

interface IBookManager {

   void addBook(in Book book);
   List<Book> getBookList();
}
