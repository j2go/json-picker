package site.tiangao.java2beans;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shitiangao on 2017/5/2.
 */
@Data
@Builder
public class BeanClass {
    private final String packageName;
    private final String author;
    private final String date;
    private final String className;
    private final List<String> boolKeys;
    private final List<String> intKeys;
    private final List<String> longKeys;
    private final List<String> doubleKeys;
    private final List<String> strKeys;
    private final Map<String, String> objectMap;


    public static BeanClass defaultOne() {
        return BeanClass.builder()
                .packageName("xyz")
                .author("tiangao")
                .date("2017-1-1")
                .className("Demo")
                .boolKeys(new ArrayList<>())
                .intKeys(new ArrayList<>())
                .longKeys(new ArrayList<>())
                .doubleKeys(new ArrayList<>())
                .strKeys(new ArrayList<>())
                .objectMap(new HashMap<>())
                .build();
    }
}
