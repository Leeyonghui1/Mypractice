﻿using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml.Linq;

namespace BookManager
{
    public class DataManager
    {
        public static List<Book> Books = new List<Book>();
        public static List<User> Users = new List<User>();

        // 태그 이름들을 미리 적어놓는 작업
        const string ISBN = "isbn";
        const string NAME = "name";
        const string PUBLISHER = "publisher";
        const string PAGE = "page";
        const string USERID = "userid";
        const string USERNAME = "username";
        const string ISBORROWED = "isborrowed";
        const string BORROWEDAT = "borrowedAt";
        const string ID = "id";

        // 정적 생성자
        // 1. 해당 클래스로 인스턴스를 처음 만들었을 때
        // 2. 해당 클래스를 접근할 때(ex. DataManager.Books)
        // 처음에 한 번만 호출함
        static DataManager()
        {
            Load();
        }

        public static void Load()
        {
            // Books.xml, Users.xml 파일을 불러옴
            try
            {
                string booksOutput = File.ReadAllText(@"./Books.xml");
                XElement bx = XElement.Parse(booksOutput);
                //LINQ 버전
                Books = (from item in bx.Descendants("book")
                         select new Book()
                         {
                             Isbn = item.Element(ISBN).Value,
                             Name = item.Element(NAME).Value,
                             Publisher = item.Element(PUBLISHER).Value,
                             Page = int.Parse(item.Element(PAGE).Value),
                             BorrowedAt = DateTime.Parse(item.Element(BORROWEDAT).Value),
                             isBorrowed = item.Element(ISBORROWED).Value != "0" ? true:false,
                             UserId = int.Parse(item.Element(USERID).Value),
                             UserName = item.Element(USERNAME).Value
                         }).ToList<Book>();
                // foreach 버전
                string usersOutput = File.ReadAllText(@"./Users.xml");
                XElement ux = XElement.Parse(usersOutput);
                Users.Clear(); // 수동 클리어
                foreach (var item in ux.Descendants("user"))
                {
                    User temp = new User();
                    temp.Name = item.Element(NAME).Value;
                    temp.Id = int.Parse(item.Element(ID).Value);
                    Users.Add(temp);
                }
            }
            catch (Exception e)
            {
                MessageBox.Show("파일 누락! 새로 만듭니다!");
                Save();
                Load();
            }
        }

        public static void Save()
        {
            // 파일 없을 때 새로 만들고 있다면 변경내용을 통째로 새로 저장함
            string booksOutput = "";
            booksOutput += "<books>\n";
            // Books 파일이 없거나 books 태그에 아무 것도 없다면
            // 파일에 <books></books>만 저장됨
            foreach (var item in Books)
            {
                booksOutput += " <book>\n";
                booksOutput += $"  <{ISBN}>{item.Isbn}</{ISBN}>\n";
                booksOutput += $"  <{NAME}>{item.Name}</{NAME}>\n";
                booksOutput += $"  <{PUBLISHER}>{item.Publisher}</{PUBLISHER}>\n";
                booksOutput += $"  <{PAGE}>{item.Page}</{PAGE}>\n";
                booksOutput += $"  <{BORROWEDAT}>{item.BorrowedAt}</{BORROWEDAT}>\n";
                booksOutput += $"  <{ISBORROWED}>"+(item.isBorrowed?1:0)+$"</{ISBORROWED}>\n";
                booksOutput += $"  <{USERID}>{item.UserId}</{USERID}>\n";
                booksOutput += $"  <{USERNAME}>{item.UserName}</{USERNAME}>\n";
                booksOutput += " </book>\n";
            }
            booksOutput += "</books>\n";
            File.WriteAllText(@"./Books.xml", booksOutput);

            string usersOutput = "";
            usersOutput += "<users>\n";
            foreach (var item in Users)
            {
                usersOutput += " <user>\n";
                usersOutput += $"  <{ID}>{item.Id}</{ID}>\n";
                usersOutput += $"  <{NAME}>{item.Name}</{NAME}>\n";
                usersOutput += " </user>\n";
            }
            usersOutput += "</users>\n";
            File.WriteAllText(@"./Users.xml", usersOutput);
        }
    }
}
