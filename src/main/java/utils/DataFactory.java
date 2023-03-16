package utils;

public class DataFactory {

//    public static ReadData dataFactory(String dataSource){
//        switch(dataSource){
//            case "Excel": return new ExcelReader();
//            case "JSON": return new JsonReader();
//            default: return null;
//        }
//    }


    public static ReadData dataFactory(DataSource dataSheetSource){
        switch(dataSheetSource){
            case Excel: return new ExcelReader();
            case JSON: return new JsonReader();
            default: return null;
        }
    }
}
