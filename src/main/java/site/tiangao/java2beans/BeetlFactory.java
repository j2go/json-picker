package site.tiangao.java2beans;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

import java.io.IOException;

/**
 * Created by shitiangao on 2017/5/2.
 */
public enum BeetlFactory {
    ins;

    private GroupTemplate groupTemplate;

    BeetlFactory() {
        try {
            ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();
            Configuration cfg = Configuration.defaultConfiguration();
            groupTemplate = new GroupTemplate(resourceLoader, cfg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Template getTemplate(String key) {
        return groupTemplate.getTemplate(key);
    }
}
