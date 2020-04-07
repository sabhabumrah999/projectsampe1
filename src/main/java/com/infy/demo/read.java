package com.infy.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



public class read {

public static void main(String[] args) throws FileNotFoundException, IOException {

JSONParser parser = new JSONParser();

Object obj = null;
try {
	obj = parser.parse(new FileReader("src/main/resources/json/je.json"));
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

JSONObject jsonObject = (JSONObject) obj;

String name = (String) jsonObject.get("Name");
System.out.println(name);

String state = (String) jsonObject.get("State");
System.out.println(state);

// loop array
JSONArray visit = (JSONArray) jsonObject.get("Places traveled");

Iterator<String> iterator = visit.iterator();
while (iterator.hasNext()) {
	System.out.println(iterator.next());
}
}
}