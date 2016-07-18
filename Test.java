package com.inspur;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.ZoneId;
import java.util.Date;

public class Test {
	public String FileInputStreamDemo(String path) throws IOException{
        File file=new File(path);
        if(!file.exists()||file.isDirectory())
            throw new FileNotFoundException();
        FileInputStream fis=new FileInputStream(file);
        byte[] buf = new byte[1024];
        StringBuffer sb=new StringBuffer();
        while((fis.read(buf))!=-1){
            sb.append(new String(buf));    
            buf=new byte[1024];//重新生成，避免和上次读取的数据重复
        }
        fis.close();
        return sb.toString();
    }

	public String getInputMessage() throws IOException {
		System.out.println("请输入您的命令∶");
		byte buffer[] = new byte[1024];
		int count = System.in.read(buffer);
		char[] ch = new char[count - 2];// 最后两位为结束符，删去不要
		for (int i = 0; i < count - 2; i++)
			ch[i] = (char) buffer[i];
		String str = new String(ch);
		return str;
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		Test t = new Test();
		//String str1 = t.getInputMessage();
		//System.out.println(str1);
		//System.out.println(t.FileInputStreamDemo("/home/yuanheqing/hello.txt"));
		File file = new File("/home/yuanheqing/hello.txt");
		System.out.println(File.pathSeparator);
		System.out.println("file exists : "+file.exists());
		InputStream is = new FileInputStream(file);
		//System.out.println(is.read());
		//System.out.println(is.toString());
		
		is.close();
		System.out.println("The size of the Zone Array: "+ZoneId.getAvailableZoneIds().size());
		Date d=new Date();
		System.out.println((d.getYear()+1900)+"  "+(d.getMonth()+1));
		
	}

}
