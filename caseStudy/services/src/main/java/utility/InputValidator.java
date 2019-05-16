/**
 * Copyright 2019 Goldman Sachs.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

//package utility;
package resources;

//import java.util.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import pojo.Company;


public class InputValidator {

    public static HashMap<String, Object> companyMap = new HashMap<>();

    private static final ObjectMapper mapper = new ObjectMapper();
    // TODO - write a method that will validate your JSON input files
    public static void validateFile(String filename)
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(filename))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

//            System.out.println(obj);


            if(filename.equals("src/main/resources/data/companyInfo.json")) {

                JSONArray companyList = (JSONArray) obj;


                for (Object ob:companyList){
                    String obStr = mapper.writeValueAsString(ob);
                    Company comp = mapper.readValue(obStr, new TypeReference<Company>() {});
                    companyMap.put(comp.getSym(), comp);
                }

                for (String ticker: companyMap.keySet()){
                    String compInfo = companyMap.get(ticker).toString();
                    System.out.println(ticker + " " + compInfo);
                }

            }

//
//            //Iterate over company array
//            companyList.forEach( cmp -> parseCompanyObject( (JSONObject) cmp ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseCompanyObject(JSONObject company)
    {
        //Get company name
        String name = (String) company.get("name");
        System.out.println(name);

        //Get company headquarters
        String headquarters = (String) company.get("headquartersCity");
        System.out.println(headquarters);

        //Get State or Country of headquarters
        String headquarterSt = (String) company.get("headquartersStateOrCountry");
        System.out.println(headquarterSt);

        //Get sector
        String sector = (String) company.get("sector");
        System.out.println(sector);
    }

    // TODO - write a method that will validate the inputs to the Company Resource
//    public static String[] validateComp(String ticker){
//        if(companyMap.containsKey(ticker)){
//            return [((Company)companyMap.get(ticker)).getName(), ((Company)companyMap.get(ticker)).getIndustry();
//        }
//        return [null, null];
//    }

    // TODO - write a method that will validate the inputs to the Stock Resource
    public static void validateStock(){

    }

    public static void main(String[] args) {
        validateFile("src/main/resources/data/companyInfo.json"); //filePath);
    }
}
