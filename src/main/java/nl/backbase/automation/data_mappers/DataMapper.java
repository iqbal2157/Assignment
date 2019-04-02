package nl.backbase.automation.data_mappers;

import nl.backbase.automation.utils.DataFactory;


public class DataMapper {

    public String getConfigValueOf(String key) {
        return (String) DataFactory.get(key, "config", key);
    }

    public String getCreateComputerValueof(String key) {
        return (String) DataFactory.get(key, "computerDetails", "create", key);
    }

    public String getUpdateComputerValueof(String key) {
        return (String) DataFactory.get(key, "computerDetails", "update", key);
    }
}