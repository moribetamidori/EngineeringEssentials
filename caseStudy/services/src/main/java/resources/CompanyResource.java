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

import pojo.Company;

//// TODO - add your @Path here
//@Path("")
public class CompanyResource {

    // TODO - Add a @GET resource to get company data
//    @GET
//    @Path("")
//    @Produces(MediaType.APPLICATION_JSON)
    public static Company returnCompany(String ticker){
        Company info = resources.InputValidator.validateComp(ticker);
//        System.out.println(info);
//        if(!(info.equals(null))){
//            System.out.println(info.getName());
//            System.out.println(info.getIndustry());
//        }

//        System.out.println(info);
        return info;
    }
    // Your service should return data for a given stock ticker

    public static void main(String[] args) {
        resources.InputValidator.validateFile("src/main/resources/data/companyInfo.json");
        returnCompany("AAPL");
//        returnCompany("EA");
    }


}