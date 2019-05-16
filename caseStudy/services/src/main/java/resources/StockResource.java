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

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import pojo.Stock;

import java.text.SimpleDateFormat;
import java.util.*;

import static javafx.scene.input.KeyCode.K;
import static javafx.scene.input.KeyCode.V;

// TODO - add your @Path here
public class StockResource {

    public static HashMap<String, Float> pairs = new HashMap<String, Float>();
    public static ArrayList<Date> sorted =new ArrayList<>();
    public static SimpleDateFormat format=new SimpleDateFormat("MM/dd/yyyy");
    public static String finalStr = "[";

    // TODO - Add a @GET resource to get stock data
    // Your service should return data based on 3 inputs
    public static void parseStock(String ticker){
        Stock info = resources.InputValidator.validateStock(ticker);
        if(!(info.equals(null))){
            String name = info.getName();
            ArrayList values = info.getDailyPrice();

            for(int i = 0; i<values.size();i++){
//                System.out.println(values.get(i));
                String pairStr = new JSONObject((LinkedHashMap)values.get(i)).toString();
//                String temp = (String)values.get(i);

                String [] arr = pairStr.split(",");
                for (String item: arr){
//                    System.out.println(item);
                    String [] arr2 = item.split(":");

//                    for (String item2: arr2){
//                        System.out.println(item2);
//                    }
                    arr2[0] = arr2[0].replaceAll("\\\\", "");
                    arr2[0] = arr2[0].replaceAll("[{}]", " ");
                    arr2[0] = arr2[0].replaceAll("\"", " ");
                    arr2[0] = arr2[0].trim();

//                    System.out.println(arr2[0]);

                    arr2[1] = arr2[1].replaceAll("[{}]", " ");
                    arr2[1] = arr2[1].replaceAll("\"", " ");
//                    System.out.println(arr2[1]);
                    arr2[1] = arr2[1].trim();

                    pairs.put(arr2[0], Float.parseFloat(arr2[1]));
                }
            }

//            for (String nme: pairs.keySet()){
//                String key = nme.toString();
//                String value = pairs.get(nme).toString();
//                System.out.println(key + ":" + value);
//            }
        }
    }


    // Stock ticker, start date and end date

    public static void sortMap(HashMap<String, Float> pairMap){

        for (String key : pairMap.keySet()) {
            try {
                Date date = format.parse(key);
                sorted.add(date);
            } catch (java.text.ParseException e) {
            e.printStackTrace();
            }
        }

        Collections.sort(sorted);
//        sorted.forEach(action-> System.out.println(format.format(action)));
    }

    public static void createString(String start, String end){
        try {
            Date startDate = format.parse(start);
            Date endDate = format.parse(end);

//            System.out.println(startDate);
//            System.out.println(endDate);

//                System.out.println(pairs);

            for(int i = 0; i < sorted.size(); i++){
                String dateStr = format.format(sorted.get(i));
                boolean chopped = false;
                if(dateStr.charAt(0) == '0'){
                    dateStr = dateStr.substring(1, dateStr.length());
                    chopped = true;
                }
                if (chopped){
                    if(dateStr.charAt(2) == '0'){
                        dateStr = dateStr.substring(0, 2) + dateStr.substring(3, dateStr.length());
                    }
                }
                else if(dateStr.charAt(3) == '0'){
                    dateStr = dateStr.substring(0, 3) + dateStr.substring(4, dateStr.length());
                }

//                System.out.println(dateStr);
                if (i != sorted.size() - 1) {
                    if(sorted.get(i).after(startDate) && sorted.get(i).before(endDate)){
//                        System.out.println(finalStr);
                        if (sorted.get(i + 1).after(startDate) && sorted.get(i + 1).before(endDate)) {
                            //not gonna break out at next index

//                            System.out.println(pairs.get(sorted.get(i).toString()).toString());
                            finalStr = finalStr + "{\"category\": \"" + dateStr + "\", \"y\": "
                                    + (pairs.get(dateStr)) + "}, ";

                        } else {
                            finalStr = finalStr + "{\"category\": \"" + dateStr + "\", \"y\": "
                                    + (pairs.get(dateStr)) + "}]";
                        }
                    }

                    else if (sorted.get(i).after(endDate)){
                        break;
                    }
                } else {
                    if(sorted.get(i).after(startDate) && sorted.get(i).before(endDate)){
                        finalStr = finalStr + "{\"category\": \"" + dateStr + "\", \"y\": "
                                + (pairs.get(dateStr)) + "}";
                    } else {
                        finalStr = finalStr + "]";
                    }
                }

            }
//            System.out.println(finalStr);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

    }

    public static String returnStock(String ticker, String start, String end){
        parseStock(ticker);
        sortMap(pairs);
        createString(start, end);

//        System.out.println(info);
        return finalStr;
    }

    public static void main(String[] args) {
        resources.InputValidator.validateFile("src/main/resources/data/historicalStockData.json");
//        parseStock("AAPL");
//        sortMap(pairs);
//        returnStock("AAPL");
//        System.out.println(pairs.get("2/1/2019"));
    }

}
