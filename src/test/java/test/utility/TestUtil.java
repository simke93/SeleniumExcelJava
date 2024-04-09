package test.utility;

import utility.Xls_Reader;

import java.util.ArrayList;

public class TestUtil {
    static Xls_Reader reader;

    public static ArrayList<Object[]> getDataFromExcel(){

        ArrayList<Object[]> myData = new ArrayList<Object[]>();
        try{
            reader = new Xls_Reader("C:/Users/P52s-Workstation/IT Akademija vezbanje " +
                    "QA/java_programs/DDFSeleniumExcel/DDFSeleniumExcel/src/test/java" +
                    "/testdata/HalfTestData.xlsx");
        } catch (Exception e){
            e.printStackTrace();
        }
        for (int rowNum = 2; rowNum <= reader.getRowCount("RegTestData2"); rowNum++) {

            String firstName = reader.getCellData("RegTestData2", "firstname", rowNum);
            String lastName = reader.getCellData("RegTestData2", "lastname", rowNum);
            String email = reader.getCellData("RegTestData2", "email", rowNum);
            String password = reader.getCellData("RegTestData2", "password", rowNum);

            Object ob[] = {firstName,lastName,email,password};
            myData.add(ob);




            }
        return myData;
        }

}


