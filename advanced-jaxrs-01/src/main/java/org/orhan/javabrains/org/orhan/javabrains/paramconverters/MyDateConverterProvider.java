package org.orhan.javabrains.paramconverters;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

@Provider
public class MyDateConverterProvider implements ParamConverterProvider {

	@Override
	public <T> ParamConverter<T> getConverter(final Class<T> rawType, Type genericType, Annotation[] annotations) {
		if(rawType.getName().equals(MyDate.class.getName())) {
			return new ParamConverter<T>(){
				@Override
				public T fromString(String value) {
					Calendar requestedDate =Calendar.getInstance();
					if("tomorrow".equalsIgnoreCase(value)) {
						requestedDate.add(Calendar.DATE,1);
					}
					else if("yesterday".equalsIgnoreCase(value)) {
						requestedDate.add(Calendar.DATE,-1);
					}
					MyDate mydate =new MyDate();
					mydate.setDate(requestedDate.get(Calendar.DATE));
					mydate.setMonth(requestedDate.get(Calendar.MONTH));
					mydate.setYear(requestedDate.get(Calendar.YEAR));
					return rawType.cast(mydate);
				}
				
				@Override
				public String toString(T myBean) {
					if(myBean == null) {
						return null;
					}
					return myBean.toString();
				}
			};
		}
		return null;
	}

}