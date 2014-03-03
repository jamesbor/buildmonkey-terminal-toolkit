package com.buildmonkey.terminal.jFiglet;

import com.buildmonkey.terminal.jFiglet.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;


public class FileUtils {

	  /**
	   * list files in the given directory and subdirs (with recursion)
	   * @param paths
	   * @return
	   */
	  public static List<File> getFiles(String paths) {
	    List<File> filesList = new ArrayList<File>();
	    for (final String path : paths.split(File.pathSeparator)) {
	      final File file = new File(path);
	      if( file.isDirectory()) {
	         recurse(filesList, file);
	      }
	      else {
	        filesList.add(file);
	      }
	    }
	    return filesList;
	  }

	  private static void recurse(List<File> filesList, File f) { 
	    File list[] = f.listFiles();
	    for (File file : list) {
	      if (file.isDirectory()) {
	         recurse(filesList, file);
	      }
	      else {
	        filesList.add(file);
	      }
	    }
	  }
	  
	  /**
	   * List the content of the given jar
	   * @param jarPath
	   * @return
	   * @throws IOException
	   */
	  public static List<String> getJarContent(String jarPath) throws IOException{
	    List<String> content = new ArrayList<String>();
	    JarFile jarFile = new JarFile(jarPath);
	    Enumeration<JarEntry> e = jarFile.entries();
	    while (e.hasMoreElements()) {
	      JarEntry entry = (JarEntry)e.nextElement();
	      String name = entry.getName();
	      content.add(name);
	    }
	    return content;
	  }
	  
	  
	  public static void main(String args[]) throws Exception {
	    List<File> list = FileUtils.getFiles(System.getProperty("java.class.path"));
	    for (File file: list) {
	      System.out.println(file.getPath());
	      //if (file.)
	    }
	    //System.out.println("1");
//	    list = FileUtils.getFiles(System.getProperty("sun.boot.class.path"));
//	    for (File file: list) {
//	      System.out.println(file.getPath());
//	    }
//	    System.out.println("2");
//	    list = FileUtils.getFiles(System.getProperty("java.ext.dirs"));
//	    for (File file: list) {
//	      System.out.println(file.getPath());
//	    }
//	    System.out.println("3");
//	    List<String> content = FileUtils.getJarContent("c:/temp/DirWatch.jar");
//	    for (String file: content) {
//	      System.out.println(file);
//	    }
	    
	  }  
}
