package resources;

import pojo.Company;

import static resources.CompanyResource.returnCompany;
import static resources.StockResource.returnStock;

public class Magic {

    public static String ultimate = "{\"company\": \"";

    public static String magicString(String ticker, String start, String end){
        Company comp = returnCompany(ticker);
        String compName = comp.getName();
        String compInd = comp.getIndustry();
        String stockStr = returnStock(ticker, start, end);
        ultimate = ultimate + compName + "\", \"industry\": \"" + compInd + "\", \"ticker\": \"" + ticker +
                "\", \"data\": " + stockStr + "}";
        System.out.println(ultimate);
        return ultimate;
    }

    public static void main(String[] args) {
        resources.InputValidator.validateFile("src/main/resources/data/historicalStockData.json");
        resources.InputValidator.validateFile("src/main/resources/data/companyInfo.json");
        magicString("AMZN", "2/1/2019", "2/20/2019");
    }
}
