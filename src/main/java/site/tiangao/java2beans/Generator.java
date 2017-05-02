package site.tiangao.java2beans;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by shitiangao on 2017/5/2.
 */
public class Generator {

    String rootPath = "/Users/shitiangao/git/github/json2beans/data";

    public void gen(String json) {
        JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);

        BeanClass beanClass = BeanClass.defaultOne();

        jsonObject.entrySet().forEach(e -> {
            if (e.getValue() instanceof JsonPrimitive) {
                JsonPrimitive primitive = (JsonPrimitive) e.getValue();
                if (primitive.isString()) {
                    beanClass.getStrKeys().add(e.getKey());
                } else if (primitive.isNumber()) {
                    beanClass.getDoubleKeys().add(e.getKey());
                } else if (primitive.isBoolean()) {
                    beanClass.getBoolKeys().add(e.getKey());
                }
                System.out.println("value  " + e.getValue());
            } else if (e.getValue() instanceof JsonObject) {
                gen(e.getValue().toString());
                System.out.println("object " + e.getValue());
            } else if (e.getValue() instanceof JsonArray) {
                System.out.println("array  " + e.getValue());
            }
        });

        Files.write(Paths.get(rootPath), );
    }

}
