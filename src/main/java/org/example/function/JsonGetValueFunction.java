package org.example.function;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.JsonNode;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.table.functions.ScalarFunction;
public class JsonGetValueFunction extends ScalarFunction {
    public JsonGetValueFunction() {
    }
    public String eval(String key, String jsonStr) {
        ObjectMapper objMapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = objMapper.readTree(jsonStr);
        } catch (JsonProcessingException var6) {
            return null;
        }
        JsonNode keyNode = jsonNode.get(key);
        return keyNode != null ? keyNode.textValue() : null;
    }
}
