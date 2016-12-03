using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Reflection;

namespace Attribute1
{
    [AttributeUsage(AttributeTargets.Class)]
    public class Table:Attribute
    {
        public string Name { get; set; }

    }
    
    [AttributeUsage(AttributeTargets.Field)]
    public class Column : Attribute
    {
       
        public string Name { get; set; }
        public string Type { get; set; }
        public int Size { get; set; }

    }
}
