﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace HelloMyCSharp03_02
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            SidePanel.Height = button1.Height;
            SidePanel.Top = button1.Top;
            firstCustomControl1.BringToFront(  );
        }

        private void button1_Click(object sender, EventArgs e)
        {
            SidePanel.Height = button1.Height;
            SidePanel.Top = button1.Top;
            firstCustomControl1.BringToFront();
        }

        private void button2_Click(object sender, EventArgs e)
        {

            SidePanel.Height = button2.Height;
            SidePanel.Top = button2.Top;
            mySecondCustomControl1.BringToFront();
        }

        private void button11_Click(object sender, EventArgs e)
        {
            Dispose();
        }

        

        private void bringToSideBar(object sender, EventArgs e)
        {
            Button btn = (sender as Button);
            SidePanel.Height = btn.Height;
            SidePanel.Top = btn.Top;
        }
    }
}
