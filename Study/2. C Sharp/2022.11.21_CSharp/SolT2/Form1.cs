﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SolT2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            List<Student> students = new List<Student>();
            students.Add(new Student() { name = "박재형", grade = 1 });
            students.Add(new Student() { name = "이재형", grade = 2 });
            students.Add(new Student() { name = "리재형", grade = 3 });
            students.Add(new Student() { name = "상남자", grade = 4 });
            students.Add(new Student() { name = "상남자_재형", grade = 1 });
            students.Add(new Student() { name = "하남자_재형", grade = 2 });

            for (int i = 0; i < students.Count; i++)
            {
                Label l = new Label();
                l.Text = $"{students[i].grade} 학년 {students[i].name}학생";
                l.AutoSize = true;
                l.Location = new Point(13, 13 + 26 * i);
                Controls.Add(l);
            }

            for (int i = students.Count - 1; i >= 0; i--)
            {
                if (students[i].grade > 1)
                    students.RemoveAt(i);
            }
            for (int i = 0; i < students.Count; i++)
            {
                Label l = new Label();
                l.Text = $"{students[i].grade} 학년 {students[i].name}학생";
                l.AutoSize = true;
                l.Location = new Point(130, 13 + 26 * i);
                Controls.Add(l);
            }
        }
    }
}
