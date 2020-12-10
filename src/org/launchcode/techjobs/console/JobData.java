package org.launchcode.techjobs.console;

import jdk.internal.org.objectweb.asm.TypeReference;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.util.HashMap;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

import static java.util.Collections.unmodifiableList;


/**
 * Created by LaunchCode
 */
public class JobData {

    private static final String DATA_FILE = "resources/job_data.csv";
    private static Boolean isDataLoaded = false;


    private static ArrayList<HashMap<String, String>> allJobs;  //all jobs allJobs purpose to be an ArrayList that stores HashMap objects which have String keys and String values.

    /**
     * Fetch list of all values from loaded data,
     * without duplicates, for a given column.
     *
     * @param field The column to retrieve values from
     * @return List of all of the values of the given field
     */
    public static ArrayList<String> findAll(String field) {

        // load data, if not already loaded
        loadData();

        ArrayList<String> values = new ArrayList<>();

        for (HashMap<String, String> row : allJobs) {
            String aValue = row.get(field);

            if (!values.contains(aValue)) {
                values.add(aValue);
            }
        }

        return values;
    }

    public static ArrayList<HashMap<String, String>> findAll() {

        // load data, if not already loaded
        loadData();

        return allJobs;
    }

    /**
     * Returns results of search the jobs data by key/value, using
     * inclusion of the search term.
     * <p>
     * For example, searching for employer "Enterprise" will include results
     * with "Enterprise Holdings, Inc".
     *
     * @param column Column that should be searched.
     * @param value  Value of teh field to search for
     * @return List of all jobs matching the criteria
     */
    public static ArrayList<HashMap<String, String>> findByColumnAndValue(String column, String value) {

        // load data, if not already loaded
        loadData();

        ArrayList<HashMap<String, String>> jobs = new ArrayList<>();


        for (HashMap<String, String> row : allJobs) {

            String aValue = row.get(column);

            if (aValue.contains(value)) {
                jobs.add(row);
            }
        }

        return jobs;
    }

    /**
     * Read in data from a CSV file and store it in a list
     */
    private static void loadData() {

        // Only load data once
        if (isDataLoaded) {
            return;
        }

        try {

            // Open the CSV file and set up pull out column header info and records
            Reader in = new FileReader(DATA_FILE);
            CSVParser parser = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
            List<CSVRecord> records = parser.getRecords();
            Integer numberOfColumns = records.get(0).size();
            String[] headers = parser.getHeaderMap().keySet().toArray(new String[numberOfColumns]);

            allJobs = new ArrayList<>();

            // Put the records into a more friendly format
            for (CSVRecord record : records) {
                HashMap<String, String> newJob = new HashMap<>();

                for (String headerLabel : headers) {
                    newJob.put(headerLabel, record.get(headerLabel));
                }

                allJobs.add(newJob);
            }

            // flag the data as loaded, so we don't do it twice
            isDataLoaded = true;

        } catch (IOException e) {
            System.out.println("Failed to load job data");
            e.printStackTrace();
        }
    }


    public static ArrayList<HashMap<String, String>> findByValue(String value) {
        //public static ArrayList<HashMap<String, String>> findByColumnAndValue(String column, String value) {

        loadData();
        ArrayList<HashMap<String, String>> jobs = new ArrayList<>();
        // for()


        //if (column.equals("all")) {

        // String jobs = " ";
        for (HashMap<String, String> rowValue : allJobs) {

            //for (String key : row.keySet()) { //key =core competency

            //String aValue = rowValue.get(value);
            //String aJob =  rowValue.get(value);
                if (rowValue.containsValue(value)) {
                    jobs.add(rowValue);

                    //System.out.println(key + ": " + row.get(key));
                }
            //}
//                //System.out.println(row);

            //String aValue = row.get(column);
            //if (row.containsValue(value)) {
            //System.out.println("testing" + row);

            //jobs.add(row);
//                    //System.out.println(row);
            //  }//end if
            //String job = " ";
            //for (Map.Entry<String, String> entry : allJobs.get()) {
            //Object jobEntry = entry.getValue();
            // HashMap<Object, Object> hashMap;
            //for (String valueKey : hashMap.keySet()) { //key =core competency
            //String job = " ";
            //   for (Map.Entry<String, String> entry :  entry.getValue(){


            //Object jobValue = row.getValue();
            //job = job + " " + jobValue;

            //System.out.println("This part runs");
            //if (jobs.contains(value)) {

            //jobs.add(allJobs.get(Integer.parseInt(job)));


            // }
            //System.out.println(key + ": " + hashMap.get(key));
            //   }

            //  System.out.println(entry.getKey() + entry.getValue());
            //System.out.println("****");
            //System.out.println(" ");
            // }


//            loadData();
//
//        ArrayList<HashMap<String, String>> jobs = new ArrayList<>();
//
//
//        for (HashMap<String, String> row : allJobs) {
//
//            String aValue = row.get(column);
//
//            if (aValue.contains(value)) {
//                jobs.add(row);
//            }
//        }



        }
    return jobs;
    }
}

                // }












