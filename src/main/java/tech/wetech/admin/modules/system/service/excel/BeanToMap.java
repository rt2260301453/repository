package tech.wetech.admin.modules.system.service.excel;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import tech.wetech.admin.modules.system.po.Subarea;
public class BeanToMap<T> {

    public Map<String,Object> getMap(T entity){
        Field[] fields = entity.getClass().getDeclaredFields();
        Map<String,Object> map = new HashMap<String,Object>();
        for (int i = 0; i < fields.length; i++) {
            String methodName = getMethodName(fields[i].getName());
            try {
                Method method = entity.getClass().getMethod(methodName);
                map.put(fields[i].getName(),method.invoke(entity));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    public String getMethodName(String fieldName){
        byte[] buffer = fieldName.getBytes();
        buffer[0] = (byte)(buffer[0]-32);
        String name = new String(buffer);
        return "get"+name;
    }

}
