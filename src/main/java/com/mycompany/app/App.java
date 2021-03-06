package com.mycompany.app;
import java.util.*;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App
{
	
	public static void main(String[] args)
	{
		port(getHerokuAssignedPort());

		get("/", (req, res) -> "Hello, World");

		post("/compute", (req, res) -> {
		  //System.out.println(req.queryParams("input1"));
		  //System.out.println(req.queryParams("input2"));

		  String input1 = req.queryParams("input1");
		  String input2 = req.queryParams("input2");
		  java.util.Scanner sc1 = new java.util.Scanner(input1);
		  sc1.useDelimiter("[;\r\n]+");
		  java.util.Scanner sc2 = new java.util.Scanner(input2);
		  sc2.useDelimiter("[;\r\n]+");
		  java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
		  java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
		  
		  while (sc1.hasNext())
		  {
		    int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
		    inputList.add(value);
		  }
		  
		  System.out.println(inputList);
		  while (sc2.hasNext())
		  {
		    int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
		    inputList2.add(value);
		  }
 		  System.out.println(inputList2);

		  String input3= req.queryParams("input3").replaceAll("\\s","");
		  String input4 = req.queryParams("input4").replaceAll("\\s","");
		  //int input2AsInt = Integer.parseInt(input2);

		  int result = App.findBiggerOfSM(inputList,inputList2, input3,input4);

		 Map map = new HashMap();
		  map.put("result", result);
		  return new ModelAndView(map, "compute.mustache");
		}, new MustacheTemplateEngine());


		get("/compute",
		    (rq, rs) -> {
		      Map map = new HashMap();
		      map.put("result", "not computed yet!");
		      return new ModelAndView(map, "compute.mustache");
		    },
		    new MustacheTemplateEngine());

	}
	public static int findBiggerOfSM(ArrayList<Integer> array,ArrayList<Integer> array2, String word,String word2) {
	
		if (array == null || array2== null ) return -1;
	  	int sum=0,sum2=0;
		for(int i=0;i<array.size();i++)
			sum+=array.get(i);
		for(int i=0;i<array2.size();i++)
			sum2+=array2.get(i);
		if(sum*sum2>=word.length()*word2.length())
			return sum*sum2;
		
		return word.length()*word2.length();
    	}
	static int getHerokuAssignedPort() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		if (processBuilder.environment().get("PORT") != null) {
		    return Integer.parseInt(processBuilder.environment().get("PORT"));
		}
		return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    	}
}
