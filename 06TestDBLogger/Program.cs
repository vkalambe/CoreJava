using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;
using System.IO;
using System.Collections;
using System.Xml.Serialization;

namespace _06TestDBLogger
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("0 = SQL , 1 = Oracle");
            int dbchoice = Convert.ToInt32(Console.ReadLine());

            DbFactory df = new DbFactory();
            DBServer dbObject = df.GetDB(dbchoice);
            
            Console.WriteLine("Enter Data");
            string data = Console.ReadLine();

            Console.WriteLine("Which op? 0 = Insert, 1 = Update, 2 = Delete");
            int opchoice = Convert.ToInt32(Console.ReadLine());

            dbObject.Manipulate(opchoice, data);

            Console.ReadLine();

        }
    }

    public abstract class DBServer
    {
        protected abstract void Insert(string data);
        protected abstract void Update(string data);
        protected abstract void Delete(string data);
        protected abstract string GetDBName();

        public void Manipulate(int opchoice, string data)
        {
                if (opchoice == 0)
                {
                    Insert(data);
                    Logger.Current.Log("Insert Successfull " + GetDBName());
                }
                else if (opchoice == 1)
                {
                    Update(data);
                    Logger.Current.Log("Update Successfull " + GetDBName());
                }
                else
                {
                    Delete(data);
                    Logger.Current.Log("Delete Successfull " + GetDBName());
                }
        }
    }

    public class SQLServer : DBServer
    {
        protected override void Insert(string data)
        {
            SqlConnection con = new SqlConnection(@"Data Source=(LocalDB)\v11.0;AttachDbFilename='D:\vishal\MAHESH SIR\DotNetDemos\01ADO\TestDB123.mdf';Integrated Security=True");
            con.Open();
            SqlCommand cmd = new SqlCommand("select * from Emp",con);
            SqlDataReader reader=cmd.ExecuteReader();
           
            List<Emp> arr = new List<Emp>();


            while (reader.Read())
            {
                Emp emp = new Emp();
                emp.No = Convert.ToInt32(reader[0]);
                emp.Name =reader[1].ToString();
                emp.Address = reader[2].ToString();
                arr.Add(emp);

            }

            foreach (Emp emp in arr)
            {
                Console.WriteLine(emp.No+" @ "+emp.Name+" @ "+emp.Address);
            }
            FileStream fs = new FileStream(@"d:\vishal\MyXML.xml",
                FileMode.OpenOrCreate,
                FileAccess.Write);
            XmlSerializer writer = new XmlSerializer(typeof(List<Emp>));
            writer.Serialize(fs,arr);
            writer = null;    
            fs.Close();
 
        }

        protected override void Update(string data)
        {
            Console.WriteLine("Updated into SQL Server" + data);
        }

        protected override void Delete(string data)
        {
            Console.WriteLine("Deleted from SQL Server" + data);
        }

        protected override string GetDBName()
        {
            return "SQL Server";
        }
    }

    public class Oracle : DBServer
    {

        protected override void Insert(string data)
        {
            Console.WriteLine("Inserted into Oracle Server" + data);
        }

        protected override void Update(string data)
        {
            Console.WriteLine("Updated into Oracle Server" + data);
        }

        protected override void Delete(string data)
        {
            Console.WriteLine("Deleted from Oracle Server" + data);
        }

        protected override string GetDBName()
        {
            return "Oracle Server";
        }
    }

    public class DbFactory
    {
        public DBServer GetDB(int i)
        {
            if (i == 0)
            {
                return new SQLServer();
            }
            else
            {
                return new Oracle();
            }
        
        }
    }

    public class Logger
    {
        private static Logger logger = new Logger();
        private Logger(){ }
        public static Logger Current
        {
            get { return logger; }
        }

        public void Log(string message)
        {
            Console.WriteLine(message);
        }
    }
    [Serializable]
   public class Emp
    {
        public int No { get; set; }
        public string Name { get; set; }
        public string Address { get; set; }
    }
}


