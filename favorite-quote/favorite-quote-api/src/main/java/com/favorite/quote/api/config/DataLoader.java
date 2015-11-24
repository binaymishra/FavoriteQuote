package com.favorite.quote.api.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * A Spring bean that is container aware and reads data from the file and loads in memory.
 * At the time of spring container starts.
 * 
 * @author Binay Mishra
 *
 */
public class DataLoader implements ResourceLoaderAware {
	
	private String filePath;

	private ResourceLoader resourceLoader;

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
	
	public List<String> loadQuotes(){
		List<String> quotes = new ArrayList<String>();
		Resource dataFile 		= resourceLoader.getResource(filePath);
		InputStream in 			= null;
		BufferedReader reader 	= null;
		try {
			 in = dataFile.getInputStream();
			 reader = new BufferedReader(new InputStreamReader(in));
			while(true){
				String line = reader.readLine();
					if(null == line || line.length() <= 0 ){
						break;
					}else{
						quotes.add(line);
					}
			}
		} catch (IOException e) {
			System.err.print(filePath + " is not found.!");
		}finally{
			try {
				reader.close();
				in.close();
			} catch (IOException e) {
				System.err.print( e.getMessage());
			}
			
		}
		return quotes;
	}

}
