package org.scu_db.demo.controller;

import org.scu_db.demo.Repository.BookRepository;
import org.scu_db.demo.model.Book;
import org.scu_db.demo.model.Member;
import org.scu_db.demo.model.Title;
import org.scu_db.demo.service.BookService;
import org.scu_db.demo.service.MemberService;
import org.scu_db.demo.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/homework")
public class HomeworkController {

    @Autowired
    private TitleService titleService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private BookService bookService;


    @RequestMapping("/1")
    public List<Integer> homework1(){
        //TODO:请完成相关代码实现下述查询要求：
        //查询所有被借走图书的Book_ID。(对应第2题)
        List<Integer> bookId;

        //------------在此之下写下执行代码--------------
        bookId=new LinkedList<>();
        for(Book book:bookService.findAllBooks()){
            if(book.getBorrowduedate()!=null)
                bookId.add(book.getBookId());
        }
        //-----------在此之上写下执行代码---------------
        return bookId;
    }

    @RequestMapping("/2")
    public List<Title> homework2(){
        //TODO:请完成相关代码实现下述查询要求：
        //查询书名为”Iliad”或”Odyssey”的书目信息。(对应第4题)
        List<Title> titles;

        //------------在此之下写下执行代码--------------
        titles=new LinkedList<>();
        for(Title title:titleService.findAllTitles()){
            if(title.getName().equals("Odyssey")||title.getName().equals("Iliad")){
                titles.add(title);
            }
        }

        //-----------在此之上写下执行代码---------------
        return titles;//TODO:修改返回值为titles
    }


    @RequestMapping("/3")
    public Integer homework3(){
        //TODO:请完成相关代码实现下述查询要求：
        //查询callnumber为”Call123”的图书有多少本。(对应第5题)
        Integer count;
        //------------在此之下写下执行代码--------------
        int c=0;
        for(Book book:bookService.findAllBooks()){
            if(book.getCallnumber().equals("Call123")) {
                c++;

            }
        }
        count=c;
        //-----------在此之上写下执行代码---------------
        return count;//TODO:修改返回值为books
    }

    @RequestMapping("/4")
    public List<String> homework4(){
        //TODO:请完成相关代码实现下述查询要求：
        //查询本数不超过2本的图书的callnumber号。(对应第7题)
        List<String> callnumbers ;
        //------------在此之下写下执行代码--------------
        callnumbers=new LinkedList<>();
        HashMap<String,Integer> map=new HashMap<String, Integer>();
        for(Book book:bookService.findAllBooks()){
            int flag=0;
            for(String key:map.keySet()){
                if(key.equals(book.getCallnumber())){
                    map.put(key,map.get(key)+1);
                    flag=1;
                    break;
                }
            }
            if(flag==0){//如果没有在map中找到相同键
                map.put(book.getCallnumber(),1);//则将对应键和键值插入到map中
            }
        }
        for(String key:map.keySet()){
            if(map.get(key)<=2){
                callnumbers.add(key);
            }
        }
        //-----------在此之上写下执行代码---------------
        return callnumbers;//TODO:修改返回值为books
    }


}
