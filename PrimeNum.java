import java.util.*;
import java.io.*;
class PrimeNum
{
public static void main(String args[]) throws IOException
{
int num,result;
FileReader fin=new FileReader("numberfile1.txt");
FileWriter fout=new FileWriter("prime.txt");
Scanner fs=new Scanner(fin);
while(fs.hasNextInt()==true)
{
num=fs.nextInt();
result=PrimeFile.Prime(num);
if(result==1)
{
fout.write(Integer.toString(num)+"\t");
}
}
fs.close();
fin.close();
fout.close();
System.out.println("Program Completed");
}
}
class PrimeFile
{
public static int Prime(int n)
{
int count=0,i;
if(n==0)
{
return 0;
}
for(i=1;i<=n;i++)
{
if(n%i==0)
{
count++;
}
}
if(count>2)
{
return 0;
}
else
{
return 1;
}
}
}
