package datadriven;

import utility.Xls_Reader;

public class ExcelOperations {

    public static void main(String[] args) {

        Xls_Reader reader = new Xls_Reader("C:/Users/P52s-Workstation/IT Akademija vezbanje " +
                "QA/java_programs/DDFSeleniumExcel/DDFSeleniumExcel/src/test/java/testdata" +
                "/HalfTestData.xlsx");


        if(!reader.isSheetExist("HomePage")) {
            reader.addSheet("HomePage");

        }

        int colCount = reader.getColumnCount("RegTestData");
        System.out.println("Total cols present in RegTestData sheet: " +colCount);
        System.out.println(reader.getCellRowNum("RegTestData", "firstname", "Tom"));





    }

}
