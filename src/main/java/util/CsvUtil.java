package util;

import core.LogFactory;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavlo Bida in 2018
 * https://github.com/PavloBida
 */

/**
 * A small util to deal with .csv files
 */
public class CsvUtil {

    private static final Logger LOG = LogFactory.getLogger(CsvUtil.class);
    private final String COMMA = ",";
    private final String NEW_LINE = "\n";

    private FileWriter fileWriter;
    private BufferedReader fileReader;
    private String fileName;

    public CsvUtil(String fileName){
        this.fileName = fileName;
    }

    /**
     * Writes single line to .csv file
     * @param line  line to write
     */
    public void writeLine(String line){
        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.append(line);
            fileWriter.append(NEW_LINE);
        } catch (IOException e) {
            LOG.error(e.getMessage());
        } finally {
            try{
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                LOG.error(e.getMessage());
            }
        }
    }

    /**
     * Writes given lines to .csv file
     * @param lines  list of lines to add
     */
    public void writeLines(List<String> lines){
        try {
            fileWriter = new FileWriter(fileName);
            for(String value : lines) {
                fileWriter.append(value);
                fileWriter.append(NEW_LINE);
            }
        } catch (IOException e) {
            LOG.error(e.getMessage());
        } finally {
            try{
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                LOG.error(e.getMessage());
            }
        }
    }

    /**
     * Replaces given delimiter with comma to stick with .csv format and writes to file
     * @param lines         list of lines to add
     * @param delimiter     a custom delimiter to be replaced with comma
     */
    public void transformAndWriteLines(List<String> lines, String delimiter) {
        try{
            fileWriter = new FileWriter(fileName);
            for(String line : lines) {
                if(!line.equals(StringUtils.EMPTY)) {
                    fileWriter.append(line.replace(delimiter, COMMA));
                    fileWriter.append(NEW_LINE);
                }
            }
            LOG.info(String.format("Successfully wrote the following data to file %s: %s", lines, fileName));
        } catch (IOException e) {
            LOG.error(e.getMessage());
        } finally {
            try{
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                LOG.error(e.getMessage());
            }
        }
    }

    /**
     * Reads .csv file into a String[]
     * @return String[] of values from .csv
     */
    public List<String> readIntoStringList() {
        List<String> result = new ArrayList<>();
        String line;
        try{
            fileReader = new BufferedReader(new FileReader(fileName));
            while((line = fileReader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            LOG.error(e.getMessage());
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                LOG.error(e.getMessage());
            }
        }
        return result;
    }

}
