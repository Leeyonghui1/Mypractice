﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml.Linq;

namespace P5
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string url = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2714000000";
            XElement x = XElement.Load(url);
            Console.WriteLine(x);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            string url = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2714000000";
            XElement x = XElement.Load(url);
            // 태그가 "data"인 것들만 가져오기
            var xq = from item in x.Descendants("data") select item;
            foreach (var item in xq)
            {
                Console.WriteLine(item.Element("hour").Value);
                Console.WriteLine(item.Element("wfKor").Value);
                Console.WriteLine(item.Element("wfEn").Value);
                Console.WriteLine(item.Element("temp").Value);
                Console.WriteLine();
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            string url = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2714000000";
            XElement x = XElement.Load(url);
            var xq = from item in x.Descendants("data") select new 
            {
                hour = item.Element("hour").Value,
                wf = item.Element("wfKor").Value,
                temp = item.Element("temp").Value
            };
            foreach (var item in xq)
            {
                Console.WriteLine(item.hour);
                Console.WriteLine(item.wf);
                Console.WriteLine(item.temp);
                Console.WriteLine();
            }
        }

        private void button4_Click(object sender, EventArgs e)
        {
            string url = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2714000000";
            XElement x = XElement.Load(url);
            var xq = from item in x.Descendants("data")
                     select new Weather()
                     {
                         hour = int.Parse(item.Element("hour").Value),
                         wf = item.Element("wfKor").Value.ToString(),
                         temp = double.Parse(item.Element("temp").Value)
                     };

            // List형태로 변환
            List<Weather> w = xq.ToList<Weather>();
            
            foreach (var item in xq)
            {
                Console.WriteLine(item.hour);
                Console.WriteLine(item.wf);
                Console.WriteLine(item.temp);
                Console.WriteLine();
            }
        }
    }
}
