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

package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class will define a company and its attributes
 * Look at resources/data/companyInfo.json
 */
public class Company {

    // TODO - Think back to your modelling session
    // Define the attributes of a Company based on the
    // provided data in resources/data
    @JsonProperty
    private String symbol;
    @JsonProperty
    private String name;
    @JsonProperty
    private String headquartersCity;
    @JsonProperty
    private String headquartersStateOrCountry;
    @JsonProperty
    private int numberOfEmployees;
    @JsonProperty
    private String sector;
    @JsonProperty
    private String industry;

    public Company (String sym, String nme, String hdqr, String hdqrSC, int empl, String sec, String ind) {
        this.symbol = sym;
        this.name = nme;
        this.headquartersCity = hdqr;
        this.headquartersStateOrCountry = hdqrSC;
        this.numberOfEmployees = empl;
        this.sector = sec;
        this.industry = ind;
    }

    public Company (){}

    // TODO - add getter and setter methods for your attributes
    public String getSym(){
        return this.symbol;
    }

    public String getName(){
        return this.name;
    }

    public String getHeadqtrCity(){
        return this.headquartersCity;
    }

    public String getHeadqtrSt(){
        return this.headquartersStateOrCountry;
    }

    public int getEmployees(){
        return this.numberOfEmployees;
    }

    public String getSector(){
        return this.sector;
    }

    public String getIndustry(){
        return this.industry;
    }

    public void setSym(String sym){
        this.symbol = sym;
    }

    public void setName(String nme){
        this.name = nme;
    }

    public void setHeadqtrCity(String hdqr){
        this.headquartersCity = hdqr;
    }

    public void setHeadqtrSt(String hdqrSC){
        this.headquartersStateOrCountry = hdqrSC;
    }

    public void setEmployees(int empl){
        this.numberOfEmployees = empl;
    }

    public void setSector(String sec){
        this.sector = sec;
    }

    public void setIndustry(String ind){
        this.industry = ind;
    }
}
