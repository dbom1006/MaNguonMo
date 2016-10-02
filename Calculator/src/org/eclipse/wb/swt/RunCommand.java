package org.eclipse.wb.swt;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.PumpStreamHandler;

public class RunCommand {
	public static String[] ListUser(){
		List<String> lst=new ArrayList<String>();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    CommandLine commandline = CommandLine.parse("net user");
	    DefaultExecutor exec = new DefaultExecutor();
	    PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
	    exec.setStreamHandler(streamHandler);
	    try {
			exec.execute(commandline);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String s=outputStream.toString();
	    String[] lines=s.split(System.getProperty("line.separator"));
	    String[] users=new String[lines.length-5];
	    int j=0;
	    for(int i=0;i<lines.length;i++)
	    	if(i>3 && i<lines.length-1) users[j++]=lines[i];
		return users;
	}
	public static void RunCommand(String line){
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    CommandLine commandline = CommandLine.parse(line);
	    DefaultExecutor exec = new DefaultExecutor();
	    PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
	    exec.setStreamHandler(streamHandler);
	    try {
			exec.execute(commandline);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println(outputStream.toString());
	}
}
