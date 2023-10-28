import java.util.*;
import java.io.*;
class Encryption
{
public static void main(String args[]) throws IOException
{
int i,en;
char c;
Scanner Sc=new Scanner(System.in);
System.out.println("Enter the number with which the character is to be shifted");
en=Sc.nextInt();
FileInputStream fin=new FileInputStream("File.txt");
FileOutputStream fout=new FileOutputStream("encrypt.txt");
while((i=fin.read())!=-1)
{
   c=(char)i;
   if(c==' ')
   fout.write(c);
   else if((c>='a' && c<=('z'-((char)en))) || (c>='A' && c<=('Z'-((char)en))))
   {
   i=i+en;
   c=(char)i;
   fout.write(c);
   }
   else if((c>('z'-((char)en))) && c<='z' || (c>('Z'-((char)en))) && c<='Z')
   {
   i=i-(26-en);
   c=(char)i;
   fout.write(c);
   }
   else
   {
   i=i+en;
   c=(char)i;
   fout.write(c);
   }

}
fin.close();
fout.close();
System.out.println("COMPLETED");
}
}
