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

package resources;

//import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// TODO - add your @Path here
public class CompanyResource {

    // TODO - Add a @GET resource to get company data
    // Your service should return data for a given stock ticker

    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("/Users/brittchin/Desktop/GS Final Project/EngineeringEssentials/caseStudy/services/src/main/resources/data/companyInfo.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray companyList = (JSONArray) obj;
            System.out.println(companyList);

            //Iterate over company array
            companyList.forEach( cmp -> parseCompanyObject( (JSONObject) cmp ) );

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

}