package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil <T> {
    /**
     * This method parses JSON file into POJO, using DTO class
     * @param file          JSON file to be parsed
     * @param dtoBaseClass  DTO class that the JSON should be parsed into (needs to be: YourClass.getClass())
     * @return              the ArrayList of data transfer objects that were received from the JSON file
     */
    public List<T> parseJson(String file, Class<?> dtoBaseClass) {
        List<T> result = null;
        try {
            InputStream input = new FileInputStream(file);
            ObjectMapper objectMapper = new ObjectMapper();
            TypeFactory typeFactory = TypeFactory.defaultInstance();
            result = objectMapper.readValue(input, typeFactory.constructCollectionType(
                            ArrayList.class, dtoBaseClass));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
