package com.util;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import com.entity.Teacher;

public class JsonUtil {
	public static String getJson(Object object){
		Class<?> cls = object.getClass();
		Field[] field = cls.getDeclaredFields();
		boolean first = true;
		StringBuffer value= new StringBuffer("{");
		for(Field x : field){
			StringBuffer Attribute = new StringBuffer("");
			String eName = x.getName();
			String type = x.getGenericType().toString();
			String val = null;
			try {
				switch(type){
				case "class java.lang.Integer":
				case "int": 
					Method m;
					m = (Method) object.getClass().getMethod(  
							"get" + Character.toUpperCase(eName.toCharArray()[0])
							+ eName.substring(1));
					val = ((Integer) m.invoke(object)).toString();
					break;
				case "class java.lang.String":
					m = (Method) object.getClass().getMethod(  
							"get" + Character.toUpperCase(eName.toCharArray()[0])
							+ eName.substring(1));
					val = (String) m.invoke(object);
					break;
				case "class com.entity.Teacher":
					m = (Method) object.getClass().getMethod(  
							"get" + Character.toUpperCase(eName.toCharArray()[0])
							+ eName.substring(1));
					eName += "Id";
					StringBuffer sb = new StringBuffer();
					sb.append(((Teacher) m.invoke(object)).getId());
					sb.append("\",");
					sb.append("\"teacherName\":\"");
					sb.append(((Teacher) m.invoke(object)).getName());
					val = sb.toString();
					break;
				}
			}catch (Exception e) {
				//e.printStackTrace();
			} 
			if(!first) Attribute.append(",");
			Attribute.append("\""+eName+"\":\""+val+"\"");
			value.append(Attribute);
			first = false;
		}return value.append("}").toString();
	}
	public static String getJson(String name,String values){
		StringBuffer value = new StringBuffer("{");
		return value.append("\""+name+"\""+":"+"\""+values+"\""+"}").toString();
	}
	public static String getJson(String values){
		StringBuffer value = new StringBuffer();
		return value.append("\""+values+"\"").toString();
	}
	public static String groupJeson(List<String> list){
		String value = "{";
		for(int i = 0; i < list.size(); i++){
			StringBuffer sb = new StringBuffer();
			String x = list.get(i);
			sb.append(x);
			sb.deleteCharAt(0);
			sb.deleteCharAt(sb.length()-1);
			if(i != list.size()-1) sb.append(",");
			value += sb.toString();
		}return value+"}";
	}
	public static String getJson(String name,List<?> list){
		StringBuffer value = new StringBuffer("{"+"\""+name+"\""+":"+"[");
		StringBuffer attribute = null;
		for(int i = 0; i < list.size(); i++){
			Object x = list.get(i);
			if(i == 0) attribute = new StringBuffer("");
			else attribute = new StringBuffer(",");
			if(x instanceof String) attribute.append(getJson((String)x));
			else attribute.append(getJson(x));
			value.append(attribute);
		}return value.append("]"+"}").toString();
	}
}
