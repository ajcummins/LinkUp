package edu.ycp.cs481.linkup.model;

public class Path {

	private String path;
	public Path(String inPath){
		path = inPath;
	}
	
	
	public void setPath(String inPath)
	{
		path = inPath;
	}
	
	public String getPath()
	{
		return path;
	}
	
	public String getUserIDFromPath()
	{
		//Just get the userID / UserID hash tag from the url
		int i = 0;
		int count = 0;
		while(i < 1)
		{
			// Count the /'s their should only be 1 right before the userID / userID Hashtag
			// example userProfile/3  NOTE: localhost:8080/ is not part of the path
			String currentChar = path.substring(count, count+1);
			count++;
			if(currentChar.equals("/"))
			{
				i++;
			}
		}
		//After this we should get the userID we want with a substring after count
		String pathUserID = path.substring(count);
		return pathUserID;
	}
	
	public String getMatchUserIDFromPath()
	{
		//Just get the userID / UserID hash tag from the url
		int i = 0;
		int count = 0;
		while(i < 2)
		{
			// Count the /'s their should only be 1 right before the userID / userID Hashtag
			// example userProfile/3  NOTE: localhost:8080/ is not part of the path
			String currentChar = path.substring(count, count+1);
			count++;
			if(currentChar.equals("/"))
			{
				i++;
			}
		}
		//After this we should get the userID we want with a substring after count
		String pathUserID = path.substring(count);
		return pathUserID;
	}
}
